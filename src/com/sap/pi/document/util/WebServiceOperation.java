package com.sap.pi.document.util;

import java.util.List;

import com.sap.pi.document.dao.CommunicationChannel;
import com.sap.pi.document.dao.InboundProcessing;
import com.sap.pi.document.dao.Logging;
import com.sap.pi.document.dao.Sender;
import com.sap.pi.document.dao.Staging;
import com.sap.pi.document.dao.VirtualReceiver;
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.MessageHeaderID;

public interface WebServiceOperation {

	public List<MessageHeaderID> getIntegratedConfigurationID(); // Get ID of all the ICO

	public IntegratedConfiguration getIntegrationConfiguration(MessageHeaderID messageHeaderID); // Get ICO by
																									// messageID

	public Sender getSenderInformation(MessageHeaderID headerID);

	public Staging getStagingInformation(IntegratedConfiguration integratedConfiguration);

	public Logging getLoggingInformation(IntegratedConfiguration integratedConfiguration);

	public VirtualReceiver getVirtualReceiverInformation(IntegratedConfiguration integratedConfiguration);

	public InboundProcessing getInboundProcessingInformation(IntegratedConfiguration integratedConfiguration);

	public CommunicationChannel communicationChannel(IntegratedConfiguration integratedConfiguration);

}
