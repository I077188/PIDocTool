package com.sap.pi.document.dao;

public class InboundProcessiong {
	SenderCommunicationChannel senderCommunicationChannel;
	String virusScan;
	String schemaValidation;
	String adapterSpecificAttribute;
	String adapterSpecificTableAttribute;

	public InboundProcessiong(SenderCommunicationChannel senderCommunicationChannel, String virusScan,
			String schemaValidation, String adapterSpecificAttribute, String adapterSpecificTableAttribute) {

		this.senderCommunicationChannel = senderCommunicationChannel;
		this.virusScan = virusScan;
		this.schemaValidation = schemaValidation;
		this.adapterSpecificAttribute = adapterSpecificAttribute;
		this.adapterSpecificTableAttribute = adapterSpecificTableAttribute;
	}

	public SenderCommunicationChannel getSenderCommunicationChannel() {
		return senderCommunicationChannel;
	}

	public void setSenderCommunicationChannel(SenderCommunicationChannel senderCommunicationChannel) {
		this.senderCommunicationChannel = senderCommunicationChannel;
	}

	public String getVirusScan() {
		return virusScan;
	}

	public void setVirusScan(String virusScan) {
		this.virusScan = virusScan;
	}

	public String getSchemaValidation() {
		return schemaValidation;
	}

	public void setSchemaValidation(String schemaValidation) {
		this.schemaValidation = schemaValidation;
	}

	public String getAdapterSpecificAttribute() {
		return adapterSpecificAttribute;
	}

	public void setAdapterSpecificAttribute(String adapterSpecificAttribute) {
		this.adapterSpecificAttribute = adapterSpecificAttribute;
	}

}
