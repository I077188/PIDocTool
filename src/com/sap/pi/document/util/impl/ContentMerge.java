package com.sap.pi.document.util.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;

/**
 * Only support text/ table
 *
 * Picture should do more investigation
 *
 */
public class ContentMerge {

	private static XWPFDocument src1Document;
	private static XWPFDocument src2Document;
	private static FileInputStream fips;
	private static FileOutputStream fops;

	// hasLocation - has the specific location for the input, current the
	// function is not supported, use false

	public static void mergeContent(List<File> sourceFiles, File target, boolean hasLocation)
			throws InvalidFormatException, IOException, XmlException {
		hasLocation = false;
		List<DGFile> fileInputs = new ArrayList<>();
		fops = new FileOutputStream(target, true);

		String location = "";
		for (int i = 0; i < sourceFiles.size(); i++) {

			if (i > 0) {
				// get location
				// docGroup files are named like
				// docDomGroup_<type>_<domGroupName>.docx
				String fileName = sourceFiles.get(i).getName();

				fileName = fileName.substring(fileName.indexOf("_") + 1);

				String type = fileName.substring(0, fileName.indexOf("_"));
				switch (type) {
				case "SCV":
					location = "Software Component";
					break;
				case "SI":
					location = "Service Interface";
					break;

				default:
					break;
				}
			}
			// get inputStream
			fips = new FileInputStream(sourceFiles.get(i));
			fileInputs.add(new DGFile(location, fips));

		}

		if (fileInputs.size() > 0) {

			OPCPackage src1Package = OPCPackage.open(fileInputs.get(0).getFips());
			src1Document = new XWPFDocument(src1Package);
			CTBody src1Body = src1Document.getDocument().getBody();

			for (int i = 1; i < fileInputs.size(); i++) {
				fips = fileInputs.get(i).getFips();
				OPCPackage src2Package = OPCPackage.open(fips);

				src2Document = new XWPFDocument(src2Package);
				CTBody src2Body = src2Document.getDocument().getBody();

				if (hasLocation) {
					appendBodyAtDefinedPart(src1Body, src2Body, fileInputs.get(i).getLocation());
				} else {
					appendBodyAtEnd(src1Body, src2Body);
				}
				fips.close();
			}

			src1Document.write(fops);
		}
		close();

	}

	private static void appendBodyAtEnd(CTBody src, CTBody append) throws XmlException {
		XmlOptions optionsOuter = new XmlOptions();
		optionsOuter.setSaveOuter();

		String appendString = append.xmlText(optionsOuter);
		String srcString = src.xmlText();

		String prefix = srcString.substring(0, srcString.indexOf(">") + 1);
		String mainPart = srcString.substring(srcString.indexOf(">") + 1, srcString.lastIndexOf("<"));

		String sufix = srcString.substring(srcString.lastIndexOf("<"));
		String addPart = appendString.substring(appendString.indexOf(">") + 1, appendString.lastIndexOf("<"));

		CTBody makeBody = CTBody.Factory.parse(prefix + mainPart + addPart + sufix);

		src.set(makeBody);
	}

	// current not working
	private static void appendBodyAtDefinedPart(CTBody src, CTBody append, String appendLocation) throws XmlException {

		XmlOptions optionsOuter = new XmlOptions();
		optionsOuter.setSaveOuter();

		String appendString = append.xmlText(optionsOuter);
		String srcString = src.xmlText();

		String prefix = srcString.substring(0, srcString.indexOf(">") + 1);

		// find the target location - <w:p...
		int locationIndex = srcString.indexOf(appendLocation);

		String prePart = srcString.substring(srcString.indexOf(">") + 1, locationIndex + appendLocation.length());
		String postPart = srcString.substring((locationIndex) + appendLocation.length(), srcString.lastIndexOf("<"));

		String tempt = postPart.substring(0, postPart.indexOf("/>") + 2);
		prePart = prePart + tempt;
		postPart = postPart.substring(postPart.indexOf("/>") + 2);

		String sufix = srcString.substring(srcString.lastIndexOf("<"));
		String addPart = appendString.substring(appendString.indexOf(">") + 1, appendString.lastIndexOf("<"));

		CTBody makeBody = CTBody.Factory.parse(prefix + prePart + addPart + postPart + sufix);

		src.set(makeBody);
	}

	public static void close() {
		try {
			src1Document.close();
			src2Document.close();
			fops.close();
			fips.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class DGFile {
	String location;
	FileInputStream fileInputStream;

	public DGFile(String location, FileInputStream fips) {
		this.location = location;
		this.fileInputStream = fips;
	}

	public String getLocation() {
		return location;
	}

	public FileInputStream getFips() {
		return fileInputStream;
	}
}
