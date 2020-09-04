package topic_05_PortProbe;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

/**
 * The AddressBarView takes the WebValidator example, and puts it into an HBox.
 * This way, we can re-use our code in any number of programs.
 */
public class AddressBarView extends HBox {
	protected Label lblIpAddress = new Label("Web address:");
	protected TextField txtIpAddress = new TextField();
	protected Label lblPort = new Label("Port:");
	protected TextField txtPort = new TextField();
	protected Button btnConnect = new Button("Probe");

	public AddressBarView() {
		super();
		this.getStyleClass().add("hbox");
		Region spacer1 = new Region();
		Region spacer2 = new Region();
		this.getChildren().addAll(lblIpAddress, txtIpAddress, spacer1, lblPort, txtPort, spacer2, btnConnect);
	}
}
