package com.sap.pi.document.dao.util.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.dao.SoftwareComponent;
import com.sap.pi.document.util.DocDomGroupUtil;
import com.sap.pi.document.util.DocDomUtil;
import com.sap.pi.document.util.dao.Item;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.DocDomUtilImpl;
import com.sap.pi.document.util.impl.EasyQueryOperationImpl;

public class SWCDocDomUtil {

	EasyQueryOperationImpl getInfo = new EasyQueryOperationImpl();
	DocDomUtil domUtil = new DocDomUtilImpl();
	DocDomGroupUtil domGroupUtil = new DocDomGroupUtilImpl();

	public void generateSWCDomFile(File templateFile) {
		
		List<SoftwareComponent> swcs = getInfo.getSCWInfo();

		System.out.println("Start generate dom file...");
		for (SoftwareComponent swc : swcs) {

			List<Item> items = new ArrayList<>();

			items.add(new Item("$Main_Name", swc.getName()));
			items.add(new Item("$DomName_Value", swc.getName()));
			items.add(new Item("$Name_Value", swc.getName()));
			items.add(new Item("$Version_Value", swc.getVersion()));
			items.add(new Item("$NameSpace_Value", swc.getNameSpace()));

			// generate dom related files
			domUtil.generateDomFile(templateFile, items, swc.getVersion(), swc.getNameSpace());

		}
		System.out.println("Finished!");
	}

	public void generateSWCDomGroupFile(File templateFile) {
		System.out.println("Start generate dom group file...");
		List<Item> items = new ArrayList<>();
		domGroupUtil.generateDomGroupFile(templateFile, items);
		System.out.println("Finished!");
	}

}
