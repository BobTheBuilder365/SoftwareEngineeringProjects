package topic_05_PortProbe;

public class PortProbeController {
	private PortProbeModel model;
	private PortProbeView view;
	private AddressBarController addressBarController;

	public PortProbeController(PortProbeModel model, PortProbeView view) {
		this.model = model;
		this.view = view;

		this.addressBarController = new AddressBarController(view.addressBar);

		view.addressBar.btnConnect.setOnAction(e -> probePort());
	}

	private void probePort() {
		String ipAddress = view.addressBar.txtIpAddress.getText();
		int port = Integer.parseInt(view.addressBar.txtPort.getText());
		boolean result = model.probePort(ipAddress, port);
		String addResult = ipAddress + ":" + port + " is " + (result ? "open" : "not open") + "\n";
		view.txtResult.setText(view.txtResult.getText() + addResult);
	}
}
