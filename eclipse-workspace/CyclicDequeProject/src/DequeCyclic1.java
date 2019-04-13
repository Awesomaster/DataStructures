import CITS2200.Deque;
import CITS2200.Overflow;
import CITS2200.Underflow;

public class DequeCyclic1 implements Deque<Object> {
	int left;
	int right;
	Object[] deque;
	int size;
	
	/**
	 * DequeCyclic is a constructor
	 * @param s is the size of the array for the deque that you want to create
	 */
	public DequeCyclic1(int s) {
		deque = new Object[s];
		left = 0;
		right = -1;
		size = 0;
	}
	
	/**
	 * isEmpty returns if the deque is empty
	 * @return boolean This returns if the deque is empty
	 */
	public boolean isEmpty() {
		if (size==0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * isFull returns if the deque is full
	 * @return boolean This returns if the deque is full
	 */
	public boolean isFull() {
		if (size==deque.length) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * peekLeft shows the the left most object in the deque
	 * @return Object Returns the object you wished to peek at
	 */
	public Object peekLeft() throws Underflow {
		if (isEmpty()) {
			throw new Underflow("Deque is empty, could not peekLeft");
		} else {
			return deque[left];
		}
	}

	/**
	 * peekRight shows the the right most object in the deque
	 * @return Object Returns the object you wished to peek at
	 */
	public Object peekRight() throws Underflow {
		if (isEmpty()) {
			throw new Underflow("Deque is empty, could not peekRight");
		} else {
			return deque[right];
		}
	}

	/**
	 * popLeft returns the left most object in the queue after removing it from the deque
	 * @return Object Returns the object you wished to pop
	 */
	public Object popLeft() throws Underflow {
		if (isEmpty()) {
			throw new Underflow("Deque is empty, could not popLeft");
		} else {
			size--;
			Object temp = deque[left];
			deque[left] = null;
			left = (left + 1) % (deque.length);
			return temp;
		}
	}

	/**
	 * popRight returns the right most object in the queue after removing it from the deque
	 * @return Object Returns the object you wished to pop
	 */
	public Object popRight() throws Underflow {
		if (isEmpty()) {
			throw new Underflow("Deque is empty, could not popRight");
		} else {
			size--;
			Object temp = deque[right];
			deque[right] = null;
			right-=1;
			if (right < 0) {
				right = deque.length - 1;
			}
			return temp;
		}
	}

	/**
	 * pushLeft takes object o and adds it to the left of the deque
	 * @param o is the object being added to the deque
	 */
	public void pushLeft(Object o) throws Overflow {
		if (isFull()) {
			throw new Overflow("Deque is full, could not pushLeft");
		} else {
			size++;
			left -= 1;
			if (left < 0) {
				left = deque.length - 1;
			}
			deque[left] = o;
		}
	}

	/**
	 * pushRight takes object o and adds it to the right of the deque
	 * @param o is the object being added to the deque
	 */
	public void pushRight(Object o) throws Overflow {
		if (isFull()) {
			throw new Overflow("Deque is full, could not pushLeft");
		} else {
			size++;
			right = (right + 1) % (deque.length);
			deque[right] = o;
		}
	}

}
