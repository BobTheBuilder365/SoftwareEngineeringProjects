package aa_A_KeyConcepts.c.PropertyChangeListenerBinding.VIEW.WebValidator;

import javafx.application.Application;
import javafx.stage.Stage;

public class WebValidator_MVC extends Application {
	
	private WebValidator_Model model;
	private WebValidator_View view;
	private WebValidator_Controller controller;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		model = new WebValidator_Model();
		view = new WebValidator_View(primaryStage, model);
		controller = new WebValidator_Controller(model, view);
		
		// Display the GUI after all initialization is complete
        view.start();
	}


}
