package com.sap.pi.document.util.dao;

public class Item {
	String paraName;
	String paraValue;

	public Item(String paraName, String paraValue) {
		this.paraName = paraName;
		this.paraValue = paraValue;
	}

	public String getParaValue() {
		return paraValue;
	}

	public String getParaName() {
		return paraName;
	}

}
