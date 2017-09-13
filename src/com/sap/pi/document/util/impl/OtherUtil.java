package com.sap.pi.document.util.impl;

import java.io.File;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class OtherUtil {

	public static String getValue(String inputValue) {

		if (inputValue != null && !inputValue.equals("") && !inputValue.equals("N/A")) {
			return inputValue;
		}
		return "N/A";
	}

	public static String formatName(String inputString) {
		String result = "";

		result = inputString.replaceAll("[^a-zA-Z0-9_.$]", "0");

		return result;
	}

	// file name: dom/domGroup_index_TYPENAME_TAG.docx
	public static File[] sortByNumber(File[] files) {

		HashMap<Integer, File> fileMap = new HashMap<Integer, File>();
		if (files != null && files.length > 0) {
			for (int i = 0; i < files.length; i++) {
				File file = files[i];

				String fileName = file.getName();
				// get number
				fileName = fileName.substring(fileName.indexOf("_") + 1);

				// check whether the template has pre-number
				String regularExpression = "[0-9]+";

				String tag = fileName.substring(0, fileName.indexOf("_"));

				Integer key = Integer.valueOf(tag);

				if (Pattern.matches(regularExpression, tag)) {
					fileMap.put(key, file);
				}
			}

			File[] result = new File[files.length];
			SortedSet<Integer> keys = new TreeSet<Integer>();
			keys.addAll(fileMap.keySet());

			int i = 0;
			for (Integer key : keys) {
				File file = fileMap.get(key);
				result[i] = file;
				i++;
			}

			return result;
		}


		return null;
	}

	public static boolean isOfType(String type, String fileName) {
		fileName = fileName.substring(fileName.indexOf("_") + 1);

		// check whether the template has pre-number
		String regularExpression = "[0-9]+";

		String tag = fileName.substring(0, fileName.indexOf("_"));

		if (Pattern.matches(regularExpression, tag)) {
			fileName = fileName.substring(fileName.indexOf("_") + 1);
		}

		return type.equalsIgnoreCase(fileName.substring(0, fileName.indexOf("_")));
	}

}
