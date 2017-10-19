package com.sap.pi.document.model;

import java.util.List;

public class Module {

	List<ProcessSequence> processSequence;
	List<ModuleConfiguration> moduleConfigurations;

	public Module(List<ProcessSequence> processSequence, List<ModuleConfiguration> moduleConfigurations) {
		this.processSequence = processSequence;
		this.moduleConfigurations = moduleConfigurations;
	}

	public List<ProcessSequence> getProcessSequence() {
		return processSequence;
	}

	public void setProcessSequence(List<ProcessSequence> processSequence) {
		this.processSequence = processSequence;
	}

	public List<ModuleConfiguration> getModuleConfigurations() {
		return moduleConfigurations;
	}

	public void setModuleConfigurations(List<ModuleConfiguration> moduleConfigurations) {
		this.moduleConfigurations = moduleConfigurations;
	}

}
