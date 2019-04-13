
public abstract class LockString implements Lock {
	int combo;
	boolean lockOpen;
	
	/**
	 * 
	 * @param combination
	 * @param isOpen
	 */
	public LockString(String combination, boolean isOpen) {
		int intCombo = Integer.parseInt(combination);
		if ((0 <= intCombo) && (intCombo <= 999)) {
			combo = intCombo;
		} else {
			System.exit(1); // AN ERROR HAS OCCURED!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
		lockOpen = isOpen;
	}
	
	/**
	 * 
	 * @param combination
	 * @return if the operation succeeded
	 */
	public boolean open(String combination) {
		if (combo == Integer.parseInt(combination)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @return if the operation succeeded
	 */
	public boolean close() {
		lockOpen = false;
		return true;
	}
	
	/**
	 * 
	 * @param currentCombination
	 * @param newCombination
	 * @return if the operation succeeded
	 */
	public boolean changeCode(String currentCombination, String newCombination) {
		// TODO Auto-generated method stub
		return false;
	}

}
