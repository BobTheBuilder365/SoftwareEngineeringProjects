package aa_A_KeyConcepts.g.InputOutputEnumeration.READText;

import javafx.application.Application;
import javafx.stage.Stage;

public class ReadTextFile_MVC extends Application {

	private ReadTextFile_View view;
	private ReadTextFile_Controller controller;
	private ReadTextFile_Model model;
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void init() {
		// Initialization - but note that model does not yet exist!
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		this.model = new ReadTextFile_Model();
		this.view = new ReadTextFile_View(stage, model);
		this.controller = new ReadTextFile_Controller(view, model);
		view.start();
	}
}
