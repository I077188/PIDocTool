package com.sap.pi.document.test;

import java.util.List;

import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.impl.WebServiceOperationImpl;
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.MessageHeaderID;

public class UtilTest {

	public static void main(String[] args) {

		Long start = System.currentTimeMillis();
		CONSTAINTS.LOG.info("Program started ... ");

		CONSTAINTS.initial();

		WebServiceOperationImpl webServiceOperation = new WebServiceOperationImpl();

		IntegratedConfiguration integratedConfiguration = new IntegratedConfiguration();

		List<MessageHeaderID> messageHeaderIDs = webServiceOperation.getIntegratedConfigurationID();

		// MessageHeaderID messageHeaderID = new MessageHeaderID();
		// messageHeaderID.setSenderComponentID("BC_BIT400_RFCLookupSender");
		// messageHeaderID.setInterfaceName("SI_RFCLookup_Sender");
		// messageHeaderID.setInterfaceNamespace("http://robert_forTest.com");
		// List<OperationMapping> operationMappings =
		// webServiceOperation.getOperationMappings(integratedConfiguration);
		//

		System.out.println("Started.." + messageHeaderIDs.size());
		for (int i = 0; i < messageHeaderIDs.size(); i++) {
			integratedConfiguration = webServiceOperation.getIntegrationConfiguration(messageHeaderIDs.get(i));


			if (integratedConfiguration != null) {
				System.out
						.println(messageHeaderIDs.get(i).getInterfaceName() + "\t:test");
			}

		}

		System.out.println("End ...");
		Long end = System.currentTimeMillis();
		CONSTAINTS.LOG.info("Program ended!");
		CONSTAINTS.LOG.info("Time wasted:\t" + (end - start) + " (ms)");


	}

}
