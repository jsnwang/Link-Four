package LinkFour;

public class Board {

	public static int[][] board = new int[7][6];
	public int playerTurn = 1;
	public static int movesLeft = 42;

	 
	 
	public Board() {

		for(int r = 0; r < 6; r++){
			for(int c = 0; c < 7; c++){
				board[c][r] = 0;
			}
		}
	}
	 
	public int CheckColumn(int col){
		int c = col;
		int r;
		for(r = 0; r < 6; r++){
			if( board[c][r] != 0){
				if(r == 0){
					break; 
				}
				r--;
				break;
			}else if(r == 5){ 
				break;
			}
		}
		board[col][r] = playerTurn; 
		return r;
	}


	public void ChangePlayer() {
		movesLeft--;
	      if(playerTurn == 1)
	      {
	        playerTurn = 2;
	      }
	      else
	      {
	        playerTurn = 1;
	      }
	 }
	
	public int[][] GetBoard()
	{
		return board;
	}


}
