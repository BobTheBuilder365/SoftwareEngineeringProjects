package topic_04_JavaFX_PropertiesBindings.animalExercise.v2;

import topic_04_JavaFX_PropertiesBindings.animalExercise.v1.Animal.Geschlecht;

// 1
public class AnimalModel {
	private Animal currentAnimal;

	// 1 Speichert bzw . erzeugt das vom User zusammengestellte Tier und speichert es unter currentAnimal
	public void saveAnimal(Tierart tierArt, Animal.Geschlecht geschlecht, String name) {
		currentAnimal = new Animal(tierArt, geschlecht, name);
	}
	// 1 Löscht das currentAnimal
	public void deleteAnimal() {
		currentAnimal = null;
	}
	// 1 Getter
	public Animal getAnimal() {
		return currentAnimal;
	}
	
}
