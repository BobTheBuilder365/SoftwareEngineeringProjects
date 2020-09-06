package topic_00_CourseSummary;

import javafx.application.Application;
import javafx.stage.Stage;

//Stufe 0 = Basis MVC Struktur
//Stufe 1 = Die View
//Stufe 1.1 Kontrollelemente - Controls used for data processing
//Stufe 2 = Geschäftslogik
//Stufe 2.1 Instanzvariabelen
//Stufe 2.2 Methoden des Models
//Stufe 3 = EventHandling und die dazu erforderlichen Methoden
//Stufe 3.1 Kontrollelemente unter Action setzen und Data Binding vornehmen
//Stufe 3.2 Methoden um die Events im Model und View zu bearbeiten

// 0
public class Summary_MVC extends Application {
	
	// 0 
	private Summary_Model model;
	private Summary_View view;
	private Summary_Controller controller;
	
	// 0
	public static void main(String[] args) {
		launch();
	}

	/**
	 * 0 - Optional. Program initialization can go here, for example, connection to
	 * a database, or a network server. The primaryStage is not yet available.
	 */
	@Override
	public void init() {
		// Nothing to do in this example
	}

	/**
	 * 0 - Note the dependencies between model, view and controller. Additionally,
	 * the view needs access to the primaryStage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Initialize the three MVC components
		this.model = new Summary_Model();
		this.view = new Summary_View(primaryStage, model);
		this.controller = new Summary_Controller(model, view);

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
}
