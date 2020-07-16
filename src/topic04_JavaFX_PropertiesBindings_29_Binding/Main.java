package topic04_JavaFX_PropertiesBindings_29_Binding;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
		
		IntegerProperty x = new SimpleIntegerProperty(3);
		IntegerProperty y = new SimpleIntegerProperty();
		
		// Hiermit wird der Y Wer an den X Wert gekoppelt
		// y erhält den X Wert x 10
		y.bind(x.multiply(10));
		System.out.println("x: " + x.getValue()); // = 3
		System.out.println("y: " + y.getValue() + "\n"); // = 30
		
		// Setzen Wert der x variable auf 9
		x.setValue(9);
		System.out.println("x: " + x.getValue()); // = 9
		System.out.println("y: " + y.getValue() + "\n"); // = 90
		
		button = new Button("Submit");
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
		
		
	}

}
