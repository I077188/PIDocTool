package com.sap.pi.document.test;

import com.sap.pi.document.dao.util.impl.EXTReceiverRuleDocDomUtil;
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

		MessageHeaderID messageHeaderID = new MessageHeaderID();
		messageHeaderID.setSenderComponentID("CC_KELLY_SOAP_SENDER");
		messageHeaderID.setInterfaceName("SI_Srudent_OUT");
		messageHeaderID.setInterfaceNamespace("http://kelly.fistModel");

		integratedConfiguration = webServiceOperation.getIntegrationConfiguration(messageHeaderID);

		/*
		 * // generate domGroup file of Receiver Determination
		 * ReceiverDeterminationDocDomUtil receiverDeterminationDocDomUtil = new
		 * ReceiverDeterminationDocDomUtil();
		 * receiverDeterminationDocDomUtil.generateRDDomGroupFile(
		 * integratedConfiguration);
		 */

		// generate external Receiver Rule Part
		EXTReceiverRuleDocDomUtil errDocDomUtil = new EXTReceiverRuleDocDomUtil();
		errDocDomUtil.generateEXTReceiverDomFile(integratedConfiguration);

		/*
		 * List<MessageHeaderID> messageHeaderIDs =
		 * webServiceOperation.getIntegratedConfigurationID();
		 *
		 * for (int i = 0; i < 15; i++) { integratedConfiguration =
		 * webServiceOperation.getIntegrationConfiguration(messageHeaderIDs.get(
		 * i));
		 *
		 * // generate domGroup file of sender SenderDocDomGroupUtil
		 * senderDocDomGroupUtil = new SenderDocDomGroupUtil();
		 * senderDocDomGroupUtil.generateSenderDomGroupFile(
		 * integratedConfiguration);
		 *
		 * // generate domGroup file of virtual receiver
		 *
		 * // generate domGroup file of logging LOGDocDomUtil logDocDomUtil =
		 * new LOGDocDomUtil();
		 * logDocDomUtil.generateLOGDomGroupFile(integratedConfiguration);
		 *
		 * // generate domGroup file of staging STGDocDomUtil stgDocDomUtil =
		 * new STGDocDomUtil();
		 * stgDocDomUtil.generateSTGDomGroupFile(integratedConfiguration);
		 *
		 * // generate domGroup file of Inbound Processing
		 * InboundProcessingDocDomUtil inboundProcessingDocDomUtil = new
		 * InboundProcessingDocDomUtil();
		 * inboundProcessingDocDomUtil.generateInboundProcessingDomGroupFile(
		 * integratedConfiguration);
		 *
		 * // generate domGroup file of Outbound Processing
		 * OutboundProcessingDocDomUtil outboundProcessingDocDomUtil = new
		 * OutboundProcessingDocDomUtil();
		 * outboundProcessingDocDomUtil.generateOutboundProcessingDomGroupFile(
		 * integratedConfiguration);
		 *
		 * }
		 */

		Long end = System.currentTimeMillis();
		CONSTAINTS.LOG.info("Program ended!");
		CONSTAINTS.LOG.info("Time wasted:\t" + (end - start) + " (ms)");


	}

}
