package topic_06_IO_Lists_Tables_FileExercise;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FileExercise_View {
	private final FileExercise_Model model;
	private final Stage stage;

	// GUI controls
	Button btnRead = new Button("Read file 'numbers.txt'");
	Label lblNumbers = new Label();
	Label lblTotal = new Label();

	public FileExercise_View(Stage stage, FileExercise_Model model) {
		this.stage = stage;
		this.model = model;

		VBox root = new VBox(btnRead, lblNumbers, lblTotal);
		root.getStyleClass().add("vbox");

		Scene scene = new Scene(root);
		stage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("FileExercise.css").toExternalForm());
		stage.setTitle("File exercise");
	}

	public void start() {
		stage.show();
	}
}
