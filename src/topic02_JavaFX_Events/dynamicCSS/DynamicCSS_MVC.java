package topic02_JavaFX_Events.dynamicCSS;

import javafx.application.Application;
import javafx.stage.Stage;

public class DynamicCSS_MVC extends Application {
	private DynamicCSS_View view;
	private DynamicCSS_Controller controller;
	private DynamicCSS_Model model;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		// Initialize the three MVC components
		model = new DynamicCSS_Model();
		view = new DynamicCSS_View(primaryStage, model);
		controller = new DynamicCSS_Controller(model, view);
		
		// Display the GUI after all initialization is complete
		view.start();
	}
}
