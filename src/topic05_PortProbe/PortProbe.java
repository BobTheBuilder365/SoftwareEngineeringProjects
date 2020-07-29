package topic05_PortProbe;

import javafx.application.Application;
import javafx.stage.Stage;

public class PortProbe extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		PortProbeModel model = new PortProbeModel();
		PortProbeView view = new PortProbeView(stage, model);
		PortProbeController controller = new PortProbeController(model, view);
		view.start();
	}
}
