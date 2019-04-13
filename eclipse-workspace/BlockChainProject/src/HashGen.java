import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class HashGen {
	private byte[] hash;
	private long nonce;
	private long time;
	private ArrayList<Transaction> transactions;
	private byte[] previousHash;
	
	public HashGen(long n, long t, ArrayList<Transaction> trans, byte[] pH) {
		nonce = n;
		time = t;
		transactions = trans;
		previousHash = pH;
	}
	
	public byte[] createHash() {
		String transString = "";

		for (int i = 0; i < transactions.size(); i++) {
			for (int j = 0; j < 3; j++) {
				transString = String.join(", ", transactions.get(i).from, transactions.get(i).to, transactions.get(i).amount, transString);
			}
		}
		String text = (time + transString + previousHash.toString() + nonce);
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(text.getBytes());
			return hash;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public byte[] getHash() {
		return hash;
	}
	
	public void setHash(byte[] hash) {
		this.hash = hash;
	}
	
}
