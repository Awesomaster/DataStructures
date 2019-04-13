
public class LockInt implements Lock {
	int combo;
	boolean lockOpen;
	
	/**
	 * LockInt
	 * @param combination
	 * @param lockState
	 */
	public LockInt(int combination, boolean lockState) {
		if ((0 <= combination) && (combination <= 999)) {
			combo = combination;
		} else {
			System.exit(1); // AN ERROR HAS OCCURED!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
		lockOpen = lockState;
	}
	
	/**
	 * Opens the lock, if you have the key
	 * @param n the combination lock you think will work
	 * @return if the operation succeeded
	 */
	public boolean open(int n) {
		if (n == combo) {
			lockOpen = true;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Close the lock
	 * @return if the operation succeeded
	 */
	public boolean close() {
		lockOpen = false;
		return true;
	}
	
	/**
	 * Change the combination on the lock, if you have the key
	 * @param currentCombo the combination lock you think will work
	 * @param newCombo the combination lock you want to work
	 * @return if the operation succeeded
	 */
	public boolean changeCode(int currentCombo, int newCombo) {
		if (currentCombo == combo) {
			if ((0 <= newCombo) && (newCombo <= 999)) {
				combo = newCombo;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
