package topic02_JavaFX_Events.dynamicCSS;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DynamicCSS_View {
    private DynamicCSS_Model model;
    protected Stage stage;
    
    protected Label lblAddStyle = new Label("Styles changed by MouseEnter/MouseExit");
    protected Label lblAddClass = new Label("Classes changed by MouseEnter/MouseExit");
    
    protected DynamicCSS_View(Stage stage, DynamicCSS_Model model) {
		this.stage = stage;
		this.model = model;
		
		stage.setTitle("Dynamic CSS Demo");
		
		VBox root = new VBox();
		root.getChildren().addAll(lblAddStyle, lblAddClass);
		root.getStyleClass().add("vbox");

		Scene scene = new Scene(root);
		scene.getStylesheets().add(
				getClass().getResource("styles.css").toExternalForm());
		stage.setScene(scene);;
	}
	
	public void start() {
		stage.show();
	}
}
