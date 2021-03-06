package com.sap.pi.document.model.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.model.CommunicationChannel;
import com.sap.pi.document.model.InboundProcessing;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.DocDomUtilImpl;
import com.sap.pi.document.util.impl.OtherUtil;
import com.sap.pi.document.util.impl.WebServiceOperationImpl;
import com.sap.pi.document.util.model.CONSTAINTS;
import com.sap.pi.document.util.model.Item;
import com.sap.xi.basis.GenericProperty;
import com.sap.xi.basis.IntegratedConfiguration;

public class InboundProcessingDocDomUtil {

	DocDomGroupUtilImpl docDomGroupUtilImpl = new DocDomGroupUtilImpl();
	DocDomUtilImpl docDomUtilImpl = new DocDomUtilImpl();

	public void generateInboundProcessingDomGroupFile(IntegratedConfiguration integratedConfiguration) {
		CONSTAINTS.LOG.info("Start to create Inbound Processing related tempt document...");

		WebServiceOperationImpl webService = new WebServiceOperationImpl();

		InboundProcessing inboundProcessing = webService.getInboundProcessingInformation(integratedConfiguration);

		if (inboundProcessing != null) {
			String virusScan = OtherUtil.getValue(inboundProcessing.getVirusScan().value());

			String schemaValidation = OtherUtil.getValue(inboundProcessing.getSchemaValidation());

			// get sender communication channel
			CommunicationChannel communicationChannel = inboundProcessing.getCommunicationChannel();

			// get Adapter specific Attribute
			List<GenericProperty> adapterSpecAttr = inboundProcessing.getAdapterSpecificAttribute();
			// List<GenericPropertyTable> adapterSpecAttrTab =
			// inboundProcessing.getAdapterSpecificTableAttribute();

			// generate dom and domGroup file of communication channel
			if (communicationChannel != null) {
				CommunicationChannelDocDomUtil ccIDocUtil = new CommunicationChannelDocDomUtil();
				ccIDocUtil.generateCommunicationChannelDomFile(communicationChannel, "INBOUNDPROCESSING", true);
			}

			// generate dom and domGroup file of adapterSepcAttrTable
			if (adapterSpecAttr != null && adapterSpecAttr.size() > 0) {

				StringBuilder sb = new StringBuilder();
				// generate dom and domGroup file of adapterSepcAttr
				for (int i = 0; i < adapterSpecAttr.size(); i++) {
					GenericProperty gProperty = adapterSpecAttr.get(i);
					String name = OtherUtil.getValue(gProperty.getName());
					String nameSpace = OtherUtil.getValue(gProperty.getNamespace());
					String value = OtherUtil.getValue(gProperty.getValue());

					// generate dom file of adapter sepecific Attribute
					if (!(name.equals("N/A") && nameSpace.equals("N/A")) && !value.equals("N/A")) {
						sb.append("<" + name + ":" + value + ">\n");
					}
				}

				List<Item> adapterSpecAttrItems = new ArrayList<>();
				adapterSpecAttrItems.add(new Item("$Main_Name", "ADAPTERSPECIFICATTRIBUTESAP"));
				adapterSpecAttrItems.add(new Item("$Value_Value", sb.toString()));
				docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_IBADAPTERSPECIFICATTRIBUTE,
						adapterSpecAttrItems, "INBOUNDPROCESSING", true);
			}
			// generate domGroup file of inboundProcessing file, needn't write
			// back
			List<Item> items = new ArrayList<>();
			items.add(new Item("$Main_Name", "InboundProcessingSAP"));
			items.add(new Item("$VirusScan_Value", virusScan));
			items.add(new Item("$SchemaValidation_Value", schemaValidation));

			docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_INBOUNDPROCESSING, items, "ICO", false);
		}
		CONSTAINTS.LOG.info("Inbound Processing related tempt document had been created.");
	}

}
