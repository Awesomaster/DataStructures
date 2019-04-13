import java.io.Serializable;

public class Transaction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4822895937804016293L;
	public String from;
	public String to;
	public String amount;
	
	public Transaction(String f, String t, long a) {
		from = f;
		to = t;
		amount = String.valueOf(a);
	}
	
}
