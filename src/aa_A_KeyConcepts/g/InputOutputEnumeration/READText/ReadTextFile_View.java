package aa_A_KeyConcepts.g.InputOutputEnumeration.READText;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReadTextFile_View {

	private final ReadTextFile_Model model;
	private final Stage stage;
	
	// GUI controls
	Button btnRead = new Button("Read file 'numbers.txt'");
	Label lblNumbers = new Label();
	Label lblTotal = new Label();

	public ReadTextFile_View(Stage stage, ReadTextFile_Model model) {
		this.stage = stage;
		this.model = model;
		
		
		VBox root = new VBox(btnRead, lblNumbers, lblTotal);
		root.getStyleClass().add("vbox");
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		scene.getStylesheets().add(
				getClass().getResource("FileExercise.css").toExternalForm());
		stage.setTitle("File exercise");
	}
	
	public void start() {
		stage.show();
	}
}
