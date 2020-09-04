package topic_00_JavaFX_OverwatchGUI;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import topic_04_JavaFX_PropertiesBindings.animalExercise.v3.AnimalModel;
import topic_04_JavaFX_PropertiesBindings.animalExercise.v3.AnimalView;
import topic_04_JavaFX_PropertiesBindings.animalExercise.v3.AnimalController;

public class OverwatchGUI_View {

	// 0 View muss das model und die stage kennen
	final private OverwatchGUI_Model model;
	final private Stage stage;
	
	
	// Instanziere ein Image, gebe URL an, und geb noch ein Flag -> Bitte gibt mir das Bild asynchron
//	final ProgressIndicator progressIndicator = new ProgressIndicator();
//	final Image image = new Image("", true;)
//	
	// 0 Konstruktor
	public OverwatchGUI_View(Stage primaryStage, OverwatchGUI_Model model) {
		this.stage = primaryStage;
		this.model = model;
		
		// 0 Wurzel als Hauptbehälter
		BorderPane root = new BorderPane();
		
		// 0 Left, Center and Right
		VBox leftBox = new VBox();	
		VBox centerBox = new VBox();
		VBox rightBox = new VBox();
		root.setLeft(leftBox);
		root.setCenter(centerBox);		
		root.setRight(rightBox);
		
		// 0 Top and Bottom
		HBox topBox = new HBox();
		HBox bottomBox = new HBox();
		root.setTop(topBox);
		root.setBottom(bottomBox);
		
		// Data Binding
		leftBox.getChildren().add(createColorPropertiesPane());
		
		// Properties and Bindings (Animal)
		centerBox.getChildren().add(createAnimalVieWPane());
		
		// 0 Standard stuff for Scene and Stage
		Scene scene = new Scene(root);
		scene.getStylesheets().add(
				getClass().getResource("OverwatchGUI_Style.css").toExternalForm());
		stage.setTitle("Overwatch Software Engineering JavaFX");
		stage.setScene(scene);
		stage.show();
	}

	// 0
	public void start() {
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
		stage.hide();
	}	
	
	/**
	 * Data Binding
	 * Erzeugt ein Bereich um eine Farbe auszuw�hlen und ein Rechteck
	 * rect.fillProperty().bind(picker.valueProperty()); bindet den augew�hlten Farbwert
	 * an das Reckteck.
	 * rect.widthProperty().bind(picker.widthProperty()); bindet zus�tzlich die Breite 
	 * des Rechtecks an die Breite des Farbauswahl Felds
	 * @return
	 */
	private Pane createColorPropertiesPane() {
		VBox pane = new VBox();
		
		// Objekt um Farben auszuw�hlen und Bereich um Farbe anzubinden
		ColorPicker picker = new ColorPicker();
		Rectangle rect = new Rectangle();
		rect.setWidth(200);
		rect.setHeight(100);	
		// F�gt den picker und das Rechteck dem Bereich hinzu
		pane.getChildren().addAll(picker, rect);
		
		// Binding (Farbe und Breite)
		rect.fillProperty().bind(picker.valueProperty());
		rect.widthProperty().bind(picker.widthProperty());
		
		return pane;
	}
	
	/** TODO
	 * Properties and Bindings (Animal) 
	 * @return
	 */
	private Pane createAnimalVieWPane() {
		VBox root = new VBox();

//		root.getChildren().add(createDataEntryPane());
//		root.getChildren().add(createControlPane());
//		root.getChildren().add(createDataDisplayPane());
//		root.getChildren().add(createTestDisplayPane());
			
		return root;
	}


}
