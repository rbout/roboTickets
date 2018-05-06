package roboTickets;

import java.io.Serializable;

public abstract class PaymentInfo implements Serializable {
	protected String name;
	
	public PaymentInfo() {
		name = "";
	}
	
	public PaymentInfo(String n) {
		name = n;
	}
}
