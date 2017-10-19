package com.sap.pi.document.entry;

import java.io.File;
import java.util.List;

import com.sap.pi.document.model.util.impl.ICODocUtil;
import com.sap.pi.document.util.impl.OtherUtil;
import com.sap.pi.document.util.impl.WebServiceOperationImpl;
import com.sap.pi.document.util.model.CONSTAINTS;
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.MessageHeaderID;

public class Entry {

	public static void main(String[] args) {

		Long start = System.currentTimeMillis();
		CONSTAINTS.LOG.info("Program started ... ");

		CONSTAINTS.LOG.info("\t\tInitial steps started...");
		CONSTAINTS.initial();
		CONSTAINTS.LOG.info("\t\tInitial steps are finished.");

		// clean document folder
		CONSTAINTS.LOG.info("\t\tClean document folder action started...");
		String resultFolderpath = CONSTAINTS.resultPath;
		File resultFolder = new File(resultFolderpath);

		int removeFiles = 0;
		if (resultFolder.isDirectory()) {
			File[] files = resultFolder.listFiles();

			for (int i = 0; i < files.length; i++) {
				files[i].delete();
				removeFiles++;
			}
		}
		CONSTAINTS.LOG.info("\t\tClean document folder action is finished.");
		CONSTAINTS.LOG.info("\t\tDelete files' number:\t" + removeFiles);

		WebServiceOperationImpl webServiceOperation = new WebServiceOperationImpl();
		// get all the ICO ID
		CONSTAINTS.LOG.info("\t\tData Collection started ... ");
		List<MessageHeaderID> messageHeaderIDs = webServiceOperation.getIntegratedConfigurationID();
		if (messageHeaderIDs == null) {
			return;
		}

		int number = messageHeaderIDs.size();
		CONSTAINTS.LOG.info("\t\t\tCollected ICO, number is:\t" + number);

		// for each ICO ID generated document
		IntegratedConfiguration integratedConfiguration = new IntegratedConfiguration();

		ICODocUtil icoDoc = new ICODocUtil();

		int count = 0;
		int count1 = 0;
		for (int i = 0; i < number; i++) {
			MessageHeaderID messageHeaderID = messageHeaderIDs.get(i);

			integratedConfiguration = webServiceOperation.getIntegrationConfiguration(messageHeaderID);
			// generated document
			String nameDoc = generateICODocName(messageHeaderID);

			String name = generateICOName(messageHeaderID);

			if (integratedConfiguration != null) {
				icoDoc.generateICODoc(integratedConfiguration, OtherUtil.formatName(nameDoc), name);
				count++;
				CONSTAINTS.LOG.info("------------------------------FINISHED!------------------------------");
			} else {
				count1++;
				CONSTAINTS.LOG.warn("No integration found with this messageID");
				CONSTAINTS.LOG.info("------------------------------FINISHED!------------------------------");
			}
		}

		Long end = System.currentTimeMillis();
		CONSTAINTS.LOG.info("Generate document number:\t" + count + "/" + number);
		CONSTAINTS.LOG.info("Has no ICO:\t" + count1 + "/" + number);
		CONSTAINTS.LOG.info("Program ended!");
		CONSTAINTS.LOG.info("Time wasted:\t" + (end - start) + " (ms)");
	}

	private static String generateICOName(MessageHeaderID messageHeaderID) {

		// String senderPartyID =
		// OtherUtil.getValue(messageHeaderID.getSenderPartyID());
		String senderComponentID = OtherUtil.getValue(messageHeaderID.getSenderComponentID());
		String interfaceName = OtherUtil.getValue(messageHeaderID.getInterfaceName());
		String interfaceNameSpace = OtherUtil.getValue(messageHeaderID.getInterfaceNamespace());
		// String receiverPartyID =
		// OtherUtil.getValue(messageHeaderID.getReceiverPartyID());
		// String receiverComponentID =
		// OtherUtil.getValue(messageHeaderID.getReceiverComponentID());

		return
		// senderPartyID + "|" +
		senderComponentID + "|" + interfaceName + "|" + interfaceNameSpace;
		// + "|" + receiverPartyID + "|" + receiverComponentID;

	}

	private static String generateICODocName(MessageHeaderID messageHeaderID) {

		String senderPartyID = OtherUtil.getValue(messageHeaderID.getSenderPartyID());
		String senderComponentID = OtherUtil.getValue(messageHeaderID.getSenderComponentID());
		String interfaceName = OtherUtil.getValue(messageHeaderID.getInterfaceName());
		String interfaceNameSpaceTT = OtherUtil.getValue(messageHeaderID.getInterfaceNamespace());
		String receiverPartyID = OtherUtil.getValue(messageHeaderID.getReceiverPartyID());
		String receiverComponentID = OtherUtil.getValue(messageHeaderID.getReceiverComponentID());

		String interfaceNameSpace = "N/A";
		if (!interfaceNameSpaceTT.equals("N/A")) {
			interfaceNameSpace = OtherUtil.formatName(interfaceName);
		}

		CONSTAINTS.LOG.info("-------------------start generate ICO document-----------------------");
		CONSTAINTS.LOG.info("Sender PartyID:\t" + senderPartyID);
		CONSTAINTS.LOG.info("Sender ComponentID:\t" + senderComponentID);
		CONSTAINTS.LOG.info("Interface name:\t" + interfaceName);
		CONSTAINTS.LOG.info("Interface Namespace:\t" + interfaceNameSpace);
		CONSTAINTS.LOG.info("Receiver PartyID:\t" + receiverPartyID);
		CONSTAINTS.LOG.info("Receiver ComponentID:\t" + receiverComponentID);
		CONSTAINTS.LOG.info("");

		return
//				senderPartyID + "_" +
		senderComponentID + "_" + interfaceName + "_" + interfaceNameSpaceTT;
//		+ "_" + receiverPartyID + "_"
//				+ receiverComponentID;
		// + "_" + System.currentTimeMillis();

	}

}
