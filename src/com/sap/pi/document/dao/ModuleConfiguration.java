package com.sap.pi.document.dao;

import java.util.List;

public class ModuleConfiguration {

	String moduleKey;

	public List<ModuleConfigurationParameters> parameters;

	public ModuleConfiguration(String moduleKey, List<ModuleConfigurationParameters> parameters) {
		this.moduleKey = moduleKey;
		this.parameters = parameters;
	}

	public List<ModuleConfigurationParameters> getParameters() {
		return parameters;
	}

	public void setParameters(List<ModuleConfigurationParameters> parameters) {
		this.parameters = parameters;
	}

	public String getModuleKey() {
		return moduleKey;
	}

	public void setModuleKey(String moduleKey) {
		this.moduleKey = moduleKey;
	}
}
