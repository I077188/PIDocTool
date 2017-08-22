package com.sap.pi.document.dao;

public class AdditionalIdentfier {

	String schemeID;
	String schemeAgencyID;
	String Name;

	public AdditionalIdentfier(String schemeID, String schemeAgencyID, String Name) {

		this.Name = Name;
		this.schemeID = schemeID;
		this.schemeAgencyID = schemeAgencyID;
	}

	public String getSchemeID() {
		return schemeID;
	}

	public String getSchemeAgencyID() {
		return schemeAgencyID;
	}

	public String getName() {
		return Name;
	}

}
