package com.sap.pi.document.model.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.DocDomUtilImpl;
import com.sap.pi.document.util.impl.OtherUtil;
import com.sap.pi.document.util.model.CONSTAINTS;
import com.sap.pi.document.util.model.Item;
import com.sap.xi.basis.DesignObjectID;
import com.sap.xi.basis.IntegratedConfigurationReceiverInterfaceRule;
import com.sap.xi.basis.QualityOfService;
import com.sap.xi.basis.ReceiverInterfaces;

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

			domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_RR_RECEIVERINTERFACE, items, type, move2dom);
		}
	}

	public void generateExtReceiverInterfaceDomFile(List<ReceiverInterfaces> interfaces, String type,
			boolean move2dom) {
		if (interfaces != null && interfaces.size() > 0) {

			for (int i = 0; i < interfaces.size(); i++) {
				List<Item> items = new ArrayList<>();

				ReceiverInterfaces receiverInterfaces = interfaces.get(i);

				QualityOfService qos = receiverInterfaces.getQualityOfService();
				if (qos != null) {
					String qosValue = qos.value();
					items.add(new Item("$Qos_Value", qosValue));
				}

				List<IntegratedConfigurationReceiverInterfaceRule> rirs = receiverInterfaces.getReceiverInterfaceRule();
				if (rirs != null && rirs.size() > 0) {

					for (int j = 0; j < rirs.size(); j++) {
						IntegratedConfigurationReceiverInterfaceRule rir = rirs.get(j);

						String operation = OtherUtil.getValue(rir.getOperation());
						DesignObjectID mapping = rir.getMapping();

						String opMapping = "N/A";
						if (mapping != null) {
							String name = OtherUtil.getValue(mapping.getName());
							String nameSpace = OtherUtil.getValue(mapping.getNamespace());
							String swc = OtherUtil.getValue(mapping.getSoftwareComponentVersionID());

							if (!(name.equals("N/A") && nameSpace.equals("N/A") && swc.equals("N/A"))) {
								opMapping = name + "|" + nameSpace + "|" + swc;
							}
						}

						String interfacesValue = "N/A";
						List<DesignObjectID> interfacesIDS = rir.getInterface();
						if (interfacesIDS != null) {
							StringBuilder sb = new StringBuilder();
							int tip = 0;
							for (int k = 0; k < interfacesIDS.size(); k++) {
								DesignObjectID interfaceID = interfacesIDS.get(k);

								String name = OtherUtil.getValue(interfaceID.getName());
								String nameSpace = OtherUtil.getValue(interfaceID.getNamespace());
								String swc = OtherUtil.getValue(interfaceID.getSoftwareComponentVersionID());

								if (!(name.equals("N/A") && nameSpace.equals("N/A") && swc.equals("N/A"))) {
									sb.append(tip + "|" + name + "|" + nameSpace + "|" + swc + "\n");
									tip++;
								}

							}
							interfacesValue = OtherUtil.getValue(sb.toString());
						}

						// create dom file of interface determination
						List<Item> errItems = new ArrayList<>();
						errItems.add(new Item("$Main_Name", "ERRRECEIVERINTERFACERULEPARTSAP"));
						errItems.add(new Item("$Operation_Value", operation));
						errItems.add(new Item("$OperationMapping_Value", opMapping));
						errItems.add(new Item("$ReceiverInterface_Value", interfacesValue));

						domUtil.generateDomFile(CONSTAINTS.DOM_EXTRECEIVERINTERFACERULE, errItems,
								OtherUtil.formatName(operation) + j);
					}
				}

				// generate internal party of receiver rule interface with
				// number
				items.add(new Item("$Main_Name", "EXTINTERFACERULEUNITSAP"));

				domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_EXTRECEIVERINTERFACERULE, items,
						"EXTRECEIVERINTERFACE_" + i, true);
			}
			// generate interface determination
			List<Item> items = new ArrayList<>();
			items.add(new Item("$Main_Name", "EXTRECEIVERINTERFACESAP"));

			domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_EXTRECEIVERINTERFACE, items, type, move2dom);
		}
	}

}
