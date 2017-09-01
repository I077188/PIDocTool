package com.sap.pi.document.test;

import com.sap.pi.document.dao.util.impl.InboundProcessingDocDomUtil;
import com.sap.pi.document.dao.util.impl.LOGDocDomUtil;
import com.sap.pi.document.dao.util.impl.STGDocDomUtil;
import com.sap.pi.document.dao.util.impl.SenderDocDomGroupUtil;
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

		// List<MessageHeaderID> messageHeaderIDs =
		// webServiceOperation.getIntegratedConfigurationID();

		MessageHeaderID messageHeaderID = new MessageHeaderID();
		messageHeaderID.setSenderComponentID("OPICHEM_VAL");
		messageHeaderID.setInterfaceName("postInvoice_IN");
		messageHeaderID.setInterfaceNamespace("http://opint.demo.sap.com/ip");

		integratedConfiguration = webServiceOperation.getIntegrationConfiguration(messageHeaderID);

		// generate domGroup file of sender
		SenderDocDomGroupUtil senderDocDomGroupUtil = new SenderDocDomGroupUtil();
		senderDocDomGroupUtil.generateSenderDomGroupFile(integratedConfiguration);

		// generate domGroup file of virtual receiver

		// generate domGroup file of logging
		LOGDocDomUtil logDocDomUtil = new LOGDocDomUtil();
		logDocDomUtil.generateLOGDomGroupFile(integratedConfiguration);

		// generate domGroup file of staging
		STGDocDomUtil stgDocDomUtil = new STGDocDomUtil();
		stgDocDomUtil.generateSTGDomGroupFile(integratedConfiguration);

		// generate domGroup file of Inbound Processing
		InboundProcessingDocDomUtil inboundProcessingDocDomUtil = new InboundProcessingDocDomUtil();
		inboundProcessingDocDomUtil.generateInboundProcessingDomGroupFile(integratedConfiguration);

		/*
		 * List<OperationMapping> operationMappings =
		 * webServiceOperation.getOperationMappings(integratedConfiguration);
		 *
		 * System.out.println("Started.." + messageHeaderIDs.size()); for (int i
		 * = 0; i < messageHeaderIDs.size(); i++) { integratedConfiguration =
		 * webServiceOperation.getIntegrationConfiguration(messageHeaderIDs.get(
		 * i));
		 *
		 *
		 * if (integratedConfiguration != null) { System.out
		 * .println(messageHeaderIDs.get(i).getInterfaceName() + "\t:test"); }
		 *
		 * }
		 */

		Long end = System.currentTimeMillis();
		CONSTAINTS.LOG.info("Program ended!");
		CONSTAINTS.LOG.info("Time wasted:\t" + (end - start) + " (ms)");


	}

}
