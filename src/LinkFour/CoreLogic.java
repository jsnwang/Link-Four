package LinkFour;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class CoreLogic implements ActionListener{

	static LinkFourView view = new LinkFourView();
    private static JFrame frame1 = new JFrame("Game Over");
    public static int r, c;
    //check if the pieces are together
    public static boolean FourConnected(int w, int x, int y, int z) {
        if (w == x && w == y && w == z) {
            return true;
        }

        return false;
    }
	
    public static int WinVertical() {
        for (r = 0; r < 6; r++) {
            for (c = 0; c < 7; c++) {
                if (Board.board[c][r] != 0) {
                    if (r < 3) {
                        if (FourConnected(Board.board[c][r], Board.board[c][r + 1], Board.board[c][r + 2], Board.board[c][r + 3])) {
                            ;
                            return Board.board[c][r];
                        }
                    }

                }
            }
        }

        return 0;
    }

    public static int WinHorizontal() {
        for (r = 0; r < 6; r++) {
            for (c = 0; c < 7; c++) {
                if (Board.board[c][r] != 0) {
                    if (c < 4) {
                        if (FourConnected(Board.board[c][r], Board.board[c + 1][r], Board.board[c + 2][r], Board.board[c + 3][r])) {
                           
                            return Board.board[c][r];
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static int WinDiagonal() {
    	for (r = 0; r < 6; r++) {
    		for (c = 0; c < 7; c++) {
    			if (Board.board[c][r] != 0) {
    				if(r < 3 && c < 4){ //Prevent out of bound error
						if( FourConnected(Board.board[c][r], Board.board[c + 1][r + 1], Board.board[c + 2][r + 2], Board.board[c + 3][r + 3]) ){ //Check diagonally, down right
							return Board.board[c][r]; //Return the winning player
						}
					}
								
					if(r > 3 && c<4){ //Prevent out of bound error
						if( FourConnected(Board.board[c][r], Board.board[c + 1][r - 1], Board.board[c + 2][r - 2], Board.board[c + 3][r - 3]) ){ //Check diagonally, down left
							return Board.board[c][r]; //Return the winning player
						}
					}
    			}
    		}
    	}
    	return 0;
    }



            
    public static void GameOver(int winner){
        int choice=0;
    	
        if(winner != 0){
        	System.out.println("The winner is: " + winner);
        	if(winner==1){
                JOptionPane.showMessageDialog(null,view.p1Name + " Won!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
                choice = JOptionPane.showConfirmDialog(frame1, view.p1Name + " has won. \n"
                        + "New Game?", "Game Over", JOptionPane.YES_NO_OPTION);
            }
        	else {
                JOptionPane.showMessageDialog(null, view.p2Name + " Won!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
                choice = JOptionPane.showConfirmDialog(frame1, view.p2Name + " has won. \n"
                        + "New Game?", "Game Over", JOptionPane.YES_NO_OPTION);
            }


            if (choice == 0)
            {
            	view.NewGame();
            	
            }
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        //LinkFourView.CreateGrid();
    	//GameOver(CheckWinner());


    }

}