package com.sap.pi.document.dao;


public class ModuleConfigurationParameters {

	String parameterName;
	String parameterValue;

	public ModuleConfigurationParameters(String parameterName, String parameterValue) {
		super();
		this.parameterName = parameterName;
		this.parameterValue = parameterValue;
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
