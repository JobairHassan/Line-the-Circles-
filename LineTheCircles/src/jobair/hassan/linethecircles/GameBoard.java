package jobair.hassan.linethecircles;

public class GameBoard {
	 
	private GamePiece gameBoard[];
	private final static int BOARD_SIZE = 9;
 
	public static int getBOARD_SIZE() {
		return BOARD_SIZE;
	}
 
	public GameBoard() {
 
		// init array of game pieces
		gameBoard = new GamePiece[BOARD_SIZE];
 
		ClearBoard();
	}
 
	public void ClearBoard() {
 
		// reset the board to its initial state
		for (int i = 0; i < BOARD_SIZE; i++)
		{
			if (i == 0 ||
				i == 1 ||
				i == 2)
					gameBoard[i] = new GamePiece("Red");
			else if (i == 6 ||
					 i == 7 ||
					 i == 8)
						gameBoard[i] = new GamePiece("Blue");
			else
				gameBoard[i] = new GamePiece("Blank");
		}
	}
 
	public void SetMove(String color, int startLocation, int endLocation) {
		gameBoard[startLocation].setColor("Blank");
		gameBoard[endLocation].setColor(color);
	}
 
	public int CheckForWin() {
 
		// return 0 for no winner
		// return 1 for red wins
		// return 2 for blue wins
 
		// Check for horizontal win
 
		// If the top row is filled with blue pieces
		if (gameBoard[0].getColor() == "Blue" &&
			gameBoard[1].getColor() == "Blue" &&
			gameBoard[2].getColor() == "Blue")
				return 2;
 
		// check the middle row to see if it is filled
		// with blue or red pieces
		if (gameBoard[3].getColor() == "Red" &&
			gameBoard[4].getColor() == "Red" &&
			gameBoard[5].getColor() == "Red")
				return 1;
		if (gameBoard[3].getColor() == "Blue" &&
			gameBoard[4].getColor() == "Blue" &&
			gameBoard[5].getColor() == "Blue")
				return 2;
 
		// If the bottom row is filled with red pieces
		if (gameBoard[6].getColor() == "Red" &&
		    gameBoard[7].getColor() == "Red" &&
		    gameBoard[8].getColor() == "Red")
		        return 1;
 
		// End horizontal win check
 
		// Check for vertical wins
 
		for (int i = 0; i <= 2; i++)
		{
			if (gameBoard[i].getColor() == "Red" &&
				gameBoard[i+3].getColor() == "Red" &&
				gameBoard[i+6].getColor() == "Red")
					return 1;
			if (gameBoard[i].getColor() == "Blue" &&
				gameBoard[i+3].getColor() == "Blue" &&
				gameBoard[i+6].getColor() == "Blue")
					return 2;
		}
 
		// End check for vertical wins
 
		// Check for diagonal wins
 
		if ((gameBoard[0].getColor() == "Red" &&
			 gameBoard[4].getColor() == "Red" &&
			 gameBoard[8].getColor() == "Red") ||
			 gameBoard[2].getColor() == "Red" &&
			 gameBoard[4].getColor() == "Red" &&
			 gameBoard[6].getColor() == "Red")
				return 1;
		if ((gameBoard[0].getColor() == "Blue" &&
			 gameBoard[4].getColor() == "Blue" &&
			 gameBoard[8].getColor() == "Blue") ||
			 gameBoard[2].getColor() == "Blue" &&
			 gameBoard[4].getColor() == "Blue" &&
			 gameBoard[6].getColor() == "Blue")
				return 2;
 
		// End check for diagonal wins
 
		// If no wins are found, return 0 to keep playing
		return 0;
	}
 
}
