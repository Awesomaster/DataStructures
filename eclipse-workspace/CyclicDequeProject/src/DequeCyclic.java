import CITS2200.Deque;
import CITS2200.Overflow;
import CITS2200.Underflow;

public class DequeCyclic implements Deque<Object> {
	int left;
	Object[] deque;
	int size;
	
	/**
	 * DequeCyclic is a constructor
	 * @param s is the size of the array for the deque that you want to create
	 */
	public DequeCyclic(int s) {
		deque = new Object[s];
		left = 0;
		size = left;
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
	 * @throws Underflow If deque is empty, throws Underflow exception
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
	 * @throws Underflow If deque is empty, throws Underflow exception
	 */
	public Object peekRight() throws Underflow {
		if (isEmpty()) {
			throw new Underflow("Deque is empty, could not peekRight");
		} else {
			return deque[(left+size-1)%(deque.length)];
		}
	}

	/**
	 * popLeft returns the left most object in the queue after removing it from the deque
	 * @return Object Returns the object you wished to pop
	 * @throws Underflow If deque is empty, throws Underflow exception
	 */
	public Object popLeft() throws Underflow {
		if (isEmpty()) {
			throw new Underflow("Deque is empty, could not popLeft");
		} else {
			Object temp = deque[left];
			deque[left] = null;
			left = (left + 1) % (deque.length);
			size--;
			return temp;
		}
	}

	/**
	 * popRight returns the right most object in the queue after removing it from the deque
	 * @return Object Returns the object you wished to pop
	 * @throws Underflow If deque is empty, throws Underflow exception
	 */
	public Object popRight() throws Underflow {
		if (isEmpty()) {
			throw new Underflow("Deque is empty, could not popRight");
		} else {
			Object temp = deque[(left+size-1)%(deque.length)];
			deque[(left+size-1)%(deque.length)] = null;
			size--;
			return temp;
		}
	}

	/**
	 * pushLeft takes object o and adds it to the left of the deque
	 * @param o is the object being added to the deque
	 * @throws Overflow If deque is full, throws Overflow exception
	 */
	public void pushLeft(Object o) throws Overflow {
		if (isFull()) {
			throw new Overflow("Deque is full, could not pushLeft");
		} else {
			left -= 1;
			if (left < 0) {
				left = deque.length - 1;
			}
			deque[left] = o;
			size++;
		}
	}

	/**
	 * pushRight takes object o and adds it to the right of the deque
	 * @param o is the object being added to the deque
	 * @throws Overflow If deque is full, throws Overflow exception
	 */
	public void pushRight(Object o) throws Overflow {
		if (isFull()) {
			throw new Overflow("Deque is full, could not pushLeft");
		} else {
			deque[(left+size)%deque.length] = o;
			size++;
		}
	}

}
