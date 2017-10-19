package com.sap.pi.document.model;

import java.util.List;

import com.sap.xi.basis.DesignObjectID;
import com.sap.xi.basis.GenericProperty;
import com.sap.xi.basis.GenericPropertyTable;
import com.sap.xi.basis.HeaderMapping;
import com.sap.xi.basis.VirusScanCode;

public class OutboundProcessing {

	public CommunicationChannel getReceiverCommunicationChannel() {
		return receiverCommunicationChannel;
	}

	public VirusScanCode getVirusScan() {
		return virusScan;
	}

	public String getSchemaValidation() {
		return schemaValidation;
	}

	public List<GenericProperty> getAdapterSpecificAttribute() {
		return adapterSpecificAttribute;
	}

	public List<GenericPropertyTable> getAdapterSpecificTableAttribute() {
		return adapterSpecificTableAttribute;
	}

	public HeaderMapping getHeaderMapping() {
		return headerMapping;
	}

	CommunicationChannel receiverCommunicationChannel;
	VirusScanCode virusScan;
	String schemaValidation;
	List<GenericProperty> adapterSpecificAttribute;
	List<GenericPropertyTable> adapterSpecificTableAttribute;
	HeaderMapping headerMapping;
	DesignObjectID receiverInterface;


	public DesignObjectID getReceiverInterface() {
		return receiverInterface;
	}

	public OutboundProcessing(CommunicationChannel senderCommunicationChannel, VirusScanCode virusScan,
			String schemaValidation, List<GenericProperty> adapterSpecificAttribute,
			List<GenericPropertyTable> adapterSpecificTableAttribute, HeaderMapping headerMapping,
			DesignObjectID receiverInterface) {

		this.receiverCommunicationChannel = senderCommunicationChannel;
		this.virusScan = virusScan;
		this.schemaValidation = schemaValidation;
		this.adapterSpecificAttribute = adapterSpecificAttribute;
		this.adapterSpecificTableAttribute = adapterSpecificTableAttribute;
		this.headerMapping = headerMapping;
		this.receiverInterface = receiverInterface;
	}

}
