package com.sap.pi.document.model;

import java.util.List;

import com.sap.xi.basis.MappingParameters;

public class OperationMapping {

	String name;
	String nameSpace;
	String softwareComponent;
	List<MappingParameters> parameters;

	public OperationMapping(String name, String nameSpace, String softwareComponent,
			List<MappingParameters> parameters) {

		this.name = name;
		this.nameSpace = nameSpace;
		this.softwareComponent = softwareComponent;
		this.parameters = parameters;
	}

	public String getName() {
		return name;
	}

	public String getNameSpace() {
		return nameSpace;
	}

	public String getSoftwareComponent() {
		return softwareComponent;
	}

	public List<MappingParameters> getParameter() {
		return parameters;
	}
}
