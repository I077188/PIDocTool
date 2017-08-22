package com.sap.pi.document.util;

import java.util.List;

import com.sap.pi.document.dao.SoftwareComponent;
import com.sap.pi.document.util.dao.Item;

public interface EasyQueryOperation {

	public List<SoftwareComponent> getSCWInfo();

	public List<Item> getSIInfo();

}
