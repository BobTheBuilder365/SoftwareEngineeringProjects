package topic_00_CourseSummary;

import javafx.beans.property.SimpleObjectProperty;

//Stufe 0 = Basis MVC Struktur
//Stufe 1 = Die View
//Stufe 1.1 Kontrollelemente - Controls used for data processing
//Stufe 2 = Geschäftslogik
//Stufe 2.1 Instanzvariabelen
//Stufe 2.2 Methoden des Models
//Stufe 3 = EventHandling und die dazu erforderlichen Methoden
//Stufe 3.1 Kontrollelemente unter Action setzen und Data Binding vornehmen
//Stufe 3.2 Methoden um die Events im Model und View zu bearbeiten

// 0
public class Summary_Model {

	// 0 Konstruktor
	protected Summary_Model() {

	}

	
	// 2.2 Dice
	public int getRandomValue() {
		return (int) (Math.random() * 6 + 1);
	}

	
	// 2.1 Pet - Properties Bindings
	private final SimpleObjectProperty<Pet> petProperty = new SimpleObjectProperty<>();

	// 2.2 Pet - Properties Bindings
	public void savePet(Pet.Species species, Pet.Gender gender, String name) {
		petProperty.set(new Pet(species, gender, name));
	}
	
	// 2.2 Pet - Properties Bindings	
	public void deletePet() {
		petProperty.set(null);
	}
	
	// 2.2 Pet - Properties Bindings	
	public Pet getPet() {
		return petProperty.get();
	}
	
	// 2.2 Pet - Properties Bindings	
	public SimpleObjectProperty<Pet> petProperty() {
		return petProperty;
	}
}
