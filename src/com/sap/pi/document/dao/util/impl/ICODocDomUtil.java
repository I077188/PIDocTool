package com.sap.pi.document.dao.util.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.ws.BindingProvider;

import com.sap.engine.services.webservices.espbase.client.api.HTTPControlFactory;
import com.sap.engine.services.webservices.espbase.client.api.HTTPControlInterface;
import com.sap.pi.document.dao.IntegratedConfiguration71;
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.IntegratedConfigurationIn;
import com.sap.xi.basis.IntegratedConfigurationInService;
import com.sap.xi.basis.IntegratedConfigurationQueryIn;
import com.sap.xi.basis.IntegratedConfigurationQueryOut;
import com.sap.xi.basis.IntegratedConfigurationReadIn;
import com.sap.xi.basis.IntegratedConfigurationReadOut;
import com.sap.xi.basis.MessageHeaderID;

public class ICODocDomUtil {

	private String host;
	private String user;
	private String password;
	private String proxy_host;
	private String proxy_port;
	private String proxy_user;
	private String proxy_password;

	public void generateICODomFil(File file) {

	}

	public void generateICODomGroupFile(File file) {

	}

	public List<IntegratedConfiguration71> getICOs() {

		IntegratedConfigurationInService icoInService;
		try {
			// initial integrated configuration service
			icoInService = new IntegratedConfigurationInService();
			IntegratedConfigurationIn port = icoInService.getIntegratedConfigurationInPort();

			set_security((BindingProvider) port, "/IntegratedConfigurationInService/IntegratedConfigurationInImplBean");

			IntegratedConfigurationQueryIn queryIn = new IntegratedConfigurationQueryIn();
			queryIn.setAdministrativeData(null);
			queryIn.setDescription(null);
			queryIn.setIntegratedConfigurationID(null);

			// query ICO
			IntegratedConfigurationQueryOut queryOut = new IntegratedConfigurationQueryOut();
			queryOut = port.query(queryIn);
			
			List<MessageHeaderID> headerIDs = queryOut.getIntegratedConfigurationID();

			for (int i = 0; i < headerIDs.size(); i++) {
				MessageHeaderID headerID = headerIDs.get(i);
				
				IntegratedConfigurationReadIn readIn = new IntegratedConfigurationReadIn();

				readIn.getIntegratedConfigurationID().add(headerID);

				IntegratedConfigurationReadOut readOut = port.read(readIn);

				List<IntegratedConfiguration> readResult = readOut.getIntegratedConfiguration();

				for (int j = 0; j < readResult.size(); j++) {
					// get the integrated configuration part: 
					
				}

				// clear the configuration part
				readIn.getIntegratedConfigurationID().clear();

			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	//
	// public List<E>

	private void set_security(BindingProvider port, String url_path) throws IOException {
		BindingProvider bp = port;

		read_properties();
		Map<String, Object> context = bp.getRequestContext();
		context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, host + url_path);
		context.put(BindingProvider.USERNAME_PROPERTY, user);
		context.put(BindingProvider.PASSWORD_PROPERTY, password);
		if (proxy_host == null || proxy_host.length() == 0)
			return;
		HTTPControlInterface httpControl = HTTPControlFactory.getInterface(port);
		httpControl.setHTTPProxy(proxy_host, Integer.parseInt(proxy_port));
		httpControl.setHTTPProxyUserPass(proxy_user, proxy_password);
	}

	private void read_properties() throws IOException {
		FileInputStream in = new FileInputStream("IDExport.properties");
		Properties prop = new Properties();
		prop.load(in);
		host = prop.getProperty("host");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
		proxy_host = prop.getProperty("proxy_host");
		proxy_port = prop.getProperty("proxy_port");
		proxy_user = prop.getProperty("proxy_user");

	}
}
