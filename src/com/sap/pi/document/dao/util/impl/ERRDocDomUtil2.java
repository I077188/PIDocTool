package com.sap.pi.document.dao.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.IntegrationPort;
import com.sap.pi.document.util.dao.Item;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.DocDomUtilImpl;
import com.sap.xi.basis.AtomicCondition;
import com.sap.xi.basis.AtomicConditionBlock;
import com.sap.xi.basis.CommunicationPartnerExtractor;
import com.sap.xi.basis.Condition;
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.ReceiverDeterminationInclude;
import com.sap.xi.basis.ReceiverRuleIn;
import com.sap.xi.basis.ReceiverRulePart;
import com.sap.xi.basis.ReceiverRuleReadIn;
import com.sap.xi.basis.ReceiverRuleReadOut;
import com.sap.xi.basis.Receivers;

// External receiver rule
public class ERRDocDomUtil2 {

	DocDomUtilImpl domUtil = new DocDomUtilImpl();
	DocDomGroupUtilImpl domGroupUtil = new DocDomGroupUtilImpl();
	// generate Dom file
	public void generateERRDomFile(IntegratedConfiguration integratedConfiguration) {

		// get informations from the integrated configuration

		List<ReceiverDeterminationInclude> etReceiverRules = new ArrayList<>();
		Receivers receivers = integratedConfiguration.getReceivers();
		etReceiverRules = receivers.getExternalReceiverRule();

		if (etReceiverRules.size() > 0) {

			for (int i = 0; i < etReceiverRules.size(); i++) {
				ReceiverDeterminationInclude etReceiverRule = etReceiverRules.get(i);

				// get operation name
				String operation = etReceiverRule.getOperation();
				operation = (operation.equals("") || operation == null) ? "N/A" : operation;

				List<String> etReceiverRuleIds = etReceiverRule.getReceiverRuleID();

				// generate RULR related domGroup and dom file, move required(Contain
				// condition(1) and receiver(n))
				for (int j = 0; j < etReceiverRuleIds.size(); j++) {

					ReceiverRuleIn port = IntegrationPort.getReceiverRulePort();
					ReceiverRuleReadIn readIn = new ReceiverRuleReadIn();

					readIn.getReceiverRuleID().add(etReceiverRuleIds.get(i));
					ReceiverRuleReadOut	readOut = port.read(readIn);


					if(readOut.getReceiverRule().size()>0) {
						//Notice: There may be several rules under one external receiver rule ID, this time only considered there is only one rule !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
						ReceiverRulePart externalReceiverRule = readOut.getReceiverRule().get(0).getRule().get(0);
						String condition = this.getCondition(externalReceiverRule.getCondition()).substring(5);
						condition = (condition == null || condition.equals("")) ? "N/A" : condition;

						// GENERATE RECEIVER related dom file
						for (int k = 0; k < externalReceiverRule.getReceiver().size(); k++) {
							this.generateERRRULERECEIVERDomFile(externalReceiverRule.getReceiver().get(k), k + "");
						}

						String num = i + j + 1 + "";
						System.out.println(num);
						List<Item> integerDomItems = new ArrayList<>();

						// integerDomItems.add(new Item("$Num_Value", num));
						integerDomItems.add(new Item("$ExternalRuleId_Value", etReceiverRuleIds.get(j)));
						integerDomItems.add(new Item("$Condition_Value", condition));
						domUtil.generateDomFile(CONSTAINTS.DOM_ERR, integerDomItems, etReceiverRuleIds.get(j));
					}
				}
				List<Item> integerDomGroupItems = new ArrayList<>();
				domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP__ERR, integerDomGroupItems, "ERRRULE",
						true);
			}
		}
	}

	public void generateERRRULERECEIVERDomFile(CommunicationPartnerExtractor receiver, String num) {
		// TODO Auto-generated method stub
		String communicationPartyID = receiver.getCommunicationParty().getValue();
		communicationPartyID = communicationPartyID == null ? "N/A" : communicationPartyID;
		String schemeID = receiver.getCommunicationPartySchema().getValue();
		schemeID = schemeID == null ? "N/A" : schemeID;
		String schemeAgencyID = receiver.getCommunicationPartyAgency().getValue();
		schemeAgencyID = schemeAgencyID == null ? "N/A" : schemeAgencyID;
		String name = receiver.getCommunicationParty().getValue();
		name = name == null ? "N/A" : name;

		String communicationComponentId = receiver.getCommunicationComponent().getValue();
		communicationComponentId = communicationComponentId == null ? "N/A" : communicationComponentId;

		List<Item> integerDomItems = new ArrayList<>();

		integerDomItems.add(new Item("$Receiver_Value", num));
		integerDomItems.add(new Item("$CommunicationPartyId_Value", communicationPartyID));
		integerDomItems.add(new Item("$SchemeId_Value", schemeID));
		integerDomItems.add(new Item("$SchemaAgencyId_Value", schemeAgencyID));
		integerDomItems.add(new Item("$Name_Value", name));
		domUtil.generateDomFile(CONSTAINTS.DOM_ERR_RULR_RECEIVER, integerDomItems, num);
	}

	public String getCondition(Condition condition) {
		// TODO Auto-generated method stub
		StringBuilder conditionString = new StringBuilder();
		for(int i =0; i<condition.getAtomicConditionBlock().size();i++) {
			AtomicConditionBlock atomicConditionBlock = condition.getAtomicConditionBlock().get(i);
			conditionString.append(" OR ");
			for (int j = 0; j < atomicConditionBlock.getAtomicCondition().size(); j++) {
				AtomicCondition atomicCondition = atomicConditionBlock.getAtomicCondition().get(j);
				String operator = atomicCondition.getOperator();
				if (operator == "EQ") {
					operator = "=";
				} else if (operator == "NE") {
					operator = "!=";
				} else if (operator == "CP") {
					operator = "~";
				}
				String leftExtrator = atomicCondition.getLeftExtractor().getContextObjectName();
				String rightExtrator = atomicCondition.getRightExtractor().getValue();
				String oneCondition = leftExtrator + " " + operator + " " + rightExtrator;
				conditionString.append(" AND ");
				conditionString.append(oneCondition);

			}
		}
		return conditionString.toString();
	}



}
