package topic_00_CourseSummary;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
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

// 0
public class Summary_View {
	
	// 0 View muss das Model und die Stage kennen
	final private Summary_Model model;
	final private Stage stage;

    // 1.1 Dice
	Button[] dice = new Button[2]; // Array for buttons

	// 1.1 Properties Bindings
	TextField txtName = new TextField();
	ComboBox<Species> cmbSpecies = new ComboBox<>();
	ComboBox<Gender> cmbGender = new ComboBox<>();
	Label lblDataID = new Label();
	Label lblDataName = new Label();
	Label lblDataSpecies = new Label();
	Label lblDataGender = new Label();
	// Buttons
	Button btnSave = new Button("Save");
	Button btnDelete = new Button("Delete");
	
	// 0 Konstruktor
	public Summary_View(Stage primaryStage, Summary_Model model) {
		// TODO Auto-generated constructor stub
		this.stage = primaryStage;
		this.model = model;

		// 0 Wurzel als Hauptbehälter und Boxen für die Regionen
		BorderPane root = new BorderPane();
//		HBox rootTop = new HBox();
//		HBox rootBottom = new HBox();
		VBox rootLeft = new VBox();
//		VBox rootRight = new VBox();

		// 1 Dice
		// Das GUI wird mit der Methode erzeugt und platziert
		root.setCenter(createDicePane()); // CENTER
		
		// 1 Properties Bindings
		// Das GUI wird mit der Methode erzeugt und platziert		
		root.setLeft(rootLeft); // LEFT
		rootLeft.getChildren().add(createDataEntryPane());
		rootLeft.getChildren().add(createControlPane());
		rootLeft.getChildren().add(createDataDisplayPane());		
		
		
//		rootTop.getChildren().add(createDicePane()); // TOP
//		rootBottom.getChildren().add(createDicePane()); // BOTTOM
//		rootRight.getChildren().add(createDicePane()); // RIGHT	
		
		// 0 Create the scene using our layout; then display it
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("SummaryCSS.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("Summary");
	}

	// 0
	public void start() {
		// TODO Auto-generated method stub
		stage.show();
	}

	/**
	 * 0 - Getter for the stage, so that the controller can access window events
	 */
	public Stage getStage() {
		return stage;
	}

	/**
	 * 0 - Optional. An opportunity to clean house, for example, disconnecting from
	 * a database or network server, before the program ends.
	 */
	public void stop() {
		// TODO Auto-generated method stub
		stage.hide();
	}

	// 1 Dice - Methode um das GUI zu erzeugen
	private Pane createDicePane() {
		GridPane root = new GridPane();
		for (int i = 0; i < 2; i++) {
			dice[i] = new Button("1");
			root.add(dice[i], i, 0);
		}
		return root;
	}

	// 1 Properties Bindings - Methode um Teil des GUIs zu erzeugen
	private Pane createDataEntryPane() {
		GridPane pane = new GridPane();
		pane.setId("dataEntry");
		// Declare the individual controls in the GUI
		Label lblName = new Label("Name");
		Label lblSpecies = new Label("Species");
		Label lblGender = new Label("Gender");
		
		// Fill combos
		cmbSpecies.getItems().addAll(Pet.Species.values());
		cmbSpecies.setValue(Species.CAT);
		cmbGender.getItems().addAll(Pet.Gender.values());
		cmbGender.setValue(Gender.FEMALE);
		
		// Organize the layout, add in the controls (col, row)
		pane.add(lblName, 0, 0);		pane.add(txtName, 1, 0);
		pane.add(lblSpecies, 0, 1);		pane.add(cmbSpecies, 1, 1);
		pane.add(lblGender, 0, 2);	pane.add(cmbGender, 1, 2);
		
		return pane;
	}
	// 1 Properties Bindings - Methode um Teil des GUIs zu erzeugen
	private Pane createControlPane() {
		GridPane pane = new GridPane();
		pane.setId("controlArea");
		pane.add(btnSave, 0, 0);
		pane.add(btnDelete, 1, 0);
		
		return pane;
	}
	// 1 Properties Bindings - Methode um Teil des GUIs zu erzeugen
	private Pane createDataDisplayPane() {
		GridPane pane = new GridPane();
		pane.setId("dataDisplay");
		// Declare the individual controls in the GUI
	    Label lblID = new Label("ID");
		Label lblName = new Label("Name");
		Label lblSpecies = new Label("Species");
		Label lblGender = new Label("Gender");
		
		// Organize the layout, add in the controls (col, row)
	    pane.add(lblID, 0, 0); pane.add(lblDataID, 1, 0);
	    pane.add(lblName, 0, 1); pane.add(lblDataName, 1, 1);
	    pane.add(lblSpecies, 0, 2); pane.add(lblDataSpecies, 1, 2);
	    pane.add(lblGender, 0, 3); pane.add(lblDataGender, 1, 3);
	    
	    return pane;
	}
}