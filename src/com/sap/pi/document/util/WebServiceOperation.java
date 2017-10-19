package com.sap.pi.document.util;

import java.util.List;

import com.sap.pi.document.model.AdapterType;
import com.sap.pi.document.model.CommunicationChannel;
import com.sap.pi.document.model.ExternalReceiverRule;
import com.sap.pi.document.model.Identifiers;
import com.sap.pi.document.model.InboundProcessing;
import com.sap.pi.document.model.Logging;
import com.sap.pi.document.model.Module;
import com.sap.pi.document.model.ModuleConfiguration;
import com.sap.pi.document.model.OperationMapping;
import com.sap.pi.document.model.OutboundProcessing;
import com.sap.pi.document.model.Parameters;
import com.sap.pi.document.model.ProcessSequence;
import com.sap.pi.document.model.Sender;
import com.sap.pi.document.model.Staging;
import com.sap.pi.document.model.VirtualReceiver;
import com.sap.xi.basis.CommunicationChannelID;
import com.sap.xi.basis.DesignObjectID;
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.MessageHeaderID;
import com.sap.xi.basis.ModuleProcess;
import com.sap.xi.basis.ParameterGroup;
import com.sap.xi.basis.ProcessStep;

public interface WebServiceOperation {

	// Get ID of all the ICO
	public List<MessageHeaderID> getIntegratedConfigurationID();

	// Get ICO by messageID
	public IntegratedConfiguration getIntegrationConfiguration(MessageHeaderID messageHeaderID);

	public Sender getSenderInformation(MessageHeaderID headerID);

	public Staging getStagingInformation(IntegratedConfiguration integratedConfiguration);

	public Logging getLoggingInformation(IntegratedConfiguration integratedConfiguration);

	public VirtualReceiver getVirtualReceiverInformation(IntegratedConfiguration integratedConfiguration);

	public InboundProcessing getInboundProcessingInformation(IntegratedConfiguration integratedConfiguration);

	public List<OutboundProcessing> getOutboundProcessingInformation(IntegratedConfiguration integratedConfiguration);

	public CommunicationChannel getCommunicationChannelInformation(CommunicationChannelID communicationChannelID);

	public Parameters getParametersInformation(com.sap.xi.basis.CommunicationChannel communicationChannel);

	public AdapterType getAdapterTypeInformation(DesignObjectID adapterMetadata);

	public Identifiers getIdentifiersInformation(com.sap.xi.basis.CommunicationChannel communicationChannel);

	public Module getModuleInformation(ModuleProcess moduleProcess);

	public List<ProcessSequence> getProcessSequenceInformation(List<ProcessStep> processStep);

	public ProcessSequence getProcessSequenceInformation(ProcessStep processStep, Integer number);

	public List<ModuleConfiguration> getModuleConfiguration(List<ParameterGroup> parameterGroup);

	public ModuleConfiguration getModuleConfiguration(ParameterGroup parameterGroup);

	public List<OperationMapping> getOperationMappings(IntegratedConfiguration integratedConfiguration);

	// public CommunicationChannel communicationChannel(IntegratedConfiguration
	// integratedConfiguration);

	public List<ExternalReceiverRule> getExternalReceiverRules(IntegratedConfiguration integratedConfiguration);

	public List<ExternalReceiverRule> getExternalReceiverRuleInfomation(List<String> externalRuleId);

}
