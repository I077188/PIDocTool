package com.sap.pi.document.util.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class CONSTAINTS {

	// initial logon part
	public static String userName;
	public static String password;
	public static String host;
	public static String port;

	public static void addNewLine(XWPFDocument document) {
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();
		run.setText("");
	}

	// initial parameters
	// must be scheduled in Main
	public static void initial() {
		try {
			FileInputStream in = new FileInputStream(
					CONSTAINTS.resourcePath + File.separator + "config" + File.separator + "Configuration.properties");
			Properties prop = new Properties();
			prop.load(in);
			host = prop.getProperty("host");
			port = prop.getProperty("port");
			userName = prop.getProperty("user");
			password = prop.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
			CONSTAINTS.LOG.error(e.getMessage());
		}
	}

	// resource part
	public static Logger LOG = LogManager.getLogger("CONSTAINTS.class");
	public static String logFolderPath = System.getProperty("user.dir") + File.separator + "log" + File.separator;
	public static String logFilePath = logFolderPath + "Execution.log";

	public static String resourcePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator;

	// result part
	public static String resultPath = resourcePath + "documents" + File.separator;

	// tempt part
	public static String temptPath = resourcePath + "temptFiles" + File.separator;

	public static String temptDomPath = temptPath + "dom" + File.separator;
	public static String temptDomGroupPath = temptPath + "domGroup" + File.separator;

	// template part
	public static String templatePath = resourcePath + "template" + File.separator;

	public static String templateDomPath = templatePath + "dom" + File.separator;
	public static String templateDomGroupPath = templatePath + "domGroup" + File.separator;
	public static String templateDocument = templatePath + "document" + File.separator;

	// document
	public static File DOCUMENT = new File(templateDocument + "PIDOC.docx");

	// SENDER
	public static File DOMGROUP_SENDER_ADDITIONALIDENTIFIER = new File(templateDomGroupPath + "Sender" + File.separator + "ADDITIONALIDENTIFIER.docx");
	public static File DOMGROUP_SENDER_COMMUNICATIONPARTY = new File(
			templateDomGroupPath + "Sender" + File.separator + "COMMUNICATIONPARTY.docx");
	public static File DOMGROUP_SENDER = new File(templateDomGroupPath + "Sender" + File.separator + "0_SENDER.docx");

	// LOGGINE
	public static File DOMGROUP_LOG = new File(templateDomGroupPath + "Logging" + File.separator + "1_LOGGING.docx");

	// STAGING
	public static File DOMGROUP_STAG = new File(templateDomGroupPath + "Staging" + File.separator + "2_STAGING.docx");

	// INBOUND PROCESSING
	static String inboundPath = templateDomGroupPath + File.separator + "InboundProcessing" + File.separator;

	// INBOUND PROCESSING - communication channel
	public static File DOMGROUP_IBLONGDESCRIPTION = new File(inboundPath + "communicationChannel" + File.separator + "0_LONGDESCRIPTION.docx");
	public static File DOMGROUP_IBPARAMTER = new File(inboundPath + "communicationChannel" + File.separator + "1_PARAMETER.docx");
	public static File DOMGROUP_IBIDENTIFIER = new File(inboundPath + "communicationChannel" + File.separator + "2_IDENTIFIER.docx");
	public static File DOMGROUP_IBMODULE = new File(inboundPath + "communicationChannel" + File.separator + "3_MODULE.docx");
	public static File DOMGROUP_IBMODULECONFIGURATION = new File(inboundPath + "communicationChannel" + File.separator + "4_MODULECONFIGURATION.docx");
	public static File DOMGROUP_IBMODULEPROCESSSEQUENCE = new File(inboundPath + "communicationChannel" + File.separator + "5_MODULEPROCESSSEQUENCE.docx");

	public static File DOMGROUP_IBCOMMUNICATIONCHANNEL = new File(inboundPath + "communicationChannel" + File.separator + "0_COMMUNICATIONCHANNEL.docx");

	public static File DOMGROUP_IBADAPTERSPECIFICATTRIBUTE = new File(inboundPath + "ADAPTERSPECIFICATTRIBUTE.docx");
	public static File DOMGROUP_INBOUNDPROCESSING = new File(inboundPath + "3_INBOUNDPROCESSING.docx");

	// OUTBOUND PROCESSING
	static String outboundPath = templateDomGroupPath + File.separator + "OutboundProcessing" + File.separator;

	// OUTBOUND PROCESSING - communication channel
	public static File DOMGROUP_OBLONGDESCRIPTION = new File(outboundPath + "communicationChannel" + File.separator + "0_LONGDESCRIPTION.docx");
	public static File DOMGROUP_OBPARAMTER = new File(outboundPath + "communicationChannel" + File.separator + "1_PARAMETER.docx");
	public static File DOMGROUP_OBIDENTIFIER = new File(outboundPath + "communicationChannel" + File.separator + "2_IDENTIFIER.docx");
	public static File DOMGROUP_OBMODULE = new File(outboundPath + "communicationChannel" + File.separator + "3_MODULE.docx");
	public static File DOMGROUP_OBMODULECONFIGURATION = new File(outboundPath + "communicationChannel" + File.separator + "4_MODULECONFIGURATION.docx");
	public static File DOMGROUP_OBMODULEPROCESSSEQUENCE = new File(outboundPath + "communicationChannel" + File.separator + "5_MODULEPROCESSSEQUENCE.docx");

	public static File DOMGROUP_OBCOMMUNICATIONCHANNEL = new File(outboundPath + "communicationChannel" + File.separator + "0_COMMUNICATIONCHANNEL.docx");

	public static File DOMGROUP_OBADAPTERSPECIFICATTRIBUTE = new File(outboundPath + "ADAPTERSPECIFICATTRIBUTE.docx");

	public static File DOMGROUP_OBHEADERMAPPING = new File(outboundPath + "1_HEADERMAPPING.docx");
	public static File DOMGROUP_OUTBOUNDPROCESSING = new File(outboundPath + "OUTBOUNDPROCESSING.docx");
	public static File DOMGROUP_OUTBOUNDPROCESSINGS = new File(outboundPath + "5_OUTBOUNDPROCESSINGS.docx");

	// public part
	public static File DOM_MODULEPROCESSSEQUENCE = new File(templateDomPath + "MODULEPROCESSSEQUENCE.docx");
	public static File DOM_MODULECONFIGURATION = new File(templateDomPath + "MODULECONFIGURATION.docx");

	// RECEIVER DETERMINATION
	static String receiverDeterminationPath = templateDomGroupPath + File.separator + "ReceiverDetermination" + File.separator;
	// RECEIVER DETERMINATION - Receiver Rule
	public static File DOMGROUP_RR_RECEIVER = new File(receiverDeterminationPath + "receiverRule" + File.separator + "RECEIVER.docx");
	public static File DOMGROUP_RR_RECEIVERS = new File(receiverDeterminationPath + "receiverRule" + File.separator+ "1_RECEIVERS.docx");

	public static File DOMGROUP_RR_RECEIVERRULE = new File(receiverDeterminationPath + "receiverRule" + File.separator  + "0_RECEIVERRULE.docx");
	public static File DOMGROUP_RR_RECEIVERRULES = new File(receiverDeterminationPath + "receiverRule" + File.separator  + "RECEIVERRULES.docx");

	// RECEIVER DETERMINATION - Receiver Rule - ReceiverInterface Rule
	static String RR_receiverInterfacePath = receiverDeterminationPath + "receiverRule" + File.separator
			+ "ReceiverInterface" + File.separator;
	// RECEIVER DETERMINATION - Receiver Rule - ReceiverInterface Rule - operation mapping
	public static File DOMGROUP_RR_RIROMP_INTEGER = new File(RR_receiverInterfacePath + "0_RIROMPINTEGER.docx");
	public static File DOMGROUP_RR_RIROMP_STRING = new File(RR_receiverInterfacePath + "1_RIROMPSTRING.docx");
	public static File DOMGROUP_RR_RIROMP_CHANEL = new File(RR_receiverInterfacePath + "2_RIROMPCHANEL.docx");

	public static File DOMGROUP_RR_RIROM = new File(RR_receiverInterfacePath + "1_RIROM.docx");
	public static File DOMGROUP_RR_RIROMP = new File(RR_receiverInterfacePath + "2_RIROMP.docx");

	public static File DOMGROUP_RR_RECEIVERINTERFACE = new File(RR_receiverInterfacePath + "0_RECEIVERINTERFACE.docx");
	public static File DOMGROUP_RR_RIR = new File(RR_receiverInterfacePath + "RIR.docx");
	public static File DOMGROUP_RR_INTERFACEDETERMINATION = new File(RR_receiverInterfacePath + "2_INTERFACEDETERMINATION.docx");

	// RECEIVER DETERMINATION - EXTReceiverRule
	static String ER_receiverPath = receiverDeterminationPath + "extendedReceiverRule" + File.separator;
	public static File DOM_EXTEXTRACTOR = new File(ER_receiverPath + "EXTEXTRACTOR.docx");
	public static File DOMGROUP_EXTEXTRACTOR = new File(ER_receiverPath + "EXTEXTRACTOR.docx");
	public static File DOMGROUP_EXTEXTRACTORS = new File(ER_receiverPath + "EXTEXTRACTORS.docx");
	public static File DOMGROUP_EXTCOMMUNICATIONPARTY = new File(ER_receiverPath + "EXTCOMMUNICATIONPARTY.docx");
	public static File DOMGROUP_EXTCOMMUNICATIONPARTYS = new File(ER_receiverPath + "EXTCOMMUNICATIONPARTYS.docx");

	public static File DOMGROUP_EXTRECEIVERRULEUNIT = new File(ER_receiverPath + "EXTRECEIVERRULEUNIT.docx");
	public static File DOMGROUP_EXTRECEIVERRULEUNITS = new File(ER_receiverPath + "EXTRECEIVERRULEUNITS.docx");

	public static File DOM_EXTRECEIVERINTERFACERULE = new File(ER_receiverPath + "EXTRECEIVERINTERFACERULE.docx");
	public static File DOMGROUP_EXTRECEIVERINTERFACERULE = new File(ER_receiverPath + "EXTRECEIVERINTERFACERULE.docx");
	public static File DOMGROUP_EXTRECEIVERINTERFACE = new File(ER_receiverPath + "EXTRECEIVERINTERFACE.docx");

	public static File DOMGROUP_EXTRECEIVERRULE = new File(ER_receiverPath + "EXTRECEIVERRULE.docx");
	public static File DOMGROUP_EXTRECEIVER = new File(ER_receiverPath + "EXTRECEIVER.docx");
	public static File DOMGROUP_EXTRECEIVERRULEPARTY = new File(ER_receiverPath + "EXTRECEIVERRULEPARTY.docx");
	public static File DOMGROUP_EXTATOCONDITIONSTRING = new File(ER_receiverPath + "0_EXTATOCONDITIONSTRING.docx");

	public static File DOMGROUP_RECEIVERDETERMINATION = new File(receiverDeterminationPath + "4_RECEIVERDETERMINATION.docx");

	// old - please keep still before all functions are working
	// remove
	public static File DOMGROUP_RECEIVERRULE = new File(receiverDeterminationPath + "0_RECEIVERRULE.docx");

	// ServiceInterface
	public static File DOM_SERVICEINTERFACE = new File(templateDomPath + "SI.docx");
	public static File DOMGROUP_SERVICEINTERFACE = new File(templateDomGroupPath + "SI.docx");

	// SoftwareComponentVersion
	public static File DOM_SOFTWARECOMPONENT = new File(templateDomPath + "SWC.docx");
	public static File DOMGROUP_SOFTWARECOMPONENT = new File(templateDomGroupPath + "SWC.docx");

	// Dynamic Receiver Rule - operation mapping parameter channel
	public static File DOM_OMP_INTEGER = new File(templateDomPath + "OMPINTEGER.docx");
	public static File DOMGROUP_OMP_INTEGER = new File(templateDomGroupPath + "0_OMPINTEGER.docx");

	public static File DOM_OMP_STRING = new File(templateDomPath + "OMPSTRING.docx");
	public static File DOMGROUP_OMP_STRING = new File(templateDomGroupPath + "1_OMPSTRING.docx");

	public static File DOM_OMP_CHANEL = new File(templateDomPath + "OMPCHANEL.docx");
	public static File DOMGROUP_OMP_CHANEL = new File(templateDomGroupPath + "2_OMPCHANEL.docx");


	public static File DOMGROUP_OMP = new File(templateDomGroupPath + "2_OMP.docx");
	public static File DOM_OMP = new File(templateDomPath + "OMP.docx");

	public static File DOMGROUP_OM = new File(templateDomGroupPath + "1_OM.docx");
	public static File DOM_OM = new File(templateDomPath + "OM.docx");

	public static File DOMGROUP_DRR = new File(templateDomGroupPath + "DRR.docx");

	public static File DOM_ADDITIONALIDENTIFIER = new File(templateDomPath + "ADDITIONALIDENTIFIER.docx");
	public static File DOMGROUP_ADDITIONALIDENTIFIER = new File(templateDomGroupPath + "ADDITIONALIDENTIFIER.docx");

	public static File DOMGROUP_COMMUNICATIONPARTY = new File(templateDomGroupPath + "COMMUNICATIONPARTY.docx");

	public static File DOM_ATOCONDITION = new File(templateDomPath + "ATOCONDITION.docx");
	public static File DOMGROUP_ATOCONDITION = new File(templateDomGroupPath + "0_ATOCONDITION.docx");



	public static File DOM_RECEIVER = new File(templateDomPath + "RECEIVER.docx");
	public static File DOMGROUP_RECEIVER = new File(templateDomGroupPath + "RECEIVER.docx");
	public static File DOMGROUP_RECEIVERS = new File(templateDomGroupPath + "1_RECEIVERS.docx");

	public static File DOMGROUP_RECEIVERRULES = new File(templateDomGroupPath + "RECEIVERRULES.docx");

}
