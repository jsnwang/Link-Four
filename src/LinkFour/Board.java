package LinkFour;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Board {

	 private int[][] board;
	 private int remainingSpots = 0;

	 public Board() {

		board = new int[10][10];
		 for (int i = 0; i < 7; i++) {
			 for (int j = 0; j < 6; j++) {
				 board[i][j] = -1;
				 remainingSpots++;
			 }
		 }
	 }

	    public int[][] getBoard() {
	        return board;
	    }

	    public boolean boardEquals(int a, int b, int c) {
	        return board[a][b] == c;
	    }

	    public void setBoard(int a, int b, int player) {
	        board[a][b] = player;
	    }


	    public int findSpot(int x) {
	        int y = -1;
	        for (int i = 0; i < 7; i++) {
	            if (board[x][i] == 0) {
	                y = i;
	            }
	        }
	        return y;
	    }

	    public int changeplayer(int player, int max_players) {
	        player++;
	        if (player > max_players) {
	            return 1;
	        }
	        return player;
	    }

	    public int getRemainingSpots() {
	 	return remainingSpots;
		}

		//public int getrsize() {
		//return rsize;
		//}

}
