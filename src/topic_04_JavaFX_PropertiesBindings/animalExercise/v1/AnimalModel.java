package topic_04_JavaFX_PropertiesBindings.animalExercise.v1;

// 1
public class AnimalModel {
	private Animal currentAnimal;

	// 1 Speichert bzw . erzeugt das vom User zusammengestellte Tier und speichert es unter currentAnimal
	public void savePet(Tierart tierArt, Animal.Geschlecht geschlecht, String name) {
		currentAnimal = new Animal(tierArt, geschlecht, name);
	}
	// 1 Löscht das currentAnimal
	public void deletePet() {
		currentAnimal = null;
	}
	// 1 Getter
	public Animal getPet() {
		return currentAnimal;
	}
}
