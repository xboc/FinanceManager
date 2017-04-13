package domain.account;

public class Account {
	
	private AccountNumber accountNumber;
	
	private String iban;
	
	private String bic;
	
	private Double solde = new Double(0);
	
	private String name;
	
	private String address;

	public Double getSolde() {
		return solde;
	}
	
	public Account(AccountNumber nbr, String iban, String bic, Double solde) {
		this.accountNumber = nbr;
		this.iban = iban;
		this.bic = bic;
		this.solde = solde;
	}

	public Account(int i, String from, String to) {
		this.accountNumber = new AccountNumber((long)i);
		this.iban = iban;
		this.bic = to;
		this.solde = solde;
	}
	
}
