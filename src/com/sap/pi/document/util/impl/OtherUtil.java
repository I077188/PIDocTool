package com.sap.pi.document.util.impl;

public class OtherUtil {

	public static String getValue(String inputValue) {

		if (inputValue != null && !inputValue.equals("") && !inputValue.equals("N/A")) {
			return inputValue;
		}
		return "N/A";
	}

	public static String formatName(String inputString) {
		String result = "";

		result = inputString.replaceAll("[^a-zA-Z0-9.-]", "0");

		return result;
	}

}
