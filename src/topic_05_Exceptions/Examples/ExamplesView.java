package topic_05_Exceptions.Examples;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExamplesView {
	private Stage stage;
	private ExamplesModel model;

	private Label lblStack = new Label("Cause stack overflow");
	protected TextField txtStack = new TextField();
	protected Button btnStack = new Button("Stack overflow");
	protected Label lblStackResult = new Label("");

	private Label lblArrayIndex = new Label("Index out of bounds");
	protected TextField txtArrayIndex = new TextField();
	protected Button btnArrayIndex = new Button("Out of bounds");
	protected Label lblArrayIndexResult = new Label("");

	private Label lblInteger = new Label("Expects an integer");
	protected TextField txtInteger = new TextField();
	protected Button btnInteger = new Button("Parse integer");
	protected Label lblIntegerResult = new Label("");

	private Label lblFile = new Label("Open a file");
	protected TextField txtFile = new TextField();
	protected Button btnFile = new Button("Open file");
	protected Label lblFileResult = new Label("");

	public ExamplesView(Stage stage, ExamplesModel model) {
		this.stage = stage;
		this.model = model;

		VBox root = new VBox();

		HBox hbox = new HBox(lblStack, txtStack, btnStack, lblStackResult);
		hbox.getStyleClass().add("hbox");
		lblStackResult.getStyleClass().add("result");
		txtStack.setDisable(true);
		txtStack.setVisible(false); // No user input needed
		root.getChildren().add(hbox);

		hbox = new HBox(lblArrayIndex, txtArrayIndex, btnArrayIndex, lblArrayIndexResult);
		hbox.getStyleClass().add("hbox");
		lblArrayIndexResult.getStyleClass().add("result");
		txtArrayIndex.setDisable(true);
		txtArrayIndex.setVisible(false); // No user input needed
		root.getChildren().add(hbox);

		hbox = new HBox(lblInteger, txtInteger, btnInteger, lblIntegerResult);
		hbox.getStyleClass().add("hbox");
		lblIntegerResult.getStyleClass().add("result");
		root.getChildren().add(hbox);

		hbox = new HBox(lblFile, txtFile, btnFile, lblFileResult);
		hbox.getStyleClass().add("hbox");
		lblFileResult.getStyleClass().add("result");
		root.getChildren().add(hbox);

		Scene scene = new Scene(root);
		stage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("Examples.css").toExternalForm());
		stage.setTitle("Exceptions examples");
	}

	public void start() {
		stage.show();
	}

}
