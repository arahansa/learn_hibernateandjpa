package chap02_2.embedded;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	@Embedded
	private BankInfo bank;
	
	@Id
	private int customerId;

	public BankInfo getBank() {
		return bank;
	}

	public void setBank(BankInfo bank) {
		this.bank = bank;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Customer [bank=" + bank + ", customerId=" + customerId + "]";
	}
	

	
}
