package aa_A_KeyConcepts.h.Datenstrukturen;

import java.util.TreeSet;

public class TreeSetExamples {
	
	public static void main(String[] args) {
		
		/**
		 * Add the strings from the array to a Treeset. 
		 * Then print all strings from the Treeset
		 */
		String[] names = {"ann", "tom", "bob", "sue", "mel"};
		
		// DEKLARIERE und INITIALISIERE das Treeset
		TreeSet<String> tree = new TreeSet<>();
		// ADD all strings to a TreeSet
		for (String name : names) {
			tree.add(name);
		}
		// PRINT all strings from the TreeSet
		for (String name : names) {
			System.out.println(name);
		}
	}

}
