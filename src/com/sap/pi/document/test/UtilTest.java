package com.sap.pi.document.test;

import java.util.List;

import com.sap.pi.document.dao.OperationMapping;
import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.impl.WebServiceOperationImpl;
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.MessageHeaderID;

public class UtilTest {

	public static void main(String[] args) {

		CONSTAINTS.initial();

		WebServiceOperationImpl webServiceOperation = new WebServiceOperationImpl();

		IntegratedConfiguration integratedConfiguration = new IntegratedConfiguration();

		MessageHeaderID messageHeaderID = new MessageHeaderID();
		messageHeaderID.setSenderComponentID("CC_KELLY_SOAP_SENDER");
		messageHeaderID.setInterfaceName("SI_Srudent_OUT");
		messageHeaderID.setInterfaceNamespace("http://kelly.fistModel");

		integratedConfiguration = webServiceOperation.getIntegrationConfiguration(messageHeaderID);

		List<OperationMapping> operationMappings = webServiceOperation.getOperationMappings(integratedConfiguration);

		System.out.println("test:\t" + operationMappings.size());

	}

}
