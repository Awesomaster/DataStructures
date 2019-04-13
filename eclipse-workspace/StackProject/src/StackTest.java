
public class StackTest {
	
	private static void test() {
		Object o = new Object();
		
		StackBlock stack = new StackBlock(5);
		stack.push(o);
		System.out.println("pushed 1 Is it full?"+stack.isFull());
		stack.push(o);
		System.out.println("pushed 2 Is it full?"+stack.isFull());
		stack.push(o);
		System.out.println("pushed 3 Is it full?"+stack.isFull());
		stack.push(o);
		System.out.println("pushed 4 Is it full?"+stack.isFull());
		stack.push(o);
		System.out.println("pushed 5 Is it full?"+stack.isFull());
		stack.push(o);
		System.out.println("pushed 6 Is it full?"+stack.isFull());
		
	}
	
	public static void main(String[] args) {
		test();
		
	}
	
}
