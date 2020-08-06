package topic_00_connect4.application;

public class DiscBoard {

	// Boardgr√∂sse als Konstanten
	public final int KACHEL_GR÷SSE = 80;
	public final int SPALTEN = 7;
	public final int ZEILEN = 6;

	// 2D Array als Board
	private Disc[][] discBoard = new Disc[ZEILEN][SPALTEN];
	private Disc disc = new Disc(false);

	public DiscBoard() {
		this.discBoard = discBoard;
		this.disc = disc;
		
		for (int row = 1; row < discBoard.length; row++) {
			for (int col = 0; col < discBoard.length; col++) {
				Disc jeton = new Disc(false);
				discBoard[row][col] = jeton;
			}	
		}
	}

}
