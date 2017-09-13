package com.sap.pi.document.dao.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.dao.CommunicationChannel;
import com.sap.pi.document.dao.OutboundProcessing;
import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.Item;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.DocDomUtilImpl;
import com.sap.pi.document.util.impl.OtherUtil;
import com.sap.pi.document.util.impl.WebServiceOperationImpl;
import com.sap.xi.basis.CommunicationPartnerExtractor;
import com.sap.xi.basis.Extractor;
import com.sap.xi.basis.GenericProperty;
import com.sap.xi.basis.HeaderMapping;
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.VirusScanCode;

public class OutboundProcessingDocDomUtil {

	DocDomGroupUtilImpl docDomGroupUtilImpl = new DocDomGroupUtilImpl();
	DocDomUtilImpl docDomUtilImpl = new DocDomUtilImpl();

	public void generateOutboundProcessingDomGroupFile(IntegratedConfiguration integratedConfiguration) {

		WebServiceOperationImpl webServiceOperationImpl = new WebServiceOperationImpl();

		List<OutboundProcessing> outboundProcessings = webServiceOperationImpl
				.getOutboundProcessingInformation(integratedConfiguration);

		for (int i = 0; i < outboundProcessings.size(); i++) {
			OutboundProcessing outboundProcessing = outboundProcessings.get(i);

			// generate dom domGroup file of communication channel
			// target type is OUTBOUNDPROCESSING
			CommunicationChannel communicationChannel = outboundProcessing.getReceiverCommunicationChannel();
			CommunicationChannelDocDomUtil ccDocDomUtil = new CommunicationChannelDocDomUtil();
			ccDocDomUtil.generateCommunicationChannelDomFile(communicationChannel, "OUTBOUNDPROCESSING", true);

			// generate dom domGroup file of HEADER MAPPING
			// target type is OUTBOUNDPROCESSING
			HeaderMapping headerMapping = outboundProcessing.getHeaderMapping();
			if (headerMapping != null) {

				String senderParty = "N/A";
				String senderComponent = "N/A";

				String receiverParty = "N/A";
				String receiverComponent = "N/A";

				CommunicationPartnerExtractor sender = headerMapping.getSender();
				CommunicationPartnerExtractor receiver = headerMapping.getReceiver();

				if (sender != null) {
					Extractor extractor = sender.getCommunicationParty();
					if (extractor != null) {
						senderParty = OtherUtil.getValue(extractor.getValue());
					}

					extractor = sender.getCommunicationComponent();
					if (extractor != null) {
						senderComponent = OtherUtil.getValue(extractor.getValue());
					}
				}

				if (receiver != null) {
					Extractor extractor = receiver.getCommunicationParty();
					if (extractor != null) {
						receiverParty = OtherUtil.getValue(extractor.getValue());
					}

					extractor = receiver.getCommunicationComponent();
					if (extractor != null) {
						receiverComponent = OtherUtil.getValue(extractor.getValue());
					}
				}

				if (!(senderParty.equals("N/A") && senderComponent.equals("N/A") && receiverParty.equals("N/A")
						&& receiverComponent.equals("N/A"))) {
					// generate domGroup file and write back type is
					// OUTBOUNDPROCESSING
					List<Item> items = new ArrayList<>();
					items.add(new Item("$Main_Name", "HEADERMAPPINGSAP"));
					items.add(new Item("$SenderParty_Value", senderParty));
					items.add(new Item("$SenderComponent_Value", senderComponent));
					items.add(new Item("$ReceiverParty_Value", receiverParty));
					items.add(new Item("$ReceiverComponent_Value", receiverComponent));

					docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_HEADERMAPPING, items,
							"OUTBOUNDPROCESSING", true);
				}
			}

			// List<GenericPropertyTable> adapterSpecAttrTab =
			// outboundProcessing.getAdapterSpecificTableAttribute();

			// get Adapter specific Attribute
			List<GenericProperty> adapterSpecAttr = outboundProcessing.getAdapterSpecificAttribute();

			// generate dom and domGroup file of adapterSepcAttr
			// target type is OUTBOUNDPROCESSING
			if (adapterSpecAttr != null && adapterSpecAttr.size() > 0) {
				StringBuilder sBuilder = new StringBuilder();

				for (int j = 0; j < adapterSpecAttr.size(); j++) {
					GenericProperty gProperty = adapterSpecAttr.get(j);
					String name = OtherUtil.getValue(gProperty.getName());
					String nameSpace = OtherUtil.getValue(gProperty.getNamespace());
					String value = OtherUtil.getValue(gProperty.getValue());

					// OutboundProcessing - Adapter specific attribute: merge in
					// one table, exclude one that value = N/A
					if (!(name.equals("N/A") && nameSpace.equals("N/A")) && !value.equals("N/A")) {
						sBuilder.append("<" + name + "|" + nameSpace + "|" + value + ">");
					}
					// // generate dom file of adapter sepecific Attribute
					// List<Item> items = new ArrayList<>();
					// items.add(new Item("$Main_Name",
					// "ADAPTERSPECIFICATTRIBUTESAP"));
					// items.add(new Item("$Name_Value", name));
					// items.add(new Item("$NameSpace_Value", nameSpace));
					// items.add(new Item("$Value_Value", value));
					//
					// docDomUtilImpl.generateDomFile(CONSTAINTS.DOM_ADAPTERSPECIFICATTRIBUTE,
					// items,
					// OtherUtil.formatName(name + nameSpace));
				}

				List<Item> adapterSpecAttrItems = new ArrayList<>();
				adapterSpecAttrItems.add(new Item("$Main_Name", "ADAPTERSPECIFICATTRIBUTESAP"));
				adapterSpecAttrItems.add(new Item("$Value_Value", sBuilder.toString()));
				docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_ADAPTERSPECIFICATTRIBUTE,
						adapterSpecAttrItems, "OUTBOUNDPROCESSING", true);
			}


			// generate dom and domGroup file of adapterSepcAttrTable

			// generate outbound processing domGroup and write back
			// target type is OUTBOUNDPROCESSINGS
			VirusScanCode virsScanCode = outboundProcessing.getVirusScan();
			String virsScan = "N/A";

			if (virsScanCode != null) {
				virsScan = OtherUtil.getValue(virsScanCode.value());
			}

			String schemaValidation = OtherUtil.getValue(outboundProcessing.getSchemaValidation());

			List<Item> items = new ArrayList<>();
			items.add(new Item("$Main_Name", "OUTBOUNDPROCESSINGSAP" + i));
			items.add(new Item("$Title_Value", "OUTBOUNDPROCESSINGSAP" + i));
			items.add(new Item("$VirsScan_Value", virsScan));
			items.add(new Item("$SchemaValidation_Value", schemaValidation));

			docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_OUTBOUNDPROCESSING, items,
					"OUTBOUNDPROCESSINGS", true);

		}

		// generate domGroup file of outboundProcessings file, needn't write
		// back
		List<Item> items = new ArrayList<>();
		items.add(new Item("$Main_Name", "OUTBOUNDPROCESSINGSSAP"));

		docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_OUTBOUNDPROCESSINGS, items, "ICO", false);
	}

}
