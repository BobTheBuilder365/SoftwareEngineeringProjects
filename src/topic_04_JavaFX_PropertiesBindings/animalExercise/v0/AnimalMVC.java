package topic_04_JavaFX_PropertiesBindings.animalExercise.v0;

// Stufe 0 = Basis MVC Struktur und die View

import javafx.application.Application;
import javafx.stage.Stage;

// 0
public class AnimalMVC extends Application {
	private AnimalView view;
	private AnimalModel model;
	private AnimalController controller;
	
	
	// 0
	public static void main(String[] args) {
		launch();
	}

	// 0
	@Override
	public void start(Stage stage) throws Exception {
		model = new AnimalModel();
		view = new AnimalView(stage, model);
		controller = new AnimalController(model, view);
		view.start();
	}
}