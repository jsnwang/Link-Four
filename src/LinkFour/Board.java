package LinkFour;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Board {

	public static int[][] board = new int[7][6];
	public int playerTurn = 1;

	 
	 
	public Board() {

		for(int r = 0; r < 6; r++){
			for(int c = 0; c < 7; c++){
				board[c][r] = 0; //Loop through array and set all values to 0
			}
		}
	}
	 
	public int CheckColumn(int col){
		int c = col;
		int r;
		for(r = 0; r < 6; r++){
			//System.out.println(board[c][r]);
			if( board[c][r] != 0){
				if(r == 0){
					break; //Return false if column is already filled
				}
				r--;
				break;
			}else if(r == 5){ //Last row of the column
				break;
			}
		}
		board[col][r] = playerTurn; //Set the value of that position to the player's piece
		
		 
			
		return r;
	}


	public void ChangePlayer() {
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
