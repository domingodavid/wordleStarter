import java.util.Random;

public class Board {
 
	private String[][] board; 			// holds state of game
	
	//What instance variable can you add to keep track of the size or the number of tiles occupied?
	
	/* default constructor for board */
	// constructors must match exactly the name
	// of the class.
	public Board() {
		
		// instantiate the board
		board = new String[6][5];
	 
	}	
	
	public void guess(Tile[][] board, int currRow) {
		
	}
 
	/*
	 * Requires:
	 * Modifies:
	 * Effect:
	 */
	public boolean word() {
		return true;
	}
	

	public String[][] getBoard() {
		return board;
	}

	public void reset() {
		board = new String[6][5];
	}
 

}
