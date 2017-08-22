package com.sap.pi.document.util;

import java.io.File;
import java.util.List;

import com.sap.pi.document.util.dao.Item;

public interface DocDomGroupUtil {
	/**
	 * Generate domGroup related file
	 * 
	 * @param templateFile
	 *            template file for generation
	 * @param items
	 *            parameters for replace
	 */
	public void generateDomGroupFile(File templateFile, List<Item> items);
}
