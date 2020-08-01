package topic_04_JavaFX_PropertiesBindings.animalExercise.v3;

import javafx.event.ActionEvent;
import topic_04_JavaFX_PropertiesBindings.animalExercise.v3.Animal.Geschlecht;
import topic_04_JavaFX_PropertiesBindings.animalExercise.v3.AnimalModel;
import topic_04_JavaFX_PropertiesBindings.animalExercise.v3.AnimalView;

// 0
public class AnimalController {
	private AnimalModel model;
	private AnimalView view;
	
	// 0
	public AnimalController(AnimalModel model, AnimalView view) {
		this.model = model;
		this.view = view;
		
		// 2 Buttons unter Aktion setzen und bestimmen welche Methode ausgeführt werden soll
		view.btnSave.setOnAction(this::save);
		view.btnDelete.setOnAction(this::delete);

		// 3 Wenn nichts im Property gespeichert ist, daktiviere Delete Button (z.B. wenn gerade gelöscht wurde)
		view.btnDelete.disableProperty().bind(model.animalProperty().isNull());
		// 3 Wenn kein Name im Textfeld eingegeben ist, deaktivere den Save Button
		view.btnSave.disableProperty().bind(view.txtName.textProperty().isEmpty());
		
	}
	
	// 2 - Die vom User ausgewählte Variablen holen, prüfen ob gültig,speichern und updaten
	private void save(ActionEvent event) {
		Tierart tierArt = view.cmbTierArt.getValue();
		Geschlecht geschlecht = view.cmbGeschlecht.getValue();
		String name = view.txtName.getText();
		if (tierArt != null && geschlecht != null && name != null & name.length() > 0) {
			model.saveAnimal(tierArt, geschlecht, name);
			updateView(model.getAnimal());
		}	
	}
	// 2 Löschen und updaten
	private void delete(ActionEvent event) {
		model.deleteAnimal();
		updateView(model.getAnimal());	
	}
	// 2 Methode für View update
	private void updateView(Animal animal) {
		if (animal != null) {
			// In View auf Label Text setzen, Zahl to String, Name holen, Enums to String
			view.lblDataID.setText(Integer.toString(animal.getID()));
			view.lblDataName.setText(animal.getName());
			view.lblDataTierArt.setText(animal.getTierArt().toString());
			view.lblDataGeschlecht.setText(animal.getGeschlecht().toString());
		} else { // Anonsten "leeren" String setzen
			view.lblDataID.setText("");
			view.lblDataName.setText("");
			view.lblDataTierArt.setText("");
			view.lblDataGeschlecht.setText("");
		}
		
	}
}
