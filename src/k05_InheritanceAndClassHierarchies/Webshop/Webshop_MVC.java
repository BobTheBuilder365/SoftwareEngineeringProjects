package k05_InheritanceAndClassHierarchies.Webshop;

//Stufe 0 = Basis MVC Struktur
//Stufe 1 = Die View
//Stufe 1.1 Kontrollelemente - Controls used for data processing
//Stufe 2 = Geschäftslogik
//Stufe 2.1 Instanzvariabelen
//Stufe 2.2 Methoden des Models
//Stufe 2.3 Im Konstruktor
//Stufe 2.4 Threads / innere Klassen
//Stufe 3 = EventHandling und die dazu erforderlichen Methoden
//Stufe 3.1 Kontrollelemente unter Action setzen und Data Binding vornehmen
//Stufe 3.2 Methoden um die Events im Model und View zu bearbeiten


import javafx.application.Application;
import javafx.stage.Stage;


// 0
public class Webshop_MVC extends Application {
	
	// 0
	private Webshop_Model model;
	private Webshop_View view;
	private Webshop_Controller controller;
	
	// 0
	public static void main(String[] args) {
		launch(args);
		
		
	}

	// 0
	@Override
	public void start(Stage primaryStage) throws Exception{
		// Initialize the three MVC components
		model = new Webshop_Model();
		view = new Webshop_View(primaryStage, model);
		controller = new Webshop_Controller(model, view);

		// Display the GUI after all initialization is complete
		view.start();
	}
	/**
	 * 0 - Optional. An opportunity to clean house, for example, disconnecting from
	 * a database or network server, before the program ends.
	 */
	@Override
	public void stop() {
		if (view != null)
			view.stop();
	}
	/**
	 * 0 - Optional. Program initialization can go here, for example, connection to
	 * a database, or a network server. The primaryStage is not yet available.
	 */
	@Override
	public void init() {
		// Nothing to do in this example
	}
	
}
