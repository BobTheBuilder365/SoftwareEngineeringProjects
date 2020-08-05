package topic_00_JavaFX_Overwatch;

import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.stage.WindowEvent;
import topic06_IO_Lists_Tables_tableViewExampleEDITABLE.SuperNumber;

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

		
		// EventTypes (&Handling)
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
		
		
		// Dice (Eine Methoe für mehrere Buttons)
		for (Button btn : view.dice) {
			btn.setOnAction(this::roll);
		}
		// ListView
		// Event handler for the buttons
		view.btnAddNewElt.setOnAction(event -> model.addNewElement());
		view.btnMultiply.setOnAction(event -> doMultiply());
		
		// Diese Methode "scrollt" mit dem neu hinzugefügten Objekt mit bzuw sorgt
		// dafür wir beim akutellen Objekt sind mit einem Listener
		// Event handler for the model's ObservableList requires a ListChangeListener.
		// To make generics happy, we have to cast our lambda: what kind of data do we have?
		// Note: May contain multiple changes - hence, the loop!
		model.getIntegerElements().addListener((ListChangeListener<Integer>) change -> { 
			while (change.next()) { // scrollTo ist vordefinierte Methode von ListView
				view.listView.scrollTo(change.getFrom()); // wo in der Liste hat die Änderung stattgefunden?
				// Die Idee ist das sich in einer Liste etwas ändert, möchten wir das der Benutzer zur Änderung geführt wird
				// Die While Schleife ist zur Sicherheit, falls sehr viele Benutzer etwas der Lsite hinzufügen wollen
			}
		});
		// Editable TablieView
//		// Event handler for the button
//		view.tablieViewAddBtn.setOnAction(event -> model.addNewElement());
//
//		// Event handlers for the table columns: validate user input
//		view.colBinary.setOnEditCommit(editEvent -> {
//			String newValue = editEvent.getNewValue();
//			if (isNumberValid(newValue, 2))
//				getSuperNumberFromEvent(editEvent).setAsBinary(newValue);
//			else // Erase invalid edited value by refreshing
//				editEvent.getTableView().refresh();
//		});
//
//		// Decimal
//		view.colDecimal.setOnEditCommit(editEvent -> {
//			String newValue = editEvent.getNewValue();
//			if (isNumberValid(newValue, 10))
//				getSuperNumberFromEvent(editEvent).setAsDecimal(newValue);
//			else // Erase invalid edited value by refreshing
//				editEvent.getTableView().refresh();
//		});
//
//		// Hex
//		view.colHex.setOnEditCommit(editEvent -> {
//			String newValue = editEvent.getNewValue();
//			if (isNumberValid(newValue, 16))
//				getSuperNumberFromEvent(editEvent).setAsHexadecimal(newValue);
//			else // Erase invalid edited value by refreshing
//				editEvent.getTableView().refresh();
//		});
//
//		// Event handler for the model's ObservableList requires a
//		// ListChangeListener, which is generic, so we have to cast our lambda
//		// to fill in the type.
//		//
//		// ListChangeListener provides a list of events, so we must provide
//		// a loop in case multiple changes are pending. We only want to scroll
//		// to the position of the last change made.
//		model.getElements().addListener((ListChangeListener<SuperNumber>) c -> {
//			while (c.next()) {
//				view.tableView.scrollTo(c.getFrom());
//			}
//		});
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

	// 2 CALCULATOR
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
	
	// 2 EventTypes
	private void displayEvent(Event mouseEvent) {
		String desc = mouseEvent.getEventType().toString() + "\n";
		view.txtEventLog.appendText(desc);
	}
	
	// Dice 
	private void roll(ActionEvent e) {
		// Get the button that was clicked
		Button btn = (Button) e.getSource();		
		// Roll a new value, and place the value into the button
		int value = model.getRandomValue();
		String s = Integer.toString(value);
		btn.setText(s);
	}	
	
	// ListView
	private void doMultiply() {
		Integer value = view.listView.getSelectionModel().getSelectedItem();
		if (value != null) {
			Integer result = model.multiplyByTwo(value);
			view.lblResult.setText(result.toString());
		}
	}
//	// Editable TableView
//	private boolean isNumberValid(String number, int radix) {
//		boolean valid;
//		try {
//			Integer.parseInt(number, radix);
//			valid = true;
//		} catch (NumberFormatException e) {
//			valid = false;
//		}
//		return valid;
//	}
//
//	private SuperNumber getSuperNumberFromEvent(CellEditEvent<SuperNumber, String> editEvent) {
//		TableView<SuperNumber> tv = editEvent.getTableView();
//		int rowNumber = editEvent.getTablePosition().getRow();
//		return tv.getItems().get(rowNumber);
//	}

	
	
	
	
	
	// Wie ruft ein Event Handler eine Methode auf?
	
	// Wie holt eine Methode im Controller eine Zahl im Model?	model.getValue();
	// Wie konvertierte man diese Zahl in eine Zeichenkette?
	
	
}
