package topic10_JavaAppTemplate.globalResources.singleton;

/**
 * BEISPIELE FACTORY METHODEN
 */

import java.time.LocalDate;

public class WoofMain {
	
	public static void main(String[] args) {
		Woof w = Woof.makeWoof(0); // Factory Methode von Woof
		
		// Die Factory Methode 'now' von LocalDate
		// liefert mir ein Objekt mit heutigem Datum
		LocalDate today = LocalDate.now();
		
		// Die Factory Methode 'of' von LocalDate 
		// liefert mir ein Objekt mit Datum, welches als Prameter mitgegeben wurde
		// LocalDate.of(year, month, dayOfMonth)
		LocalDate weihnachten = LocalDate.of(2020, 12, 25); 
	}

}
