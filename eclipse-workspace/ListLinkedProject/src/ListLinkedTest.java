/** 
 * Written by Josh Collier, 2019.
 */

import java.util.Random;

import CITS2200.ListLinked;
import CITS2200.WindowLinked;
import CITS2200.OutOfBounds;

public class ListLinkedTest
{
	/** Prints usage and terminates program */
	public static void usage() {
		System.out.println("Usage:");
		System.out.println("e.g. For testing a random list:");
		System.out.println("  java ListLinked");
		System.exit(1);
	}

	/** Prints error message and terminates program */
	public static void pperr(String msg) {
		System.out.println("Error:");
		System.out.println(msg);
		System.exit(1);
	}


	/** Method for testing a given array of long integers for debugging.
	 *  @param a the array of longs to be sorted.
	 */
	public static void testMain(ListLinked list, WindowLinked w, Object[] oArr)
	{
		// print contents of array a before sorting
		System.out.println("Starting list operations");
		list.beforeFirst(w);
		System.out.println("1) beforeFirst(w); Window is centred on the 'before' link");
		// Both are being counted in length and we are starting position at 1 just for sake of consistency and understanding
		int pos = 1; // Position 1 is before list
		int length = 2; // Length is after list
		
		for (int n = 2; n <= 1000; n++) {
			Random rand = new Random();
			try {
				switch (rand.nextInt(12)) {
					case 0:
						System.out.print(n + ") afterLast(w); ");
						System.out.print("pos:"+pos+" size:"+length+"; ");
						list.afterLast(w);
						System.out.println("Set window pos to 'after'");
						pos = length;
						break;
					case 1:
						System.out.print(n + ") beforeFirst(w); ");
						System.out.print("pos:"+pos+" size:"+length+"; ");
						list.beforeFirst(w);
						System.out.println("Set window pos to 'before'");
						pos = 1;
						break;
					case 2:
						System.out.print(n + ") delete(w); ");
						System.out.print("pos:"+pos+" size:"+length+"; ");
						list.delete(w);
						if ((pos==0)||(pos ==length)) {
							System.out.println("A VERY LARGE ERROR HAS OCCURED");
						}
						System.out.println("Deleted the current w");
						length-= 1;
						break;
					case 3:
						System.out.print(n + ") examine(w); ");
						System.out.print("pos:"+pos+" size:"+length+"; ");
						System.out.println("Examined: " + list.examine(w));
						break;
					case 4:
						int after = rand.nextInt(7);
						System.out.print(n + ") insertAfter(o, w); ");
						System.out.print("pos:"+pos+" size:"+length+"; ");
						list.insertAfter(oArr[after], w);
						System.out.println("Placing " + oArr[after] + " after w");
						length+=1;
						break;
					case 5:
						int before = rand.nextInt(7);
						System.out.print(n + ") insertBefore(o, w); ");
						System.out.print("pos:"+pos+" size:"+length+"; ");
						list.insertBefore(oArr[before], w);
						System.out.println("Placing " + oArr[before] + " before w");
						pos+=1;
						length+=1;
						break;
					case 6:
						System.out.print(n + ") isAfterLast(w); ");
						System.out.print("pos:"+pos+" size:"+length+"; ");
						System.out.println("Is the window after last? " + list.isAfterLast(w));
						break;
					case 7:
						System.out.print(n + ") isBeforeFirst(w); ");
						System.out.print("pos:"+pos+" size:"+length+"; ");
						System.out.println("Is the window before first? " + list.isBeforeFirst(w));
						break;
					case 8:
						System.out.print(n + ") isEmpty(); ");
						System.out.print("pos:"+pos+" size:"+length+"; ");
						System.out.println("Is the boy empty? " + list.isEmpty());
						break;
					case 9:
						System.out.print(n + ") next(w); ");
						System.out.print("pos:"+pos+" size:"+length+"; ");
						pos+=1;
						list.next(w);
						System.out.println("We went next");
						break;
					case 10:
						System.out.print(n + ") previous(w); ");
						System.out.print("pos:"+pos+" size:"+length+"; ");
						list.previous(w);
						pos-=1;
						System.out.println("We went to previous");
						break;
					case 11:
						int replaced = rand.nextInt(7);
						System.out.print(n + ") replace(o, w); ");
						System.out.print("pos:"+pos+" size:"+length+"; ");
						System.out.println("Replacing " + list.replace(oArr[replaced], w) + " with " + oArr[replaced]);
						break;
				}
			} catch (OutOfBounds oob) {
				System.out.println("ERROR: (" + oob + ")");
			}
		}
		
	}

	/** Method for testing an array of randomly generated
	 *  long integers.
	 *  @arg size the length of the array to be generated.
	 */
	public static void runMain() {
		ListLinked list = new ListLinked();
		WindowLinked w = new WindowLinked();
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		Object d = new Object();
		Object e = new Object();
		Object f = new Object();
		Object g = new Object();
		Object[] oArr = {a,b,c,d,e,f,g};
		testMain(list, w, oArr);
	}

	public static void main(String[] args)
	{
		if (args.length!=0) {
			usage();
		} else {
			runMain();
		}
	}
}
