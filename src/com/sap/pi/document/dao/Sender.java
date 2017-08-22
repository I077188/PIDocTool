package com.sap.pi.document.dao;

public class Sender {

	String communicationParty;
	String communicationComponent;
	String namespace;
	String senderInterface;
	String senderInterfaceSWC;

	public Sender(String senderCommunicationParty, String senderCommunicationComponent, String senderInterface,
			String senderNamespace, String senderInterfaceSWC) {
		this.communicationParty = senderCommunicationParty;
		this.communicationComponent = senderCommunicationComponent;
		this.senderInterface = senderInterface;
		this.namespace = senderNamespace;
		this.senderInterfaceSWC = senderInterfaceSWC;

	}

	public String getSenderCommunicationParty() {
		return communicationParty;
	}

	public void setSenderCommunicationParty(String senderCommunicationParty) {
		this.communicationParty = senderCommunicationParty;
	}

	public String getSenderCommunicationComponent() {
		return communicationComponent;
	}

	public void setSenderCommunicationComponent(String senderCommunicationComponent) {
		this.communicationComponent = senderCommunicationComponent;
	}

	public String getSenderInterface() {
		return senderInterface;
	}

	public void setSenderInterface(String senderInterface) {
		this.senderInterface = senderInterface;
	}

	public String getSenderNamespace() {
		return namespace;
	}

	public void setSenderNamespace(String senderNamespace) {
		this.namespace = senderNamespace;
	}

	public String getSenderInterfaceSWC() {
		return senderInterfaceSWC;
	}

	public void setSenderInterfaceSWC(String senderInterfaceSWC) {
		this.senderInterfaceSWC = senderInterfaceSWC;
	}

}
