package com.sap.pi.document.util.dao;

import java.io.File;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class CONSTAINTS {

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
	public static File DOM_DRR_OMP_INTEGER = new File(templateDomPath + "DRROMPINTEGER.docx");
	public static File DOMGROUP_DRR_OMP_INTEGER = new File(templateDomGroupPath + "DRROMPINTEGER.docx");

	public static File DOM_DRR_OMP_STRING = new File(templateDomPath + "DRROMPSTRING.docx");
	public static File DOMGROUP_DRR_OMP_STRING = new File(templateDomGroupPath + "DRROMPSTRING.docx");

	public static File DOM_DRR_OMP_CHANEL = new File(templateDomPath + "DRROMPCHANEL.docx");
	public static File DOMGROUP_DRR_OMP_CHANEL = new File(templateDomGroupPath + "DRROMPCHANEL.docx");

	public static File DOMGROUP_DRR_OMP = new File(templateDomGroupPath + "DRROMP.docx");
	public static File DOM_DRR_OMP = new File(templateDomPath + "DRROMP.docx");

	public static File DOMGROUP_DRR_OM = new File(templateDomGroupPath + "DRROM.docx");
	public static File DOM_DRR_OM = new File(templateDomPath + "DRROM.docx");

	public static File DOMGROUP_DRR = new File(templateDomGroupPath + "DRR.docx");
	public static File DOMGROUP_SENDER = new File(templateDomGroupPath + "SENDER.docx");

	// tempt part
	public static String temptPath = resourcePath + "temptFiles" + File.separator;

	public static String temptDomPath = temptPath + "dom" + File.separator;
	public static String temptDomGroupPath = temptPath + "domGroup" + File.separator;

	public static String userName = "I888888";
	public static String password = "Abcd1234";

	public static void addNewLine(XWPFDocument document) {
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();
		run.setText("");
	}
}
