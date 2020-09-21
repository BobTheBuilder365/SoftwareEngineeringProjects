package aa_B_CompanyAnalyser;

//Stufe 0 = Basis MVC Struktur
//Stufe 1 = Die View
//Stufe 1.1 Kontrollelemente - Controls used for data processing
//Stufe 2 = Geschäftslogik
//Stufe 2.1 Instanzvariabelen
//Stufe 2.2 Methoden des Models
//Stufe 3 = EventHandling und die dazu erforderlichen Methoden
//Stufe 3.1 Kontrollelemente unter Action setzen und Data Binding vornehmen
//Stufe 3.2 Methoden um die Events im Model und View zu bearbeiten

import javafx.application.Application;
import javafx.stage.Stage;

// 0
// - erweitern die klasse mit "Application"
public class ComAnalyser_MVC extends Application {
	

	// 0
	// View, Model, Controller als private (gekapselte Instanzvariablen)
	private ComAnalyser_View view;
	private ComAnalyser_Model model;
	private ComAnalyser_Controller controller;

	//0
	public static void main(String[] args) {
		launch(args);
		
		
	}

	// 0
	@Override
	public void start(Stage stage) {
		// Initialize the GUI (erzeuge MVC Struktur)
		model = new ComAnalyser_Model();
		view = new ComAnalyser_View(stage, model);
		controller = new ComAnalyser_Controller(model, view);
		// Display the GUI after all initialization is complete
		view.start();
	}



}
