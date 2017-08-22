package com.sap.pi.document.dao;

public class Logging {

	Boolean userGlobalSetting;
	String scenarioSpecificConfiguration;

	public Logging(Boolean stagingUseGlobalSetting, String stagingScenarioSpecificConfiguration) {
		this.userGlobalSetting = stagingUseGlobalSetting;
		this.scenarioSpecificConfiguration = stagingScenarioSpecificConfiguration;

	}

	public Boolean getStagingUseGlobalSetting() {
		return userGlobalSetting;
	}

	public void setStagingUseGlobalSetting(Boolean stagingUseGlobalSetting) {
		this.userGlobalSetting = stagingUseGlobalSetting;
	}

	public String getStagingScenarioSpecificConfiguration() {
		return scenarioSpecificConfiguration;
	}

	public void setStagingScenarioSpecificConfiguration(String stagingScenarioSpecificConfiguration) {
		this.scenarioSpecificConfiguration = stagingScenarioSpecificConfiguration;
	}

}
