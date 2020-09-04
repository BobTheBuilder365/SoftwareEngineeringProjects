package topic_05_PortProbe;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class PortProbeView {
	private Stage stage;
	private PortProbeModel model;
	protected AddressBarView addressBar;

	protected TextArea txtResult = new TextArea();

	public PortProbeView(Stage stage, PortProbeModel model) {
		this.stage = stage;
		this.model = model;

		addressBar = new AddressBarView();

		BorderPane root = new BorderPane();
		root.setTop(addressBar);
		root.setCenter(txtResult);

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("PortProbe.css").toExternalForm());
		stage.setTitle("Port Probe");
		stage.setScene(scene);
		;
	}

	public void start() {
		stage.show();
	}

}
