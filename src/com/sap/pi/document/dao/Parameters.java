package com.sap.pi.document.dao;

import java.util.List;

import com.sap.xi.basis.CommunicationChannelDirection;
import com.sap.xi.basis.GenericProperty;

public class Parameters {

	AdapterType adapterType;
	CommunicationChannelDirection Direction;
	String TransportProtocol;
	String MessageProtocol;
	String AdapterEngine;
	List<GenericProperty> AdapterSpecific;

	public Parameters(AdapterType adaperType, CommunicationChannelDirection direction, String transportProtocol,
			String messageProtocol,
			String adapterEngine, List<GenericProperty> adapterSpecific) {
		super();
		this.adapterType = adaperType;
		Direction = direction;
		TransportProtocol = transportProtocol;
		MessageProtocol = messageProtocol;
		AdapterEngine = adapterEngine;
		AdapterSpecific = adapterSpecific;
	}

	public AdapterType getAdaperType() {
		return adapterType;
	}

	public void setAdaperType(AdapterType adaperType) {
		this.adapterType = adaperType;
	}

	public CommunicationChannelDirection getDirection() {
		return Direction;
	}

	public void setDirection(CommunicationChannelDirection direction) {
		Direction = direction;
	}

	public String getTransportProtocol() {
		return TransportProtocol;
	}

	public void setTransportProtocol(String transportProtocol) {
		TransportProtocol = transportProtocol;
	}

	public String getMessageProtocol() {
		return MessageProtocol;
	}

	public void setMessageProtocol(String messageProtocol) {
		MessageProtocol = messageProtocol;
	}

	public String getAdapterEngine() {
		return AdapterEngine;
	}

	public void setAdapterEngine(String adapterEngine) {
		AdapterEngine = adapterEngine;
	}

	public List<GenericProperty> getAdapterSpecific() {
		return AdapterSpecific;
	}

	public void setAdapterSpecific(List<GenericProperty> adapterSpecific) {
		AdapterSpecific = adapterSpecific;
	}

}
