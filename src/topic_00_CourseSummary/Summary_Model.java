package topic_00_CourseSummary;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import tictactoe.TicTacToe_Model.ValidMove;

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


/**
 * ModelPorpertyExample Erläuterung
 * This model simulates external changes to data. It uses a thread that randomly
 * increments or decrements the value.
 * 
 * In order for the value to generate events (when changed), we must use the
 * class javafx.beans.property.SimpleIntegerProperty. An object of this class
 * contains a single integer value, and generate events when the value changes.
 */
// 0
public class Summary_Model {

	// 2.1 Pet - Properties Bindings
	private final SimpleObjectProperty<Pet> petProperty = new SimpleObjectProperty<>();
	
	
	
	// 2.1 - TicTacToe
	public static final int BOARD_SIZE = 3; // Game board size	
	public enum ValidMove { X, O }; // Possible moves
	private ValidMove nextMove = ValidMove.X; //Next Move
	private ValidMove winner = null; // Set to the winner, if there is one
	protected ValidMove[][] board = new ValidMove[BOARD_SIZE][BOARD_SIZE]; // Game board	

	// 2.1 - ModelPropertyExample
	// final promises that this object will not change
	private final SimpleIntegerProperty value;
	private Simulator sim;	
	
	
	//
	
	// 0 Konstruktor
	protected Summary_Model() {
		
		// 2.3 ModelPropertyExample
		value = new SimpleIntegerProperty();
		value.setValue(0);
		sim = new Simulator();
		sim.setDaemon(true);
		sim.start();
	}

	
	// 2.2 Dice
	public int getRandomValue() {
		return (int) (Math.random() * 6 + 1);
	}

	

	// 2.2 Pet - Properties Bindings
	public void savePet(Pet.Species species, Pet.Gender gender, String name) {
		petProperty.set(new Pet(species, gender, name));
	}
	
	// 2.2 Pet - Properties Bindings	
	public void deletePet() {
		petProperty.set(null);
	}
	
	// 2.2 Pet - Properties Bindings	
	public Pet getPet() {
		return petProperty.get();
	}
	
	// 2.2 Pet - Properties Bindings	
	public SimpleObjectProperty<Pet> petProperty() {
		return petProperty;
	}
	
	
	
	// 2.2 TicTacToe
	/**
	 * Method to make the game move
	 * Make a move in the indicated place, alternating X and O.
	 * We can only move in a blank (null) space.
	 */
	public boolean makeMove(int col, int row) {
		boolean moveMade = false;
		if (winner == null && board[col][row] == null) {
			board[col][row] = nextMove;
			nextMove = (nextMove == ValidMove.X) ? ValidMove.O : ValidMove.X;
			moveMade = true;
		}
		checkWinner();
		return moveMade;
	}

	// 2.2 TicTacToe
	/**
	 * Method to check if someone has one
	 * Set the result if someone has won
	 */
	private void checkWinner() {
		for (int i = 0; i < BOARD_SIZE && winner == null; i++) {
			boolean rowWinner  = true;
			boolean colWinner = true;
			for (int j = 1; j < BOARD_SIZE; j++) {
				rowWinner &= board[i][0] != null && board[i][0] == board[i][j];
				colWinner &= board[0][i] != null && board[0][i] == board[j][i];
			}
			if (rowWinner) winner = board[i][0];
			if (colWinner) winner = board[0][i];
		}
		boolean diag1Winner = true;
		boolean diag2Winner = true;
		for (int i = 1; i < BOARD_SIZE; i++) {
			diag1Winner &= board[0][0] != null && board[0][0] == board[i][i];
			diag2Winner &= board[0][BOARD_SIZE-1] != null && board[0][BOARD_SIZE-1] == board[i][BOARD_SIZE-1-i];
		}
		if (diag1Winner) winner = board[0][0];
		if (diag2Winner) winner = board[0][BOARD_SIZE-1];
	}

	// 2.2 TicTacToe
	public ValidMove getWinner() {
		return winner;
	}

	// 2.2 ModelPropertyExample
	public SimpleIntegerProperty valueProperty() {
		return value;
	}
	// 2.2 ModelPropertyExample
	public int getValue() {
		return value.get();
	}
	// 2.2 ModelPropertyExample
	public int incrementValue() {
		int val = value.get();
		val++;
		value.setValue(val);
		return val;
	}
	// 2.2 ModelPropertyExample	
	/**
	 * Called, when we should stop our simulation
	 */
	public void stop() {
		if (sim != null) sim.interrupt();
	}
	// 2.4 ModelPropertyExample
	/**
	 * We haven't seen threads yet, but a thread is just an independent,
	 * parallel activity. In this case, the thread randomly increments or
	 * decrements our value
	 */
	private class Simulator extends Thread {
		@Override
		public void run() {
			try {
				while (true) {
					int rand = (int) (Math.random() * 5);
					if (rand == 1) // 20% chance of increment
						value.setValue(value.get()+1);
					else if (rand == 2)// 20% chance of decrement
						value.setValue(value.get()-1);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
			}
		}
	}
}
