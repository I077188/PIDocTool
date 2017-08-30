package com.sap.pi.document.dao.util.impl;

import com.sap.xi.basis.IntegratedConfiguration;

public class ReceiverDeterminationDocDomUtil {

	public void generateRDDomFile(IntegratedConfiguration integratedConfiguration) {

		// generate Receiver Rule Part
		RRDocDomUtil rrDocDomUtil = new RRDocDomUtil();
		rrDocDomUtil.generateRRDomFile(integratedConfiguration);

		// generate external Receiver Rule Part


		// generate dynamic Receiver Rule Part
		DRRDocDomUtil drrDocDomUtil = new DRRDocDomUtil();
		drrDocDomUtil.generateDRRDomFile(integratedConfiguration);
	}

}
