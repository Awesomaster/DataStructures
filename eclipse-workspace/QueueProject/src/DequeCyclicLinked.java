import CITS2200.Link;
import CITS2200.Queue;
import CITS2200.Underflow;

public class DequeCyclicLinked implements Queue {
	Link queue;
	Link first;
	
	public DequeCyclicLinked() {
		queue = new Link(null, null);
		first = queue;
	}
	
	
	@Override
	public Object dequeue() throws Underflow {
		Object temp = first.item;
		if (isEmpty()) {
			throw new Underflow("Cannot deque nothing");
		} else {
			first = first.successor;
			return temp;
		}
	}

	@Override
	public void enqueue(Object arg0) {
		
	}

	@Override
	public Object examine() throws Underflow {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
