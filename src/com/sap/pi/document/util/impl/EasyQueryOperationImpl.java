package com.sap.pi.document.util.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.sap.pi.document.dao.SoftwareComponent;
import com.sap.pi.document.util.EasyQueryOperation;
import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.Item;

public class EasyQueryOperationImpl implements EasyQueryOperation {

	private static List<Item> information;

	private HttpOperation httpOperation = new HttpOperation();

	@Override
	public List<SoftwareComponent> getSCWInfo() {

		List<NameValuePair> vPairs = new ArrayList<NameValuePair>(1);

		vPairs.add(new BasicNameValuePair("action", "Start query"));
		vPairs.add(new BasicNameValuePair("changeL", "true"));
		vPairs.add(new BasicNameValuePair("deletedL", "N"));
		vPairs.add(new BasicNameValuePair("qc", "All software components"));
		vPairs.add(new BasicNameValuePair("result", "NAME"));
		vPairs.add(new BasicNameValuePair("result", "VENDOR"));
		vPairs.add(new BasicNameValuePair("result", "VERSION"));
		vPairs.add(new BasicNameValuePair("swcL", "Local Software Components"));
		vPairs.add(new BasicNameValuePair("swcV", "bc680ca1924311d9bb93d52d0a126213_-1"));
		vPairs.add(new BasicNameValuePair("syncTabL", "true"));
		vPairs.add(new BasicNameValuePair("types", "workspace"));
		vPairs.add(new BasicNameValuePair("underL", "true"));
		vPairs.add(new BasicNameValuePair("xmlReleaseL", "7.1"));
		vPairs.add(new BasicNameValuePair("userL", CONSTAINTS.userName));

		List<String[]> result = httpOperation.sendPostRequestWithParameters(vPairs);


		// initial index part

		String[] header = result.get(0);

		int indexName = 0;
		int indexVersion = 0;
		int indexNameSpace = 0;

		for (int i = 0; i < header.length; i++) {
			String attribute = header[i].toLowerCase();
			if (attribute.indexOf("name") >= 0) {
				indexName = i;
			} else if (attribute.indexOf("version") >= 0) {
				indexVersion = i;
			} else if (attribute.indexOf("vendor") >= 0) {
				indexNameSpace = i;
			} else {

			}
		}

		// create software component dom related object

		List<SoftwareComponent> swcList = new ArrayList<>();
		for (int i = 1; i < result.size(); i++) {
			SoftwareComponent swc = new SoftwareComponent(result.get(i)[indexName], result.get(i)[indexVersion],
					result.get(i)[indexNameSpace]);
			swcList.add(swc);
		}
		// System.out.println("Software component number is:\t" +
		// swcList.size());

		return swcList;
	}

	@Override
	public List<Item> getSIInfo() {
		return information;
	}

}
