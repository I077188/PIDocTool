package com.sap.pi.document.dao;

public class Logging {

	String userGlobalSetting;
	String scenarioSpecificConfiguration;

	public Logging(String stagingUseGlobalSetting, String stagingScenarioSpecificConfiguration) {
		this.userGlobalSetting = stagingUseGlobalSetting;
		this.scenarioSpecificConfiguration = stagingScenarioSpecificConfiguration;

	}

	public String getStagingUseGlobalSetting() {
		return userGlobalSetting;
	}

	public void setStagingUseGlobalSetting(String stagingUseGlobalSetting) {
		this.userGlobalSetting = stagingUseGlobalSetting;
	}

	public String getStagingScenarioSpecificConfiguration() {
		return scenarioSpecificConfiguration;
	}

	public void setStagingScenarioSpecificConfiguration(String stagingScenarioSpecificConfiguration) {
		this.scenarioSpecificConfiguration = stagingScenarioSpecificConfiguration;
	}

}
