package com.sap.pi.document.dao.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.Item;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.DocDomUtilImpl;
import com.sap.xi.basis.IntegratedConfiguration;

public class OutboundProcessingDocDomUtil {

	DocDomGroupUtilImpl docDomGroupUtilImpl = new DocDomGroupUtilImpl();
	DocDomUtilImpl docDomUtilImpl = new DocDomUtilImpl();

	public void generateOutboundProcessingDomGroupFile(IntegratedConfiguration integratedConfiguration) {


		// generate domGroup file of inboundProcessing file, needn't write back
		List<Item> items = new ArrayList<>();
		items.add(new Item("$Main_Name", "OutboundProcessingSAP"));

		docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_OUTBOUNDPROCESSING, items, "ICO", false);
	}

}
