package com.sap.pi.document.model;

public class Sender {

	CommunicationPartyDao communicationParty;
	String communicationComponent;
	String namespace;
	String senderInterface;
	String senderInterfaceSWC;

	public Sender(CommunicationPartyDao senderCommunicationParty, String senderCommunicationComponent,
			String senderInterface,
			String senderNamespace, String senderInterfaceSWC) {
		this.communicationParty = senderCommunicationParty;
		this.communicationComponent = senderCommunicationComponent;
		this.senderInterface = senderInterface;
		this.namespace = senderNamespace;
		this.senderInterfaceSWC = senderInterfaceSWC;

	}

	public CommunicationPartyDao getSenderCommunicationParty() {
		return communicationParty;
	}

	public String getSenderCommunicationComponent() {
		return communicationComponent;
	}


	public String getSenderInterface() {
		return senderInterface;
	}


	public String getSenderNamespace() {
		return namespace;
	}

	public String getSenderInterfaceSWC() {
		return senderInterfaceSWC;
	}

}
