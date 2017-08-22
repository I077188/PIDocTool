package com.sap.pi.document.util;

import java.io.File;
import java.util.List;

import com.sap.pi.document.util.dao.Item;

public interface DocDomUtil {
	/**
	 * generate dom related files
	 * 
	 * @param templateFile
	 *            template file for the generation file
	 * @param items
	 *            parameters for the replacement
	 * @param tags
	 *            tags for generate file
	 */
	public void generateDomFile(File templateFile, List<Item> items, String... tags);

}
