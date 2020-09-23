package aa_A_KeyConcepts.h.Datenstrukturen;

import java.util.ArrayList;

public class ArrayListExamples {
	
	public static void main(String[] args) {
		
		
		String[] names = {"ann", "tom", "bob", "sue", "mel"};
		ArrayList<String> firstHalf = new ArrayList<>();
		ArrayList<String> secondHalf = new ArrayList<>();
		
		// ADD all names that begin with letters (a-m) to "firstHalf",
		// ADD all others to "secondHalf"
		for (String name : names) {
			if (name.compareTo("n") < 0) {
				firstHalf.add(name);
			} else {
				secondHalf.add(name);
			}
		}
	}

}
