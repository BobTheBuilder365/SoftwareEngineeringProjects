package aa_A_KeyConcepts.Datenstrukturen;

public class ArrayExamples {
	
	public static void main(String[] args) {
		
		int[] numbers = { 1, 2, 3, 4, 5};
		int sum = 0;
		
		// SUMMIERE die integer Werte
		for (int number : numbers) {
			sum += number;
		}
		// PRINT die integer Werte
		System.out.println(sum); // 15
		
		// PRINT die UNGERADEN Werte
		for (int number : numbers) {
			if (number % 2 == 1) {
				System.out.println(number); // 1 3 5
			}
		}
		// PRINT die GERADEN Werte
		for (int number : numbers) {
			if (number % 2 == 0) {
				System.out.println(number); // 2 4
			}
		}
		
		String[] names = {"ann", "tom", "bob", "sue", "mel"};
		// REVERSE the order of names in the array
		for (int i = 0; i < names.length / 2; i++) {
			swap(names, i, names.length -1 - i);
		}
		for (String name : names) {
			System.out.println(name);
		}
	}
	
	// Methode um Reverse the order of names in the array zu erledigen
	public static void swap(String[] array, int pos1, int pos2) {
		String temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;
	}


}
