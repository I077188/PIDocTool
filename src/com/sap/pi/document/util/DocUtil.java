package com.sap.pi.document.util;

import java.io.File;
import java.util.List;

import com.sap.pi.document.util.model.Item;

public interface DocUtil {
	public void generateDocFile(File templateFile, List<Item> items);
}
