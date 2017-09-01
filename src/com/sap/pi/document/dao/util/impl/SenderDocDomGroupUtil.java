package com.sap.pi.document.dao.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.dao.CommunicationPartyDao;
import com.sap.pi.document.dao.Sender;
import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.Item;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.OtherUtil;
import com.sap.pi.document.util.impl.WebServiceOperationImpl;
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.MessageHeaderID;

public class SenderDocDomGroupUtil {

	DocDomGroupUtilImpl domGroupUtil = new DocDomGroupUtilImpl();

	public void generateSenderDomGroupFile(IntegratedConfiguration integratedConfiguration) {
		CONSTAINTS.LOG.info("Start to create sender related tempt document...");

		MessageHeaderID intID = integratedConfiguration.getIntegratedConfigurationID();

		WebServiceOperationImpl webServiceOperationImpl = new WebServiceOperationImpl();
		Sender sender = webServiceOperationImpl.getSenderInformation(intID);

		if (sender != null) {

			CommunicationPartyDao partyDao = sender.getSenderCommunicationParty();
			if (partyDao != null) {

				CommunicationPartyDocDomUtil communicationPartyDocDomUtil = new CommunicationPartyDocDomUtil();
				communicationPartyDocDomUtil.generateCommunicationPartyDomFile(partyDao, "SENDER", true);
			}

			String componentID = OtherUtil.getValue(sender.getSenderCommunicationComponent());
			String senderInterface = OtherUtil.getValue(sender.getSenderInterface());
			String senderNamespace = OtherUtil.getValue(sender.getSenderNamespace());
			String senderSWC = OtherUtil.getValue(sender.getSenderInterfaceSWC());

			List<Item> items = new ArrayList<>();
			items.add(new Item("$Main_Name", "SENDERSAP"));
			items.add(new Item("$ComponentID_Value", componentID));
			items.add(new Item("$SenderInterface_Value", senderInterface));
			items.add(new Item("$SenderNameSpace_Value", senderNamespace));
			items.add(new Item("$SenderSWC_Value", senderSWC));

			domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_SENDER, items, "ICO", false);

		}

		CONSTAINTS.LOG.info("Sender related tempt documents had been created.");
	}

}
