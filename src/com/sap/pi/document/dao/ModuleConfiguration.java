package com.sap.pi.document.dao;

public class ModuleConfiguration {

	String moduleKey;
	String parameterName;
	String parameterValue;

	public ModuleConfiguration(String moduleKey, String parameterName, String parameterValue) {
		super();
		this.moduleKey = moduleKey;
		this.parameterName = parameterName;
		this.parameterValue = parameterValue;
	}

	public String getModuleKey() {
		return moduleKey;
	}

	public void setModuleKey(String moduleKey) {
		this.moduleKey = moduleKey;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterValue() {
		return parameterValue;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}

}
