package domain.operation;

import java.util.Date;

import domain.account.Account;

public class CreditCardOperation extends Operation{
	
	public CreditCardOperation(Double amount, Account from, Account to, Date date){
		super(amount,from,to,date);
	}
	
	public CreditCardOperation(Double amount, String from, String to, Date date){
		super(amount, from, to, date);
	}
}
