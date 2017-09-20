package com.sap.pi.document.dao.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.dao.ReceiverDao;
import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.Item;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.OtherUtil;
import com.sap.xi.basis.CommunicationComponentID;
import com.sap.xi.basis.Condition;
import com.sap.xi.basis.DesignObjectID;
import com.sap.xi.basis.IntegratedConfigurationReceiverInterfaceRule;
import com.sap.xi.basis.MappingParameters;
import com.sap.xi.basis.ReceiverInterfaces;

public class ReceiverDaoDocDomUtil {

	DocDomGroupUtilImpl docDomGroupUtilImpl = new DocDomGroupUtilImpl();

	public void generateReceiverDomFile(List<ReceiverDao> receiverDaos, String type, boolean move2dom) {

		// receiverDao including 1 receiver rule and related receiver interface
		for (int i = 0; i < receiverDaos.size(); i++) {
			// receiver
			ReceiverDao receiverDao = receiverDaos.get(i);

			CommunicationComponentID receiverRule = receiverDao.getReceiverRule();
			String componentID = OtherUtil.getValue(receiverRule.getComponentID());
			String partID = OtherUtil.getValue(receiverRule.getPartyID());

			List<ReceiverInterfaces> receiverInterfaces = receiverDao.getReceiverInterface();

			if (receiverInterfaces == null && componentID.equals("N/A") && partID.equals("N/A")) {
				return;
			} else {
				for (int j = 0; j < receiverInterfaces.size(); j++) {
					// interface determination
					ReceiverInterfaces receiverInterface = receiverInterfaces.get(j);
					List<IntegratedConfigurationReceiverInterfaceRule> receiverInterfaceRules = receiverInterface
							.getReceiverInterfaceRule();

					if (receiverInterfaceRules != null && receiverInterfaceRules.size() > 0) {
						for (int k = 0; k < receiverInterfaceRules.size(); k++) {
							// interface rule
							IntegratedConfigurationReceiverInterfaceRule receiverInterfaceRule = receiverInterfaceRules
									.get(k);

							String operation = OtherUtil.getValue(receiverInterfaceRule.getOperation());

							DesignObjectID mapping = receiverInterfaceRule.getMapping();
							MappingParameters mappingParameter = receiverInterfaceRule.getMappingParameters();

							Condition condition = receiverInterfaceRule.getCondition();

							List<DesignObjectID> interfaces = receiverInterfaceRule.getInterface();

							// generate operation Mapping related domGroup file
							// and write back to dom file of Receiver Interface
							RIROperationMappingDocDomUtil opMappingDocDomUtil = new RIROperationMappingDocDomUtil();
							opMappingDocDomUtil.generateMappingDomFile(operation, mapping, mappingParameter, "RIR_" + k,
									true);

							// generate condition part for receiver interface rule
							// if (condition != null) {
							// ConditionDocDomUtil conditionDocDomUtil = new
							// ConditionDocDomUtil();
							// //
							// conditionDocDomUtil.generateConditionDomFile(condition,
							// // "RIR", true);
							// conditionDocDomUtil.generateConditionStringDomFile(condition,
							// "RIR_" + k, true);
							// }
							String conditionValue = "N/A";
							if (condition != null) {
								conditionValue = OtherUtil.getValue(OtherUtil.getCondition(condition));
							}


							// generate interfaces related domGroup file and
							// write back to dom file of receiver interface
							ReceiverInterfaceDocDomUtil riDocDomUtil = new ReceiverInterfaceDocDomUtil();
							riDocDomUtil.generateInterfaceDomFile(interfaces, "RIR_" + k, true);

							// generate receiver Interface rule domGroup file
							// and write back to
							List<Item> items = new ArrayList<>();
							items.add(new Item("$Main_Name", OtherUtil.formatName(operation)));
							items.add(new Item("$Operation_Name", operation));
							items.add(new Item("$Condition_Value", conditionValue));

							docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_RR_RIR, items, "INTERFACEDETERMINATION_" + k, true);
						}
					}

					// generate the domGroup file of interface determination and
					// write back to dom, targe type is receiver
					String quality = OtherUtil.getValue(receiverInterface.getQualityOfService().value());

					List<Item> items = new ArrayList<>();
					items.add(new Item("$Main_Name", OtherUtil.formatName(quality)));
					items.add(new Item("$QoS_Value", quality));
					docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_RR_INTERFACEDETERMINATION, items, "RECEIVER_" + j, true);
				}
			}


			// generate receiver domGroup file and write back to the dom, target
			// type is the RR - receiver rule
			List<Item> items = new ArrayList<>();
			items.add(new Item("$Main_Name", OtherUtil.formatName(partID + "-" + componentID)));
			items.add(new Item("$PartyID_Value", partID));
			items.add(new Item("$ComponentID_Value", componentID));

			docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_RR_RECEIVER, items, "RECEIVERS_" + i, true);
		}

		// generate receiver rule domGroup file and write back to dom, targe
		// type is RD determination
		List<Item> items = new ArrayList<>();
		items.add(new Item("$Main_Name", "receiverRuleSAP"));

		docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_RR_RECEIVERS, items, type, move2dom);

	}

}
