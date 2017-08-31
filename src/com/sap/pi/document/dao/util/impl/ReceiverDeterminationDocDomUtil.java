package com.sap.pi.document.dao.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.Item;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.xi.basis.IntegratedConfiguration;

public class ReceiverDeterminationDocDomUtil {

	public void generateRDDomFile(IntegratedConfiguration integratedConfiguration) {

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
		DocDomGroupUtilImpl domGroupUtil = new DocDomGroupUtilImpl();
		List<Item> rDestinationDomGroupItems = new ArrayList<>();
		rDestinationDomGroupItems.add(new Item("$Main_Name", "receiverDestination"));
		domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_RD, rDestinationDomGroupItems, "ICO", true);
	}

}
