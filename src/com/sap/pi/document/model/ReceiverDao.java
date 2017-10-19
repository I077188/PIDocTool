package com.sap.pi.document.model;

import java.util.List;

import com.sap.xi.basis.CommunicationComponentID;
import com.sap.xi.basis.ReceiverInterfaces;

public class ReceiverDao {

	CommunicationComponentID receiverWithCCID;
	List<ReceiverInterfaces> receiverInterfaces;

	public CommunicationComponentID getReceiverRule() {
		return receiverWithCCID;
	}

	public List<ReceiverInterfaces> getReceiverInterface() {
		return receiverInterfaces;
	}

	public ReceiverDao(CommunicationComponentID receiverWithCCID,
			List<ReceiverInterfaces> receiverInterfaces) {
		this.receiverWithCCID = receiverWithCCID;
		this.receiverInterfaces = receiverInterfaces;
	}
}
