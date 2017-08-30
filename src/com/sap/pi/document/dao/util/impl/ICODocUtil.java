package com.sap.pi.document.dao.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.Item;
import com.sap.pi.document.util.impl.DocUtilImp;
import com.sap.xi.basis.IntegratedConfiguration;

public class ICODocUtil {

	public void generateICODoc(IntegratedConfiguration integratedConfiguration) {
		DocUtilImp docUtilImp = new DocUtilImp();

		List<Item> items = new ArrayList<>();

		docUtilImp.generateDocFile(CONSTAINTS.DOCUMENT, items);

	}

}
