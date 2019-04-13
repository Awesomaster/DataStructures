import java.lang.invoke.MethodHandles;

import CITS2200.BinaryTree;
import CITS2200.Iterator;
import CITS2200.OutOfBounds;
import CITS2200.WindowLinked;

public class BinTree<A> extends BinaryTree<A> {
	
	public BinTree() {
		super();
	}
	
	public BinTree(A item, BinaryTree<A> b1, BinaryTree<A> b2) {
		super(item, b1, b2);
	}
	
	/**
	 * Are they equal. Maybe?
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof BinaryTree) {
			return equals2ElectricBoogaloo((BinaryTree<A>)o, this);
		}
		return false;
	}
	
	/**
	 * Tests if equal
	 * @param you you
	 * @param me me
	 * @return if it is
	 */
	private boolean equals2ElectricBoogaloo(BinaryTree<A> you, BinaryTree<A> me) {
		if (you.isEmpty() && !me.isEmpty()) {
			return false;
		}
		else if (me.isEmpty() && !you.isEmpty()) {
			return false;
		}
		else if (me.isEmpty() && you.isEmpty()) {
			return true;
		}
		else if (!me.isEmpty() && !you.isEmpty() && you.getItem().equals(me.getItem())) {
			return equals2ElectricBoogaloo(you.getLeft(), me.getLeft()) && equals2ElectricBoogaloo(you.getRight(), me.getRight());
		}
		return false;
	}

	/**
	 * iterates
	 */
	@Override
	public Iterator<A> iterator() {
		// TODO Auto-generated method stub
		return new BasicTreeIterator();
	}
	
	private class BasicTreeIterator implements Iterator<A> {
		private ListLinked listy;
		private WindowLinked w;
		
		private BasicTreeIterator() {
			w = new WindowLinked();
			listy = new ListLinked();
			listy.beforeFirst(w);
			listy.insertAfter(new BinTree<A>(getItem(), getLeft(), getRight()), w);
		}
		
		/**
		 * does it have next
		 */
		@Override
		public boolean hasNext() {
			return !listy.isEmpty();
		}

		/**
		 * return next
		 */
		@Override
		public A next() throws OutOfBounds {
			listy.beforeFirst(w);
			listy.next(w);
			BinaryTree<A> bin = (BinaryTree<A>) listy.delete(w);
			listy.beforeFirst(w);
			try {
				if (!bin.getLeft().isEmpty()) {
					listy.insertAfter(bin.getLeft(), w);
				}
				if (!bin.getRight().isEmpty()) {
					listy.insertAfter(bin.getRight(), w);
				}
				listy.beforeFirst(w);
				return bin.getItem();
			} catch (OutOfBounds a) {
				throw new OutOfBounds("OOB");
			}
		}
	}
}
