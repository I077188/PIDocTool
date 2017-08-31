package com.sap.pi.document.util.dao;

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

	public static Logger LOG = LogManager.getLogger("CONSTAINTS.class");
	public static String logFolderPath = System.getProperty("user.dir") + File.separator + "log" + File.separator;
	public static String logFilePath = logFolderPath + "Execution.log";

	public static String resourcePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator;

	public static String resultPath = resourcePath + "documents" + File.separator;

	// template part
	public static String templatePath = resourcePath + "template" + File.separator;

	public static String templateDomPath = templatePath + "dom" + File.separator;
	public static String templateDomGroupPath = templatePath + "domGroup" + File.separator;
	public static String templateDocument = templatePath + "document" + File.separator;

	// document
	public static File DOCUMENT = new File(templateDocument + "PIDOC.docx");

	// ServiceInterface
	public static File DOM_SERVICEINTERFACE = new File(templateDomPath + "SI.docx");
	public static File DOMGROUP_SERVICEINTERFACE = new File(templateDomGroupPath + "SI.docx");

	// SoftwareComponentVersion
	public static File DOM_SOFTWARECOMPONENT = new File(templateDomPath + "SWC.docx");
	public static File DOMGROUP_SOFTWARECOMPONENT = new File(templateDomGroupPath + "SWC.docx");

	// Dynamic Receiver Rule - operation mapping parameter channel
	public static File DOM_OMP_INTEGER = new File(templateDomPath + "OMPINTEGER.docx");
	public static File DOMGROUP_OMP_INTEGER = new File(templateDomGroupPath + "OMPINTEGER.docx");

	public static File DOM_OMP_STRING = new File(templateDomPath + "OMPSTRING.docx");
	public static File DOMGROUP_OMP_STRING = new File(templateDomGroupPath + "OMPSTRING.docx");

	public static File DOM_OMP_CHANEL = new File(templateDomPath + "OMPCHANEL.docx");
	public static File DOMGROUP_OMP_CHANEL = new File(templateDomGroupPath + "OMPCHANEL.docx");

	public static File DOMGROUP_OMP = new File(templateDomGroupPath + "OMP.docx");
	public static File DOM_OMP = new File(templateDomPath + "OMP.docx");

	public static File DOMGROUP_OM = new File(templateDomGroupPath + "OM.docx");
	public static File DOM_OM = new File(templateDomPath + "OM.docx");

	public static File DOMGROUP_DRR = new File(templateDomGroupPath + "DRR.docx");

	// sender
	public static File DOMGROUP_SENDER = new File(templateDomGroupPath + "SENDER.docx");

	public static File DOM_ADDITIONALIDENTIFIER = new File(templateDomPath + "ADDITIONALIDENTIFIER.docx");
	public static File DOMGROUP_ADDITIONALIDENTIFIER = new File(templateDomGroupPath + "ADDITIONALIDENTIFIER.docx");

	public static File DOMGROUP_COMMUNICATIONPARTY = new File(templateDomGroupPath + "COMMUNICATIONPARTY.docx");

	public static File DOMGROUP_RR = new File(templateDomGroupPath + "RR.docx");

	public static File DOM_ATO_CONDITION = new File(templateDomPath + "ATOCONDITION.docx");
	public static File DOMGROUP_ATO_CONDITION_BLOCK = new File(templateDomGroupPath + "ATOCONDITIONBLOCK.docx");

	public static File DOM_RECEIVER = new File(templateDomPath + "RECEIVER.docx");
	public static File DOMGROUP_RECEIVER = new File(templateDomGroupPath + "RECEIVER.docx");
	public static File DOMGROUP_RECEIVERRULE = new File(templateDomGroupPath + "RECEIVERRULE.docx");
	public static File DOMGROUP_RECEIVERINTERFACE = new File(templateDomGroupPath + "RECEIVERINTERFACE.docx");
	public static File DOMGROUP_RIR = new File(templateDomGroupPath + "RIR.docx");
	public static File DOMGROUP_INTERFACEDETERMINATION = new File(templateDomGroupPath + "INTERFACEDETERMINATION.docx");

	public static File DOMGROUP_INBOUNDPROCESSING = new File(templateDomGroupPath + "INBOUNDPROCESSING.docx");
	public static File DOMGROUP_OUTBOUNDPROCESSING = new File(templateDomGroupPath + "OUTBOUNDPROCESSING.docx");

	// communication channel
	public static File DOMGROUP_LONGDESCRIPTION = new File(templateDomGroupPath + "LONGDESCRIPTION.docx");
	public static File DOMGROUP_PARAMTER = new File(templateDomGroupPath + "LONGDESCRIPTION.docx");
	public static File DOMGROUP_IDENTIFIER = new File(templateDomGroupPath + "IDENTIFIER.docx");

	// External Receiver Rule - operation mapping parameter channel
	public static File DOM_ERR = new File(templateDomPath + "ERR.docx");
	public static File DOMGROUP__ERR = new File(templateDomPath + "ERR.docx");
	public static File DOM_ERR_RULR = new File(templateDomPath + "ERRRULE.docx");
	public static File DOMGROUP__ERR_RULE = new File(templateDomPath + "ERRRULE.docx");
	// External Receiver Rule
	public static File DOMGROUP_ERR_CONDITION = new File(templateDomGroupPath + "ERRRULECONDITION.docx");
	public static File DOM_ERR_RULR_RECEIVER = new File(templateDomPath + "ERRRULERECEIVER.docx");
	public static File DOMGROUP_ERR_RULR_RECEIVER = new File(templateDomGroupPath + "ERRRULERECEIVER.docx");
	public static File DOMGROUP_ERR_RULE_PARTSUNIT = new File(templateDomGroupPath + "ERRRULEUNIT.docx");
	public static File DOMGROUP_ERR_RULEPARTS = new File(templateDomGroupPath + "ERRRULE.docx");
	public static File DOMGROUP_ERR_RECEIVERRULE = new File(templateDomGroupPath + "ERRRECEIVERRULE.docx");
	public static File DOMGROUP_ERR_RULEID = new File(templateDomGroupPath + "ERRRULEID.docx");
	public static File DOMGROUP_ERR = new File(templateDomGroupPath + "ERR.docx");

	public static File DOM_MODULECONFIG = new File(templateDomPath + "MODULECONFIG.docx");
	public static File DOM_MODULEPROCESSSEQUENCE = new File(templateDomPath + "MODULEPROCESSSEQUENCE.docx");
	public static File DOMGROUP_MODULEPROCESSSEQUENCE = new File(templateDomGroupPath + "MODULEPROCESSSEQUENCE.docx");
	public static File DOMGROUP_MODULECONFIGURATION = new File(templateDomGroupPath + "MODULECONFIGURATION.docx");

	public static File DOMGROUP_MODULE = new File(templateDomGroupPath + "MODULE.docx");
	public static File DOMGROUP_COMMUNICATIONCHANNEL = new File(templateDomGroupPath + "COMMUNICATIONCHANNEL.docx");

	public static File DOMGROUP_ADAPTERSPECIFICATTRIBUTE = new File(
			templateDomGroupPath + "ADAPTERSPECIFICATTRIBUTE.docx");
	public static File DOM_ADAPTERSPECIFICATTRIBUTE = new File(templateDomPath + "ADAPTERSPECIFICATTRIBUTE.docx");

	// Receiver Destination
	public static File DOMGROUP_RD = new File(templateDomGroupPath + "RD.docx");

	// Staging Destination
	public static File DOMGROUP_STAG = new File(templateDomGroupPath + "STAGING.docx");

	// Loging Destination
	public static File DOMGROUP_LOG = new File(templateDomGroupPath + "LOGGING.docx");
	// tempt part
	public static String temptPath = resourcePath + "temptFiles" + File.separator;

	public static String temptDomPath = temptPath + "dom" + File.separator;
	public static String temptDomGroupPath = temptPath + "domGroup" + File.separator;

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
		}
	}
}
