package topic_04_JavaFX_PropertiesBindings.petExercise.v3;


import javafx.beans.property.SimpleObjectProperty;
import topic_00_CourseSummary.Pet;

public class PetModel {
	private final SimpleObjectProperty<Pet> petProperty = new SimpleObjectProperty<>();
	
	// 3 Speichert bzw . erzeugt das vom User zusammengestellte Tier und speichert es unter animalProperty
	public void savePet(Pet.Species species, Pet.Gender gender, String name) {
		petProperty.set(new Pet(species, gender, name));
	}
	
	// LOESCHEN
	public void deletePet() {
		petProperty.set(null);
	}
	// Getter für den WERT
	public Pet getPet() {
		return petProperty.get();
	}
	// Wrapp ein Property in ein Objekt (UM DAS OBJEKT SELBST ZU HOLEN)
	public SimpleObjectProperty<Pet> petProperty() {
		return petProperty;
	}
}
