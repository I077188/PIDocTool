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

		// generate domGroup file of sender
		SenderDocDomGroupUtil senderDocDomGroupUtil = new SenderDocDomGroupUtil();
		senderDocDomGroupUtil.generateSenderDomGroupFile(integratedConfiguration);

		// generate domGroup file of virtual receiver

		// generate domGroup file of logging

		// generate domGroup file of staging

		// generate domGroup file of Inbound Processing
		InboundProcessingDocDomUtil inboundProcessingDocDomUtil = new InboundProcessingDocDomUtil();
		inboundProcessingDocDomUtil.generateInboundProcessingDomGroupFile(integratedConfiguration);

		// generate domGroup file of Receiver Determination
		ReceiverDeterminationDocDomUtil receiverDeterminationDocDomUtil = new ReceiverDeterminationDocDomUtil();
		receiverDeterminationDocDomUtil.generateRDDomGroupFile(integratedConfiguration);

		// generate domGroup file of Outbound Processing
		OutboundProcessingDocDomUtil outboundProcessingDocDomUtil = new OutboundProcessingDocDomUtil();
		outboundProcessingDocDomUtil.generateOutboundProcessingDomGroupFile(integratedConfiguration);

		List<Item> items = new ArrayList<>();
		docUtilImp.generateDocFile(CONSTAINTS.DOCUMENT, items);

	}

}
