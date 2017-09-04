package com.sap.pi.document.dao.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.Item;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.DocDomUtilImpl;
import com.sap.pi.document.util.impl.OtherUtil;
import com.sap.xi.basis.ChannelProperty;
import com.sap.xi.basis.CommunicationChannelID;
import com.sap.xi.basis.DesignObjectID;
import com.sap.xi.basis.IntegerProperty;
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.MappingParameters;
import com.sap.xi.basis.ReceiverDeterminationMapping;
import com.sap.xi.basis.Receivers;
import com.sap.xi.basis.RestrictedGenericProperty;

// Dynamic receiver rule
public class DRRDocDomUtil {

	DocDomUtilImpl domUtil = new DocDomUtilImpl();
	DocDomGroupUtilImpl domGroupUtil = new DocDomGroupUtilImpl();

	// generate Dom file
	public void generateDRRDomFile(IntegratedConfiguration integratedConfiguration) {

		// get informations from the integrated configuration
		List<ReceiverDeterminationMapping> dyReceiverRules = new ArrayList<>();

		Receivers receivers = integratedConfiguration.getReceivers();

		dyReceiverRules = receivers.getDynamicReceiverRule();

		for (int i = 0; i < dyReceiverRules.size(); i++) {
			ReceiverDeterminationMapping dtReceiverRule = dyReceiverRules.get(i);

			// get operation name
			String operation = OtherUtil.getValue(dtReceiverRule.getOperation());

			DesignObjectID mapping = dtReceiverRule.getMapping();
			String mappingName = OtherUtil.getValue(mapping.getName());

			String mappingNameSpace = OtherUtil.getValue(mapping.getNamespace());

			String mappingSWCV = OtherUtil.getValue(mapping.getSoftwareComponentVersionID());

			MappingParameters mappingParameters = dtReceiverRule.getMappingParamters();

			List<IntegerProperty> integers = mappingParameters.getInteger();
			List<RestrictedGenericProperty> strings = mappingParameters.getString();
			List<ChannelProperty> channels = mappingParameters.getChannel();

			// generate Integer related domGroup and dom file, move required
			for (int j = 0; j < integers.size(); j++) {
				List<Item> integerDomItems = new ArrayList<>();
				IntegerProperty integerProperty = integers.get(j);

				String name = integerProperty.getName();
				name = (name == null || name.equals("")) ? "N/A" : name;

				Integer value = integerProperty.getValue();
				String valueString = "N/A";
				if (value != null) {
					valueString = value.toString();
				}

				integerDomItems.add(new Item("$Main_Name", name));
				integerDomItems.add(new Item("$Name_Value", name));
				integerDomItems.add(new Item("$Value_Value", valueString));

				domUtil.generateDomFile(CONSTAINTS.DOM_OMP_INTEGER, integerDomItems, name);
			}

			List<Item> integerDomGroupItems = new ArrayList<>();
			integerDomGroupItems.add(new Item("$Operation_Name", operation));
			integerDomGroupItems.add(new Item("$Main_Name", "integersParameterSAP"));
			domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_OMP_INTEGER, integerDomGroupItems, "OMP", true);

			// generate String related domGroup and dom file, move required
			for (int j = 0; j < strings.size(); j++) {
				List<Item> stringDomItems = new ArrayList<>();
				RestrictedGenericProperty stringProperty = strings.get(j);

				String name = stringProperty.getName();
				name = (name == null | name.equals("")) ? "N/A" : name;

				String value = stringProperty.getValue();
				value = (value == null | value.equals("")) ? "N/A" : value;

				stringDomItems.add(new Item("$Main_Name", name));
				stringDomItems.add(new Item("$Name_Value", name));
				stringDomItems.add(new Item("$Value_Value", value));

				domUtil.generateDomFile(CONSTAINTS.DOM_OMP_STRING, stringDomItems, name);
			}
			List<Item> stringDomGroupItems = new ArrayList<>();
			stringDomGroupItems.add(new Item("$Operation_Name", operation));
			stringDomGroupItems.add(new Item("$Main_Name", "stringsParameterSAP"));

			domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_OMP_STRING, stringDomGroupItems, "OMP", true);

			// generate Chanel related domGroup and dom file, move required
			for (int j = 0; j < channels.size(); j++) {
				List<Item> channelDomItems = new ArrayList<>();
				ChannelProperty channelProperty = channels.get(j);

				String channelName = channelProperty.getName();
				channelName = (channelName == null || channelName.equals("")) ? "N/A" : channelName;
				CommunicationChannelID channelValue = channelProperty.getValue();

				String valuePartyID = "N/A";
				String valueComponentID = "N/A";
				String valueChannelID = "N/A";

				if (channelValue != null) {
					valuePartyID = channelValue.getPartyID();
					valuePartyID = (valuePartyID == null || valuePartyID.equals("N/A")) ? "N/A" : valuePartyID;
					valueComponentID = channelValue.getComponentID();
					valueComponentID = (valueComponentID == null || valueComponentID.equals("N/A")) ? "N/A"
							: valueComponentID;
					valueChannelID = channelValue.getPartyID();
					valueChannelID = (valuePartyID == null || valuePartyID.equals("N/A")) ? "N/A" : valueChannelID;
				}

				channelDomItems.add(new Item("$Main_Name", channelName));
				channelDomItems.add(new Item("$Name_Value", channelName));
				channelDomItems.add(new Item("$PartyID_Value", valuePartyID));
				channelDomItems.add(new Item("$ComponentID_Value", valueComponentID));
				channelDomItems.add(new Item("$ChannelID_Value", valueChannelID));

				domUtil.generateDomFile(CONSTAINTS.DOM_OMP_CHANEL, channelDomItems, channelName);
			}
			List<Item> channelDomGroupItems = new ArrayList<>();
			channelDomGroupItems.add(new Item("$Operation_Name", operation));
			channelDomGroupItems.add(new Item("$Main_Name", "channelsParameterSAP"));
			domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_OMP_CHANEL, channelDomGroupItems, "OMP", true);

			// generate domGroup and dom file of operation Mapping parameter
			List<Item> drrIMPItems = new ArrayList<>();
			drrIMPItems.add(new Item("$Operation_Name", operation));
			drrIMPItems.add(new Item("$Main_Name", "ompParameterSAP"));
			domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_OMP, drrIMPItems, "DRR", true);

			// generate domGroup and dom file of operation mapping
			List<Item> omDomItems = new ArrayList<>();
			omDomItems.add(new Item("$Name_Value", mappingName));
			omDomItems.add(new Item("$NameSpace_Value", mappingNameSpace));
			omDomItems.add(new Item("$ComponentID_Value", mappingSWCV));

			domUtil.generateDomFile(CONSTAINTS.DOM_OM, omDomItems, mappingName);

			List<Item> omDomGroupItems = new ArrayList<>();
			drrIMPItems.add(new Item("$Operation_Name", operation));
			drrIMPItems.add(new Item("$Main_Name", "omParameterSAP"));
			// write back to receiver determination
			domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_OM, omDomGroupItems, "RECEIVERDESTINATION", true);
		}
	}

}
