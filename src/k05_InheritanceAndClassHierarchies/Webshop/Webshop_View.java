package k05_InheritanceAndClassHierarchies.Webshop;



import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


// 0
public class Webshop_View {

	// 0 View muss das model und die Stage kennen
	final private Webshop_Model model;
	final private Stage stage;
	
	private Label testLabel = new Label("Test Label");
	
	// 0
	public Webshop_View(Stage stage, Webshop_Model model) {
		// TODO Auto-generated constructor stub
		this.stage = stage;
		this.model = model;
		
		// 0
		BorderPane root = new BorderPane();
		root.setCenter(testLabel);
		

		
		// 0 Standard stuff for Scene and Stage
		Scene scene = new Scene(root);
		scene.getStylesheets().add(
				getClass().getResource("Webshop_Style.css").toExternalForm());
		stage.setTitle("Webshop example");
		stage.setScene(scene);

	}

	// 0
	public void start() {
		// TODO Auto-generated method stub
		stage.show();
	}

	/**
	 * 0 - Getter for the stage, so that the controller can access window events
	 */
	public Stage getStage() {
		return stage;
	}

	/**
	 * 0 - Optional. An opportunity to clean house, for example, disconnecting from
	 * a database or network server, before the program ends.
	 */
	public void stop() {
		// TODO Auto-generated method stub
		stage.hide();
	}

}
