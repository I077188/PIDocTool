package com.sap.pi.document.entry;

import java.util.List;

import com.sap.pi.document.dao.util.impl.ICODocUtil;
import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.impl.OtherUtil;
import com.sap.pi.document.util.impl.WebServiceOperationImpl;
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.MessageHeaderID;

public class Entry {

	public static void main(String[] args) {

		Long start = System.currentTimeMillis();
		CONSTAINTS.LOG.info("Program started ... ");

		CONSTAINTS.initial();
		CONSTAINTS.LOG.info("\t\tInitial steps are finished.");

		WebServiceOperationImpl webServiceOperation = new WebServiceOperationImpl();
		// get all the ICO ID
		CONSTAINTS.LOG.info("\t\tData Collection started ... ");
		List<MessageHeaderID> messageHeaderIDs = webServiceOperation.getIntegratedConfigurationID();
		CONSTAINTS.LOG.info("\t\t\tCollected ICO, number is:\t" + messageHeaderIDs.size());

		// for each ICO ID generated document
		IntegratedConfiguration integratedConfiguration = new IntegratedConfiguration();

		ICODocUtil icoDoc = new ICODocUtil();
		for (int i = 0; i < messageHeaderIDs.size(); i++) {
			MessageHeaderID messageHeaderID = messageHeaderIDs.get(i);
			String name = generateICOName(messageHeaderID);

			integratedConfiguration = webServiceOperation.getIntegrationConfiguration(messageHeaderID);
			// generated document
			icoDoc.generateICODoc(integratedConfiguration, name);
		}

		Long end = System.currentTimeMillis();
		CONSTAINTS.LOG.info("Program ended!");
		CONSTAINTS.LOG.info("Time wasted:\t" + (end - start) + " (ms)");
	}

	private static String generateICOName(MessageHeaderID messageHeaderID) {

		String senderPartyID = OtherUtil.getValue(messageHeaderID.getSenderPartyID());
		String senderComponentID = OtherUtil.getValue(messageHeaderID.getSenderComponentID());
		String interfaceName = OtherUtil.getValue(messageHeaderID.getInterfaceName());
		String interfaceNameSpaceTT = OtherUtil.getValue(messageHeaderID.getInterfaceNamespace());
		String receiverPartyID = OtherUtil.getValue(messageHeaderID.getReceiverPartyID());
		String receiverComponentID = OtherUtil.getValue(messageHeaderID.getSenderComponentID());

		String interfaceNameSpace = "N/A";
		if (!interfaceNameSpaceTT.equals("N/A")) {
			interfaceNameSpace = interfaceName.replaceAll("http://", "");
		}

		return senderPartyID + "$" + senderComponentID + "$" + interfaceName + "$" + interfaceNameSpace + "$"
				+ receiverPartyID + "$" + receiverComponentID;

	}

}
