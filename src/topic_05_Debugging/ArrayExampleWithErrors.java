package topic_05_Debugging;

public class ArrayExampleWithErrors {

	// Args = SInd die eingehenden String Parameter
	public static void main(String[] args) {
		int[] numsIn;
		int[] numsOut;

		// Convert command-line args to integer array
		numsIn = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			numsIn[i] = Integer.parseInt(args[i]);
		}

		// Create the second array
		// WRONG: funktioniert nur bei Gerader Anzahl
//		int lengthNumsOut = numsIn.length / 2; // error
		// RIGHT
		int lengthNumsOut = (numsIn.length + 1) / 2;
		numsOut = new int[lengthNumsOut]; // Somit haben wir ein Array mit Platz f�r 3

		// Process the first array into the second
		// Example 1 mit Zahlen 3,7,5,3,4,2 als Parameter
		for (int i = 0; i < lengthNumsOut; i++) {
			// WRONG: numsIn.length - i ergibt 6-0= 0, aber wir haben kein 6. Element
//			numsOut[i] = numsIn[i] + numsIn[numsIn.length - i]; // error
			// RIGHT:
			numsOut[i] = numsIn[i] + numsIn[numsIn.length - i - 1];
		}

		// Print the result
		// Example 1 mit Zahlen 3,7,5,3,4,2 als Parameter
		// WRONG : Arrays lassen sich so nicht ausgeben
//		System.out.println(numsOut); // error
		// RIGHT
		for (int result : numsIn) {
			System.out.println(result);
		}

	}
}
