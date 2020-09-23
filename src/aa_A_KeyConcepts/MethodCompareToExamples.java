package aa_A_KeyConcepts;

public class MethodCompareToExamples {
	
	// BESCHREIBUNG DER METHODE :compareTo
	// Null ist, wenn die beiden Objekte name1 und name2 identisch sind.
	// negativ ist, wenn das aufrufende Objekt name1 kleiner ist als das Objekt
	// name2, das als Parameter übergeben wird.
	// positiv ist, wenn das aufrufende Objekt name1 grösser ist als das Objekt
	// name2, das als Parameter übergeben wird.
	public int compareTo(Dice otherDice) {
		return this.points - otherDice.getPoints();
	}
	if (compValue == 0)
		System.out.println("Gleiche Namen");
	else if (compValue < 0)
		System.out.println(name1 + " ist kleiner");
	else
		System.out.println(name2 + " ist kleiner");


}
