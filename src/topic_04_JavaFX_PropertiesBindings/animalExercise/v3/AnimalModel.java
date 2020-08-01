package topic_04_JavaFX_PropertiesBindings.animalExercise.v3;

import javafx.beans.property.SimpleObjectProperty;
import topic_04_JavaFX_PropertiesBindings.animalExercise.v3.Animal.Geschlecht;
import topic_04_JavaFX_PropertiesBindings.petExercise.v3.Pet;

// 1
public class AnimalModel {
	//	private Animal currentAnimal;
	// 1 Speichert bzw . erzeugt das vom User zusammengestellte Tier und speichert es unter currentAnimal
	//	public void saveAnimal(Tierart tierArt, Animal.Geschlecht geschlecht, String name) {
	//		currentAnimal = new Animal(tierArt, geschlecht, name);
	//	}
	// 1 Löscht das currentAnimal
	//	public void deleteAnimal() {
	//		currentAnimal = null;
	//	}
	// 1 Getter
	//	public Animal getAnimal() {
	//		return currentAnimal;
	//	}
	private final SimpleObjectProperty<Animal> animalProperty = new SimpleObjectProperty<>();
	
	// 3 Speichert bzw . erzeugt das vom User zusammengestellte Tier und speichert es unter animalProperty
	public void saveAnimal(Tierart tierArt, Animal.Geschlecht geschlecht, String name) {
		animalProperty.set(new Animal(tierArt, geschlecht, name));
	} // 3 Löschen
	public void deleteAnimal() {
		animalProperty.set(null);
	} // 3 Getter
	public Animal getAnimal() {
		return animalProperty.get();
	} // Wrapp ein Property in ein Objekt
	public SimpleObjectProperty<Animal> animalProperty() {
		return animalProperty;
	}
}
