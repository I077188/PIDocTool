package com.sap.pi.document.test;

import java.util.List;

import com.sap.pi.document.dao.InboundProcessing;
import com.sap.pi.document.util.WebServiceOperation;
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

		// UtilTest utilTest = null;
		PO8test();

		WebServiceOperation webServiceOperation = new WebServiceOperationImpl();

		List<MessageHeaderID> messageHeaderIDs = webServiceOperation.getIntegratedConfigurationID();


		for (int i = 1; i < 10; i++) {
			IntegratedConfiguration integratedConfiguration = webServiceOperation
					.getIntegrationConfiguration(messageHeaderIDs.get(i));

			InboundProcessing inboundProcessing = webServiceOperation
					.getInboundProcessingInformation(integratedConfiguration);

			System.out.println(inboundProcessing.getSchemaValidation());
			System.out.println(inboundProcessing.getCommunicationChannel().getChannelID());
		}



	}

	public static void PO8test() {

		WebServiceOperation webServiceOperation = new WebServiceOperationImpl();
		MessageHeaderID messageHeaderID = new MessageHeaderID();
		messageHeaderID.setInterfaceName("SI_Srudent_OUT");
		messageHeaderID.setInterfaceNamespace("http://kelly.fistModel");
		messageHeaderID.setSenderComponentID("CC_KELLY_SOAP_SENDER");
		IntegratedConfiguration integratedConfiguration = webServiceOperation
				.getIntegrationConfiguration(messageHeaderID);

	}

	/*
	 * public static void domDomGroupTest() throws IOException,
	 * InvalidFormatException, XmlException {
	 * 
	 * int i = 3;
	 * 
	 * if (i == 1) { DocDomUtilImpl ddu = new DocDomUtilImpl(); List<Item> items
	 * = new ArrayList<Item>();
	 * 
	 * for (int j = 0; j < 3; j++) { items.add(new Item("$Main_Name",
	 * "testVersion_DomName" + j)); items.add(new Item("$Name_Value",
	 * "testVersion_Name" + j)); items.add(new Item("$Version_Value",
	 * "testVersion_Version" + j)); items.add(new Item("$NameSpace_Value",
	 * "testVersion_NameSpace" + j));
	 * 
	 * ddu.generateDomFile(CONSTAINTS.DOM_SOFTWARECOMPONENT, items); } for (int
	 * j = 0; j < 3; j++) { items.add(new Item("$Main_Name",
	 * "testVersion_DomName" + j)); items.add(new Item("$Name_Value",
	 * "testVersion_Name" + j)); items.add(new Item("$Version_Value",
	 * "testVersion_Version" + j));
	 * 
	 * ddu.generateDomFile(CONSTAINTS.DOM_SERVICEINTERFACE, items); } } else if
	 * (i == 2) { DocDomGroupUtilImpl ddgu = new DocDomGroupUtilImpl();
	 * List<Item> items = new ArrayList<Item>(); items.add(new
	 * Item("$Main_Name", "testVersion_DomGroupName"));
	 * ddgu.generateDomGroupFile(CONSTAINTS.DOMGROUP_SOFTWARECOMPONENT, items);
	 * ddgu.generateDomGroupFile(CONSTAINTS.DOMGROUP_SERVICEINTERFACE, items); }
	 * else if (i == 3) { DocUtilImp du = new DocUtilImp(); List<Item> items =
	 * new ArrayList<Item>(); items.add(new Item("$ICO_Value",
	 * "ICOTestVersion_Name"));
	 * 
	 * du.generateDocFile(CONSTAINTS.DOCUMENT, items); }
	 * 
	 * System.out.println("Test is over"); }
	 */

}
