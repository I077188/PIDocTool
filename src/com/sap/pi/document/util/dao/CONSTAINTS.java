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
	public static File DOMGROUP_SENDER = new File(templateDomGroupPath + "SENDER.docx");

	public static File DOMGROUP_RR = new File(templateDomGroupPath + "RR.docx");

	public static File DOM_ATO_CONDITION = new File(templateDomPath + "ATOCONDITION.docx");
	public static File DOMGROUP_ATO_CONDITION_BLOCK = new File(templateDomGroupPath + "ATOCONDITIONBLOCK.docx");

	public static File DOM_RECEIVER = new File(templateDomPath + "RECEIVER.docx");
	public static File DOMGROUP_RECEIVER = new File(templateDomGroupPath + "RECEIVER.docx");
	public static File DOMGROUP_RECEIVERRULE = new File(templateDomGroupPath + "RECEIVERRULE.docx");
	public static File DOMGROUP_RECEIVERINTERFACE = new File(templateDomGroupPath + "RECEIVERINTERFACE.docx");
	public static File DOMGROUP_RIR = new File(templateDomGroupPath + "RIR.docx");
	public static File DOMGROUP_INTERFACEDETERMINATION = new File(templateDomGroupPath + "INTERFACEDETERMINATION.docx");

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
