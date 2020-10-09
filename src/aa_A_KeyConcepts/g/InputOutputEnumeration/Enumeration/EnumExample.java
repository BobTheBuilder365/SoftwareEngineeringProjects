package aa_A_KeyConcepts.g.InputOutputEnumeration.Enumeration;

/**
 * Wie man Enum's benutzt
 * 
 * @author matth
 *
 */

// Access: Wie bei einer Klasse
//
// Beschreibung: Enums sind Listen von Werten (auch Aufzählungen genannt) die nicht ändern
// Setup: Wie bei einer Klasse
// Inhalt: Werte
// Enum Konvetionen: Enum Einzahl und Werte der Aufzählung in Grossbuchstaben
// Wieso Enums nutzen? -> Wir nutzen Enums für Dinge die nicht ändern, einfacher und sauberer als ein Array von Strings mit Enums
public class EnumExample {

	// Enum innerhalb einer Klasse
	enum Flavor {
		CHOCOLATE, VANILLA, STRAWBERRY;
		
		public static void getVanilla() {
			System.out.println(Flavor.VANILLA);
		}
	}

	// Arrays können unterschiedlichste Typen annehmen
	static String[] levelsAsStringArray = { "Low", "Medium", "High" };

	public static void main(String[] args) {

		System.out.println(levelsAsStringArray[0]); // Low
		System.out.println(levelsAsStringArray[1]); // Medium
		System.out.println(levelsAsStringArray[2]); // High

		System.out.println(Level.HIGH); // HIGH
		Level l = Level.LOW;
		System.out.println(l); // LOW

		// Beispiel Videospiel mit unterschiedlichen Levels
		switch (l) { // Wie ein If-else Statement
		case LOW:
			System.out.println("Low level"); // Low level
			break;
		case MEDIUM:
			System.out.println("Medium level");
			break;
		case HIGH:
			System.out.println("High level");
			break;
		default:
			System.out.println("Nichts ausgewählt");
			break;
		}

		// Funktionieren beide Flavor. oder flav.
		Flavor flav = Flavor.VANILLA;
		if (flav == Flavor.VANILLA) { // Überflüssig, nur um zu zeigen, dass beides geht
		}
		if (flav == flav.VANILLA) {
			System.out.println("it's vanilla"); // It's vanilla
		} else if (flav == flav.CHOCOLATE) {
			System.out.println("it's chocolate");
		} else if (flav == flav.STRAWBERRY) {
			System.out.println("it's strawberry");
		}

		flav.getVanilla(); // VANILLA
	}

// Enum ausserhalb einer Klasse
enum Level {

	LOW, MEDIUM, HIGH;}
}