package com.sap.pi.document.dao;

public class IntegratedConfiguration71 {
	String senderPartyID;
	String senderComponentID;
	String interfaceName;
	String interfaceNamespace;
	String receiverPartyID;
	String receiverComponentID;

	public IntegratedConfiguration71(String senderPartyID, String senderComponentID, String interfaceName,
			String interfaceNamespace, String receiverPartyID, String receiverComponentID) {
		this.senderPartyID = senderPartyID;
		this.senderComponentID = senderComponentID;
		this.interfaceName = interfaceName;
		this.interfaceNamespace = interfaceNamespace;
		this.receiverPartyID = receiverPartyID;
		this.receiverComponentID = receiverComponentID;
	}

	public String getSenderPartyID() {
		return senderPartyID;
	}

	public void setSenderPartyID(String senderPartyID) {
		this.senderPartyID = senderPartyID;
	}

	public String getSenderComponentID() {
		return senderComponentID;
	}

	public void setSenderComponentID(String senderComponentID) {
		this.senderComponentID = senderComponentID;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getInterfaceNamespace() {
		return interfaceNamespace;
	}

	public void setInterfaceNamespace(String interfaceNamespace) {
		this.interfaceNamespace = interfaceNamespace;
	}

	public String getReceiverPartyID() {
		return receiverPartyID;
	}

	public void setReceiverPartyID(String receiverPartyID) {
		this.receiverPartyID = receiverPartyID;
	}

	public String getReceiverComponentID() {
		return receiverComponentID;
	}

	public void setReceiverComponentID(String receiverComponentID) {
		this.receiverComponentID = receiverComponentID;
	}

}
