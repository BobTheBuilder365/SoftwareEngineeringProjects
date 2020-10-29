package aa_A_KeyConcepts.h.Datenstrukturen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Example 3 Using the Collections Class
/*
 * In addition to the methods found in List and Map, the Collections class exposes a number of static utility methods that operate on or return collections. Example 3 demonstrates a few such methods by creating a List, then using the Collections class to reverse, swap, and sort its elements.
 * 
 * This program first adds the letters a b c and d to a List, again using ArrayList as the concrete implementation.) It then reverses the elements of the list by invoking Collections.reverse(list). To swap the elements around within the List, the program invokes the Collections.swap method (For example, Collections.swap(list,0,3) swaps the elements at index positions 0 and 3. Finally, the Collections.sort() method alphabetically sorts the elements.
 */


public class CollectionsDemoUsingTheCollectionClass {
	public static void main(String[] args) {
		System.out.println("Creating the list...");
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		printElements(list);
		System.out.println("Reversing the elements...");
		Collections.reverse(list);
		printElements(list);

		System.out.println("Swapping the elements around...");
		Collections.swap(list, 0, 3);
		Collections.swap(list, 2, 0);
		printElements(list);

		System.out.println("Alphabetically sorting the elements...");
		Collections.sort(list);
		printElements(list);
	}

	private static void printElements(List<String> list) {
		for (Object o : list) {
			System.out.println(o.toString());
		}
	}

	/*
	 * The output of Example 3 is as follows:
	 * 
	 * Creating the list...
	 * 
	 * a
	 * 
	 * b
	 * 
	 * c
	 * 
	 * d
	 * 
	 * Reversing the elements...
	 * 
	 * d
	 * 
	 * c
	 * 
	 * b
	 * 
	 * a
	 * 
	 * Swapping the elements around...
	 * 
	 * b
	 * 
	 * c
	 * 
	 * a
	 * 
	 * d
	 * 
	 * Alphabetically sorting the elements...
	 * 
	 * a
	 * 
	 * b
	 * 
	 * c
	 * 
	 * d
	 */
}
