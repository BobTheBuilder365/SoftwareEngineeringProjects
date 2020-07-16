package topic04_JavaFX_PropertiesBindings_28_Properties_MVC_Version;

import javafx.stage.Stage;

public class Person_View {
	
	private final Person_Model model;
	private Stage stage;
	
	protected Person_View(Stage stage, Person_Model model) {
		this.stage = stage;
		this.model = model;
		stage.setTitle("Properties Demo");
	}

	public void start() {
		stage.show();	
	}
	public void stop() {
		stage.hide();
	}
	public Stage getStage() {
		return this.stage;
	}

}
