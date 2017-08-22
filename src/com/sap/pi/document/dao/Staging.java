package com.sap.pi.document.dao;

public class Staging {

	String useGlobalSetting;
	String scenarioSpecificConfiguration;

	public Staging(String stagingUseGlobalSetting, String stagingScenarioSpecificConfiguration) {
		this.useGlobalSetting = stagingUseGlobalSetting;
		this.scenarioSpecificConfiguration = stagingScenarioSpecificConfiguration;

	}

	public String getStagingUseGlobalSetting() {
		return useGlobalSetting;
	}

	public void setStagingUseGlobalSetting(String stagingUseGlobalSetting) {
		this.useGlobalSetting = stagingUseGlobalSetting;
	}

	public String getStagingScenarioSpecificConfiguration() {
		return scenarioSpecificConfiguration;
	}

	public void setStagingScenarioSpecificConfiguration(String stagingScenarioSpecificConfiguration) {
		this.scenarioSpecificConfiguration = stagingScenarioSpecificConfiguration;
	}

}
