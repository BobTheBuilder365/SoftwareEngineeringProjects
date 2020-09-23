package aa_A_KeyConcepts.c.PropertyChangeListenerBinding.VIEW.WebValidator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class WebValidator_View {

	private WebValidator_Model model;
	private Stage stage;
	
    protected TextField txtIpAddress = new TextField();
    protected TextField txtPort = new TextField();
    protected Label lblIpAddress = new Label("Web adress : ");
    protected Label lblPort = new Label("Port Number : ");
    protected Button btnConnect = new Button("Connect");

	protected WebValidator_View(Stage stage, WebValidator_Model model) {
		this.stage = stage;
		this.model = model;
		
        stage.setTitle("Web Validator");
        HBox root = new HBox();
        Region spacer1 = new Region();
        spacer1.setPrefWidth(30);
        Region spacer2 = new Region();
        spacer2.setPrefWidth(30);
     
        
        root.getChildren().addAll(lblIpAddress, txtIpAddress, spacer1, lblPort, txtPort);

        Scene scene = new Scene(root);
//		scene.getStylesheets().add(
//				getClass().getResource("EmailValidator.css").toExternalForm());        
        stage.setScene(scene);
	}

	public void start() {
		stage.show();

	}

	/**
	 * Stopping the view - just make it invisible
	 */
	public void stop() {
		stage.hide();
	}

	/**
	 * Getter for the stage, so that the controller can access window events
	 */
	public Stage getStage() {
		return stage;
	}
}
