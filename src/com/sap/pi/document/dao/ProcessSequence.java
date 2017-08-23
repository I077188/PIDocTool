package com.sap.pi.document.dao;

public class ProcessSequence {

	String number;
	String moduleName;
	String type;
	String moduleKey;

	public ProcessSequence(String number, String moduleName, String type, String moduleKey) {
		super();
		this.number = number;
		this.moduleName = moduleName;
		this.type = type;
		this.moduleKey = moduleKey;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModuleKey() {
		return moduleKey;
	}

	public void setModuleKey(String moduleKey) {
		this.moduleKey = moduleKey;
	}

}
