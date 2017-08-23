package com.sap.pi.document.dao;

import com.sap.xi.basis.ModuleTypeCode;

public class ProcessSequence {

	Integer number;
	String moduleName;
	ModuleTypeCode type;
	String moduleKey;

	public ProcessSequence(Integer number, String moduleName, ModuleTypeCode type, String moduleKey) {
		super();
		this.number = number;
		this.moduleName = moduleName;
		this.type = type;
		this.moduleKey = moduleKey;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public ModuleTypeCode getType() {
		return type;
	}

	public void setType(ModuleTypeCode type) {
		this.type = type;
	}

	public String getModuleKey() {
		return moduleKey;
	}

	public void setModuleKey(String moduleKey) {
		this.moduleKey = moduleKey;
	}

}
