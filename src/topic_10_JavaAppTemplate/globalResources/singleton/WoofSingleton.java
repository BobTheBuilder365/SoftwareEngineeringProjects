package topic_10_JavaAppTemplate.globalResources.singleton;

/**
 * Diese Klasse möchte sicherstellen das es NUR EIN Objekt der Klasse gibt. Dazu
 * brauchen wir eine Factory Methode, weil wir eben die Erstellung von neuen
 * Objekten steuern wollen.
 */

public class WoofSingleton {

	// Das wird die EINZIGE Instanz dieser Klasse sein
	private static WoofSingleton singleton = null; // INITIAL haben wir KEIN Objekt der Klasse erstellt
	// Somit ist Initial auch kein Objekt der Klasse erstellt

	// Objektattribut
	private int x;

	private WoofSingleton() {
		x = 0;
	}

	/**
	 * Factory Methode, um das Design Pattern Singleton zu veranschaulichen Möchten
	 * nur 1 Objekt erlauben
	 * 
	 */
	public static WoofSingleton makeWoof() {
		// Prüfen erst ob wir bereits ein Objekt haben
		if (singleton == null) // Haben wir kein Objekt? Dann:
			singleton = new WoofSingleton(); // Erstelle neues Objekt und sonst:
		// Retourniere das Objekt (Falls bereits eines vorhanden ist, wird die IF
		// Bedingung
		// übersprungen und das Objekt zurückgeliefert
		return singleton;

	}

}
