package com.sap.pi.document.util.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.sap.pi.document.util.DocDomUtil;
import com.sap.pi.document.util.model.CONSTAINTS;
import com.sap.pi.document.util.model.Item;

public class DocDomUtilImpl implements DocDomUtil {

	private FileInputStream fips;
	private XWPFDocument document;
	private FileOutputStream fops;

	@Override
	public void generateDomFile(File templateFile, List<Item> items, String... tags) {

		// initial parameters
		Map<String, String> parameters = new HashMap<String, String>();

		for (Item item : items) {
			parameters.put(item.getParaName(), item.getParaValue());
		}

		String templateFileName = templateFile.getName();
		String type = templateFileName.substring(0, templateFileName.indexOf("."));

		try {
			fips = new FileInputStream(templateFile);
			document = new XWPFDocument(fips);

			String fileNameTag = "";
			for (String tag : tags) {
				fileNameTag += tag;
			}

			// create tempt file for document dom, named like
			// docDom_<type>_<domName>.docx
			String mainName = OtherUtil.getValue(parameters.get("$Main_Name"));

			String domFilePath = "";
			if (fileNameTag == "") {
				if (mainName.equals("N/A")) {
					domFilePath = CONSTAINTS.temptDomPath + "docDom_" + type + ".docx";
				}
				domFilePath = CONSTAINTS.temptDomPath + "docDom_" + type + "_" + mainName + ".docx";
			} else {
				if (mainName.equals("N/A")) {
					domFilePath = CONSTAINTS.temptDomPath + "docDom_" + type + "_" + fileNameTag + ".docx";
				}
				domFilePath = CONSTAINTS.temptDomPath + "docDom_" + type + "_" + mainName + "_"
						+ fileNameTag + ".docx";
			}

			File domFile = new File(domFilePath);

			if (domFile.exists()) {
				domFile.delete();
			}

			domFile.createNewFile();
			fops = new FileOutputStream(domFile);

			// replace content in the template file
			// - get paragraphs
			String regularExpression = "\\$(.*)_Value";

			List<XWPFParagraph> paragraphs = document.getParagraphs();
			for (XWPFParagraph paragraph : paragraphs) {
				List<XWPFRun> runs = paragraph.getRuns();

				if (runs != null) {
					for (XWPFRun run : runs) {
						String text = run.getText(0);
						if (text != null && Pattern.matches(regularExpression, text)) {
							text = parameters.get(text);
							run.setText(text, 0);
						}
					}
				}
			}

			// - get tables
			/*
			 * List<XWPFTable> tables = document.getTables(); for (XWPFTable
			 * table : tables) { for (XWPFTableRow row : table.getRows()) { for
			 * (XWPFTableCell cell : row.getTableCells()) { for (XWPFParagraph p
			 * : cell.getParagraphs()) { for (XWPFRun run : p.getRuns()) {
			 * String text = run.getText(0); if (text != null &&
			 * Pattern.matches(regularExpression, text)) { text =
			 * parameters.get(text); run.setText(text, 0); } } } } } }
			 */
			List<XWPFTable> tables = document.getTables();
			for (XWPFTable table : tables) {
				for (XWPFTableRow row : table.getRows()) {
					TT: for (XWPFTableCell cell : row.getTableCells()) {
						// for each cell judge whether it is a parameter cell or
						// a value cell
						// if the first run of first paragraph not include "$",
						// it parameter cell
						List<XWPFParagraph> xwpfParagraphs = cell.getParagraphs();

						if (xwpfParagraphs.size() > 0) {
							XWPFParagraph xwpfParagraph = xwpfParagraphs.get(0);
							List<XWPFRun> xwpfRuns = xwpfParagraph.getRuns();
							if (xwpfRuns.size() > 0) {
								XWPFRun run0 = xwpfRuns.get(0);
								if (run0.getText(0).indexOf("$") < 0) {
									continue TT;
								} else {
									// execute value replace
									for (XWPFParagraph p : xwpfParagraphs) {

										StringBuilder sb = new StringBuilder();

										for (XWPFRun run : p.getRuns()) {
											String text = run.getText(0);
											sb.append(text);
											run.setText("", 0);

											if (Pattern.matches(regularExpression, sb.toString())) {
												run.setText(OtherUtil.getValue(parameters.get(sb.toString())));
											} else {
												continue;
											}
										}
									}

								}
							}
						}

					}
				}
			}

			// generate the dom file
			document.write(fops);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			CONSTAINTS.LOG.error(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			CONSTAINTS.LOG.error(e.getMessage());
		} finally {
			close();
		}
	}

	private void close() {
		try {
			if (fips != null) {
				fips.close();
			}
			if (fops != null) {
				fops.close();
			}
			if (document != null) {
				document.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			CONSTAINTS.LOG.error(e.getMessage());
		}
	}
}