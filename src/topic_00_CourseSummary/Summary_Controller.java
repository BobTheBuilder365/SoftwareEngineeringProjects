package topic_00_CourseSummary;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import topic_00_CourseSummary.Pet.Gender;
import topic_00_CourseSummary.Pet.Species;


//Stufe 0 = Basis MVC Struktur
//Stufe 1 = Die View
//Stufe 1.1 Kontrollelemente - Controls used for data processing
//Stufe 2 = Geschäftslogik
//Stufe 2.1 Instanzvariabelen
//Stufe 2.2 Methoden des Models
//Stufe 3 = EventHandling und die dazu erforderlichen Methoden
//Stufe 3.1 Kontrollelemente unter Action setzen und Data Binding vornehmen
//Stufe 3.2 Methoden um die Events im Model und View zu bearbeiten

public class Summary_Controller {
	
	// 0 Controller muss Model und View kennen
	final private Summary_Model model;
	final private Summary_View view;

	// 0 Konstruktor
	public Summary_Controller(Summary_Model model, Summary_View view) {
		this.model= model;
		this.view = view;
		// TODO Auto-generated constructor stub
		
		
		// 3 Dice (Eine Methoe für mehrere Buttons)
		for (Button btn : view.dice) {
			btn.setOnAction(this::roll);
		}
		
		
		//	3.1 Pet - Properties Bindings				
		// Kontrollelemente unter Aktion setzen
		view.btnSave.setOnAction(this::save);
		view.btnDelete.setOnAction(this::delete);
		// Data Binding
		view.btnDelete.disableProperty().bind(model.petProperty().isNull());
		view.btnSave.disableProperty().bind(view.txtName.textProperty().isEmpty());
	}

	// 3.2 Dice 
	private void roll(ActionEvent e) {
		// Get the button that was clicked
		Button btn = (Button) e.getSource();		
		// Roll a new value, and place the value into the button
		int value = model.getRandomValue();
		String s = Integer.toString(value);
		btn.setText(s);
	}	

	
	//	3.2 Pet - Properties Bindings		
	private void save(ActionEvent e) {
		Species species = view.cmbSpecies.getValue();
		Gender gender = view.cmbGender.getValue();
		String name = view.txtName.getText();
		if (species != null && gender != null && name != null && name.length() > 0) {
			model.savePet(species, gender, name);
			updateView(model.getPet());
		}
	}
	//	3.2 Pet - Properties Bindings		
	private void delete(ActionEvent e) {
		model.deletePet();
		updateView(model.getPet());
	}
	//	3.2 Pet - Properties Bindings	
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