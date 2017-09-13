package com.sap.pi.document.dao.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.dao.CommunicationChannel;
import com.sap.pi.document.dao.Identifiers;
import com.sap.pi.document.dao.Module;
import com.sap.pi.document.dao.ModuleConfiguration;
import com.sap.pi.document.dao.ModuleConfigurationParameters;
import com.sap.pi.document.dao.Parameters;
import com.sap.pi.document.dao.ProcessSequence;
import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.Item;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.DocDomUtilImpl;
import com.sap.pi.document.util.impl.OtherUtil;
import com.sap.xi.basis.GenericProperty;
import com.sap.xi.basis.ModuleTypeCode;
import com.sap.xi.basis.global.LONGDescription;

public class CommunicationChannelDocDomUtil {
	DocDomGroupUtilImpl docDomGroupUtilImpl = new DocDomGroupUtilImpl();
	DocDomUtilImpl docDomUtilImpl = new DocDomUtilImpl();

	public void generateCommunicationChannelDomFile(CommunicationChannel communicationChannel, String type,
			boolean move2dom) {

		String id = OtherUtil.getValue(communicationChannel.getChannelID());
		String partyID = OtherUtil.getValue(communicationChannel.getParty());
		String componentID = OtherUtil.getValue(communicationChannel.getComponentID());

		List<LONGDescription> descriptions = communicationChannel.getDescription();

		Parameters parameter = communicationChannel.getParameters();

		Identifiers identifier = communicationChannel.getIdentifiers();

		Module module = communicationChannel.getModule();

		// generate dom and domGroup file of description
		// write back to communication channel
		if (descriptions.size() > 0) {
			LONGDescription description = descriptions.get(0);
			String descriptionContent = OtherUtil.getValue(description.getValue());
			String language = OtherUtil.getValue(description.getLanguageCode());

			List<Item> items = new ArrayList<>();
			items.add(new Item("$Main_Name", "LONGDESCRIPTIONSAP"));
			items.add(new Item("$LONGDESCRIPTION_Value", language + "::" + descriptionContent));
			docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_LONGDESCRIPTION, items, "COMMUNICATIONCHANNEL",
					true);
		}

		// generate domGroup file of parameter
		if (parameter != null) {
			String adapterType_NAME = OtherUtil.getValue(parameter.getAdaperType().getName());
			String adapterType_NAMESPACE = OtherUtil.getValue(parameter.getAdaperType().getNameSpace());
			String adapterType_SWC = OtherUtil.getValue(parameter.getAdaperType().getSoftwareComponent());

			String adapterEngine = OtherUtil.getValue(parameter.getAdapterEngine());
			String direction = OtherUtil.getValue(parameter.getDirection().value());

			String transportProtocal = OtherUtil.getValue(parameter.getTransportProtocol());
			String messageProtocal = OtherUtil.getValue(parameter.getMessageProtocol());

			// change specific value to String
			List<GenericProperty> adapterSpecific = parameter.getAdapterSpecific();
			StringBuilder content = new StringBuilder();
			for (int i = 0; i < adapterSpecific.size(); i++) {
				GenericProperty property = adapterSpecific.get(i);

				// filter by excluding attribute whose value is "N/A"
				if (!OtherUtil.getValue(property.getValue()).equals("N/A")) {
					content.append(("<" + OtherUtil.getValue(property.getName())) + "::"
							+ OtherUtil.getValue(property.getNamespace()) + "::"
							+ OtherUtil.getValue(property.getValue()) + ">\n");
				}
			}

			String adapterSpecificContent = "N/A";
			if (content != null && content.length() > 0) {
				adapterSpecificContent = OtherUtil.getValue(content.toString());
			}

			List<Item> items = new ArrayList<>();
			items.add(new Item("$Main_Name", "PARAMETERSAP"));
			items.add(new Item("$AdapterTypeName_Value", adapterType_NAME));
			items.add(new Item("$AdapterTypeNameSpace_Value", adapterType_NAMESPACE));
			items.add(new Item("$AdapterTypeSWC_Value", adapterType_SWC));
			items.add(new Item("$AdapterEngine_Value", adapterEngine));
			items.add(new Item("$Direction_Value", direction));
			items.add(new Item("$TransportProtocal_Value", transportProtocal));
			items.add(new Item("$MessageProtocal_Value", messageProtocal));
			items.add(new Item("$AdapterSpecificContent_Value", adapterSpecificContent));

			docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_PARAMTER, items, "COMMUNICATIONCHANNEL", true);
		}

		// generate dom and domGroup file of identifier
		if (identifier != null) {

			String senderAgency = OtherUtil.getValue(identifier.getReceiverAgency());
			String senderSchema = OtherUtil.getValue(identifier.getReceiverSchema());
			String receiverAgency = OtherUtil.getValue(identifier.getReceiverAgency());
			String receiverSchema = OtherUtil.getValue(identifier.getReceiverSchema());

			List<Item> identifierItems = new ArrayList<>();
			identifierItems.add(new Item("$Main_Name", OtherUtil.formatName(id.replaceAll("_", "") + "IDENTIFIERSAP")));
			identifierItems.add(new Item("$SenderAgency_Value", senderAgency));
			identifierItems.add(new Item("$SenderSchema_Value", senderSchema));
			identifierItems.add(new Item("$ReceiverAgency_Value", receiverAgency));
			identifierItems.add(new Item("$ReceiverSchema_Value", receiverSchema));

			if (!(senderAgency.equals("N/A") && senderSchema.equals("N/A") && receiverAgency.equals("N/A")
					&& receiverSchema.equals("N/A"))) {
				docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_IDENTIFIER, identifierItems,
						"COMMUNICATIONCHANNEL", true);
			}
		}

		if (module != null) {
			List<ProcessSequence> processSequences = module.getProcessSequence();
			List<ModuleConfiguration> moduleConfigurations = module.getModuleConfigurations();

			if (processSequences != null) {

				for (int i = 0; i < processSequences.size(); i++) {
					ProcessSequence processSequence = processSequences.get(i);
					Integer tempt = processSequence.getNumber();
					String number = "N/A";

					if (tempt != null) {
						number = tempt.toString();
					}

					String name = OtherUtil.getValue(processSequence.getModuleName());
					String key = OtherUtil.getValue(processSequence.getModuleKey());

					ModuleTypeCode moduleTypeCode = processSequence.getType();
					String moduleType = "N/A";
					if (moduleTypeCode != null) {
						moduleType = OtherUtil.getValue(moduleTypeCode.value());
					}

					// generate dom
					List<Item> items = new ArrayList<>();
					items.add(new Item("$Main_Name", "PROCESSSEQUENCESAP"));
					items.add(new Item("$Number_Value", number));
					items.add(new Item("$Key_Value", key));
					items.add(new Item("$Name_Value", name));
					items.add(new Item("$ModuleType_Value", moduleType));

					docDomUtilImpl.generateDomFile(CONSTAINTS.DOM_MODULEPROCESSSEQUENCE, items,
							OtherUtil.formatName(moduleType + key + name));

				}

				// generate domGroup and write back as module type
				List<Item> processSeqItems = new ArrayList<>();
				processSeqItems.add(new Item("$Main_Name", "MODULEPROCESSSEQUENCEPARTSAP"));

				docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_MODULEPROCESSSEQUENCE, processSeqItems,
						"MODULE", true);
			}

			if (moduleConfigurations != null) {
				for (int i = 0; i < moduleConfigurations.size(); i++) {
					// generate dom
					ModuleConfiguration configuration = moduleConfigurations.get(i);
					String key = OtherUtil.getValue(configuration.getModuleKey());
					List<ModuleConfigurationParameters> parameters = configuration.getParameters();

					StringBuilder tempt = new StringBuilder();
					for (int j = 0; j < parameters.size(); j++) {
						ModuleConfigurationParameters paramter = parameters.get(j);
						tempt.append(OtherUtil.getValue(paramter.getParameterName()) + "::\t"
								+ OtherUtil.getValue(paramter.getParameterValue()) + "\n");
					}

					String parametersValue = "N/A";
					if (tempt != null && tempt.length() > 0) {
						parametersValue = OtherUtil.getValue(tempt.toString());
					}

					List<Item> items = new ArrayList<>();
					items.add(new Item("$Main_Name", "MODULECONFIGURATIONPARTSAP"));
					items.add(new Item("$Key_Value", key));
					items.add(new Item("$ParametersValue_Value", parametersValue));

					docDomUtilImpl.generateDomFile(CONSTAINTS.DOM_MODULECONFIGURATION, items, key);

				}
				// generate domGroup and write back as module type
				List<Item> moduleConfigItems = new ArrayList<>();
				moduleConfigItems.add(new Item("$Main_Name", "MODULECONFIGURATIONPART"));

				docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_MODULECONFIGURATION, moduleConfigItems,
						"MODULE", true);
			}
		}

		// generate domGroup of Module
		// write back to communication channel
		List<Item> moduleItems = new ArrayList<>();
		moduleItems.add(new Item("$Main_Name", "MODULESAP"));

		docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_MODULE, moduleItems, "COMMUNICATIONCHANNEL", true);

		// generate domGroup of Module
		// write back to communication channel
		List<Item> ccItems = new ArrayList<>();
		ccItems.add(new Item("$Main_Name", "COMMUNICATIONCHANNELSAP"));
		ccItems.add(new Item("$ID_Value", id));
		ccItems.add(new Item("$ComponentID_Value", componentID));
		ccItems.add(new Item("$PartyID_Value", partyID));

		docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_COMMUNICATIONCHANNEL, ccItems, type, move2dom);
	}

}
