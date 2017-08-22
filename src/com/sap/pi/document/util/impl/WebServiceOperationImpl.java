package com.sap.pi.document.util.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;

import org.apache.commons.lang3.StringUtils;

import com.sap.pi.document.dao.AdditionalIdentfier;
import com.sap.pi.document.dao.CommunicationChannel;
import com.sap.pi.document.dao.CommunicationPartyDao;
import com.sap.pi.document.dao.InboundProcessing;
import com.sap.pi.document.dao.Logging;
import com.sap.pi.document.dao.Sender;
import com.sap.pi.document.dao.Staging;
import com.sap.pi.document.dao.VirtualReceiver;
import com.sap.pi.document.util.WebServiceOperation;
import com.sap.pi.document.util.dao.IntegrationPort;
import com.sap.pi.document.util.dao.SetSecurity;
import com.sap.xi.basis.CommunicationParty;
import com.sap.xi.basis.CommunicationPartyAdditionalIdentifier;
import com.sap.xi.basis.CommunicationPartyIn;
import com.sap.xi.basis.CommunicationPartyInService;
import com.sap.xi.basis.CommunicationPartyReadIn;
import com.sap.xi.basis.CommunicationPartyReadOut;
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.IntegratedConfigurationIn;
import com.sap.xi.basis.IntegratedConfigurationQueryIn;
import com.sap.xi.basis.IntegratedConfigurationQueryOut;
import com.sap.xi.basis.IntegratedConfigurationReadIn;
import com.sap.xi.basis.IntegratedConfigurationReadOut;
import com.sap.xi.basis.MessageHeaderID;

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
	public IntegratedConfiguration getIntegrationConfiguration(MessageHeaderID messageHeaderID) {

		IntegratedConfigurationIn port = IntegrationPort.getIntegratedConfigurationPort();
		IntegratedConfigurationReadIn readIn = new IntegratedConfigurationReadIn();
		readIn.getIntegratedConfigurationID().add(messageHeaderID);
		IntegratedConfigurationReadOut readOut = port.read(readIn);

		return readOut.getIntegratedConfiguration().get(0);
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
		InboundProcessing inboundProcessing = null;
		inboundProcessing.setVirusScan(integratedConfiguration.getInboundProcessing().getVirusScan());

		if (integratedConfiguration.getInboundProcessing().isSchemaValidationIndicator()) {
			inboundProcessing.setSchemaValidation("Validation By Adapter");
		} else {
			inboundProcessing.setSchemaValidation("No Validation");
		}

		inboundProcessing.setAdapterSpecificAttribute(
				integratedConfiguration.getInboundProcessing().getAdapterSpecificAttribute());
		// inboundProcessing.setSenderCommunicationChannel(this.get);
		return null;
	}

	@Override
	public CommunicationChannel communicationChannel(IntegratedConfiguration integratedConfiguration) {
		// TODO Auto-generated method stub
		return null;
	}

}
