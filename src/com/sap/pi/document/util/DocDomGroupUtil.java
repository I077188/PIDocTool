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
	 * @param targetType
	 *            use couple with move2Dom - target type used for generated dom
	 *            file, set "" when not move 2 dom
	 * @param move2Dom
	 *            true-move to dom folder accordingly with changing the file
	 *            name with targetType
	 */
	public void generateDomGroupFile(File templateFile, List<Item> items, String targetType, boolean move2Dom);
}
