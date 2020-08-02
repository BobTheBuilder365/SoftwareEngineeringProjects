package topic00_JavaFX_Overwatch;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OverwatchView {
	
	// 0 View muss das model und die stage kennen
	private final OverwatchModel model;
	private Stage stage;

	// ButtonCLick 
	protected Button btnClick;
	protected Label lblNumber;

	// 0 Konstruktor
	public OverwatchView(Stage primaryStage, OverwatchModel model) {
		this.stage = primaryStage;
		this.model = model;
		
		// 0 Wurzel als Hauptbehälter
		GridPane root = new GridPane();
		
		root.getChildren().add(createButtonClickPane()); // Buttonclick	
		
		
		// 0 Standard stuff for Scene and Stage
		Scene scene = new Scene(root);
		scene.getStylesheets().add(
				getClass().getResource("OverwatchStyle.css").toExternalForm());
		stage.setTitle("Overwatch Software Engineering JavaFX");
		stage.setScene(scene);
		stage.show();
	}

	// 0
	public void start() {
		stage.show();	
	}

	/**
	 * 0 Getter for the stage, so that the controller can access window events
	 */
	public Stage getStage() {
		return stage;
	}
	
	private Pane createButtonClickPane() {
		GridPane pane = new GridPane();
		lblNumber = new Label();
		// Hol im Model den Wert von value, konvertiere Intger to String und setze als Text im Label
		lblNumber.setText(Integer.toString(model.getValue()));
		pane.add(lblNumber, 0, 0);
		btnClick = new Button();
		btnClick.setText("Click Me!");
		pane.add(btnClick, 0, 1);
		
		return pane;
	}
}
