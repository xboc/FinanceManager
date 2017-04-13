package domain.operation;

import java.util.Date;

import domain.account.Account;

public class DebitOperation extends Operation{
	
	public DebitOperation(Double amount, Account from, Account to, Date date){
		super(amount,from,to,date);
	}
	
	public DebitOperation(Double amount, String from, String to, Date date){
		super(amount, from, to, date);
	}
}
