package com.sap.pi.document.util;

import java.util.List;

import com.sap.pi.document.dao.Sender;
import com.sap.xi.basis.MessageHeaderID;

public interface WebServiceOperation {

	public List<MessageHeaderID> getIntegratedConfigurationID();

	public Sender getSenderInformation(MessageHeaderID headerID);

}
