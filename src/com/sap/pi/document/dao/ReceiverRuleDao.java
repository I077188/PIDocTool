package com.sap.pi.document.dao;

import java.util.List;

import com.sap.xi.basis.Condition;

public class ReceiverRuleDao {

	Condition condtionDao;
	List<ReceiverDao> receiverDao;

	public ReceiverRuleDao(Condition condtionDao, List<ReceiverDao> receiverDao) {
		this.condtionDao = condtionDao;
		this.receiverDao = receiverDao;
	}

	public Condition getCondtionDao() {
		return condtionDao;
	}

	public List<ReceiverDao> getReceiverDao() {
		return receiverDao;
	}

}
