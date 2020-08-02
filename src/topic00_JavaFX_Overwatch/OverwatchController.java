package topic00_JavaFX_Overwatch;

public class OverwatchController {
	
	// Controller muss Model und View kennen
	private OverwatchModel model;
	private OverwatchView view;

	// Konstruktor
	public OverwatchController(OverwatchModel model, OverwatchView view) {
		// TODO Auto-generated constructor stub
		
		
		// register ourselves to listen for button clicks
		view.btnClick.setOnAction((event) -> {
			// TODO: Was soll getan werden?
			model.incrementValue();
			String newText = Integer.toString(model.getValue());
			view.lblNumber.setText(newText);
		});
	}

	
	// Wie ruft ein Event Handler eine Methode auf?
	
	// Wie holt eine Methode im Controller eine Zahl im Model?	
	// Wie konvertierte man diese Zahl in eine Zeichenkette?
	
	
}
