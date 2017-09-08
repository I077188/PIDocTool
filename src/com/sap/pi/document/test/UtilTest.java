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
		messageHeaderID.setSenderComponentID("BC_KELLY_RestSender");
		messageHeaderID.setInterfaceName("SI_Rest_Sender");
		messageHeaderID.setInterfaceNamespace("http://kelly.fourth.rest2restModel");
		messageHeaderID.setReceiverPartyID("CIDX_Buyer_Party");
		messageHeaderID.setReceiverComponentID("BC_ANGELA_JDBC_Receiver");
		// messageHeaderID.setSenderComponentID("CC_KELLY_SOAP_SENDER");
		// messageHeaderID.setInterfaceName("SI_Srudent_OUT");
		// messageHeaderID.setInterfaceNamespace("http://kelly.fistModel");
		// messageHeaderID.setSenderComponentID("BS_SOAPUI_Anna");
		// messageHeaderID.setInterfaceName("SI_Student_Out_Async");
		// messageHeaderID.setInterfaceNamespace("http://firstdemo");

		/*
		 * <SenderComponentID>CC_KELLY_SOAP_SENDER</SenderComponentID>
		 * <InterfaceName>SI_Srudent_OUT</InterfaceName>
		 * <InterfaceNamespace>http://kelly.fistModel</InterfaceNamespace>
		 */

		integratedConfiguration = webServiceOperation.getIntegrationConfiguration(messageHeaderID);


		// if (integratedConfiguration == null) {
		// System.out.println("null");
		// } else {
		// ICODocUtil icoDoc = new ICODocUtil();
		// icoDoc.generateICODoc(integratedConfiguration, "test");
		// }

		// generate domGroup file of Receiver Determination
		// ReceiverDeterminationDocDomUtil receiverDeterminationDocDomUtil = new
		// ReceiverDeterminationDocDomUtil();
		// receiverDeterminationDocDomUtil.generateRDDomGroupFile(integratedConfiguration);

		// generate Receiver Rule Part
		// ReceiverRuleDocDomUtil rrDocDomUtil = new ReceiverRuleDocDomUtil();
		// rrDocDomUtil.generateRRDomFile(integratedConfiguration);

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
