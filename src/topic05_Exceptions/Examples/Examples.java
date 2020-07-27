package topic05_Exceptions.Examples;

import javafx.application.Application;
import javafx.stage.Stage;

public class Examples extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		ExamplesModel model = new ExamplesModel();
		ExamplesView view = new ExamplesView(stage, model);
		ExamplesController controller = new ExamplesController(model, view);
		view.start();
	}

}
