package com.sap.pi.document.util.impl;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sap.pi.document.util.model.CONSTAINTS;

public class HttpOperation {
	public List<String[]> sendPostRequestWithParameters(List<NameValuePair> vPairs) {

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost("http://" + CONSTAINTS.host + ":" + CONSTAINTS.port
				+ "/rep/support/SimpleQuery?j_username="
				+ CONSTAINTS.userName + "&j_password=" + CONSTAINTS.password);

		List<String[]> results = new ArrayList<String[]>();
		Document document = null;
		try {
			post.setEntity(new UrlEncodedFormEntity(vPairs));
			HttpResponse response = client.execute(post);

			BufferedReader bfReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			List<InputStream> ins = new ArrayList<>();

			String line = "";
			boolean copy = false;

			while ((line = bfReader.readLine()) != null) {

				if (line.indexOf("<table ") >= 0) {
					line = "<table>";
					copy = true;
				}

				if (copy) {
					// in.read(line.getBytes("UTF-8"));
					ins.add(new ByteArrayInputStream(line.getBytes("UTF-8")));
				}

				if (line.equalsIgnoreCase("</table>")) {
					copy = false;
				}
			}

			// get document
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			document = factory.newDocumentBuilder().parse(new SequenceInputStream(Collections.enumeration(ins)));

			Element table = (Element) document.getElementsByTagName("table").item(0);

			NodeList trList = table.getElementsByTagName("tr");

			if (trList.getLength() > 0) {

				// get first line

				Element header = (Element) trList.item(0);
				NodeList headerAttribute = header.getElementsByTagName("th");
				int length = headerAttribute.getLength();

				String[] headerItem = new String[length];

				for (int i = 0; i < length; i++) {
					headerItem[i] = headerAttribute.item(i).getTextContent();
					// System.out.println(headerItem[i]);
				}
				results.add(headerItem);

				// get other records line
				nodeOut:
				for (int i = 1; i < trList.getLength(); i++) {
					String[] resultItem = new String[length];
					Element recordItem = (Element) trList.item(i);
					NodeList recordItemAttribute = recordItem.getElementsByTagName("td");
					int size = headerAttribute.getLength();

					for (int j = 0; j < size; j++) {
						String value = recordItemAttribute.item(j).getTextContent();
						if (value == null || value == "") {
							continue nodeOut;
						}
						resultItem[j] = value;
					}
					results.add(resultItem);
				}
			}

		} catch (IOException | UnsupportedOperationException | SAXException | ParserConfigurationException e) {
			e.printStackTrace();
			CONSTAINTS.LOG.error(e.getMessage());
		} finally {
		}
		return results;

	}

}
