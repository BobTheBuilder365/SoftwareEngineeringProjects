package topic_04_JavaFX_PropertiesBindings.animalExercise.v1;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import topic_04_JavaFX_PropertiesBindings.animalExercise.v1.Animal.Geschlecht;

// 0

public class AnimalView {
	
	// 0 
	private Stage stage;
	private AnimalModel model;
	
	// 0 Controls used for data processing
	TextField txtName = new TextField();
	ComboBox<Tierart> cmbTierArt = new ComboBox<>();
	ComboBox<Geschlecht> cmbGeschlecht = new ComboBox<>();
	
	Label lblDataID = new Label();
	Label lblDataName = new Label();
	Label lblDataTierArt = new Label();
	Label lblDataGeschlecht = new Label();
	
	// 0 Buttons
	Button btnSave = new Button("Save");
	Button btnDelete = new Button("Delete");

	// 0
	public AnimalView(Stage stage, AnimalModel model) {
		this.stage = stage;
		this.model = model;
		
		// 0
		// Wurzel als Hauptbehälter
		VBox root = new VBox();
		root.getChildren().add(createDataEntryPane());
		root.getChildren().add(createControlPane());
		root.getChildren().add(createDataDisplayPane());
		root.getChildren().add(createTestDisplayPane());
		
		// 0
		// Standard stuff for Scene and Stage
		Scene scene = new Scene(root);
		scene.getStylesheets().add(
				getClass().getResource("AnimalCSS.css").toExternalForm());
		stage.setTitle("Enter and display a Animal");
		stage.setScene(scene);
		stage.show();
	}

	// 0
	public void start() {
		stage.show();
	}
	
	// 0 Data Entry Pane
	// Namenseingabe und Auswahl der Tierart und des Geschlechts
	
	private Pane createDataEntryPane() {
		GridPane pane = new GridPane();
		pane.setId("dataEntry");
		// Declare the individual controls in the GUI
		Label lblName = new Label("Name");
		Label lblTierart = new Label("Tierart");
		Label lblGeschlecht = new Label("Geschlecht");
		
		// Fill combos (hol mir die Items,alle hinzufügen von den values der Enums)
		cmbTierArt.getItems().addAll(Tierart.values());
		cmbGeschlecht.getItems().addAll(Animal.Geschlecht.values());
		
		// Organize the layout, add in the controls (col, row)
		// pane.add(child, columnIndex, rowIndex);
		pane.add(lblName, 0, 0);		pane.add(txtName, 4, 0);
		pane.add(lblTierart, 0, 1);		pane.add(cmbTierArt, 4, 1);
		pane.add(lblGeschlecht, 0, 2);	pane.add(cmbGeschlecht, 4, 2);
		
		return pane;
	}

	// 0 Data Control Pane
	private Pane createControlPane() {
		GridPane pane = new GridPane();
		pane.setId("controlArea");
		pane.add(btnSave, 0, 0);
		pane.add(btnDelete, 4, 0);
		
		return pane;
	}
	
	// 0 Data Display Pane
	private Pane createDataDisplayPane() {
		GridPane pane = new GridPane();
		pane.setId("dataDisplay");
		// Declare the individual controls in the GUI
	    Label lblID = new Label("ID");
		Label lblName = new Label("Name");
		Label lblTierArt = new Label("Tierart");
		Label lblGeschlecht = new Label("Geschlecht");
		
		// Organize the layout, add in the controls (col, row)
	    pane.add(lblID, 0, 0); pane.add(lblDataID, 4, 0);
	    pane.add(lblName, 0, 1); pane.add(lblDataName, 4, 1);
	    pane.add(lblTierArt, 0, 2); pane.add(lblDataTierArt, 4, 2);
	    pane.add(lblGeschlecht, 0, 3); pane.add(lblDataGeschlecht, 4, 3);

	    
	    return pane;
	}
	
	// 1 
	// Display test data
	private Pane createTestDisplayPane() {
		GridPane pane = new GridPane();
		pane.setId("testData");
		
		Label lblTest = new Label("Test Output:");
		
		return pane;
	}
}