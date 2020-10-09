package aa_A_KeyConcepts.g.InputOutputEnumeration.Enumeration;

public class EnumerationExample {
	
	//.ordinal gibt Position des Enums zurück

	enum Gender {
		MALE, FEMALE, UNKNOWN; // = public static final Gender MALE = new Gender("MALE", 0)

		// Lieferte alle definierten Werte des Enums als Array
		public void printGenderValues() {
			Gender[] all = Gender.values(); // Liefert alle Werte
			for (Gender val : all) {
				System.out.println(val); // Druckt alle Werte
			}
		}

	}

	// Methode wandelt einen String(z.B. "FEMALE") in das entsprechende
	// Gender-Objekt um
	public static Gender stringTOEnum(String input) {
		String temp = input;
		Gender g = Gender.valueOf(temp); // Nimmt einen Wert
		return g;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person pl = new Person("Joe", Gender.MALE);
		Gender gen = pl.getGender();
		switch (gen) {
		case MALE:
			System.out.println("Lieber " + pl.getName());
			break;
		case FEMALE:
			System.out.println("Liebe " + pl.getName());
			break;
		default:
			System.out.println("Hallo " + pl.getName());
			break;
		}

		// Wandelt einen String(z.B. "FEMALE") in das entsprechende Gender-Objekt um
		String input = "FEMALE";
		Gender f = Gender.valueOf(input);
		System.out.println(f);

		System.out.println("String zu Enum " + stringTOEnum("FEMALE"));

	}

}
