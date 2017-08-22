package com.sap.pi.document.util;

import java.util.List;

import com.sap.pi.document.dao.Logging;
import com.sap.pi.document.dao.Sender;
import com.sap.pi.document.dao.Staging;
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.IntegratedConfigurationIn;
import com.sap.xi.basis.MessageHeaderID;

public interface WebServiceOperation {

	public IntegratedConfigurationIn getIntegrationPort();

	public List<MessageHeaderID> getIntegratedConfigurationID(); // Get ID of all the ICO

	public IntegratedConfiguration getIntegrationConfiguration(MessageHeaderID messageHeaderID); // Get ICO by
																									// messageID

	public Sender getSenderInformation(MessageHeaderID headerID);

	public Staging getStagingInfomation(IntegratedConfiguration integratedConfiguration);

	public Logging getLoggingInfomation(IntegratedConfiguration integratedConfiguration);

}
