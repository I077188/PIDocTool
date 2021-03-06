package com.sap.pi.document.util.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;

import org.apache.commons.lang3.StringUtils;

import com.sap.pi.document.model.AdapterType;
import com.sap.pi.document.model.AdditionalIdentfier;
import com.sap.pi.document.model.CommunicationChannel;
import com.sap.pi.document.model.CommunicationPartyDao;
import com.sap.pi.document.model.ExternalReceiverRule;
import com.sap.pi.document.model.Identifiers;
import com.sap.pi.document.model.InboundProcessing;
import com.sap.pi.document.model.Logging;
import com.sap.pi.document.model.Module;
import com.sap.pi.document.model.ModuleConfiguration;
import com.sap.pi.document.model.ModuleConfigurationParameters;
import com.sap.pi.document.model.OperationMapping;
import com.sap.pi.document.model.OutboundProcessing;
import com.sap.pi.document.model.Parameters;
import com.sap.pi.document.model.ProcessSequence;
import com.sap.pi.document.model.Sender;
import com.sap.pi.document.model.Staging;
import com.sap.pi.document.model.VirtualReceiver;
import com.sap.pi.document.util.WebServiceOperation;
import com.sap.pi.document.util.model.CONSTAINTS;
import com.sap.pi.document.util.model.IntegrationPort;
import com.sap.pi.document.util.model.SetSecurity;
import com.sap.xi.basis.ChannelProperty;
import com.sap.xi.basis.CommunicationChannelDirection;
import com.sap.xi.basis.CommunicationChannelID;
import com.sap.xi.basis.CommunicationChannelIn;
import com.sap.xi.basis.CommunicationChannelReadIn;
import com.sap.xi.basis.CommunicationChannelReadOut;
import com.sap.xi.basis.CommunicationParty;
import com.sap.xi.basis.CommunicationPartyAdditionalIdentifier;
import com.sap.xi.basis.CommunicationPartyIn;
import com.sap.xi.basis.CommunicationPartyInService;
import com.sap.xi.basis.CommunicationPartyReadIn;
import com.sap.xi.basis.CommunicationPartyReadOut;
import com.sap.xi.basis.DesignObjectID;
import com.sap.xi.basis.GenericProperty;
import com.sap.xi.basis.GenericPropertyTable;
import com.sap.xi.basis.HeaderMapping;
import com.sap.xi.basis.IntegerProperty;
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.IntegratedConfigurationIn;
import com.sap.xi.basis.IntegratedConfigurationQueryIn;
import com.sap.xi.basis.IntegratedConfigurationQueryOut;
import com.sap.xi.basis.IntegratedConfigurationReadIn;
import com.sap.xi.basis.IntegratedConfigurationReadOut;
import com.sap.xi.basis.IntegratedConfigurationReceiverInterfaceRule;
import com.sap.xi.basis.MappingParameters;
import com.sap.xi.basis.MessageHeaderID;
import com.sap.xi.basis.ModuleProcess;
import com.sap.xi.basis.ModuleTypeCode;
import com.sap.xi.basis.ParameterGroup;
import com.sap.xi.basis.ProcessStep;
import com.sap.xi.basis.ReadContextCode;
import com.sap.xi.basis.ReceiverDeterminationMapping;
import com.sap.xi.basis.ReceiverInterfaces;
import com.sap.xi.basis.Receivers;
import com.sap.xi.basis.RestrictedGenericProperty;
import com.sap.xi.basis.VirusScanCode;
import com.sap.xi.basis.global.LONGDescription;

public class WebServiceOperationImpl implements WebServiceOperation {

	@Override
	public List<MessageHeaderID> getIntegratedConfigurationID() {

		IntegratedConfigurationIn port = IntegrationPort.getIntegratedConfigurationPort();
		IntegratedConfigurationQueryIn queryIn = new IntegratedConfigurationQueryIn();
		queryIn.setAdministrativeData(null);
		queryIn.setDescription(null);
		queryIn.setIntegratedConfigurationID(null);

		// query ICO
		IntegratedConfigurationQueryOut queryOut = new IntegratedConfigurationQueryOut();
		queryOut = port.query(queryIn);
		List<MessageHeaderID> headerIDs = queryOut.getIntegratedConfigurationID();

		return headerIDs;
	}

	@Override
	public IntegratedConfiguration getIntegrationConfiguration(MessageHeaderID messageHeaderID) {

		IntegratedConfigurationIn port = IntegrationPort.getIntegratedConfigurationPort();

		IntegratedConfigurationReadIn readIn = new IntegratedConfigurationReadIn();
		readIn.getIntegratedConfigurationID().add(messageHeaderID);
		readIn.setReadContext(ReadContextCode.fromValue("Active"));

		IntegratedConfigurationReadOut readOut = port.read(readIn);

		List<IntegratedConfiguration> integratedConfigurations = readOut.getIntegratedConfiguration();
		readIn.getIntegratedConfigurationID().clear();

		if (integratedConfigurations.size() > 0) {
			return integratedConfigurations.get(0);
		} else {
			return null;
		}
	}

	private List<MappingParameters> getOperationMappingParameters(
			IntegratedConfigurationReceiverInterfaceRule interfaceRule) {

		List<MappingParameters> operationMappingParameters = new ArrayList<>();
		MappingParameters mappingParameters = new MappingParameters();

		// get mapping parameters
		MappingParameters tempt = interfaceRule.getMappingParameters();
		List<IntegerProperty> integers = tempt.getInteger();
		List<RestrictedGenericProperty> strings = tempt.getString();
		List<ChannelProperty> channelProperties = tempt.getChannel();

		if (integers.size() > 0 || strings.size() > 0 || channelProperties.size() > 0) {
			if (integers.size() > 0) {
				mappingParameters.getInteger().addAll(integers);
			}

			if (strings.size() > 0) {
				mappingParameters.getString().addAll(strings);
			}

			if (channelProperties.size() > 0) {
				mappingParameters.getChannel().addAll(channelProperties);
			}
			// create new OperationMappingParameter
			operationMappingParameters.add(mappingParameters);
		}

		return operationMappingParameters;
	}

	@Override
	public List<OperationMapping> getOperationMappings(IntegratedConfiguration integratedConfiguration) {

		List<OperationMapping> operationMappings = new ArrayList<>();
		if (integratedConfiguration != null) {
			List<ReceiverInterfaces> receiverInterfaces = integratedConfiguration.getReceiverInterfaces();
			if (receiverInterfaces.size() > 0) {
				for (int i = 0; i < receiverInterfaces.size(); i++) {
					ReceiverInterfaces interfaces = receiverInterfaces.get(i);

					// get interface rules
					List<IntegratedConfigurationReceiverInterfaceRule> interfaceRules = interfaces
							.getReceiverInterfaceRule();

					if (interfaceRules.size() > 0) {
						for (int j = 0; j < interfaceRules.size(); j++) {
							IntegratedConfigurationReceiverInterfaceRule interfaceRule = interfaceRules.get(j);

							// get Mappings
							DesignObjectID mapping = interfaceRule.getMapping();

							String name = mapping.getName();
							name = (name.equals("") || name == null) ? "N/A" : name;

							String namespace = mapping.getNamespace();
							namespace = (namespace.equals("") || namespace == null) ? "N/A" : namespace;

							String softwareComponentVersionID = mapping.getSoftwareComponentVersionID();
							softwareComponentVersionID = (softwareComponentVersionID.equals("")
									|| softwareComponentVersionID == null) ? "N/A" : softwareComponentVersionID;

							if (!(name.equals("N/A") && namespace.equals("N/A")
									&& softwareComponentVersionID.equals("N/A"))) {

								// get mapping parameters
								operationMappings.add(new OperationMapping(name, namespace, softwareComponentVersionID,
										getOperationMappingParameters(interfaceRule)));
							}
						}
					}
				}
			}

			return operationMappings;
		}

		return null;
	}

	public List<ReceiverDeterminationMapping> getDynamicRecevierRule(IntegratedConfiguration integratedConfiguration) {

		List<ReceiverDeterminationMapping> dyReRule = new ArrayList<>();

		Receivers receivers = integratedConfiguration.getReceivers();

		dyReRule = receivers.getDynamicReceiverRule();

		if (dyReRule.size() > 0) {
			for (int i = 0; i < dyReRule.size(); i++) {
				ReceiverDeterminationMapping rdMapping = dyReRule.get(i);

				String operation = rdMapping.getOperation();
				operation = (operation.equals("") || operation == null) ? "N/A" : operation;

			}
		}
		return dyReRule;

	}

	@Override
	public Sender getSenderInformation(MessageHeaderID headerID) {
		IntegratedConfiguration iConfig = this.getIntegrationConfiguration(headerID);

		if (iConfig != null) {
			MessageHeaderID mHeaderID = iConfig.getIntegratedConfigurationID();

			CommunicationPartyDao communicationParty = null;

			String communicationPartyID = OtherUtil.getValue(mHeaderID.getSenderPartyID());

			// get communicationParty
			if (!communicationPartyID.equals("N/A")) {
				try {
					communicationParty = getCommunicationParty(communicationPartyID);
				} catch (MalformedURLException e) {
					e.printStackTrace();
					CONSTAINTS.LOG.error(e.getMessage());
				}
			}

			String communicationComponent = OtherUtil.getValue(mHeaderID.getSenderComponentID());

			String namespace = OtherUtil.getValue(mHeaderID.getInterfaceNamespace());

			String senderInterface = OtherUtil.getValue(mHeaderID.getInterfaceName());

			com.sap.xi.basis.InboundProcessing inboundProcessing = iConfig.getInboundProcessing();
			String senderInterfaceSWC = "N/A";
			if (inboundProcessing != null) {
				senderInterfaceSWC = OtherUtil.getValue(inboundProcessing.getSenderInterfaceSoftwareComponentVersion());
			}

			return new Sender(communicationParty, communicationComponent, senderInterface, namespace,
					senderInterfaceSWC);
		}
		return null;

	}

	@Override
	public Staging getStagingInformation(IntegratedConfiguration integratedConfiguration) {

		String specificConfig = integratedConfiguration.getStaging().getSpecificConfiguration();

		if (StringUtils.isBlank(specificConfig)) {
			specificConfig = "N/A";
		}
		return new Staging(integratedConfiguration.getStaging().isUseGlobal(), specificConfig);

	}

	public CommunicationPartyDao getCommunicationParty(String communicationPartyID) throws MalformedURLException {

		CommunicationPartyInService cPartyInService = new CommunicationPartyInService();
		CommunicationPartyIn cPartyIn = cPartyInService.getCommunicationPartyInPort();

		SetSecurity setSecurity = new SetSecurity();
		try {
			setSecurity.set_security((BindingProvider) cPartyIn,
					"/CommunicationPartyInService/CommunicationPartyInImplBean");
		} catch (IOException e) {
			e.printStackTrace();
			CONSTAINTS.LOG.error(e.getMessage());
		}

		CommunicationPartyReadIn in = new CommunicationPartyReadIn();
		in.getPartyID().add(communicationPartyID);
		CommunicationPartyReadOut out = cPartyIn.read(in);

		List<CommunicationParty> parties = out.getParty();
		List<AdditionalIdentfier> additionalIdentfiers = new ArrayList<>();

		if (parties.size() > 0) {
			CommunicationParty party = out.getParty().get(0);

			List<CommunicationPartyAdditionalIdentifier> cpAdditionalIdentifiers = party.getAdditionalIdentifier();

			for (int i = 0; i < cpAdditionalIdentifiers.size(); i++) {
				CommunicationPartyAdditionalIdentifier cpAdditionalIdentifier = cpAdditionalIdentifiers.get(i);

				String schemeID = OtherUtil.getValue(cpAdditionalIdentifier.getSchemeID());

				String schemeAgencyID = OtherUtil.getValue(cpAdditionalIdentifier.getSchemeAgencyID());

				String Name = OtherUtil.getValue(cpAdditionalIdentifier.getValue());

				if (!(schemeID.equals("N/A") && schemeAgencyID.equals("N/A") && Name.equals("N/A"))) {
					additionalIdentfiers.add(new AdditionalIdentfier(schemeID, schemeAgencyID, Name));
				}
			}
		}

		return new CommunicationPartyDao(communicationPartyID, additionalIdentfiers);
	}

	@Override
	public Logging getLoggingInformation(IntegratedConfiguration integratedConfiguration) {

		String specificConfig = integratedConfiguration.getLogging().getSpecificConfiguration();

		if (StringUtils.isBlank(specificConfig)) {
			specificConfig = "N/A";
		}

		return new Logging(integratedConfiguration.getLogging().isUseGlobal(), specificConfig);
	}

	@Override
	public VirtualReceiver getVirtualReceiverInformation(IntegratedConfiguration integratedConfiguration) {

		return null; // Not find the position
	}

	@Override
	public InboundProcessing getInboundProcessingInformation(IntegratedConfiguration integratedConfiguration) {

		com.sap.xi.basis.InboundProcessing inboundProcessing = integratedConfiguration.getInboundProcessing();

		if (inboundProcessing != null) {
			VirusScanCode virusScan = inboundProcessing.getVirusScan();

			String schemaValidation = null;
			if (inboundProcessing.isSchemaValidationIndicator()) {
				schemaValidation = "Validation By Adapter";
			} else {
				schemaValidation = "No Validation";
			}

			List<GenericProperty> adapterSpecificAttribute;
			adapterSpecificAttribute = inboundProcessing.getAdapterSpecificAttribute();

			List<GenericPropertyTable> adapterSpecificTableAttribute = inboundProcessing
					.getAdapterSpecificTableAttribute();

			CommunicationChannelID communicationChannelID = inboundProcessing.getCommunicationChannel();

			CommunicationChannel communicationChannel = getCommunicationChannelInformation(communicationChannelID);

			return new InboundProcessing(communicationChannel, virusScan, schemaValidation, adapterSpecificAttribute,
					adapterSpecificTableAttribute);
		}
		return null;
	}

	@Override
	public List<OutboundProcessing> getOutboundProcessingInformation(IntegratedConfiguration integratedConfiguration) {

		List<com.sap.xi.basis.OutboundProcessing> outboundProcessings = integratedConfiguration.getOutboundProcessing();
		List<OutboundProcessing> outboundProcessingDaos = new ArrayList<>();

		for (int i = 0; i < outboundProcessings.size(); i++) {
			com.sap.xi.basis.OutboundProcessing outboundProcessing = outboundProcessings.get(i);

			VirusScanCode virusScan = outboundProcessing.getVirusScan();

			String schemaValidation = null;
			if (outboundProcessing.isSchemaValidationIndicator()) {
				schemaValidation = "Validation By Adapter";
			} else {
				schemaValidation = "No Validation";
			}

			DesignObjectID receiverInterface = outboundProcessing.getReceiverInterface();

			HeaderMapping headerMapping = outboundProcessing.getHeaderMapping();

			List<GenericProperty> adapterSpecificAttribute;
			adapterSpecificAttribute = outboundProcessing.getAdapterSpecificAttribute();

			List<GenericPropertyTable> adapterSpecificTableAttribute = outboundProcessing
					.getAdapterSpecificTableAttribute();

			CommunicationChannelID communicationChannelID = outboundProcessing.getCommunicationChannel();

			CommunicationChannel communicationChannel = getCommunicationChannelInformation(communicationChannelID);

			OutboundProcessing outboundProcessingDao = new OutboundProcessing(communicationChannel, virusScan,
					schemaValidation, adapterSpecificAttribute, adapterSpecificTableAttribute, headerMapping,
					receiverInterface);
			outboundProcessingDaos.add(outboundProcessingDao);
		}

		return outboundProcessingDaos;
	}

	@Override
	public CommunicationChannel getCommunicationChannelInformation(CommunicationChannelID communicationChannelID) {

		CommunicationChannelIn port = IntegrationPort.getCommunicationChannelPort();
		CommunicationChannelReadIn readIn = new CommunicationChannelReadIn();
		readIn.getCommunicationChannelID().add(communicationChannelID);
		CommunicationChannelReadOut readOut = port.read(readIn);

		if (readOut.getCommunicationChannel().size() == 0) {
			return null;
		}

		com.sap.xi.basis.CommunicationChannel originalChannel = readOut.getCommunicationChannel().get(0);
		List<LONGDescription> description = readOut.getCommunicationChannel().get(0).getDescription();

		Parameters parameters = this.getParametersInformation(originalChannel);
		Identifiers identifiers = this.getIdentifiersInformation(originalChannel);
		Module module = this.getModuleInformation(originalChannel.getModuleProcess());

		return new CommunicationChannel(communicationChannelID.getPartyID(), communicationChannelID.getComponentID(),
				communicationChannelID.getChannelID(), description, parameters, identifiers, module);
	}

	@Override
	public Parameters getParametersInformation(com.sap.xi.basis.CommunicationChannel communicationChannel) {

		if (communicationChannel == null) {
			return null;
		}
		AdapterType adapterType = this.getAdapterTypeInformation(communicationChannel.getAdapterMetadata());
		CommunicationChannelDirection direction = communicationChannel.getDirection();
		String transportProtocol = communicationChannel.getTransportProtocol();
		String messageProtocol = communicationChannel.getMessageProtocol();
		String adapterEngine = communicationChannel.getAdapterEngineName();
		List<GenericProperty> adapterSpecific = communicationChannel.getAdapterSpecificAttribute();

		return new Parameters(adapterType, direction, transportProtocol, messageProtocol, adapterEngine,
				adapterSpecific);
	}

	@Override
	public AdapterType getAdapterTypeInformation(DesignObjectID adapterMetadata) {

		if (adapterMetadata == null) {
			return null;
		}
		String name = adapterMetadata.getName();
		String nameSpace = adapterMetadata.getNamespace();
		String softwarecomponent = adapterMetadata.getSoftwareComponentVersionID();
		return new AdapterType(name, nameSpace, softwarecomponent);
	}

	@Override
	public Identifiers getIdentifiersInformation(com.sap.xi.basis.CommunicationChannel communicationChannel) {

		if (communicationChannel == null) {
			return null;
		}
		String senderAgency = communicationChannel.getSenderIdentifier().getSchemeAgencyID();
		String senderSchema = communicationChannel.getSenderIdentifier().getSchemeID();
		String receiverAgency = communicationChannel.getReceiverIdentifier().getSchemeAgencyID();
		String receiverSchema = communicationChannel.getReceiverIdentifier().getSchemeID();
		return new Identifiers(senderAgency, senderSchema, receiverAgency, receiverSchema);
	}

	@Override
	public Module getModuleInformation(ModuleProcess moduleProcess) {

		if (moduleProcess == null) {
			return null;
		}
		List<ProcessSequence> processSequence = this.getProcessSequenceInformation(moduleProcess.getProcessStep());
		List<ModuleConfiguration> moduleConfigurations = this.getModuleConfiguration(moduleProcess.getParameterGroup());
		return new Module(processSequence, moduleConfigurations);
	}

	@Override
	public List<ProcessSequence> getProcessSequenceInformation(List<ProcessStep> processStep) {

		List<ProcessSequence> processSequencesList = new ArrayList<>();

		for (int i = 0; i < processStep.size(); i++) {
			ProcessSequence processSequence = this.getProcessSequenceInformation((processStep).get(i), i);
			if (processSequence != null) {
				processSequencesList.add(processSequence);
			}
		}

		return processSequencesList;
	}

	@Override
	public ProcessSequence getProcessSequenceInformation(ProcessStep processStep, Integer number) {

		String moduleName = processStep.getModuleName();
		ModuleTypeCode type = processStep.getModuleType();
		String moduleKey = processStep.getParameterGroupID();

		return new ProcessSequence(number, moduleName, type, moduleKey);
	}

	@Override
	public List<ModuleConfiguration> getModuleConfiguration(List<ParameterGroup> parameterGroup) {

		if (parameterGroup.size() == 0) {
			return null;
		}
		List<ModuleConfiguration> moduleConfigurationsList = new ArrayList<>();
		for (int i = 0; i < parameterGroup.size(); i++) {
			moduleConfigurationsList.add(this.getModuleConfiguration(parameterGroup.get(i)));
		}

		return moduleConfigurationsList;
	}

	@Override
	public ModuleConfiguration getModuleConfiguration(ParameterGroup parameterGroup) {

		if (parameterGroup == null) {
			return null;
		}
		String moduleKey = parameterGroup.getParameterGroupID();
		List<ModuleConfigurationParameters> parameters = new ArrayList<>();

		List<RestrictedGenericProperty> parameterProp = parameterGroup.getParameter();

		if (parameterProp != null) {
			int size = parameterProp.size();
			for (int i = 0; i < size; i++) {
				RestrictedGenericProperty property = parameterProp.get(i);

				String name = OtherUtil.getValue(property.getName());
				String value = OtherUtil.getValue(property.getValue());

				if (!(name.equals("N/A") && value.equals("N/A"))) {
					parameters.add(new ModuleConfigurationParameters(name, value));
				}

			}
		}

		return new ModuleConfiguration(moduleKey, parameters);
	}

	/*
	 * @Override public CommunicationChannel
	 * communicationChannel(IntegratedConfiguration integratedConfiguration) { //
	 * TODO Auto-generated method stub return null; }
	 */

	@Override
	public List<ExternalReceiverRule> getExternalReceiverRules(IntegratedConfiguration integratedConfiguration) {
		// TODO Auto-generated method stub
		if (integratedConfiguration == null
				|| integratedConfiguration.getReceivers().getExternalReceiverRule().size() == 0) {
			return null;
		}
		List<ExternalReceiverRule> externalReceiverRuleList = new ArrayList<>();
		for (int i = 0; i < integratedConfiguration.getReceivers().getExternalReceiverRule().size(); i++) {
			List<ExternalReceiverRule> externalReceiverRule = this.getExternalReceiverRuleInfomation(
					integratedConfiguration.getReceivers().getExternalReceiverRule().get(i).getReceiverRuleID());
			externalReceiverRuleList.addAll(externalReceiverRule);
		}

		return externalReceiverRuleList;
	}

	@Override
	public List<ExternalReceiverRule> getExternalReceiverRuleInfomation(List<String> externalRuleId) {

		/*
		 * if(externalRuleId.size()==0) return null;
		 *
		 * ReceiverRuleIn port = IntegrationPort.getReceiverRulePort();
		 * ReceiverRuleReadIn readIn = new ReceiverRuleReadIn();
		 *
		 *
		 * for(int i =0; i< externalRuleId.size();i++) {
		 * readIn.getReceiverRuleID().add(externalRuleId.get(i)); ReceiverRuleReadOut
		 * readOut = port.read(readIn);
		 *
		 * ExternalReceiverRule externalReceiverRule = readOut.getReceiverRule(); }
		 */
		return null;
	}

}
