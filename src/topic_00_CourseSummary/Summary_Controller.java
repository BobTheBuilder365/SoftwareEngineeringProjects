package topic_00_CourseSummary;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import topic_00_CourseSummary.Pet.Gender;
import topic_00_CourseSummary.Pet.Species;


public class Summary_Controller {
	
	// 0 Controller muss Model und View kennen
	final private Summary_Model model;
	final private Summary_View view;

	// 0 Konstruktor
	protected Summary_Controller(Summary_Model model, Summary_View view) {
		this.model= model;
		this.view = view;
		// TODO Auto-generated constructor stub
		
		
		// 3.1 Dice (Eine Methoe für mehrere Buttons)
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

	
		// 3.1 TicTacToe
		// "abonniert" die Buttons und setz diese auf Aktion wenn ein Button gedrückt wird
		for (int col = 0; col < view.buttons.length; col++) {
			for (int row = 0; row < view.buttons[0].length; row++) {
				view.buttons[col][row].setOnAction(this::buttonClick);
			}
		}
		
		
		// 3.1 EmailValidator
		view.txtEmail.textProperty().addListener(
				// Parameters of any PropertyChangeListener
				(observable, oldValue, newValue) -> validateEmailAddress(newValue));
		
		
		// 3.1 ModelPropertyExample
		// register ourselves to listen for property changes in the model. Each change results in a short animation.
		model.valueProperty().addListener( (observable, oldValue, newValue) -> {
		        String newText = Integer.toString(model.getValue());
		        
		        // Move to the JavaFX thread
		        Platform.runLater(new Runnable() {
		            @Override public void run() {
				        view.lblNumber.setText(newText);        
						view.doAnimate();
		            }
		        });
			}
        );
		// 3.1 ModelPropertyExample
		// register ourselves to listen for button clicks
		view.btnClick.setOnAction((event) -> {
		        model.incrementValue();
		        String newText = Integer.toString(model.getValue());
		        view.lblNumber.setText(newText);        
			}
		);
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
	
	
	// 3.2 TicTacToe
	private void buttonClick(ActionEvent e) {
		// Finde den Button - Auf welchen Button hat der User gedrückt?)
		Button btn = (Button) e.getSource();
		int col = -1;
		int row = -1;
		for (int c = 0; c < view.buttons.length; c++) {
			for (int r = 0; r < view.buttons[0].length; r++) {
				if (btn == view.buttons[c][r]) {
					col = c;
					row = r;
				}
			}
		}

		if (model.makeMove(col, row)) {
			view.buttons[col][row].setText(model.board[col][row].toString());
			if (model.getWinner() != null) {
				Alert showWinner = new Alert(AlertType.INFORMATION);
				showWinner.setTitle("Winner");
				showWinner.setHeaderText("The winner is " + model.getWinner());
				showWinner.showAndWait();
			}
		}
	}

	// 3.2 EmailValdiator
	private void validateEmailAddress(String newValue) {
		boolean valid = false;

		// Split on '@': must give us two not-empty parts
		String[] addressParts = newValue.split("@");
		if (addressParts.length == 2 && !addressParts[0].isEmpty() && !addressParts[1].isEmpty()) {
			// We want to split the domain on '.', but split does not give us an empty
			// string, if the split-character is the last character in the string. So we
			// first ensure that the string does not end with '.'
			if (addressParts[1].charAt(addressParts[1].length() - 1) != '.') {
				// Split domain on '.': must give us at least two parts.
				// Each part must be at least two characters long
				String[] domainParts = addressParts[1].split("\\.");
				if (domainParts.length >= 2) {
					valid = true;
					for (String s : domainParts) {
						if (s.length() < 2) valid = false;
					}
				}
			}
		}

		view.txtEmail.getStyleClass().remove("emailNotOk");
		view.txtEmail.getStyleClass().remove("emailOk");
		if (valid) {
			view.txtEmail.getStyleClass().add("emailOk");
		} else {
			view.txtEmail.getStyleClass().add("emailNotOk");
		}
	}
}