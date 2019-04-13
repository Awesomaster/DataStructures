
public interface Lock {
	public boolean open(int combination);
	public boolean close();
	public boolean changeCode(int currentCombination, int newCombination);
}
