package tictactoe;


public class TicTacToe_Model {
	
	public static final int BOARD_SIZE = 3; // Game board size
	
	public enum ValidMove { X, O }; // Possible moves
	private ValidMove nextMove = ValidMove.X; //Next Move
	
	private ValidMove winner = null; // Set to the winner, if there is one
	
	protected ValidMove[][] board = new ValidMove[BOARD_SIZE][BOARD_SIZE]; // Game board
	
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
	
	public ValidMove getWinner() {
		return winner;
	}
}
