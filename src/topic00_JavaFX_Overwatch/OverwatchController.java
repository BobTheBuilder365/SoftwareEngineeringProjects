package topic00_JavaFX_Overwatch;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.WindowEvent;

// Stufe 0 = Basis MVC Struktur und die View
// Stufe 1 = Model bestimmen
// Stufe 2 = Controller mit Model und Vie verbinden, Events und Event Handling

public class OverwatchController implements EventHandler<ActionEvent> { // 1 Eventhandler
	
	// 0 Controller muss Model und View kennen
	final private OverwatchModel model;
	final private OverwatchView view;

	// 0 Konstruktor
	protected OverwatchController(OverwatchModel model, OverwatchView view) {
		this.model = model;
		this.view = view;

		// BUTTONCLICK
		// register ourselves to listen for button clicks
		view.btnClick.setOnAction((event) -> {
			model.incrementValue();
			String newText = Integer.toString(model.getValue());
			view.lblNumber.setText(newText);
		});
		
		// CALCULATOR
		// register for events
		for (Button b : view.digits) {
			b.setOnAction(this);
		}
		view.btnPlus.setOnAction(this);
		view.btnClear.setOnAction(this);
		view.btnEquals.setOnAction(this);

		
		// EventTypes
		view.btnEventClick.setOnAction(this::displayEvent);
		view.btnEventClick.setOnContextMenuRequested(this::displayEvent);
		view.btnEventClick.setOnKeyPressed(this::displayEvent);
		view.btnEventClick.setOnMouseClicked(this::displayEvent);
		view.btnEventClick.setOnMouseEntered(this::displayEvent);
		view.btnEventClick.setOnMouseExited(this::displayEvent);
		view.btnEventClick.setOnMousePressed(this::displayEvent);
		view.btnEventClick.setOnMouseReleased(this::displayEvent);
		
		// Event Handling
		// Event handling with an anonymous class
		view.btnClickAnonClass.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				incrementValueEH(e);
			}
		});
		// Event handling with a lambda
		view.btnClickLambda.setOnAction(e -> {
			incrementValueEH(e);
		});
		// Event handling with a method reference
		view.btnClickMethRef.setOnAction(this::incrementValueEH);
		
		// register ourselves to handle window-closing event
		view.getStage().setOnCloseRequest(this::closeWindow);
		
		
		// Dynamic CSS
		view.lblAddClass.setOnMouseEntered( e -> {
			view.lblAddClass.getStyleClass().add("hasMouse");
		});
		view.lblAddClass.setOnMouseExited(e -> {
			view.lblAddClass.getStyleClass().remove("hasMouse");			
		});		
		view.lblAddStyle.setOnMouseEntered(e -> {
			view.lblAddStyle.setStyle("-fx-text-fill: red; -fx-border-color: #000000; -fx-border-width: 1px; -fx-border-style: solid;");
		});		
		view.lblAddStyle.setOnMouseExited(e -> {
			view.lblAddStyle.setStyle("");
		});		
	}

	// 2 ButtonCLick
	private void incrementValue(ActionEvent e) {
		model.incrementValue();
		String newNumber = Integer.toString(model.getValue());
		view.lblNumber.setText(newNumber);
	}
	
	// 2 Event Handling
	private void incrementValueEH(ActionEvent e) {
		model.incrementValueEH();
		String newText1 = Integer.toString(model.getValueEH());
		view.lblEventHandlingNumber.setText(newText1);
	}
	
	// 0 EventHandling
	public void closeWindow(WindowEvent e) {
		view.stop();
		Platform.exit();
	}

	// 2
	// CALCULATOR
	@Override
	public void handle(ActionEvent event) {
		Button btn = (Button) event.getSource();
		
		if (btn == view.btnClear) {
			view.txtCalc.setText("");
		} else if (btn == view.btnEquals) {
			String result = model.calculate(view.txtCalc.getText());
			view.txtCalc.setText(result);
		} else { // All other buttons: append button.text to text-field
			view.txtCalc.setText(view.txtCalc.getText() + btn.getText());
		}
	}
	
	// EventTypes
	private void displayEvent(Event mouseEvent) {
		String desc = mouseEvent.getEventType().toString() + "\n";
		view.txtEventLog.appendText(desc);
	}
	
	// Wie ruft ein Event Handler eine Methode auf?
	
	// Wie holt eine Methode im Controller eine Zahl im Model?	
	// Wie konvertierte man diese Zahl in eine Zeichenkette?
	
	
}
