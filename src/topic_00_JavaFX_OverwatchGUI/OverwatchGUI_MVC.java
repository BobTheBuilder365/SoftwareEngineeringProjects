package topic_00_JavaFX_OverwatchGUI;

import javafx.application.Application;
import javafx.stage.Stage;
import topic_00_JavaFX_OverwatchNEW.OverwatchController;
import topic_00_JavaFX_OverwatchNEW.OverwatchModel;
import topic_00_JavaFX_OverwatchNEW.OverwatchView;

public class OverwatchGUI_MVC extends Application {
	
	// 0
	private OverwatchGUI_Model model;
	private OverwatchGUI_View view;
	private OverwatchGUI_Controller controller;
	
	// 0
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * 0 - Optional. Program initialization can go here, for example, connection to
	 * a database, or a network server. The primaryStage is not yet available.
	 */
	@Override
	public void init() {
		// Nothing to do in this example
	}
	
	/**
	 * 0 - Note the dependencies between model, view and controller. Additionally,
	 * the view needs access to the primaryStage
	 */
	@Override
	public void start(Stage primaryStage) {
		// Initialize the three MVC components
		model = new OverwatchGUI_Model();
		view = new OverwatchGUI_View(primaryStage, model);
		controller = new OverwatchGUI_Controller(model, view);

		// Display the GUI after all initialization is complete
		view.start();
	}
	
	/**
	 * 0 - Optional. An opportunity to clean house, for example, disconnecting from
	 * a database or network server, before the program ends.
	 */
	@Override
	public void stop() {
		if (view != null)
			view.stop();
	}
}