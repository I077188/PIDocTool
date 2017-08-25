package com.sap.pi.document.util.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;

import org.apache.commons.lang3.StringUtils;

import com.sap.pi.document.dao.AdapterType;
import com.sap.pi.document.dao.AdditionalIdentfier;
import com.sap.pi.document.dao.CommunicationChannel;
import com.sap.pi.document.dao.CommunicationPartyDao;
import com.sap.pi.document.dao.Identifiers;
import com.sap.pi.document.dao.InboundProcessing;
import com.sap.pi.document.dao.Logging;
import com.sap.pi.document.dao.Module;
import com.sap.pi.document.dao.ModuleConfiguration;
import com.sap.pi.document.dao.ModuleConfigurationParameters;
import com.sap.pi.document.dao.Parameters;
import com.sap.pi.document.dao.ProcessSequence;
import com.sap.pi.document.dao.Sender;
import com.sap.pi.document.dao.Staging;
import com.sap.pi.document.dao.VirtualReceiver;
import com.sap.pi.document.util.WebServiceOperation;
import com.sap.pi.document.util.dao.IntegrationPort;
import com.sap.pi.document.util.dao.SetSecurity;
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
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.IntegratedConfigurationIn;
import com.sap.xi.basis.IntegratedConfigurationQueryIn;
import com.sap.xi.basis.IntegratedConfigurationQueryOut;
import com.sap.xi.basis.IntegratedConfigurationReadIn;
import com.sap.xi.basis.IntegratedConfigurationReadOut;
import com.sap.xi.basis.MessageHeaderID;
import com.sap.xi.basis.ModuleProcess;
import com.sap.xi.basis.ModuleTypeCode;
import com.sap.xi.basis.ParameterGroup;
import com.sap.xi.basis.ProcessStep;
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
		IntegratedConfigurationReadOut readOut = port.read(readIn);

		if (readOut.getIntegratedConfiguration().size() == 0)
			return null;
		return readOut.getIntegratedConfiguration().get(0);
	}


	@Override
	public Staging getStagingInformation(IntegratedConfiguration integratedConfiguration) {

		String specificConfig = integratedConfiguration.getStaging().getSpecificConfiguration();

		if (StringUtils.isBlank(specificConfig)) {
			specificConfig = "N/A";
		}
		return new Staging(integratedConfiguration.getStaging().isUseGlobal(), specificConfig);

	}


	@Override
	public Sender getSenderInformation(MessageHeaderID headerID) {
		IntegratedConfiguration iConfig = this.getIntegrationConfiguration(headerID);

		MessageHeaderID mHeaderID = iConfig.getIntegratedConfigurationID();

		CommunicationPartyDao communicationParty = null;

		String communicationPartyID = mHeaderID.getSenderPartyID();
		communicationPartyID = (communicationPartyID == null || communicationPartyID.equals("")) ? "N/A"
				: communicationPartyID;

		if (!communicationPartyID.equals("N/A")) {
			// get communicationParty
			try {
				communicationParty = getCommunicationParty(communicationPartyID);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

		} else {
			List<AdditionalIdentfier> additionalIdentfiers = new ArrayList<>();
			additionalIdentfiers.add(new AdditionalIdentfier("N/A", "N/A", "N/A"));
			communicationParty = new CommunicationPartyDao("N/A", additionalIdentfiers);
		}

		String communicationComponent = mHeaderID.getSenderComponentID();
		communicationComponent = (communicationComponent == null || communicationComponent.equals("")) ? "N/A"
				: communicationComponent;

		String namespace = mHeaderID.getInterfaceNamespace();
		namespace = (namespace == null || namespace.equals("")) ? "N/A" : namespace;

		String senderInterface = mHeaderID.getInterfaceName();
		senderInterface = (senderInterface == null || senderInterface.equals("")) ? "N/A" : senderInterface;

		String senderInterfaceSWC = iConfig.getInboundProcessing().getSenderInterfaceSoftwareComponentVersion();
		senderInterfaceSWC = (senderInterfaceSWC == null || senderInterfaceSWC.equals("")) ? "N/A" : senderInterfaceSWC;

		return new Sender(communicationParty, communicationComponent, senderInterface, namespace, senderInterfaceSWC);
	}

	private CommunicationPartyDao getCommunicationParty(String communicationPartyID) throws MalformedURLException {

		CommunicationPartyInService cPartyInService = new CommunicationPartyInService();
		CommunicationPartyIn cPartyIn = cPartyInService.getCommunicationPartyInPort();

		SetSecurity setSecurity = new SetSecurity();
		try {
			setSecurity.set_security((BindingProvider) cPartyIn,
					"/CommunicationPartyInService/CommunicationPartyInImplBean");
		} catch (IOException e) {
			e.printStackTrace();
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

				String schemeID = cpAdditionalIdentifier.getSchemeID();
				schemeID = (schemeID.equals("") || schemeID == null) ? "N/A" : schemeID;

				String schemeAgencyID = cpAdditionalIdentifier.getSchemeAgencyID();
				schemeAgencyID = (schemeAgencyID.equals("") || schemeAgencyID == null) ? "N/A" : schemeAgencyID;

				String Name = cpAdditionalIdentifier.getValue();
				Name = (Name.equals("") || Name == null) ? "N/A" : Name;

				additionalIdentfiers.add(new AdditionalIdentfier(schemeID, schemeAgencyID, Name));
			}
		} else {
			additionalIdentfiers.add(new AdditionalIdentfier("N/A", "N/A", "N/A"));
		}

		return new CommunicationPartyDao(communicationPartyID, additionalIdentfiers);
	}


	@Override
	public Logging getLoggingInformation(IntegratedConfiguration integratedConfiguration) {

		String specificConfig = integratedConfiguration.getLogging().getSpecificConfiguration();

		if (StringUtils.isBlank(specificConfig)) {
			specificConfig = "N/A";
		}

		return new Logging(integratedConfiguration.getLogging().isUseGlobal(),
				specificConfig);
	}

	@Override
	public VirtualReceiver getVirtualReceiverInformation(IntegratedConfiguration integratedConfiguration) {

		return null; // Not find the position
	}


	@Override
	public InboundProcessing getInboundProcessingInformation(IntegratedConfiguration integratedConfiguration) {

		VirusScanCode virusScan = integratedConfiguration.getInboundProcessing().getVirusScan();

		String schemaValidation = null;
		if (integratedConfiguration.getInboundProcessing().isSchemaValidationIndicator()) {
			schemaValidation = "Validation By Adapter";
		} else {
			schemaValidation = "No Validation";
		}

		List<GenericProperty> adapterSpecificAttribute;
		adapterSpecificAttribute = integratedConfiguration.getInboundProcessing().getAdapterSpecificAttribute();

		List<GenericPropertyTable> adapterSpecificTableAttribute;
		adapterSpecificTableAttribute = integratedConfiguration.getInboundProcessing()
				.getAdapterSpecificTableAttribute();


		CommunicationChannelID communicationChannelID = integratedConfiguration.getInboundProcessing()
				.getCommunicationChannel();

		CommunicationChannel communicationChannel = this.getCommunicationChannelInformation(communicationChannelID);

		return new InboundProcessing(communicationChannel, virusScan, schemaValidation, adapterSpecificAttribute,
				adapterSpecificTableAttribute);
	}

	@Override
	public CommunicationChannel getCommunicationChannelInformation(CommunicationChannelID communicationChannelID) {


		CommunicationChannelIn port = IntegrationPort.getCommunicationChannelPort();
		CommunicationChannelReadIn readIn = new CommunicationChannelReadIn();
		readIn.getCommunicationChannelID().add(communicationChannelID);
		CommunicationChannelReadOut readOut = port.read(readIn);

		if (readOut.getCommunicationChannel().size() == 0)
			return null;
		com.sap.xi.basis.CommunicationChannel originalChannel = readOut.getCommunicationChannel().get(0);
		List<LONGDescription> description = readOut.getCommunicationChannel().get(0).getDescription();

		Parameters parameters = this.getParametersInformation(originalChannel);
		Identifiers identifiers = this.getIdentifiersInformation(originalChannel);
		Module module = this.getModuleInformation(originalChannel.getModuleProcess());

		return new CommunicationChannel(communicationChannelID.getPartyID(), communicationChannelID.getChannelID(),
				communicationChannelID.getComponentID(), description, parameters, identifiers, module);
	}


	@Override
	public Parameters getParametersInformation(com.sap.xi.basis.CommunicationChannel communicationChannel)
	{

		if (communicationChannel == null)
			return null;
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

		if (adapterMetadata == null)
			return null;
		String name = adapterMetadata.getName();
		String nameSpace = adapterMetadata.getNamespace();
		String softwarecomponent = adapterMetadata.getSoftwareComponentVersionID();
		return new AdapterType(name, nameSpace, softwarecomponent);
	}

	@Override
	public Identifiers getIdentifiersInformation(com.sap.xi.basis.CommunicationChannel communicationChannel) {

		if (communicationChannel == null)
			return null;
		String senderAgency = communicationChannel.getSenderIdentifier().getSchemeAgencyID();
		String senderSchema = communicationChannel.getSenderIdentifier().getSchemeID();
		String receiverAgency = communicationChannel.getReceiverIdentifier().getSchemeAgencyID();
		String receiverSchema = communicationChannel.getReceiverIdentifier().getSchemeID();
		return new Identifiers(senderAgency, senderSchema, receiverAgency, receiverSchema);
	}

	@Override
	public Module getModuleInformation(ModuleProcess moduleProcess) {

		if (moduleProcess == null)
			return null;
		List<ProcessSequence> processSequence = this.getProcessSequenceInformation(moduleProcess.getProcessStep());
		List<ModuleConfiguration> moduleConfigurations = this.getModuleConfiguration(moduleProcess.getParameterGroup());
		return new Module(processSequence, moduleConfigurations);
	}


	@Override
	public List<ProcessSequence> getProcessSequenceInformation(List<ProcessStep> processStep) {

		List<ProcessSequence> processSequencesList = new ArrayList<>();

		for (int i = 0; i < processStep.size(); i++) {
			ProcessSequence processSequence = this.getProcessSequenceInformation((processStep).get(i), i);
			if (processSequence != null)
				processSequencesList.add(processSequence);
		}

		return processSequencesList;
	}

	@Override
	public ProcessSequence getProcessSequenceInformation(ProcessStep processStep,Integer number) {

		String moduleName = processStep.getModuleName();
		ModuleTypeCode type = processStep.getModuleType();
		String moduleKey = processStep.getParameterGroupID();

		return new ProcessSequence(number, moduleName, type, moduleKey);
	}


	@Override
	public List<ModuleConfiguration> getModuleConfiguration(List<ParameterGroup> parameterGroup) {

		if (parameterGroup.size() == 0)
			return null;
		List<ModuleConfiguration> moduleConfigurationsList = new ArrayList<>();
		for(int i =0; i< parameterGroup.size();i++) {
			moduleConfigurationsList.add(this.getModuleConfiguration(parameterGroup.get(i)));
		}

		return moduleConfigurationsList;
	}


	@Override
	public ModuleConfiguration getModuleConfiguration(ParameterGroup parameterGroup) {

		if (parameterGroup == null)
			return null;
		String moduleKey = parameterGroup.getParameterGroupID();
		List<ModuleConfigurationParameters> parameters = new ArrayList<>();
		ModuleConfigurationParameters parameter = new ModuleConfigurationParameters(
				parameterGroup.getParameter().get(0).getName(), parameterGroup.getParameter().get(0).getValue());
		parameters.add(parameter);

		for (int i = 1; i < parameterGroup.getParameter().size(); i++) {
			parameter.setParameterName(parameterGroup.getParameter().get(i).getName());
			parameter.setParameterValue(parameterGroup.getParameter().get(i).getValue());
			parameters.add(parameter);
		}
		return new ModuleConfiguration(moduleKey, parameters);
	}
}
