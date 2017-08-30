package com.sap.pi.document.dao.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.Item;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.DocDomUtilImpl;
import com.sap.pi.document.util.impl.OtherUtil;
import com.sap.xi.basis.DesignObjectID;

public class ReceiverInterfaceDocDomUtil {

	DocDomUtilImpl domUtil = new DocDomUtilImpl();
	DocDomGroupUtilImpl domGroupUtil = new DocDomGroupUtilImpl();

	public void generateInterfaceDomFile(List<DesignObjectID> interfaces, String type, boolean move2dom) {
		for (int i = 0; i < interfaces.size(); i++) {
			DesignObjectID receiverInterface = interfaces.get(i);

			String interfaceName = OtherUtil.getValue(receiverInterface.getName());
			String interfaceNameSpace = OtherUtil.getValue(receiverInterface.getNamespace());
			String interfaceSWC = OtherUtil.getValue(receiverInterface.getSoftwareComponentVersionID());

			List<Item> items = new ArrayList<>();
			// how to add?
			items.add(new Item("$Main_Name", "receiverInterfaceSAP"));
			items.add(new Item("$Name_Value", interfaceName));
			items.add(new Item("$NameSpace_Value", interfaceNameSpace));
			items.add(new Item("$ComponentID_Value", interfaceSWC));

			domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_RECEIVERINTERFACE, items, type, move2dom);
		}


	}
}
