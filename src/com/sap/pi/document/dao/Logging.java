package com.sap.pi.document.dao;

public class Logging {

	Boolean userGlobalSetting;
	Boolean scenarioSpecificConfiguration;

	public Logging(Boolean stagingUseGlobalSetting, Boolean stagingScenarioSpecificConfiguration) {
		this.userGlobalSetting = stagingUseGlobalSetting;
		this.scenarioSpecificConfiguration = stagingScenarioSpecificConfiguration;

	}

	public Boolean getStagingUseGlobalSetting() {
		return userGlobalSetting;
	}

	public void setStagingUseGlobalSetting(Boolean stagingUseGlobalSetting) {
		this.userGlobalSetting = stagingUseGlobalSetting;
	}

	public Boolean getStagingScenarioSpecificConfiguration() {
		return scenarioSpecificConfiguration;
	}

	public void setStagingScenarioSpecificConfiguration(Boolean stagingScenarioSpecificConfiguration) {
		this.scenarioSpecificConfiguration = stagingScenarioSpecificConfiguration;
	}

}
