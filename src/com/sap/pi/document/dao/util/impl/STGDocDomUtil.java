package com.sap.pi.document.dao.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.Item;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.DocDomUtilImpl;
import com.sap.pi.document.util.impl.OtherUtil;
import com.sap.xi.basis.AdvancedSettings;
import com.sap.xi.basis.IntegratedConfiguration;

// External receiver rule
public class STGDocDomUtil {

	DocDomUtilImpl domUtil = new DocDomUtilImpl();
	DocDomGroupUtilImpl domGroupUtil = new DocDomGroupUtilImpl();

	// generate Dom file
	public void generateERRDomGroupFile(IntegratedConfiguration integratedConfiguration) {

		// get informations from the integrated configuration
		AdvancedSettings staging = integratedConfiguration.getStaging();

		if (staging != null) {

			String specificConfig = OtherUtil.getValue(staging.getSpecificConfiguration());
			Boolean isUseGlobal = staging.isUseGlobal();
			String useGlobal = null;
			if(isUseGlobal) {
				useGlobal = "TRUE";
			}else {
				useGlobal = "FALSE";
			}

			// generate staging dom group, erite back to ICO
			List<Item> stagDomGroupItems = new ArrayList<>();
			stagDomGroupItems.add(new Item("$Main_Name", "staging"));
			stagDomGroupItems.add(new Item("$IsGlobalSetting_Value", useGlobal));
			stagDomGroupItems.add(new Item("$SpecificConfiguration_Value", specificConfig));

			domGroupUtil.generateDomGroupFile(CONSTAINTS.DOMGROUP_STAG, stagDomGroupItems, "ICO", false);

		}
	}



}
