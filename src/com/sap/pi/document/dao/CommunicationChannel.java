package com.sap.pi.document.dao;


public class CommunicationChannel {

	String Party;
	String ComponentID;
	String ChannelID;
	String Description;
	Parameters Parameters;
	Identifiers identifiers;
	Module module;

	public CommunicationChannel(String party, String componentID, String channelID, String description,
			com.sap.pi.document.dao.Parameters parameters, Identifiers identifiers, Module module) {

		Party = party;
		ComponentID = componentID;
		ChannelID = channelID;
		Description = description;
		Parameters = parameters;
		this.identifiers = identifiers;
		this.module = module;
	}

	public String getParty() {
		return Party;
	}

	public void setParty(String party) {
		Party = party;
	}

	public String getComponentID() {
		return ComponentID;
	}

	public void setComponentID(String componentID) {
		ComponentID = componentID;
	}

	public String getChannelID() {
		return ChannelID;
	}

	public void setChannelID(String channelID) {
		ChannelID = channelID;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Parameters getParameters() {
		return Parameters;
	}

	public void setParameters(Parameters parameters) {
		Parameters = parameters;
	}

	public Identifiers getIdentifiers() {
		return identifiers;
	}

	public void setIdentifiers(Identifiers identifiers) {
		this.identifiers = identifiers;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

}
