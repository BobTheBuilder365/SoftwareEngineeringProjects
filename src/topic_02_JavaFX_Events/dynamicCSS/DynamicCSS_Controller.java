package topic_02_JavaFX_Events.dynamicCSS;

import javafx.event.Event;

public class DynamicCSS_Controller {

	final private DynamicCSS_Model model;
	final private DynamicCSS_View view;

	protected DynamicCSS_Controller(DynamicCSS_Model model, DynamicCSS_View view) {
		this.model = model;
		this.view = view;

		view.lblAddClass.setOnMouseEntered(e -> {
			view.lblAddClass.getStyleClass().add("hasMouse");
		});

		view.lblAddClass.setOnMouseExited(e -> {
			view.lblAddClass.getStyleClass().remove("hasMouse");

		});

		view.lblAddStyle.setOnMouseEntered(e -> {
			view.lblAddStyle.setStyle(
					"-fx-text-fill: red; -fx-border-color: #000000; -fx-border-width: 1px; -fx-border-style: solid;");
		});

		view.lblAddStyle.setOnMouseExited(e -> {
			view.lblAddStyle.setStyle("");
		});
	}
}
