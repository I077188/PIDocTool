package com.sap.pi.document.model.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.model.AdditionalIdentfier;
import com.sap.pi.document.model.CommunicationPartyDao;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.DocDomUtilImpl;
import com.sap.pi.document.util.impl.OtherUtil;
import com.sap.pi.document.util.model.CONSTAINTS;
import com.sap.pi.document.util.model.Item;

public class CommunicationPartyDocDomUtil {

	DocDomGroupUtilImpl docDomGroupUtilImpl = new DocDomGroupUtilImpl();
	DocDomUtilImpl docDomUtilImpl = new DocDomUtilImpl();


	public void generateCommunicationPartyDomFile(CommunicationPartyDao partyDao, String type, boolean move2dom,
			int tag) {

		List<AdditionalIdentfier> additionalIdentfiers = partyDao.getAdditionalIdentfier();
		String partyID = OtherUtil.getValue(partyDao.getCommunicationPartyID());

		for (int i = 0; i < additionalIdentfiers.size(); i++) {
			AdditionalIdentfier additionalIdentfier = additionalIdentfiers.get(i);

			String schemeID = OtherUtil.getValue(additionalIdentfier.getSchemeID());
			String schemeAgencyID = OtherUtil.getValue(additionalIdentfier.getSchemeAgencyID());
			String name = OtherUtil.getValue(additionalIdentfier.getName());

			List<Item> items = new ArrayList<>();
			items.add(new Item("$Main_Name", "ADDITIONALIDENTIFIERSAP"));
			items.add(new Item("$Name_Value", name));
			items.add(new Item("$SchemeID_Value", schemeID));
			items.add(new Item("$SchemeAgencyID_Value", schemeAgencyID));

			docDomUtilImpl.generateDomFile(CONSTAINTS.DOM_ADDITIONALIDENTIFIER, items,
					OtherUtil.formatName(name + schemeID + schemeAgencyID));
		}

		// generate domGroup file of additional identifier
		// write back type is communication party
		List<Item> items = new ArrayList<>();
		items.add(new Item("$Main_Name", "ADDITIONALIDENTIFIERSSAP"));
		// items.add(new Item("$CPID_Value", partyID));

		docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_SENDER_ADDITIONALIDENTIFIER, items, "COMMUNICATIONPARTY", true);

		// generate domGroup file of additional identifier
		// write back type is communication party
		List<Item> communicationPartyItems = new ArrayList<>();

		// traditiaonl communication party
		if (tag == 1) {
			communicationPartyItems.add(new Item("$Main_Name", "COMMUNICATIONPARTYSAP"));
			communicationPartyItems.add(new Item("$PartyID_Value", partyID));

			docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_SENDER_COMMUNICATIONPARTY,
					communicationPartyItems, type,
					move2dom);
		}

		// external receiver rule communication party
		if (tag == 2) {
			communicationPartyItems.add(new Item("$Main_Name", "EXTCOMMUNICATIONPARTYSAP"));
			communicationPartyItems.add(new Item("$PartyID_Value", partyID));

			docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_EXTCOMMUNICATIONPARTY, communicationPartyItems,
					type, move2dom);

		}
	}

}
