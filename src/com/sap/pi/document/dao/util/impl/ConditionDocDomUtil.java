package com.sap.pi.document.dao.util.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.pi.document.util.dao.CONSTAINTS;
import com.sap.pi.document.util.dao.Item;
import com.sap.pi.document.util.impl.DocDomGroupUtilImpl;
import com.sap.pi.document.util.impl.DocDomUtilImpl;
import com.sap.pi.document.util.impl.OtherUtil;
import com.sap.xi.basis.AtomicCondition;
import com.sap.xi.basis.AtomicConditionBlock;
import com.sap.xi.basis.Condition;
import com.sap.xi.basis.Extractor;

public class ConditionDocDomUtil {

	DocDomGroupUtilImpl docDomGroupUtilImpl = new DocDomGroupUtilImpl();
	DocDomUtilImpl docDomUtilImpl = new DocDomUtilImpl();

	public void generateConditionDomFile(Condition condition, String type, boolean move2dom) {
		// AtomicConditionBlock
		List<AtomicConditionBlock> atomicConditionBlocks = condition.getAtomicConditionBlock();

		for (int j = 0; j < atomicConditionBlocks.size(); j++) {
			AtomicConditionBlock atomicConditionBlock = atomicConditionBlocks.get(j);

			List<AtomicCondition> atomicConditions = atomicConditionBlock.getAtomicCondition();

			for (int k = 0; k < atomicConditions.size(); k++) {

				AtomicCondition atomicCondition = atomicConditions.get(k);

				// generate dom file for each atomicConditions
				List<Item> items = new ArrayList<>();

				String operationName = OtherUtil.getValue(atomicCondition.getOperator());

				items.add(new Item("$Operation_Value", operationName));

				Extractor left = atomicCondition.getLeftExtractor();
				Extractor right = atomicCondition.getRightExtractor();
				String leftTypeID = "N/A";
				String leftValue = "N/A";
				String leftDataType = "N/A";
				String leftContextObjectName = "N/A";
				String leftContextObjectNamespace = "N/A";

				if (left != null) {
					leftTypeID = OtherUtil.getValue(left.getTypeID().value());
					leftValue = OtherUtil.getValue(left.getValue());
					leftDataType = OtherUtil.getValue(left.getDatatype());
					leftContextObjectName = OtherUtil.getValue(left.getContextObjectName());
					leftContextObjectNamespace = OtherUtil.getValue(left.getContextObjectNamespace());
				}

				items.add(new Item("$LeftExtractorTypeID_Value", leftTypeID));
				items.add(new Item("$LeftExtractorValue_Value", leftValue));
				items.add(new Item("$LeftExtractorDataType_Value", leftDataType));
				items.add(new Item("$LeftExtractorContextObjectName_Value", leftContextObjectName));
				items.add(new Item("$LeftExtractorContextObjectNamespace_Value", leftContextObjectNamespace));

				String rightTypeID = "N/A";
				String rightValue = "N/A";
				String rightDataType = "N/A";
				String rightContextObjectName = "N/A";
				String rightContextObjectNamespace = "N/A";

				if (right != null) {
					rightTypeID = OtherUtil.getValue(right.getTypeID().value());
					rightValue = OtherUtil.getValue(right.getValue());
					rightDataType = OtherUtil.getValue(right.getDatatype());
					rightContextObjectName = OtherUtil.getValue(right.getContextObjectName());
					leftContextObjectNamespace = OtherUtil.getValue(right.getContextObjectNamespace());
				}

				items.add(new Item("$RightExtractorTypeID_Value", rightTypeID));
				items.add(new Item("$RightExtractorValue_Value", rightValue));
				items.add(new Item("$RightExtractorDataType_Value", rightDataType));
				items.add(new Item("$RightExtractorContextObjectName_Value", rightContextObjectName));
				items.add(new Item("$RightExtractorContextObjectNamespace_Value", rightContextObjectNamespace));

				// generate dom files of AtomicCondition
				docDomUtilImpl.generateDomFile(CONSTAINTS.DOM_ATO_CONDITION, items, operationName);

			}

			// generate domGroup file of AtomicConditionBlock write back
			// required target type RR (receiver rule)

			List<Item> items = new ArrayList<>();
			items.add(new Item("$Main_Name", "ATOCONDITIONBLOCK"));
			docDomGroupUtilImpl.generateDomGroupFile(CONSTAINTS.DOMGROUP_ATO_CONDITION_BLOCK, items, type, move2dom);
		}
	}

}
