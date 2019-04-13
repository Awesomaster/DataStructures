import CITS2200.Overflow;
import CITS2200.Stack;
import CITS2200.Underflow;
import CITS2200.Link;

public class StackLinked implements Stack {
	Link stack;
	
	/**
	 * An array that we have taken some functionality from so that it acts as a stack to the user.
	 * @param s size of StackBlock
	 */
	public StackLinked() {
		stack = new Link(null, null);
	}

	/**
	 * examine() is a function that looks at the top element of the stack, and throws an exception if the stack is empty
	 * @return gives you a peek at the object on top of the stack
	 */
	public Object examine() throws Underflow {
		if (isEmpty()) {
			throw new Underflow("The stack is empty and thus you cannot examine anything");
		} else {
			return stack.item;
		}
	}

	/**
	 * isEmpty() is a function that checks if the stack is empty by seeing if the successor is null
	 * @return if the stack is empty
	 */
	public boolean isEmpty() {
		if (stack.successor == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * pop() is a function that takes the top value off the stack and give it to you
	 * @return gives you the object on top of the stack
	 */
	public Object pop() throws Underflow {
		if (isEmpty()) {
			throw new Underflow("You cant pop from an empty stack, silly.");
		}

		Object popable = stack.item;
		stack = stack.successor;
		return popable;
	}

	/**
	 * push(Object o) puts the object o on top of the stack
	 * @param o the object you wish to put on the stack
	 */
	public void push(Object o) throws Overflow {
		Link temp = new Link(o, stack);
		stack = temp;
	}

}
