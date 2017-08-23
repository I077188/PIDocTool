package com.sap.pi.document.dao;

import java.util.List;

public class Parameters {

	AdapterType adaperType;
	String Direction;
	String TransportProtocol;
	String MessageProtocol;
	String AdapterEngine;
	List<String> AdapterSpecific;

	public Parameters(AdapterType adaperType, String direction, String transportProtocol, String messageProtocol,
			String adapterEngine, List<String> adapterSpecific) {
		super();
		this.adaperType = adaperType;
		Direction = direction;
		TransportProtocol = transportProtocol;
		MessageProtocol = messageProtocol;
		AdapterEngine = adapterEngine;
		AdapterSpecific = adapterSpecific;
	}

	public AdapterType getAdaperType() {
		return adaperType;
	}

	public void setAdaperType(AdapterType adaperType) {
		this.adaperType = adaperType;
	}

	public String getDirection() {
		return Direction;
	}

	public void setDirection(String direction) {
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

	public List<String> getAdapterSpecific() {
		return AdapterSpecific;
	}

	public void setAdapterSpecific(List<String> adapterSpecific) {
		AdapterSpecific = adapterSpecific;
	}

}
