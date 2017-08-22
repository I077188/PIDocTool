package com.sap.pi.document.util.dao;

import java.io.IOException;

import javax.xml.ws.BindingProvider;

import com.sap.xi.basis.IntegratedConfigurationIn;
import com.sap.xi.basis.IntegratedConfigurationInService;

public class IntegrationPort {

	public static IntegratedConfigurationIn getIntegratedConfigurationPort() {

		IntegratedConfigurationInService icoInService;
		SetSecurity setSecurity;
		icoInService = new IntegratedConfigurationInService();
		IntegratedConfigurationIn port = icoInService.getIntegratedConfigurationInPort();
		setSecurity = new SetSecurity();

		try {
			setSecurity.set_security((BindingProvider) port,
					"/IntegratedConfigurationInService/IntegratedConfigurationInImplBean");
			return port;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// public static

}
