package manager.budget;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import domain.account.Account;
import domain.account.AccountNumber;
import manager.AccountManager;
import manager.budget.classification.Classification;

public class Budget {
	
	private HashMap<AccountNumber, AccountManager> accountList = null;
	
	private HashSet<Classification> classificationSet = new HashSet<Classification>();
	
	private String budgetName = null;
	
	private Date startDate;
	private Date endDate;
	
	
	
	public Budget(String name){
		this.budgetName = name;
	}
	
	public Double getExpenses(Date from, Date to, AccountNumber accountNumber){
		AccountManager accountManager = accountList.get(accountNumber);
		return null;
	}
	
	public void addClassification(Classification classification) {
		classificationSet.add(classification);
	}
	
	public Double getTotalExpectedRevenue() {
		Double amount = new Double(0.0);
		
		Iterator<Classification> it = classificationSet.iterator();
		
		while(it.hasNext()) {
			Classification classification = it.next();
			if(classification.getExpectedAmount()>0){
				amount = amount + classification.getExpectedAmount();
			}
		}
		return amount;
	}
	
	public Double getTotalExpectedExpenses() {
		Double amount = new Double(0.0);
		
		Iterator<Classification> it = classificationSet.iterator();
		
		while(it.hasNext()) {
			Classification classification = it.next();
			if(classification.getExpectedAmount()<0){
				amount = amount - classification.getExpectedAmount();
			}
		}
		return amount;
	}
	

}
