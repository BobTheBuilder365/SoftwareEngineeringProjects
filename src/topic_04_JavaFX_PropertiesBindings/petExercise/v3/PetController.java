package topic_04_JavaFX_PropertiesBindings.petExercise.v3;


import javafx.event.ActionEvent;
import topic_00_CourseSummary.Pet;
import topic_00_CourseSummary.Pet.Gender;
import topic_00_CourseSummary.Pet.Species;

//0
public class PetController {
	private PetView view;
	private PetModel model;

	// 0
	public PetController(PetModel model, PetView view) {
		this.model = model;
		this.view = view;
		
		// 2 Buttons unter Aktion setzen und bestimmen welche Methode ausgeführt werden soll
		view.btnSave.setOnAction(this::save);
		view.btnDelete.setOnAction(this::delete);
		
		// 3 Wenn nichts im Property gespeichert ist, daktiviere Delete Button (z.B. wenn gerade gelöscht wurde)
		view.btnDelete.disableProperty().bind(model.petProperty().isNull());
		// 3 Wenn kein Name im Textfeld eingegeben ist, deaktivere den Save Button
		view.btnSave.disableProperty().bind(view.txtName.textProperty().isEmpty());
	}
	
	// 2 - Die vom User ausgewählte Variablen holen, prüfen ob gültig,speichern und updaten
	private void save(ActionEvent e) {
		Species species = view.cmbSpecies.getValue();
		Gender gender = view.cmbGender.getValue();
		String name = view.txtName.getText();
		if (species != null && gender != null && name != null && name.length() > 0) {
			model.savePet(species, gender, name);
			updateView(model.getPet());
		}
	}
	// 2 Löschen und updaten
	private void delete(ActionEvent e) {
		model.deletePet();
		updateView(model.getPet());
	}
	// 2 Methode für View update
	private void updateView(Pet pet) {
		if (pet != null) {
			view.lblDataID.setText(Integer.toString(pet.getID()));
			view.lblDataName.setText(pet.getName());
			view.lblDataSpecies.setText(pet.getSpecies().toString());
			view.lblDataGender.setText(pet.getGender().toString());
		} else {
			view.lblDataID.setText("");
			view.lblDataName.setText("");
			view.lblDataSpecies.setText("");
			view.lblDataGender.setText("");
		}
	}
}
