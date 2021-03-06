package topic_00_poker.MVC;

import javafx.application.Application;
import javafx.stage.Stage;
import topic_00_poker.controller.PokerGameController;
import topic_00_poker.model.PokerGameModel;
import topic_00_poker.view.PokerGameView;

public class PokerGame extends Application {
	public static final int NUM_PLAYERS = 2;
	PokerGameModel model;
	PokerGameView view;
	PokerGameController controller;
	
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	// Create and initialize the MVC components
    	model = new PokerGameModel();
    	view = new PokerGameView(primaryStage, model);
    	controller = new PokerGameController(model, view);
    }
}
