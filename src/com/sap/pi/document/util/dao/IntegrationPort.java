package com.sap.pi.document.util.dao;

import java.io.IOException;

import javax.xml.ws.BindingProvider;

import com.sap.xi.basis.CommunicationChannelIn;
import com.sap.xi.basis.CommunicationChannelInService;
import com.sap.xi.basis.CommunicationPartyIn;
import com.sap.xi.basis.CommunicationPartyInService;
import com.sap.xi.basis.IntegratedConfigurationIn;
import com.sap.xi.basis.IntegratedConfigurationInService;
import com.sap.xi.basis.ReceiverRuleIn;
import com.sap.xi.basis.ReceiverRuleInService;

public class IntegrationPort {

	public static IntegratedConfigurationIn getIntegratedConfigurationPort() {

		IntegratedConfigurationInService icoInService;
		SetSecurity setSecurity;
		icoInService = new IntegratedConfigurationInService();
		IntegratedConfigurationIn port = icoInService.getIntegratedConfigurationInPort();
		setSecurity = new SetSecurity();

		try {
			setSecurity.set_security((BindingProvider) port,
					"/IntegratedConfigurationInService/IntegratedConfigurationInImplBean");
			return port;
		} catch (IOException e) {
			e.printStackTrace();
			CONSTAINTS.LOG.error(e.getMessage());
		}

		return null;
	}

	public static CommunicationChannelIn getCommunicationChannelPort() {
		CommunicationChannelInService icoInService;
		SetSecurity setSecurity;
		icoInService = new CommunicationChannelInService();
		CommunicationChannelIn port = icoInService.getCommunicationChannelInPort();
		setSecurity = new SetSecurity();

		try {
			setSecurity.set_security((BindingProvider) port,
					"/CommunicationChannelInService/CommunicationChannelInImplBean");
			return port;
		} catch (IOException e) {
			e.printStackTrace();
			CONSTAINTS.LOG.error(e.getMessage());
		}

		return null;
	}

	public static CommunicationPartyIn getCommunicationPartyPort() {
		CommunicationPartyInService icoInService;
		SetSecurity setSecurity;
		icoInService = new CommunicationPartyInService();
		CommunicationPartyIn port = icoInService.getCommunicationPartyInPort();
		setSecurity = new SetSecurity();

		try {
			setSecurity.set_security((BindingProvider) port,
					"/CommunicationPartyInService/CommunicationPartyInImplBean");
			return port;
		} catch (IOException e) {
			e.printStackTrace();
			CONSTAINTS.LOG.error(e.getMessage());
		}

		return null;
	}

	public static ReceiverRuleIn getReceiverRulePort() {
		ReceiverRuleInService icoInService;
		SetSecurity setSecurity;
		icoInService = new ReceiverRuleInService();
		ReceiverRuleIn port = icoInService.getReceiverRuleInPort();
		setSecurity = new SetSecurity();

		try {
			setSecurity.set_security((BindingProvider) port, "/ReceiverRuleInService/ReceiverRuleInImplBean");
			return port;
		} catch (IOException e) {
			e.printStackTrace();
			CONSTAINTS.LOG.error(e.getMessage());
		}

		return null;
	}
}
