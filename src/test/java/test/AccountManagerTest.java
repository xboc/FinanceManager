package test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import domain.account.Account;
import domain.account.AccountNumber;
import domain.operation.DebitOperation;
import domain.operation.Operation;
import junit.framework.Assert;
import manager.AccountManager;

public class AccountManagerTest {
	
	AccountManager manager;
	Account from;
	Account to;
	
	@Before
	public void setup() {
		from = new Account(new AccountNumber((long)1245), "test", "bic", new Double(0));
		to = new Account(new AccountNumber((long)5432), "test", "bic", new Double(0));
		
		manager = new AccountManager(from);
	}
	
	@Test
	public void getSoldeTest() {
		Assert.assertTrue(0== manager.getSolde()); ;
	}
	
	@Test
	public void getSolde_AddOperationTest() {
		Operation operation = new DebitOperation(new Double(2), from,to,new Date());
		manager.addOperation(operation);
		Assert.assertTrue(2== manager.getSolde()); ;
	}
	
	@Test
	public void checkPositiveBalance() {
		Operation operation = new DebitOperation(new Double(2), from,to,new Date());
		manager.addOperation(operation);
		System.out.println(manager.getBalance(to));
		Assert.assertTrue(-2== manager.getBalance(to)); ;
	}
	
	@Test
	public void checkNegativeBalance() {
		Operation operation = new DebitOperation(new Double(2), to,from,new Date());
		manager.addOperation(operation);
		
		Assert.assertTrue(2== manager.getBalance(to)); ;
	}
	
	@Test
	public void checkNegativeBalanceMultipleOperation() {
		Operation operation = new DebitOperation(new Double(2), to,from,new Date());
		Operation operation2 = new DebitOperation(new Double(5), from,to,new Date());
		manager.addOperation(operation);
		manager.addOperation(operation2);
		System.out.println(manager.getBalance(to));
		
		Assert.assertTrue(-3== manager.getBalance(to)); ;
	}
	
	
	
	public void getBalance(Account account){
		
	}
}
