package com.sap.pi.document.dao.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.Item;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.OtherUtil;
import com.sap.xi.basis.CommunicationComponentID;
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.NoReceiverBehaviour;
import com.sap.xi.basis.Receivers;

public class ReceiverDeterminationDocDomUtil {

	public void generateRDDomGroupFile(IntegratedConfiguration integratedConfiguration) {

		DocDomGroupUtilImpl domGroupUtil = new DocDomGroupUtilImpl();

		// generate Receiver Rule Part
		ReceiverRuleDocDomUtil rrDocDomUtil = new ReceiverRuleDocDomUtil();
		rrDocDomUtil.generateRRDomFile(integratedConfiguration);

		// generate external Receiver Rule Part
		EXTReceiverRuleDocDomUtil errDocDomUtil = new EXTReceiverRuleDocDomUtil();
		errDocDomUtil.generateEXTReceiverDomFile(integratedConfiguration);

		// generate dynamic Receiver Rule Part
		DRRDocDomUtil drrDocDomUtil = new DRRDocDomUtil();
		drrDocDomUtil.generateDRRDomFile(integratedConfiguration);

		// dom group Receiver Destination, write back to type ICO
		Receivers receiver = integratedConfiguration.getReceivers();
		List<Item> rDestinationDomGroupItems = new ArrayList<>();
		String noReceiverBehavior = "N/A";
		String noReceiverReceiver = "N/A";

		if (receiver != null) {
			NoReceiverBehaviour noReceiverBehaviour = receiver.getNoReceiverBehaviour();
			String partyID = "N/A";
			String componentID = "N/A";

			if (noReceiverBehaviour != null) {
				noReceiverBehavior = OtherUtil.getValue(noReceiverBehavior.toString());
			}

			CommunicationComponentID ccID = receiver.getNoReceiverReceiver();
			if (ccID != null) {
				partyID = OtherUtil.getValue(ccID.getPartyID());
				componentID = OtherUtil.getValue(ccID.getComponentID());
			}

			if (partyID != "N/A") {
				noReceiverReceiver = partyID + "|";
				if (componentID != "N/A") {
					noReceiverReceiver = noReceiverReceiver + componentID;
				}
			} else {
				if (componentID != "N/A") {
					noReceiverReceiver = componentID;
				}
			}
		}
		rDestinationDomGroupItems.add(new Item("$NoReceiverBehavior_Value", noReceiverBehavior));
		rDestinationDomGroupItems.add(new Item("$NoReceiverReceiver_Value", noReceiverReceiver));
		rDestinationDomGroupItems.add(new Item("$Main_Name", "receiverDetermination"));
		domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_RECEIVERDETERMINATION, rDestinationDomGroupItems, "ICO",
				false);

	}

}
