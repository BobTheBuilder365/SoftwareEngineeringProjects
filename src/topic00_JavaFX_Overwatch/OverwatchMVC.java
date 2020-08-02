package topic00_JavaFX_Overwatch;

import javafx.application.Application;
import javafx.stage.Stage;

// Alt + Shift + R rename all


public class OverwatchMVC extends Application {
	
	private OverwatchModel model;
	private OverwatchView view;
	private OverwatchController controller;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Optional. Program initialization can go here, for example, connection to
	 * a database, or a network server. The primaryStage is not yet available.
	 */
	@Override
	public void init() {
		// Nothing to do in this example
	}
	


	/**
	 * Note the dependencies between model, view and controller. Additionally,
	 * the view needs access to the primaryStage
	 */
	@Override
	public void start(Stage primaryStage) {
		// Initialize the three MVC components
		model = new OverwatchModel();
		view = new OverwatchView(primaryStage, model);
		controller = new OverwatchController(model, view);

		// Display the GUI after all initialization is complete
		view.start();
	}
}
