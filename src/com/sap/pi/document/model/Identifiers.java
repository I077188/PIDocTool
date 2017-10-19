package com.sap.pi.document.model;

public class Identifiers {

	String senderAgency;
	String senderSchema;
	String receiverAgency;
	String receiverSchema;

	public Identifiers(String senderAgency, String senderSchema, String receiverAgency, String receiverSchema) {
		super();
		this.senderAgency = senderAgency;
		this.senderSchema = senderSchema;
		this.receiverAgency = receiverAgency;
		this.receiverSchema = receiverSchema;
	}

	public String getSenderAgency() {
		return senderAgency;
	}

	public void setSenderAgency(String senderAgency) {
		this.senderAgency = senderAgency;
	}

	public String getSenderSchema() {
		return senderSchema;
	}

	public void setSenderSchema(String senderSchema) {
		this.senderSchema = senderSchema;
	}

	public String getReceiverAgency() {
		return receiverAgency;
	}

	public void setReceiverAgency(String receiverAgency) {
		this.receiverAgency = receiverAgency;
	}

	public String getReceiverSchema() {
		return receiverSchema;
	}

	public void setReceiverSchema(String receiverSchema) {
		this.receiverSchema = receiverSchema;
	}


}
