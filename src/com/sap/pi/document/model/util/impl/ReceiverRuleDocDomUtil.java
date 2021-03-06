package com.sap.pi.document.model.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.model.ReceiverDao;
import com.sap.pi.document.model.ReceiverRuleDao;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.OtherUtil;
import com.sap.pi.document.util.model.CONSTAINTS;
import com.sap.pi.document.util.model.Item;
import com.sap.xi.basis.CommunicationComponentID;
import com.sap.xi.basis.Condition;
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.IntegratedConfigurationReceiverRule;
import com.sap.xi.basis.ReceiverInterfaces;
import com.sap.xi.basis.Receivers;

public class ReceiverRuleDocDomUtil {

	DocDomGroupUtilImpl docDomGroupUtilImpl = new DocDomGroupUtilImpl();
	// generate the dom file of Receiver Rule
	public void generateRRDomFile(IntegratedConfiguration integratedConfiguration) {

		// generate receiver rule dao then generate dom file

		// - generate receiver rule dao
		List<ReceiverRuleDao> receiverRuleDaos = generateReceiverRuleDao(integratedConfiguration);

		if (receiverRuleDaos != null && receiverRuleDaos.size() > 0) {
			// generate dom file for each receiver rule
			for (int i = 0; i < receiverRuleDaos.size(); i++) {
				ReceiverRuleDao receiverRuleDao = receiverRuleDaos.get(i);

				// for each receiverRuleDao require to generate dom file
				// for condition

				Condition condition = receiverRuleDao.getCondtionDao();
				/*if (condition != null) {
					ConditionDocDomUtil conditionDocDomUtil = new ConditionDocDomUtil();
					// conditionDocDomUtil.generateConditionDomFile(condition,
					// "RECEIVERRULE", true);
					conditionDocDomUtil.generateConditionStringDomFile(condition, "RECEIVERRULE_" + i, true);
				}*/

				String conditionValue = "N/A";
				if (condition != null) {
					conditionValue = OtherUtil.getValue(OtherUtil.getCondition(condition));
				}

				// generate dom/ domGroup file of receiverDao
				List<ReceiverDao> receiverDao = receiverRuleDao.getReceiverDao();
				if (receiverDao != null && receiverDao.size() > 0) {
					ReceiverDaoDocDomUtil receiverDaoDocDomUtil = new ReceiverDaoDocDomUtil();
					receiverDaoDocDomUtil.generateReceiverDomFile(receiverRuleDao.getReceiverDao(), "RECEIVERRULE_" + i,
							true);
				}

				// generate receiverrules domGroup file and write back type
				// receiverrules
				List<Item> items = new ArrayList<>();
				items.add(new Item("$Main_Name", "RECEIVERRULESAP"));
				items.add(new Item("$ReceiverRuleTitle_Value", "RECEIVERRULE  " + (i + 1)));
				items.add(new Item("$Condition_Value", conditionValue));

				docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_RR_RECEIVERRULE, items, "RECEIVERRULES_" + i,
						true);
			}

			// generated domGroup file of Receiver Rule, write back required,
			// target type is RD (Receiver Determination)
			List<Item> items = new ArrayList<>();
			items.add(new Item("$Main_Name", "RECEIVERRULESSAP"));
			docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_RR_RECEIVERRULES, items, "RECEIVERDETERMINATION",
					true);
		}

	}

	private List<ReceiverRuleDao> generateReceiverRuleDao(IntegratedConfiguration integratedConfiguration) {
		List<ReceiverRuleDao> receiverRuleDaos = new ArrayList<>();

		// get receiverInterface
		List<ReceiverInterfaces> receiverInterfaces = integratedConfiguration.getReceiverInterfaces();

		// get receiver
		Receivers receivers = integratedConfiguration.getReceivers();
		// get receiver rule * n
		List<IntegratedConfigurationReceiverRule> receiverRules = receivers.getReceiverRule();

		for (int j = 0; j < receiverRules.size(); j++) {
			IntegratedConfigurationReceiverRule receiverRule = receiverRules.get(j);

			// get condition
			Condition condition = receiverRule.getCondition();
			// get ReceiverDao
			List<ReceiverDao> receiverDaos = getReceiverDao(receiverRule, receiverInterfaces);

			// generate receiver rule daos
			if (receiverDaos.size() > 0) {
				receiverRuleDaos.add(new ReceiverRuleDao(condition, receiverDaos));
			}
		}

		return receiverRuleDaos;
	}

	private List<ReceiverDao> getReceiverDao(IntegratedConfigurationReceiverRule receiverRule,
			List<ReceiverInterfaces> receiverInterfaces) {

		List<ReceiverDao> receiverDaos = new ArrayList<>();
		String keyInRR;
		String keyInRI;

		// get key value of receiver rule
		// get receiver list in the receiver rule
		List<CommunicationComponentID> receiversInRR = receiverRule.getReceiver();

		for (int i = 0; i < receiversInRR.size(); i++) {
			// for each receiver get the key
			// get receiver
			CommunicationComponentID receiverInRR = receiversInRR.get(i);

			String partyID = OtherUtil.getValue(receiverInRR.getPartyID());
			String componentID = OtherUtil.getValue(receiverInRR.getComponentID());
			keyInRR = partyID + "-" + componentID;

			if (!keyInRR.equals("N/A-N/A")) {
				// loop interface to add interface part for each receiver
				if (receiverInterfaces.size() > 0) {
					// generate receiverRuleDao
					// get receiver Interface in receiver interface part
					List<ReceiverInterfaces> reInterfacesInRI = new ArrayList<>();
					for (int l = 0; l < receiverInterfaces.size(); l++) {
						ReceiverInterfaces receiverInterface = receiverInterfaces.get(l);
						// including receiver/ receiverInterfaceRule/ QoS

						CommunicationComponentID receiverInRI = receiverInterface.getReceiver();

						if (receiverInRI != null) {

							String partyIDInRI = OtherUtil.getValue(receiverInRI.getPartyID());
							String componentIDInRI = OtherUtil.getValue(receiverInRI.getComponentID());
							keyInRI = partyIDInRI + "-" + componentIDInRI;

							if (keyInRI.equals(keyInRR)) {
								reInterfacesInRI.add(receiverInterface);
							}
						}
					}
					ReceiverDao receiverDao = new ReceiverDao(receiverInRR, reInterfacesInRI);

					receiverDaos.add(receiverDao);
				}
			}
		}
		return receiverDaos;
	}
}
