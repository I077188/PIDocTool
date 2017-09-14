package com.sap.pi.document.util.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Pattern;

import com.sap.xi.basis.AtomicCondition;
import com.sap.xi.basis.AtomicConditionBlock;
import com.sap.xi.basis.Condition;

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
			File[] result = new File[files.length];
			for (int i = 0; i < files.length; i++) {
				File file = files[i];

				String fileName = file.getName();
				// get number
				Integer key = getIndexOfFile(fileName);
				if (key >= 0) {
					fileMap.put(key, file);
				} else {
					// once met a name without sequence number then return
					result = files;
					return result;
				}
			}
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

	public static Integer getIndexOfFile(String fileName) {
		Integer key = -1;

		if (fileName.indexOf("_") >= 0) {
			String regularExpression = "[0-9]+";

			String tag = fileName.substring(0, fileName.indexOf("_"));
			// number_NAME.docx
			if (Pattern.matches(regularExpression, tag)) {
				key = Integer.valueOf(tag);
			} else {
				// dom/domGroup_number_Name.docx
				if (fileName.indexOf("_") >= 0) {
					fileName = fileName.substring(fileName.indexOf("_") + 1);
					// check whether the template has pre-number
					if (fileName.indexOf("_") >= 0) {
						tag = fileName.substring(0, fileName.indexOf("_"));

						if (Pattern.matches(regularExpression, tag)) {
							key = Integer.valueOf(tag);
						}
					}
				}
			}

		}
		return key;
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

	public static String getCondition(Condition condition) {
		// TODO Auto-generated method stub
		StringBuilder conditionString = new StringBuilder();

		List<AtomicConditionBlock> conditionBlocks = condition.getAtomicConditionBlock();

		if (conditionBlocks != null) {
			for (int i = 0; i < conditionBlocks.size(); i++) {
				AtomicConditionBlock atomicConditionBlock = conditionBlocks.get(i);
				if (i > 0) {
					conditionString.append("OR(");
				} else {
					conditionString.append("(");
				}

				List<AtomicCondition> atoConditions = atomicConditionBlock.getAtomicCondition();

				if (atoConditions != null) {
					for (int j = 0; j < atoConditions.size(); j++) {
						AtomicCondition atomicCondition = atoConditions.get(j);
						String operator = atomicCondition.getOperator();
						if (operator.equals("EQ")) {
							operator = "=";
						} else if (operator.equals("NE")) {
							operator = "!=";
						} else if (operator.equals("CP")) {
							operator = "~";
						}
						String leftExtratorName = atomicCondition.getLeftExtractor().getValue();
						String leftExtratorValue = atomicCondition.getLeftExtractor().getContextObjectName();

						String leftExtractor = OtherUtil.getValue(leftExtratorName + leftExtratorValue);

						String rightExtrator = atomicCondition.getRightExtractor().getValue();
						String oneCondition = "(" + leftExtractor + " " + operator + " " + rightExtrator + ")";
						conditionString.append(oneCondition);
						if (j < (atoConditions.size() - 1)) {
							conditionString.append(" AND ");
						}
					}
					conditionString.append(")");
				}
			}
		}

		return conditionString.toString();
	}


}
