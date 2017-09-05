package com.sap.pi.document.dao.util.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.sap.pi.document.dao.AdditionalIdentfier;
import com.sap.pi.document.dao.CommunicationPartyDao;
import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.IntegrationPort;
import com.sap.pi.document.util.dao.Item;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.DocDomUtilImpl;
import com.sap.pi.document.util.impl.OtherUtil;
import com.sap.xi.basis.CommunicationPartnerExtractor;
import com.sap.xi.basis.CommunicationParty;
import com.sap.xi.basis.CommunicationPartyAdditionalIdentifier;
import com.sap.xi.basis.CommunicationPartyIn;
import com.sap.xi.basis.CommunicationPartyReadIn;
import com.sap.xi.basis.CommunicationPartyReadOut;
import com.sap.xi.basis.Condition;
import com.sap.xi.basis.Extractor;
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.ReceiverDeterminationInclude;
import com.sap.xi.basis.ReceiverInterfaces;
import com.sap.xi.basis.ReceiverRule;
import com.sap.xi.basis.ReceiverRuleIn;
import com.sap.xi.basis.ReceiverRulePart;
import com.sap.xi.basis.ReceiverRuleReadIn;
import com.sap.xi.basis.ReceiverRuleReadOut;
import com.sap.xi.basis.Receivers;

public class EXTReceiverRuleDocDomUtil {

	DocDomGroupUtilImpl docDomGroupUtilImpl = new DocDomGroupUtilImpl();
	DocDomUtilImpl docDomUtilImpl = new DocDomUtilImpl();

	// generate EXTRECEIVER domGroup file write back type RECEIVERDESTINATION
	public void generateEXTReceiverDomFile(IntegratedConfiguration integratedConfiguration) {

		// receiver interface
		List<ReceiverInterfaces> receiverInterfaces = integratedConfiguration.getReceiverInterfaces();
		generateDomFileInterfaceDetermination(receiverInterfaces);

		// receiver rule
		Receivers receivers = integratedConfiguration.getReceivers();
		List<ReceiverDeterminationInclude> extReceiverRules = receivers.getExternalReceiverRule();

		if (extReceiverRules != null) {
			HashSet<String> ruleIDs = getAllRuleIDs(extReceiverRules);

			if (ruleIDs != null && ruleIDs.size() > 0) {
				List<ReceiverRule> receiverRules = getAllReceiverRules(ruleIDs);
				// generate receiver Rule part of EXTReceiver, write back type
				// EXTRECEIVER
				if (receiverRules != null && receiverRules.size() > 0) {
					generateDomFileReceiverRule(receiverRules);
				}
			}
		}

		// Generate external receiver file
		List<Item> items = new ArrayList<>();
		items.add(new Item("$Main_Name", "EXTRECEIVERSAP"));
		docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_EXTRECEIVER, items, "RECEIVERDESTINATION", true);
	}

	// get interface determination and write back to type EXTRECEIVER
	private void generateDomFileInterfaceDetermination(List<ReceiverInterfaces> receiverInterfaces) {
		ReceiverInterfaceDocDomUtil riDomUtil = new ReceiverInterfaceDocDomUtil();
		riDomUtil.generateExtReceiverInterfaceDomFile(receiverInterfaces, "EXTRECEIVER", true);
	}

	// get communication party domGroup and write back to type EXTEXTRACTOR
	private void generateDomFileCommunicationParty(List<CommunicationParty> communicationParties) {

		CommunicationPartyDocDomUtil communicationPartyDocDomUtil = new CommunicationPartyDocDomUtil();

		for (int i = 0; i < communicationParties.size(); i++) {
			CommunicationParty communicationParty = communicationParties.get(i);
			List<CommunicationPartyAdditionalIdentifier> commpartyAdditionalIdentifiers = communicationParty
					.getAdditionalIdentifier();
			List<AdditionalIdentfier> additionalIdentfiers = new ArrayList<>();
			// generate addtionalIdentifier
			if (commpartyAdditionalIdentifiers != null && commpartyAdditionalIdentifiers.size() > 0) {
				for (int j = 0; j < commpartyAdditionalIdentifiers.size(); j++) {
					CommunicationPartyAdditionalIdentifier additionalIdentifier = commpartyAdditionalIdentifiers.get(j);
					String schemeID = OtherUtil.getValue(additionalIdentifier.getSchemeID());
					String schemeAgencyID = OtherUtil.getValue(additionalIdentifier.getSchemeAgencyID());
					String Name = OtherUtil.getValue(additionalIdentifier.getValue());

					if (!(Name.equals("N/A") && schemeAgencyID.equals("N/A") && schemeID.equals("N/A"))) {
						additionalIdentfiers.add(new AdditionalIdentfier(schemeID, schemeAgencyID, Name));
					}
				}
			}

			String partyID = communicationParty.getPartyID();

			CommunicationPartyDao partyDao = new CommunicationPartyDao(partyID, additionalIdentfiers);
			communicationPartyDocDomUtil.generateCommunicationPartyDomFile(partyDao, "COMMUNICATIONPARTYS", true, 2);
		}
		List<Item> items = new ArrayList<>();
		items.add(new Item("$Main_Name", "COMMUNICATIONPARTYSAP"));
		docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_EXTCOMMUNICATIONPARTYS, items, "EXTEXTRACTOR",
				true);
	}

	// get all ReceiverRule domGroup file and write back to type EXTRECEIVER
	private void generateDomFileReceiverRule(List<ReceiverRule> receiverRules) {
		for (int i = 0; i < receiverRules.size(); i++) {
			ReceiverRule receiverRule = receiverRules.get(i);
			if (receiverRule != null) {
				generateDomFileReceiverRule(receiverRule, i);
			}
		}
		// generate domGroup file of EXTRECEIVERRULE
		// write back to type: EXTRECEIVERRULE
		List<Item> items = new ArrayList<>();
		items.add(new Item("$Main_Name", "EXTRECEIVERRULESAP"));
		docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_EXTRECEIVERRULE, items, "EXTRECEIVER",
				true);
	}

	// generate on receiver rule dom file receiver rule
	// target type EXTRECEIVERRULE
	private void generateDomFileReceiverRule(ReceiverRule receiverRule, int tag) {
		List<ReceiverRulePart> receiverRuleParts = receiverRule.getRule();
		if (receiverRuleParts != null && receiverRuleParts.size() > 0) {
			for (int i = 0; i < receiverRuleParts.size(); i++) {
				ReceiverRulePart receiverRulePart = receiverRuleParts.get(i);

				// generate domGroup for condition
				// target type is EXTRECEIVERRULEUNIT
				Condition condition = receiverRulePart.getCondition();
				List<CommunicationPartnerExtractor> extractors = receiverRulePart.getReceiver();

				ConditionDocDomUtil conditionDocDomUtil = new ConditionDocDomUtil();
				conditionDocDomUtil.generateConditionDomFile(condition, "EXTRECEIVERRULEPARTUNIT", true);

				// generate domGroup for the extractor
				// target type is EXTRECEIVERRULEPARTYUNIT
				if (extractors != null && extractors.size() > 0) {
					generateDomFileofExtractor(extractors);
				}

				// genreate one receiver rule party unit
				List<Item> items = new ArrayList<>();
				items.add(new Item("$Main_Name", "EXTRECEIVERRULEPARTYSAP" + tag));
				docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_EXTRECEIVERRULEUNIT, items,
						"EXTRECEIVERRULEPARTY", true);
			}
			// generate domGroup file of EXTRECEIVERRULEPART
			// write back to type: EXTRECEIVERRULEUNIT
			List<Item> items = new ArrayList<>();
			items.add(new Item("$Main_Name", "EXTRECEIVERRULEPARTYSAP" + tag));
			docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_EXTRECEIVERRULEPARTY, items, "EXTRECEIVERRULE",
					true);
		}
	}

	// target type EXTRECEIVERRULEUNIT
	private void generateDomFileofExtractor(List<CommunicationPartnerExtractor> extractors) {

		for (int j = 0; j < extractors.size(); j++) {
			CommunicationPartnerExtractor extractor = extractors.get(j);

			Extractor extractorComponent = extractor.getCommunicationComponent();
			Extractor extractorParty = extractor.getCommunicationParty();
			Extractor extractorPartyAgency = extractor.getCommunicationPartyAgency();
			Extractor extractorPartySchema = extractor.getCommunicationPartySchema();

			String componentID = "N/A";
			String partyID = "N/A";
			String partyAgencyID = "N/A";
			String partySchemaID = "N/A";

			if (extractorComponent != null) {
				componentID = OtherUtil.getValue(extractorComponent.getValue());
			}
			if (extractorParty != null) {
				partyID = OtherUtil.getValue(extractorParty.getValue());
			}
			if (extractorPartyAgency != null) {
				partyAgencyID = OtherUtil.getValue(extractorPartyAgency.getValue());
			}
			if (extractorPartySchema != null) {
				partySchemaID = OtherUtil.getValue(extractorPartySchema.getValue());
			}

			if (!(componentID.equals("N/A") && partyID.equals("N/A") && partyAgencyID.equals("N/A")
					&& partySchemaID.equals("N/A"))) {
				// generate dom file of extractor
				List<Item> items = new ArrayList<>();
				items.add(new Item("$Main_Name", "EXTEXTRACTORSAP"));
				items.add(new Item("$ComponentID_Value", componentID));
				items.add(new Item("$PartyID_Value", partyID));
				items.add(new Item("$PartyAgencyID_Value", partyAgencyID));
				items.add(new Item("$PartySchemaID_Value", partySchemaID));

				docDomUtilImpl.generateDomFile(CONSTAINTS.DOM_EXTEXTRACTOR, items,
						OtherUtil.formatName(componentID + partyID + partyAgencyID + partySchemaID));
			}
			// get communication party
			// target type EXTEXTRACTOR
			CommunicationPartyIn port = IntegrationPort.getCommunicationPartyPort();
			CommunicationPartyReadIn in = new CommunicationPartyReadIn();
			in.getPartyID().add(partyID);
			CommunicationPartyReadOut out = port.read(in);

			List<CommunicationParty> communicationParties = out.getParty();

			if (communicationParties != null && communicationParties.size() > 0) {
				generateDomFileCommunicationParty(communicationParties);
			}

			// generate extractor dom
			List<Item> items = new ArrayList<>();
			items.add(new Item("$Main_Name", "EXTEXTRACTORSAP" + j));
			docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_EXTEXTRACTOR, items, "EXTRECEIVERRULEUNIT",
					true);

		}
		// generate domGroup file of extractor
		// write back type EXTRECEIVERRULEPART
		List<Item> items = new ArrayList<>();
		items.add(new Item("$Main_Name", "EXTEXTRACTORSSAP"));

		docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_EXTEXTRACTORS, items, "EXTRECEIVERRULEPART", true);

	}

	private HashSet<String> getAllRuleIDs(List<ReceiverDeterminationInclude> extReceiverRules) {

		HashSet<String> result = new HashSet<>();
		for (int i = 0; i < extReceiverRules.size(); i++) {
			ReceiverDeterminationInclude extReceiverRule = extReceiverRules.get(i);

			List<String> ruleIDs = extReceiverRule.getReceiverRuleID();
			if (ruleIDs != null) {
				result.addAll(ruleIDs);
			}
		}

		return result;
	}

	private List<ReceiverRule> getAllReceiverRules(HashSet<String> ruleIDs) {

		List<ReceiverRule> result = new ArrayList<>();
		for (int j = 0; j < ruleIDs.size(); j++) {
			ReceiverRuleIn port = IntegrationPort.getReceiverRulePort();
			ReceiverRuleReadIn readIn = new ReceiverRuleReadIn();

			Iterator<String> iterator = ruleIDs.iterator();
			while (iterator.hasNext()) {
				String ruleID = iterator.next();

				readIn.getReceiverRuleID().add(ruleID);
				ReceiverRuleReadOut readOut = port.read(readIn);

				List<ReceiverRule> receiverRules = readOut.getReceiverRule();

				if (receiverRules != null) {
					result.addAll(receiverRules);
				}
			}
		}

		return result;
	}

}
