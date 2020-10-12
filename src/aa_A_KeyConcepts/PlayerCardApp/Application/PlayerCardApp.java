package aa_A_KeyConcepts.PlayerCardApp.Application;

import java.io.FileNotFoundException;

import aa_A_KeyConcepts.PlayerCardApp.Controller.Controller;
import aa_A_KeyConcepts.PlayerCardApp.Model.PlayerCardCollection;
import aa_A_KeyConcepts.PlayerCardApp.Util.Initializer;
import aa_A_KeyConcepts.PlayerCardApp.View.PlayerCardMainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class PlayerCardApp extends Application {

	private PlayerCardCollection myCards; //model  mit Aggregationen
	private PlayerCardMainView mainView; //View
	private Controller controller; //Controller
	
	public void start(Stage stage) throws FileNotFoundException {
		//modell instanzieren
		this.myCards = Initializer.readPlayerFile();
		
		//Controller instanzieren und Model mitgeben
		this.controller = new Controller(this.myCards);
		
		//View instanzieren und Controller mitgeben
		this.mainView = new PlayerCardMainView(this.controller);
		this.controller.setView(this.mainView);
		
		// Wurzel an Szene und Szene in Fenster
		Scene scene = new Scene(this.mainView, 300, 300);
		stage.setScene(scene);
		stage.setTitle("Spierkarten-App");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
