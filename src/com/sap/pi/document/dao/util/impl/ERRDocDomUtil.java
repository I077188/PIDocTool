package com.sap.pi.document.dao.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.IntegrationPort;
import com.sap.pi.document.util.dao.Item;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.DocDomUtilImpl;
import com.sap.pi.document.util.impl.OtherUtil;
import com.sap.xi.basis.AtomicCondition;
import com.sap.xi.basis.AtomicConditionBlock;
import com.sap.xi.basis.CommunicationPartnerExtractor;
import com.sap.xi.basis.Condition;
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.ReceiverDeterminationInclude;
import com.sap.xi.basis.ReceiverRule;
import com.sap.xi.basis.ReceiverRuleIn;
import com.sap.xi.basis.ReceiverRulePart;
import com.sap.xi.basis.ReceiverRuleReadIn;
import com.sap.xi.basis.ReceiverRuleReadOut;
import com.sap.xi.basis.Receivers;

// External receiver rule
public class ERRDocDomUtil {

	DocDomUtilImpl domUtil = new DocDomUtilImpl();
	DocDomGroupUtilImpl domGroupUtil = new DocDomGroupUtilImpl();

	// generate Dom file
	public void generateERRDomFile(IntegratedConfiguration integratedConfiguration) {

		// get informations from the integrated configuration
		Receivers receivers = integratedConfiguration.getReceivers();
		List<ReceiverDeterminationInclude> etReceiverRules = receivers.getExternalReceiverRule();

		if (etReceiverRules.size() > 0) {

			for (int i = 0; i < etReceiverRules.size(); i++) {
				ReceiverDeterminationInclude etReceiverRule = etReceiverRules.get(i);

				// get operation name
				// String operation =
				// OtherUtil.getValue(etReceiverRule.getOperation());

				List<String> etReceiverRuleIds = etReceiverRule.getReceiverRuleID();

				// generate RULR related domGroup and dom file, move required(Contain
				// condition(1) and receiver(n))
				for (int j = 0; j < etReceiverRuleIds.size(); j++) {

					ReceiverRuleIn port = IntegrationPort.getReceiverRulePort();
					ReceiverRuleReadIn readIn = new ReceiverRuleReadIn();

					readIn.getReceiverRuleID().add(etReceiverRuleIds.get(i));
					ReceiverRuleReadOut readOut = port.read(readIn);

					List<ReceiverRule> receiverRules = readOut.getReceiverRule();

					for (int n = 0; n < receiverRules.size(); n++) {

						ReceiverRule receverRule = readOut.getReceiverRule().get(n);
						List<ReceiverRulePart> ruleParts = receverRule.getRule();

						for (int m = 0; m < ruleParts.size(); m++) { // For each Rule
							ReceiverRulePart externalReceiverRule = ruleParts.get(m);

							String condition = this.getCondition(externalReceiverRule.getCondition());
							condition = OtherUtil.getValue(condition);

							// generate condition related dom and dom Group file, write back to rule UNIT
							List<Item> conditionDomItems = new ArrayList<>();
							conditionDomItems.add(new Item("$Main_Name", etReceiverRuleIds.get(j)));
							// conditionDomItems.add(new Item("$ExternalRuleId_Value",
							// etReceiverRuleIds.get(j)));
							conditionDomItems.add(new Item("$Condition_Value", condition));
							domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_ERR_CONDITION, conditionDomItems,
									"RULEPARTSUNIT", true);

							// GENERATE RECEIVER related dom and domGroup file
							List<CommunicationPartnerExtractor> extractors = externalReceiverRule.getReceiver();
							for (int k = 0; k < extractors.size(); k++) {
								this.generateERRRULERECEIVERDomFile(extractors.get(k), String.valueOf(k));
							}

							// write back to dom, type RULEPARTSUNIT
							List<Item> receiverDomGroupItems = new ArrayList<>();
							receiverDomGroupItems.add(new Item("$Main_Name", "ruleReceiver"));
							domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_ERR_RULR_RECEIVER,
									receiverDomGroupItems, "RULEPARTSUNIT", true);

							// generate domGroup for rule part unit, write back type rule part
							List<Item> errRuleUnitItems = new ArrayList<>();
							receiverDomGroupItems.add(new Item("$Main_Name", "ruleUnit"));
							domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_ERR_RULE_PARTSUNIT, errRuleUnitItems,
									"RULEPART", true);

						}
						// generate rule domGROUP file with rule part, write back receiver rule
						List<Item> ruleDomGroupItems = new ArrayList<>();
						ruleDomGroupItems.add(new Item("$Main_Name", "rule"));
						domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_ERR_RULEPARTS, ruleDomGroupItems,
								"RECEIVERRULE", true);
					}
					// generate receiver rule domGROUP file with rule part, write back rule ID
					List<Item> ruleDomGroupItems = new ArrayList<>();
					ruleDomGroupItems.add(new Item("$Main_Name", "rule"));
					domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_ERR_RECEIVERRULE, ruleDomGroupItems, "RULEID",
							true);
				}

				// generate ruleID domGROUP file
				List<Item> ruleIdDomGroupItems = new ArrayList<>();
				ruleIdDomGroupItems.add(new Item("$Main_Name", "ruleId"));
				domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_ERR_RULEID, ruleIdDomGroupItems, "ERR", true);
			}

			// generate ExternalRule domGROUP file
			List<Item> ruleIdDomGroupItems = new ArrayList<>();
			ruleIdDomGroupItems.add(new Item("$Main_Name", "externalRule"));
			domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_ERR, ruleIdDomGroupItems, "RD", true);
		}
	}

	// generate receiver(external rule -->..--> rule-->receiver ) dom file
	public void generateERRRULERECEIVERDomFile(CommunicationPartnerExtractor receiver, String num) {

		String communicationPartyID = OtherUtil.getValue(receiver.getCommunicationParty().getValue());
		String schemeID = OtherUtil.getValue(receiver.getCommunicationPartySchema().getValue());
		String schemeAgencyID = OtherUtil.getValue(receiver.getCommunicationPartyAgency().getValue());
		String name = OtherUtil.getValue(receiver.getCommunicationParty().getValue());

		String communicationComponentId = OtherUtil.getValue(receiver.getCommunicationComponent().getValue());

		List<Item> receiverDomItems = new ArrayList<>();

		receiverDomItems.add(new Item("$Receiver_Value", num));
		receiverDomItems.add(new Item("$CommunicationPartyId_Value", communicationPartyID));
		receiverDomItems.add(new Item("$SchemeId_Value", schemeID));
		receiverDomItems.add(new Item("$SchemaAgencyId_Value", schemeAgencyID));
		receiverDomItems.add(new Item("$Name_Value", name));
		receiverDomItems.add(new Item("$CommunicationComponent_Value", communicationComponentId));
		domUtil.generateDomFile(CONSTAINTS.DOM_ERR_RULR_RECEIVER, receiverDomItems, num);
	}

	public String getCondition(Condition condition) {
		// TODO Auto-generated method stub
		StringBuilder conditionString = new StringBuilder();
		for (int i = 0; i < condition.getAtomicConditionBlock().size(); i++) {
			AtomicConditionBlock atomicConditionBlock = condition.getAtomicConditionBlock().get(i);
			if (i > 0) {
				conditionString.append("OR(");
			} else {
				conditionString.append("(");
			}

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
				conditionString.append(oneCondition);
				if (i < condition.getAtomicConditionBlock().size()) {
					conditionString.append(" AND ");
				}

			}
			conditionString.append(")");
		}
		return conditionString.toString();
	}

}
