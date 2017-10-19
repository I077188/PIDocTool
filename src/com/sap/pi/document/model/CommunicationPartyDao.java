package com.sap.pi.document.model;

import java.util.List;

public class CommunicationPartyDao {

	String communicationPartyID;
	List<AdditionalIdentfier> additionalIdentfiers;

	public CommunicationPartyDao(String communicationPartyID, List<AdditionalIdentfier> additionalIdentfiers) {
		this.additionalIdentfiers = additionalIdentfiers;
		this.communicationPartyID = communicationPartyID;
	}

	public String getCommunicationPartyID() {
		return communicationPartyID;
	}

	public List<AdditionalIdentfier> getAdditionalIdentfier() {
		return additionalIdentfiers;
	}

}
