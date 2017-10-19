package com.sap.pi.document.model;

public class VirtualReceiver {

	String vrCommunicationParty;
	String vrCommunicationComponent;
	String vrDescription = "N/A";

	public VirtualReceiver(String vrCommunicationParty, String vrCommunicationComponent) {
		this.vrCommunicationParty = vrCommunicationParty;
		this.vrCommunicationComponent = vrCommunicationComponent;
	}

	public String getVrCommunicationParty() {
		return vrCommunicationParty;
	}

	public void setVrCommunicationParty(String vrCommunicationParty) {
		this.vrCommunicationParty = vrCommunicationParty;
	}

	public String getVrCommunicationComponent() {
		return vrCommunicationComponent;
	}

	public void setVrCommunicationComponent(String vrCommunicationComponent) {
		this.vrCommunicationComponent = vrCommunicationComponent;
	}

}
