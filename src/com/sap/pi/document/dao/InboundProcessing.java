package com.sap.pi.document.dao;

import java.util.List;

import com.sap.xi.basis.GenericProperty;
import com.sap.xi.basis.VirusScanCode;

public class InboundProcessing {

	CommunicationChannel senderCommunicationChannel;
	VirusScanCode virusScan;
	String schemaValidation;
	List<GenericProperty> adapterSpecificAttribute;
	String adapterSpecificTableAttribute;

	public InboundProcessing(CommunicationChannel senderCommunicationChannel, VirusScanCode virusScan,
			String schemaValidation, List<GenericProperty> adapterSpecificAttribute,
			String adapterSpecificTableAttribute) {

		this.senderCommunicationChannel = senderCommunicationChannel;
		this.virusScan = virusScan;
		this.schemaValidation = schemaValidation;
		this.adapterSpecificAttribute = adapterSpecificAttribute;
		this.adapterSpecificTableAttribute = adapterSpecificTableAttribute;
	}

	public CommunicationChannel getSenderCommunicationChannel() {
		return senderCommunicationChannel;
	}

	public void setSenderCommunicationChannel(CommunicationChannel senderCommunicationChannel) {
		this.senderCommunicationChannel = senderCommunicationChannel;
	}

	public VirusScanCode getVirusScan() {
		return virusScan;
	}

	public void setVirusScan(VirusScanCode virusScanCode) {
		this.virusScan = virusScanCode;
	}

	public String getSchemaValidation() {
		return schemaValidation;
	}

	public void setSchemaValidation(String schemaValidation) {
		this.schemaValidation = schemaValidation;
	}

	public List<GenericProperty> getAdapterSpecificAttribute() {
		return adapterSpecificAttribute;
	}

	public void setAdapterSpecificAttribute(List<GenericProperty> adapterSpecificAttribute) {
		this.adapterSpecificAttribute = adapterSpecificAttribute;
	}

}
