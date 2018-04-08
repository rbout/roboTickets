package roboTickets;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class User {
	private String loginName;
	private String userName;
	private final int userID;
	private GregorianCalendar date;
	private boolean isUser = true;
	private static int nextID = 00000;
	private double paidToDate;
	private String paymentInfo;
	
	public User(String lN, String n, int i) {
		loginName = lN;
		userName = n;
		userID = i;
		paidToDate = 0.0;
		paymentInfo = null;
		date = new GregorianCalendar();
	}
	public User(int i, String lN, String uN, boolean iU, GregorianCalendar d, double pTD) {
		userID = i;
		loginName = lN;
		userName = uN;
		isUser = iU;
		date = d;
		paidToDate = pTD;
		paymentInfo = null;
	}
	public void setNextID(int i) {
		nextID = i;
	}
	public int getNextID() {
		nextID = userID;
		return nextID;
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
	public String toString() {
		String d = date.getInstance().get(GregorianCalendar.MONTH) + "/" + date.getInstance().get(GregorianCalendar.DAY_OF_MONTH) + "/" + date.getInstance().get(GregorianCalendar.YEAR);
		return userID + "	" + loginName + "	" + userName + "	" + isUser + "	" + d + "	" + paidToDate;
	}
}