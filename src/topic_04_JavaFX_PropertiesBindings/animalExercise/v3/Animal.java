package topic_04_JavaFX_PropertiesBindings.animalExercise.v3;

// 0
public class Animal {
	
	private static int highestID = -1;
	
	public enum Geschlecht { Männchen, Weibchen}; 

	private final int ID;
	private Tierart tierArt; // ausgelagertes Enum
	private Geschlecht geschlecht;
	private String name;
	
	// Konstruktor wo Tierart und Geschlecht bestimmt werden muss
	public Animal(Tierart tierart, Geschlecht geschlecht, String name) {
		highestID++;
		this.ID = getNextID();
		this.tierArt = tierArt;
		this.geschlecht = geschlecht;
		this.name = name;	
	}

	// Methode um dem Objekt die nächste ID zuzuweisen
	private static int getNextID() {
		return highestID++;
	}

	
	// Getter für ID
	public int getID() {
		return this.ID;
	}
	
	// Getter und Setter für Rest
	public void setTierArt(Tierart tierart) {
		this.tierArt = tierart;
	}
	public Tierart getTierArt() {
		return this.tierArt;
	}
	
	public void setGeschlecht(Geschlecht geschlecht) {
		this.geschlecht = geschlecht;	
	}
	public Geschlecht getGeschlecht() {
		return this.geschlecht;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
