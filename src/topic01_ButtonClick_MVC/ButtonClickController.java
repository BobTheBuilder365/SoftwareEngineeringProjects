package topic01_ButtonClick_MVC;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class ButtonClickController {

	private final ButtonClickModel model;
	private final ButtonClickView view;

	protected ButtonClickController(ButtonClickModel model, ButtonClickView view) {
		this.model = model;
		this.view = view;

		// register ourselves to listen for button clicks
		view.btnClick.setOnAction((event) -> {
			model.incrementValue();
			String newText = Integer.toString(model.getValue());
			view.lblNumber.setText(newText);
		});
	}
}
