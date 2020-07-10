package topic01_JavaFX_MVC;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ButtonDemo extends Application {
	private Integer value = 1; // the value to be desplayed
	
	/**
	 * If a control will be
	 * accessed from various places, then declare it as an instance attribute
	 */	
	Label valueLabel = new Label();

	/**
	 * Launches the JavaFX framework launch(); = organisiert Fenster vom
	 * Betriebssystem
	 */
	public static void main(String[] args) {
		launch(); //
	}

	/**
	 * Is where our program really starts called by JavaFx The "Stage" is the window
	 * JavaFX controls this stage setTile = Title at top of window show(); = display
	 * to the user setScene = Place content on stage
	 */
	public void start(Stage primaryStage) throws Exception {

		GridPane root = new GridPane();

		Button btn = new Button("Increment");

		root.add(valueLabel, 0, 0);
		root.add(btn, 0, 1);

		setValueLabel();
		
		btn.setOnAction(this::methodName); 

		// The "Scene" is the content
		// The "root" oif the tree is here a GridPa
		Scene scene = new Scene(root, 150, 100);
		
		primaryStage.setTitle("Incrementor");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void setValueLabel() {
		valueLabel.setText(value.toString());

	}

	private void methodName(ActionEvent e) {
		
	}
}