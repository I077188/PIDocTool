package com.sap.pi.document.model;

import java.util.List;

import com.sap.xi.basis.GenericProperty;
import com.sap.xi.basis.GenericPropertyTable;
import com.sap.xi.basis.VirusScanCode;

public class InboundProcessing {

	CommunicationChannel communicationChannel;
	VirusScanCode virusScan;
	String schemaValidation;
	List<GenericProperty> adapterSpecificAttribute;
	List<GenericPropertyTable> adapterSpecificTableAttribute;

	public InboundProcessing(CommunicationChannel senderCommunicationChannel, VirusScanCode virusScan,
			String schemaValidation, List<GenericProperty> adapterSpecificAttribute,
			List<GenericPropertyTable> adapterSpecificTableAttribute) {

		this.communicationChannel = senderCommunicationChannel;
		this.virusScan = virusScan;
		this.schemaValidation = schemaValidation;
		this.adapterSpecificAttribute = adapterSpecificAttribute;
		this.adapterSpecificTableAttribute = adapterSpecificTableAttribute;
	}

	public CommunicationChannel getCommunicationChannel() {
		return communicationChannel;
	}

	public void setSenderCommunicationChannel(CommunicationChannel senderCommunicationChannel) {
		this.communicationChannel = senderCommunicationChannel;
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

	public List<GenericPropertyTable> getAdapterSpecificTableAttribute() {
		return adapterSpecificTableAttribute;
	}

	public void setAdapterSpecificTableAttribute(List<GenericPropertyTable> adapterSpecificTableAttribute) {
		this.adapterSpecificTableAttribute = adapterSpecificTableAttribute;
	}

}
