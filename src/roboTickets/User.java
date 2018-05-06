package roboTickets;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.io.Serializable;

public class User implements Serializable {
	private String loginName;
	private String userName;
	private String password;
	private final int userID;
	private GregorianCalendar date;
	private boolean isUser = true;
	private static int nextID = 00000;
	private double paidToDate;
	private PaymentInfo paymentInfo;
	
	public User(String lN, String n, String pw, int i) {
		loginName = lN;
		userName = n;
		password = pw;
		userID = i;
		paidToDate = 0.0;
		paymentInfo = null;
		date = new GregorianCalendar();
	}
	
	public void setNextID(int i) {
		nextID = i;
	}
	
	public int getNextID() {
		return userID;
	}
	
	public void setDate(GregorianCalendar g){
		date = g;
	}
	
	public void setName(String n) {
		userName = n;
	}
	
	public void paidAmount(int amount) {
		paidToDate = paidToDate + amount;
	}
	
	public void setIsUser(boolean u) {
		isUser = u;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getLoginName() {
		return loginName;
	}
	
	public int getYears() {
		return GregorianCalendar.getInstance().get(GregorianCalendar.YEAR) - date.YEAR;
	}
	
	public boolean checkPassword(String s) {
		if(s.equals(password))
			return true;
		return false;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean getIsUser() {
		return isUser;
	}
	
	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}
	
	public void setUserPayment(PaymentInfo pi) {
		paymentInfo = pi;
	}
	
	public void addPayTicket(double p) {
		paidToDate = paidToDate + p;
	}
	
	public double getPaidToDate() {
		return paidToDate;
	}
	
	public String toString() {
		String d = date.getInstance().get(GregorianCalendar.MONTH) + "/" + date.getInstance().get(GregorianCalendar.DAY_OF_MONTH) + "/" + date.getInstance().get(GregorianCalendar.YEAR);
		return userID + "	" + loginName + "	" + userName + "	" + password + "	" + isUser + "	" + d + "	" + paidToDate;
	}
}