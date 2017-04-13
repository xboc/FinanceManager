package domain.operation;

import java.util.Date;
import java.util.Objects;

import domain.account.Account;
import domain.operation.comment.Comment;

public abstract class Operation {
	
	private Account accountSender;
	
	private Account accountReceiver;
	
	private Date valueDate;
	
	private Comment comment;

	private Double amount;

	public Double getAmount() {
		return amount;
	}
	
	public Operation(Double amount, Account from, Account to, Date date){
		this.amount = amount;
		this.accountReceiver=to;
		this.accountSender=from;
		this.valueDate=date;
	}
	public Operation(Double amount, String from, String to, Date date){
		this.amount = amount;
		this.accountReceiver=new Account(0,from,to);
		this.accountSender=new Account(1,from,to);
		this.valueDate=date;
	}
	
	public void setComment(Comment comment){
		this.comment=comment;
	}
	
	public Account getAccountReceiver(){
		return this.accountReceiver;
	}
	
	public Account getAccountSender(){
		return this.accountSender;
	}

	public Date getValueDate() {
		return valueDate;
	}
	
	public int hashCode(){
		return Objects.hash(this.accountReceiver,this.accountSender,this.amount,this.valueDate,this.comment);
	}

	public Comment getComment() {
		return comment;
	}

	
}
