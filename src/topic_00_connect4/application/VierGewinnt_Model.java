package topic_00_connect4.application;

public class VierGewinnt_Model {

	// Konstante Spielfeldgrösse
	public static final int BOARD_SIZE = 7;

	// 2 Spieler
	private Player player1, player2;
	private DiscBoard jetonBoard;
	private Disc jeton;

	public VierGewinnt_Model() {
		this.jetonBoard = new DiscBoard();
		this.player1 = new Player(null);
		this.player2 = new Player(null);
		this.jeton = new Disc(false);
		
		
		

	}
	
}
