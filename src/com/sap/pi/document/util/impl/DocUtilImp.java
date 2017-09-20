package com.sap.pi.document.util.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;

import com.sap.pi.document.util.DocUtil;
import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.Item;

public class DocUtilImp implements DocUtil {

	private FileInputStream fips;
	private XWPFDocument document;
	private FileOutputStream fops;

	@Override
	public void generateDocFile(File templateFile, List<Item> items) {

		// initial parameters
		Map<String, String> parameters = new HashMap<String, String>();

		for (Item item : items) {
			parameters.put(item.getParaName(), item.getParaValue());
		}

		try {
			fips = new FileInputStream(templateFile);
			document = new XWPFDocument(fips);

			// create tempt file for document domGroup, named like
			// docDomGroup_<type>_<domName>_tempt.docx
			String icoTemptDocPath = CONSTAINTS.resultPath + "ICO_"
					+ OtherUtil.formatName(parameters.get("$Main_Value"))
					+ "_tempt.docx";

			File icoTemptDoc = new File(icoTemptDocPath);

			if (icoTemptDoc.exists()) {
				icoTemptDoc.delete();
			}

			icoTemptDoc.createNewFile();

			fops = new FileOutputStream(icoTemptDoc, true);

			// modified the groupName
			// replace content
			String regularExpression = "\\$(.*)_Value";

			// modified the groupName
			// replace content
			List<XWPFParagraph> paragraphs = document.getParagraphs();

			for (XWPFParagraph paragraph : paragraphs) {
				StringBuilder sb = new StringBuilder();
				List<XWPFRun> xwpfRuns = paragraph.getRuns();

				boolean replace = false;
				for (XWPFRun run : xwpfRuns) {
					String text = run.getText(0);
					if (text.indexOf("$") >= 0) {
						replace = true;
					}

					sb.append(text);
					if (replace) {
						run.setText("", 0);
					}
					// replace parameter had been replaced
					if ((text.lastIndexOf(" ") == (text.length() - 1)) || text.substring(0, 1).equals(" ")) {
						replace = false;
					}

					if (Pattern.matches(regularExpression, sb.toString())) {
						run.setText(OtherUtil.getValue(parameters.get(sb.toString())));
					} else {
						continue;
					}
				}
			}

			// - get tables
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

			document.write(fops);
			close();

			/*
			 * List<XWPFParagraph> paragraphs = document.getParagraphs(); for
			 * (XWPFParagraph paragraph : paragraphs) { List<XWPFRun> runs =
			 * paragraph.getRuns();
			 *
			 * if (runs != null) { for (XWPFRun run : runs) { String text =
			 * run.getText(0); if (text != null &&
			 * Pattern.matches(regularExpression, text)) { text =
			 * parameters.get(text); run.setText(text, 0); } } } }
			 * document.write(fops); close();
			 */

			// copy all the information from dom and domgroup tempt files
			String icoDocPath = CONSTAINTS.resultPath + "ICO_" + OtherUtil.formatName(parameters.get("$Main_Value"))
					+ ".docx";

			File icoDoc = new File(icoDocPath);
			if (icoDoc.exists()) {
				CONSTAINTS.LOG.warn("An old file with the same name exist:\t" + icoDocPath);
				icoDoc.delete();
			}

			icoDoc.createNewFile();

			// generate File list of input <domXX.docx and
			// domgroup_XXX_tempt.docx>
			List<File> sourceFiles = new ArrayList<>();
			sourceFiles.add(icoTemptDoc);

			File dir = new File(CONSTAINTS.temptDomGroupPath);

			File[] originalFiles = dir.listFiles();
			File[] files = OtherUtil.sortByNumber(originalFiles);

			for (File file : files) {
				if (!file.isDirectory()) {
					sourceFiles.add(file);
				}
			}

			// merge content to the domGroup file
			try {

				ContentMerge.mergeContent(sourceFiles, icoDoc, false);
			} catch (InvalidFormatException | XmlException e) {
				e.printStackTrace();
				CONSTAINTS.LOG.error(e.getMessage());
			}

			// clean up tempt dom folder removeAllDomFile();
			removeAllDomGroupFile();
			// remove tempt file
			if (icoTemptDoc.exists()) {
				icoTemptDoc.delete();
			}

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

	/**
	 * remove all the generated tempt dom files
	 */
	private void removeAllDomGroupFile() {
		// loop directory and delete tempt file
		File dir = new File(CONSTAINTS.temptDomGroupPath);
		for (File file : dir.listFiles()) {
			if (!file.isDirectory()) {
				file.delete();
			}
		}
	}

	private void close() {
		try {
			if (fips != null) {
				fops.flush();
				fips.close();
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
