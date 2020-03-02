package LinkFour;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class CoreLogic implements ActionListener{

//LinkFourView linkFourView = new LinkFourView();
    private JFrame frame1 = new JFrame("Game Over");
    int r;
    int c;
    Board b = new Board();
    //check if the pieces are together
    public boolean fourConnected(int w, int x, int y, int z) {
        if (w == x && w == y && w == z) {
            return true;
        }

        return false;
    }

    public int winVertical() {
        System.out.println("verti was called");
        for (r = 0; r < 6; r++) {
            for (c = 0; c < 7; c++) {
                if (b.board[c][r] != 0) {
                    if (r < 3) {
                        if (fourConnected(b.board[c][r], b.board[c][r + 1], b.board[c][r + 2], b.board[c][r + 3])) {
                            gameover();
                            return b.board[c][r];
                        }
                    }

                }
            }
        }

        return 0;
    }

    public int winHorizontal() {
        System.out.println("hori was called");
        for (r = 0; r < 6; r++) {
            for (c = 0; c < 7; c++) {
                if (b.board[c][r] != 0) {
                    if (c < 4) {
                        if (fourConnected(b.board[c][r], b.board[c + 1][r], b.board[c + 2][r], b.board[c + 3][r])) {
                            gameover();
                            return b.board[c][r];
                        }
                    }
                }
            }
        }
        return 0;
    }

            public int winDiagonal() {
                System.out.println("diagonal was called");
                for (r = 0; r < 6; r++) {
                    for (c = 0; c < 7; c++) {
                        if (b.board[c][r] != 0) {
                            if (r < 3 && c < 4) {
                                if (fourConnected(b.board[c][r], b.board[c + 1][r + 1], b.board[c + 2][r + 2], b.board[c + 3][r + 3])) {
                                    gameover();
                                    return b.board[c][r];
                                }
                            }
                            if (r>3 && c<4){
                                {
                                    if(fourConnected(b.board[c][r], b.board[c + 1][r - 1], b.board[c + 2][r - 2], b.board[c + 3][r - 3])) {
                                        gameover();
                                        return b.board[c][r];
                                    }
                                }

                            }
                            else {
                                return 0;
                            }
                        }
                    }
                }
                return 0;
            }



    public void gameover(){
        System.out.println("game over was called");
         int horiWinner;
         int vertiWinner;
         int diagWinner;
        horiWinner = winHorizontal();
        diagWinner = winDiagonal();
        vertiWinner = winVertical();

        if(horiWinner!=0){
            if(horiWinner ==1){
                JOptionPane.showMessageDialog(frame1, "color has won.");
            }
            else {
                JOptionPane.showMessageDialog(frame1, "color has won.");
            }
        }
        if(diagWinner!=0){
            if(diagWinner ==1){
                JOptionPane.showMessageDialog(frame1, "color has won.");
            }
            else {
                JOptionPane.showMessageDialog(frame1, "color has won.");
            }
        }
        if(vertiWinner!=0){
            if(vertiWinner ==1){
                JOptionPane.showMessageDialog(frame1, "color has won.");
            }
            else {
                JOptionPane.showMessageDialog(frame1, "color has won.");
            }
        }

    }
    public void actionPerformed(ActionEvent e)
    {
        //CreateGrid();
            gameover();


    }

}