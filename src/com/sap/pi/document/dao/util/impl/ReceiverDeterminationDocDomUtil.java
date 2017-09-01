package com.sap.pi.document.dao.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.Item;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.OtherUtil;
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.Receivers;

public class ReceiverDeterminationDocDomUtil {

	public void generateRDDomGroupFile(IntegratedConfiguration integratedConfiguration) {

		DocDomGroupUtilImpl domGroupUtil = new DocDomGroupUtilImpl();

		// generate Receiver Rule Part
		ReceiverRuleDocDomUtil rrDocDomUtil = new ReceiverRuleDocDomUtil();
		rrDocDomUtil.generateRRDomFile(integratedConfiguration);

		// generate external Receiver Rule Part
		ERRDocDomUtil errDocDomUtil = new ERRDocDomUtil();
		errDocDomUtil.generateERRDomFile(integratedConfiguration);


		// generate dynamic Receiver Rule Part
		DRRDocDomUtil drrDocDomUtil = new DRRDocDomUtil();
		drrDocDomUtil.generateDRRDomFile(integratedConfiguration);

		// dom group Receiver Destination, write back to type ICO

		Receivers receiver = integratedConfiguration.getReceivers();
		if (receiver != null) {
			String noReceiverBehavior = OtherUtil
					.getValue(receiver.getNoReceiverBehaviour().toString());
			String partyID = OtherUtil.getValue(receiver.getNoReceiverReceiver().getPartyID());
			String componentID = OtherUtil.getValue(receiver.getNoReceiverReceiver().getComponentID());
			String noReceiverReceiver = "N/A";

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

			List<Item> rDestinationDomGroupItems = new ArrayList<>();
			rDestinationDomGroupItems.add(new Item("$Main_Name", "receiverDestination"));
			rDestinationDomGroupItems.add(new Item("$NoReceiverBehavior_Value", noReceiverBehavior));
			rDestinationDomGroupItems.add(new Item("$NoReceiverReceiver_Value", noReceiverReceiver));
			domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_RD, rDestinationDomGroupItems, "ICO", false);
		}

	}

}
