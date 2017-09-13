package com.sap.pi.document.util.impl;

import java.io.File;

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

	public static File[] sortByNumber(File[] files) {

		int size = files.length;
		if (size > 0) {
			File[] result = new File[size];

			for (int i = 0; i < files.length; i++) {
				File file = files[i];

				String fileName = file.getName();
				int index = extractNumber(fileName);

				result[index] = file;
			}

			return result;
		}
		return null;
	}

	private static int extractNumber(String name) {
		int i = 0;
		try {
			int s = name.lastIndexOf('_') + 1;
			int e = name.lastIndexOf('.');
			String number = name.substring(s, e);
			i = Integer.parseInt(number);
		} catch (Exception e) {
			i = 0; // if filename does not match the format
			// then default to 0
		}
		return i;
	}
}
