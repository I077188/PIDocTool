package com.sap.pi.document.model;

import java.util.List;

import com.sap.xi.basis.Condition;
import com.sap.xi.basis.Receivers;

public class ExternalReceiverRule {

	List<String> ReceiverRuleID;
	Condition condition;
	Receivers receiver;

	public ExternalReceiverRule(List<String> receiverRuleID, Condition condition, Receivers receiver) {
		super();
		ReceiverRuleID = receiverRuleID;
		this.condition = condition;
		this.receiver = receiver;
	}

	public List<String> getReceiverRuleID() {
		return ReceiverRuleID;
	}

	public void setReceiverRuleID(List<String> receiverRuleID) {
		ReceiverRuleID = receiverRuleID;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Receivers getReceiver() {
		return receiver;
	}

	public void setReceiver(Receivers receiver) {
		this.receiver = receiver;
	}

}
