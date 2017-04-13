package domain.account;

public class AccountNumber {

	private Long id;
	
	public String toString(){
		return id.toString();
	}
	
	public AccountNumber(Long id) {
		this.id = id;
	}
	
}
