package com.sap.pi.document.model;

public class AdapterType {

	String name;
	String nameSpace;
	String softwareComponent;

	public AdapterType(String name, String nameSpace, String softwarecomponent) {
		this.name = name;
		this.nameSpace = nameSpace;
		this.softwareComponent = softwarecomponent;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameSpace() {
		return this.nameSpace;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	public String getSoftwareComponent() {
		return this.softwareComponent;
	}

	public void setSoftwareComponent(String softwareComponent) {
		this.softwareComponent = softwareComponent;
	}
}
