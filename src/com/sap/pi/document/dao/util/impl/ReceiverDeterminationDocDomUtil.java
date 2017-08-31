package com.sap.pi.document.dao.util.impl;

import com.sap.xi.basis.IntegratedConfiguration;

public class ReceiverDeterminationDocDomUtil {

	public void generateRDDomGroupFile(IntegratedConfiguration integratedConfiguration) {

		// generate Receiver Rule Part
		ReceiverRuleDocDomUtil rrDocDomUtil = new ReceiverRuleDocDomUtil();
		rrDocDomUtil.generateRRDomFile(integratedConfiguration);

		// generate external Receiver Rule Part


		// generate dynamic Receiver Rule Part
		DRRDocDomUtil drrDocDomUtil = new DRRDocDomUtil();
		drrDocDomUtil.generateDRRDomFile(integratedConfiguration);
	}

}
