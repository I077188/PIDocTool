package com.sap.pi.document.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.XmlException;

import com.sap.pi.document.dao.Logging;
import com.sap.pi.document.util.WebServiceOperation;
import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.Item;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.DocDomUtilImpl;
import com.sap.pi.document.util.impl.DocUtilImp;
import com.sap.pi.document.util.impl.WebServiceOperationImpl;
import com.sap.xi.basis.IntegratedConfiguration;
import com.sap.xi.basis.MessageHeaderID;

public class UtilTest {

	public static void main(String[] args) {

		/*
		 * SWCDocDomUtil swcDocDomUtil = new SWCDocDomUtil();
		 * 
		 * swcDocDomUtil.generateSWCDomFile(CONSTAINTS.DOM_SOFTWARECOMPONENT);
		 * 
		 * swcDocDomUtil.generateSWCDomGroupFile(CONSTAINTS.DOMGROUP_SOFTWARECOMPONENT);
		 */

		WebServiceOperation webServiceOperation = new WebServiceOperationImpl();

		List<MessageHeaderID> messageHeaderIDs = webServiceOperation.getIntegratedConfigurationID();

		for (int i = 0; i < messageHeaderIDs.size(); i++) {
			IntegratedConfiguration integratedConfiguration = webServiceOperation
					.getIntegrationConfiguration(messageHeaderIDs.get(i));
			// Staging staging =
			// webServiceOperation.getStagingInfomation(integratedConfiguration);
			Logging logging = webServiceOperation.getLoggingInfomation(integratedConfiguration);
			System.out.println(logging.getStagingScenarioSpecificConfiguration());
		}

	}

	public static void domDomGroupTest() throws IOException, InvalidFormatException, XmlException {

		int i = 3;

		if (i == 1) {
			DocDomUtilImpl ddu = new DocDomUtilImpl();
			List<Item> items = new ArrayList<Item>();

			for (int j = 0; j < 3; j++) {
				items.add(new Item("$Main_Name", "testVersion_DomName" + j));
				items.add(new Item("$Name_Value", "testVersion_Name" + j));
				items.add(new Item("$Version_Value", "testVersion_Version" + j));
				items.add(new Item("$NameSpace_Value", "testVersion_NameSpace" + j));

				ddu.generateDomFile(CONSTAINTS.DOM_SOFTWARECOMPONENT, items);
			}
			for (int j = 0; j < 3; j++) {
				items.add(new Item("$Main_Name", "testVersion_DomName" + j));
				items.add(new Item("$Name_Value", "testVersion_Name" + j));
				items.add(new Item("$Version_Value", "testVersion_Version" + j));

				ddu.generateDomFile(CONSTAINTS.DOM_SERVICEINTERFACE, items);
			}
		} else if (i == 2) {
			DocDomGroupUtilImpl ddgu = new DocDomGroupUtilImpl();
			List<Item> items = new ArrayList<Item>();
			items.add(new Item("$Main_Name", "testVersion_DomGroupName"));
			ddgu.generateDomGroupFile(CONSTAINTS.DOMGROUP_SOFTWARECOMPONENT, items);
			ddgu.generateDomGroupFile(CONSTAINTS.DOMGROUP_SERVICEINTERFACE, items);
		} else if (i == 3) {
			DocUtilImp du = new DocUtilImp();
			List<Item> items = new ArrayList<Item>();
			items.add(new Item("$ICO_Value", "ICOTestVersion_Name"));

			du.generateDocFile(CONSTAINTS.DOCUMENT, items);
		}

		System.out.println("Test is over");
	}

}
