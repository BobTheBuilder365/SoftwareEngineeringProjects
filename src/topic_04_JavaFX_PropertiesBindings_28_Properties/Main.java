package topic_04_JavaFX_PropertiesBindings_28_Properties;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	Stage window;
	Button button;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Propertys Demo");

		Person lisa = new Person();

		lisa.firstNameProperty().addListener((v, oldValue, newValue) -> {
			System.out.println("Name changed to " + newValue); // = Sarah
			System.out.println("firstNameProperty(): " + lisa.firstNameProperty());
			// -> firstNameProperty(): StringProperty und der Speicherort [bean:
			// topic04JavaFX....
			// , name : firstName, value: Sarah]
			System.out.println("getFirstName(): " + lisa.getFirstName()); // = Sarah

		});

		button = new Button("Submit");
		button.setOnAction(event -> lisa.setFirstName("Sarah"));

		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();

	}

}
