package com.sap.pi.document.util;

import java.util.List;

import com.sap.pi.document.model.SoftwareComponent;
import com.sap.pi.document.util.model.Item;

public interface EasyQueryOperation {

	public List<SoftwareComponent> getSCWInfo();

	public List<Item> getSIInfo();

}
