package topic_04_JavaFX_PropertiesBindings_28_Properties_MVC_Version;

import javafx.application.Application;
import javafx.stage.Stage;

public class Person_MVC extends Application {

	private Person_Model model;
	private Person_Controller controller;
	private Person_View view;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		model = new Person_Model();
		view = new Person_View(primaryStage, model);
		controller = new Person_Controller(model, view);
		view.start();
	}

}
