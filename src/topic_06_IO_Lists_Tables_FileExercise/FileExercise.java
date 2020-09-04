package topic_06_IO_Lists_Tables_FileExercise;

import javafx.application.Application;
import javafx.stage.Stage;

public class FileExercise extends Application {

	private FileExercise_View view;
	private FileExercise_Controller controller;
	private FileExercise_Model model;

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void init() {
		// Initialization - but note that model does not yet exist!
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.model = new FileExercise_Model();
		this.view = new FileExercise_View(stage, model);
		this.controller = new FileExercise_Controller(view, model);
		view.start();
	}
}
