package roboTickets;

public class CreditCard extends PaymentInfo {
	private int creditCardNum;
	private int securityCode;
	private String expirationDate;
	private String streetAdress;
	private String zipCode;
	private String state;
	
	public CreditCard(String n, int ccn, int sc, String xd, String sa, String zc, String s) {
		super(n);
		creditCardNum = ccn;
		securityCode = sc;
		expirationDate = xd;
		streetAdress = sa;
		zipCode = zc;
		state = s;
	}
}
