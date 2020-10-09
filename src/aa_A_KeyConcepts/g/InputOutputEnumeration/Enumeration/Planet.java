package aa_A_KeyConcepts.g.InputOutputEnumeration.Enumeration;

public enum Planet {
	MERCURY(3.3011e+23, 2.4397e6) {
		public String weather() { // Ueberschriebene weather Methode für das Objekt MECURY
			return "too hot";
		}
	},
	VENUS(4.3011e+23, 6.4397e6), EARTH(5.9011e+23, 6.4397e6), MARS(6.3011e+23, 3.4397e6) {
		public String weather() {
			return "too cold";
		}
	};

	// Planet = Objekt, Masse und Radius = Objekt Attribute

	// KLASSEN ATTRIBUT
	// Universale Gravitations Konstante (m3 kg-1 s-2
	public static final double G = 6.76300E-11;

	
	private final double mass; // In Kilogramm
	private final double radius; // In Metern

	private Planet(double mass, double radius) {
		this.mass = mass;
		this.radius = radius;
	}

	// OBJEKT METHODE
	public double surfaceGravity() {
		return G * mass / (radius * radius);
	}

	// OVERLOADING METHODE (Allgemeine METHODE zum überschreiben bei einzelnen
	// Objekten)
	public String weather() {
		return "unknown";
	}

	public double getMass() {
		return this.mass;
	}

	public double getRadius() {
		return this.radius;
	}
}
