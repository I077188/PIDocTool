package com.sap.pi.document.dao;

public class SoftwareComponent {

	public SoftwareComponent(String name, String version, String nameSpace) {
		this.name = name;
		this.version = version;
		this.nameSpace = nameSpace;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getNameSpace() {
		return nameSpace;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	String name;
	String version;
	String nameSpace;

}
