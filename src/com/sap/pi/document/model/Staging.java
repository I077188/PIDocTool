package com.sap.pi.document.model;

public class Staging {

	Boolean useGlobalSetting;
	String scenarioSpecificConfiguration;

	public Staging(Boolean stagingUseGlobalSetting, String stagingScenarioSpecificConfiguration) {
		this.useGlobalSetting = stagingUseGlobalSetting;
		this.scenarioSpecificConfiguration = stagingScenarioSpecificConfiguration;

	}

	public Boolean getStagingUseGlobalSetting() {
		return useGlobalSetting;
	}

	public void setStagingUseGlobalSetting(Boolean stagingUseGlobalSetting) {
		this.useGlobalSetting = stagingUseGlobalSetting;
	}

	public String getStagingScenarioSpecificConfiguration() {
		return scenarioSpecificConfiguration;
	}

	public void setStagingScenarioSpecificConfiguration(String stagingScenarioSpecificConfiguration) {
		this.scenarioSpecificConfiguration = stagingScenarioSpecificConfiguration;
	}

}
