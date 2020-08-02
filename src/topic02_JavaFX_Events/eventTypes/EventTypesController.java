package topic02_JavaFX_Events.eventTypes;

import javafx.event.Event;

public class EventTypesController {
	final private EventTypesModel model;
	final private OverwatchView view;

	protected EventTypesController(EventTypesModel model, OverwatchView view) {
		this.model = model;
		this.view = view;

		view.btnClick.setOnAction(this::displayEvent);
		view.btnClick.setOnContextMenuRequested(this::displayEvent);
		view.btnClick.setOnKeyPressed(this::displayEvent);
		view.btnClick.setOnMouseClicked(this::displayEvent);
		view.btnClick.setOnMouseEntered(this::displayEvent);
		view.btnClick.setOnMouseExited(this::displayEvent);
		view.btnClick.setOnMousePressed(this::displayEvent);
		view.btnClick.setOnMouseReleased(this::displayEvent);
	}

	private void displayEvent(Event e) {
		String desc = e.getEventType().toString() + "\n";
		view.txtEventLog.appendText(desc);
	}
}
