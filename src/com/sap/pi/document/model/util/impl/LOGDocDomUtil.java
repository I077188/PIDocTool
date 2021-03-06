package com.sap.pi.document.model.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.DocDomUtilImpl;
import com.sap.pi.document.util.impl.OtherUtil;
import com.sap.pi.document.util.model.CONSTAINTS;
import com.sap.pi.document.util.model.Item;
import com.sap.xi.basis.AdvancedSettings;
import com.sap.xi.basis.IntegratedConfiguration;

// External receiver rule
public class LOGDocDomUtil {

	DocDomUtilImpl domUtil = new DocDomUtilImpl();
	DocDomGroupUtilImpl domGroupUtil = new DocDomGroupUtilImpl();

	// generate Dom file
	public void generateLOGDomGroupFile(IntegratedConfiguration integratedConfiguration) {
		CONSTAINTS.LOG.info("Start to create LOGGING related tempt document...");

		// get informations from the integrated configuration
		AdvancedSettings logging = integratedConfiguration.getLogging();

		if (logging != null) {

			String specificConfig = OtherUtil.getValue(logging.getSpecificConfiguration());
			Boolean isUseGlobal = logging.isUseGlobal();
			String useGlobal = null;
			if(isUseGlobal) {
				useGlobal = "TRUE";
			}else {
				useGlobal = "FALSE";
			}

			// generate staging dom group, erite back to ICO
			List<Item> stagDomGroupItems = new ArrayList<>();
			stagDomGroupItems.add(new Item("$Main_Name", "LOGGING"));
			stagDomGroupItems.add(new Item("$IsGlobalSetting_Value", useGlobal));
			stagDomGroupItems.add(new Item("$SpecificConfiguration_Value", specificConfig));

			CONSTAINTS.LOG.info("Generate Logging domGroup start");
			domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_LOG, stagDomGroupItems, "ICO", false);
			CONSTAINTS.LOG.info("Generate Logging domGroup end");

		}
		CONSTAINTS.LOG.info("LOGGING related tempt document had been created.");
	}
}
