package com.sap.pi.document.util;

import java.util.List;

import com.sap.pi.document.dao.AdapterType;
import com.sap.pi.document.dao.CommunicationChannel;
import com.sap.pi.document.dao.ExternalReceiverRule;
import com.sap.pi.document.dao.Identifiers;
import com.sap.pi.document.dao.InboundProcessing;
import com.sap.pi.document.dao.Logging;
import com.sap.pi.document.dao.Module;
import com.sap.pi.document.dao.ModuleConfiguration;
import com.sap.pi.document.dao.OperationMapping;
import com.sap.pi.document.dao.Parameters;
import com.sap.pi.document.dao.ProcessSequence;
import com.sap.pi.document.dao.Sender;
import com.sap.pi.document.dao.Staging;
import com.sap.pi.document.dao.VirtualReceiver;
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

	public CommunicationChannel communicationChannel(IntegratedConfiguration integratedConfiguration);

	public List<ExternalReceiverRule> getExternalReceiverRules(IntegratedConfiguration integratedConfiguration);

	public List<ExternalReceiverRule> getExternalReceiverRuleInfomation(List<String> externalRuleId);

}
