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

import com.sap.pi.document.util.DocDomGroupUtil;
import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.Item;

public class DocDomGroupUtilImpl implements DocDomGroupUtil {

	private FileInputStream fips;
	private XWPFDocument document;
	private FileOutputStream fops;

	@Override
	public void generateDomGroupFile(File templateFile, List<Item> items, String targetType, boolean move2Dom) {

		// initial parameters
		Map<String, String> parameters = new HashMap<String, String>();
		for (Item item : items) {
			parameters.put(item.getParaName(), item.getParaValue());
		}

		// get domGroup type
		String templateFileName = templateFile.getName();
		String type = templateFileName.substring(0, templateFileName.indexOf("."));

		try {

			fips = new FileInputStream(templateFile);
			document = new XWPFDocument(fips);

			// create tempt file for document domGroup, named like
			// docDomGroup_<type>_<domGroupName>_tempt.docx
			// docDomGroup_<type>_tempt.docx
			String domGroupTemptFilePath = "";
			String mainName = OtherUtil.getValue(parameters.get("$Main_Name"));

			if (mainName != null && mainName != "" && mainName.toLowerCase() != "null" && !mainName.equals("N/A")) {
				domGroupTemptFilePath = CONSTAINTS.temptDomGroupPath + "docDomGroup_" + type + "_" + mainName
						+ "_tempt.docx";
			} else {
				domGroupTemptFilePath = CONSTAINTS.temptDomGroupPath + "docDomGroup_" + type + "_tempt.docx";
			}

			File domGroupTemptFile = new File(domGroupTemptFilePath);

			if (domGroupTemptFile.exists()) {
				domGroupTemptFile.delete();
			}

			domGroupTemptFile.createNewFile();

			fops = new FileOutputStream(domGroupTemptFile, true);

			// modified the groupName
			// replace content
			String regularExpression = "\\$(.*)_Value";

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
					TT:
					for (XWPFTableCell cell : row.getTableCells()) {
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

			// copy all the information from dom and domgroup tempt files
			String domGroupFilePath = "";
			if (mainName != null && mainName != "" && mainName != "null") {
				domGroupFilePath = CONSTAINTS.temptDomGroupPath + "docDomGroup_" + type + "_" + mainName + ".docx";
			} else {
				domGroupFilePath = CONSTAINTS.temptDomGroupPath + "docDomGroup_" + type + ".docx";
			}

			File domGroupFile = new File(domGroupFilePath);
			if (domGroupFile.exists()) {
				domGroupFile.delete();
			}

			domGroupFile.createNewFile();

			// generate File list of input <domXX.docx and
			// domgroup_XXX_tempt.docx>
			// loop source file for domGroup generation
			List<File> sourceFiles = new ArrayList<>();

			sourceFiles.add(domGroupTemptFile);

			File dir = new File(CONSTAINTS.temptDomPath);

			// sorting file to confirm the adding sequence
			for (File file : dir.listFiles()) {
				if (!file.isDirectory()) {
					String fileName = file.getName();
					if (fileName.indexOf("_" + type + "_") >= 0) {
						sourceFiles.add(file);
					}

				}
			}

			// merge content to the domGroup file
			try {
				ContentMerge.mergeContent(sourceFiles, domGroupFile, false);

				if (move2Dom) {
					move2Dom(targetType, domGroupFile);
				}

			} catch (InvalidFormatException | XmlException e) {
				e.printStackTrace();
				CONSTAINTS.LOG.error(e.getMessage());
			}

			// clean up tempt dom folder removeAllDomFile();
			removeAllDomFile(type);
			// remove tempt file
			if (domGroupTemptFile.exists()) {
				domGroupTemptFile.delete();
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

	private void move2Dom(String type, File file) {
		String fileName = file.getName();
		// System.out.println("before:\t" + fileName);

		// original file type
		// name like domGroup_<original type>_$Main_Name_<tags>.docx
		// target file type
		// name like dom_<target type>_$Main_Name_<tags>.docx

		String tempt = fileName.substring(fileName.indexOf("_") + 1);
		String tempt2 = tempt.substring(tempt.indexOf("_"));

		fileName = "dom_" + type + tempt2;

		// System.out.println("after:\t" + fileName);

		File targeFile = new File(CONSTAINTS.temptDomPath + fileName);

		if (targeFile.exists()) {
			targeFile.delete();
		}

		file.renameTo(targeFile);
	}

	/**
	 * remove all the generated tempt dom files
	 */
	private void removeAllDomFile(String type) {
		// int i = 0;
		// loop directory and delete tempt file
		File dir = new File(CONSTAINTS.temptDomPath);
		for (File file : dir.listFiles()) {
			if (!file.isDirectory()) {
				String fileName = file.getName();

				fileName = fileName.substring(fileName.indexOf("_") + 1);

				if (type.equalsIgnoreCase(fileName.substring(0, fileName.indexOf("_")))) {
					// i++;
					file.delete();
				}
			}
		}
		// System.out.println("delete files number is:\t" + i);
	}

	private void close() {
		try {
			if (fips != null) {
				fips.close();
			}
			if (fops != null) {
				fops.flush();
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
