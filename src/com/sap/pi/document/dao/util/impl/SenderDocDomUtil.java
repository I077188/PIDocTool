package com.sap.pi.document.dao.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.dao.Sender;
import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.Item;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;

public class SenderDocDomUtil {

	DocDomGroupUtilImpl domGroupUtil = new DocDomGroupUtilImpl();
	public void generateSenderDomGroupFile(Sender sender) {

		List<Item> items = new ArrayList<>();

		domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_SENDER, items, "ICO", false);

	}

}
