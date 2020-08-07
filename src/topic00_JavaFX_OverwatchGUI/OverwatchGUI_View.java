package topic00_JavaFX_OverwatchGUI;

import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.stage.Stage;
import topic00_JavaFX_OverwatchNEW.OverwatchModel;

public class OverwatchGUI_View {

	// 0 View muss das model und die stage kennen
	final private OverwatchGUI_Model model;
	final private Stage stage;
	
	// 0 Konstruktor
	public OverwatchGUI_View(Stage primaryStage, OverwatchGUI_Model model) {
		this.stage = primaryStage;
		this.model = model;
		
		// 0 Wurzel als HauptbehÃ¤lter
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
		
		leftBox.getChildren().add(createColorPropertiesPane());
		
		
		
	
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
	 * Erzeugt ein Bereich um eine Farbe auszuwählen und ein Rechteck
	 * rect.fillProperty().bind(picker.valueProperty()); bindet den augewählten Farbwert
	 * an das Reckteck.
	 * rect.widthProperty().bind(picker.widthProperty()); bindet zusätzlich die Breite 
	 * des Rechtecks an die Breite des Farbauswahl Felds
	 * @return
	 */
	private Pane createColorPropertiesPane() {
		VBox pane = new VBox();
		
		// Objekt im Farben auszuwählen
		ColorPicker picker = new ColorPicker();
//		Rectangle rect = RectangleBuilder.create().width(200).height(100).build(); // VERALTET
		Rectangle rect = new Rectangle();
		rect.setWidth(200);
		rect.setHeight(100);
		
		// Fügt den picker und das Rechteck dem Bereich hinzu
		pane.getChildren().addAll(picker, rect);
		
		// Binding
		rect.fillProperty().bind(picker.valueProperty());
		rect.widthProperty().bind(picker.widthProperty());
		
		return pane;
	}
}
