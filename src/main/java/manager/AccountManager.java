package manager;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import domain.account.Account;
import domain.operation.Operation;
import filereader.DeutscheBankFileReader;

public class AccountManager {
	
	private Account account;
	
	private LinkedList<Operation> operationList = new LinkedList<Operation>();
	
	private DeutscheBankFileReader reader = new DeutscheBankFileReader();
	
	
	public Double getSolde(){
		Double solde = account.getSolde();
		for(Operation operation : operationList) {
			solde = operation.getAmount()+account.getSolde();
		}
		return solde;
	}
	
	public AccountManager(Account account){
		this.account=account;
	}

	public void addOperation(Operation operation) {
		this.operationList.add(operation);
	}
	
	public Double getBalance(Account account){
		Double balance = Double.valueOf(0);
		for(Operation operation : operationList) {
			if(operation.getAccountReceiver().equals(account)){
				balance = balance - operation.getAmount();
			}
			if(operation.getAccountSender().equals(account)){
				balance = balance + operation.getAmount();
			}
		}
		return balance;	
	}
	
	public void createOperationFromFiles(LinkedList<String> fileNameList) {
		for (String fileName : fileNameList) {
			operationList= reader.getOperationListFromFile(new File(fileName), operationList);
		}
	}
	
	
	public LinkedList<Operation> getFilteredList(Date from, Date to){
		Iterator<Operation> it = operationList.iterator();
		LinkedList<Operation> result = new LinkedList<Operation>();
		while (it.hasNext()){
			Operation op = (Operation) it.next();
			if (from.before(op.getValueDate()) && to.after(op.getValueDate())){
				result.add(op);
			}
		}
		
		return result;
	}
	
	
	
}
