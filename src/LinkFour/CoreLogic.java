package LinkFour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CoreLogic {

Board board = new Board();
public void boardLogic(Board newBoard){
    int connect4 = 4;
    int remainingSpots = 0;
    board = newBoard;
  //  remainingSpots = board.getremainingSpots();
    //rsize = board.getrsize();
    //csize = board.getcsize();
}
    //button on click, change the color of the last available slot in the corresponding column.
    //We check that this is the last one by making the there is a color black or yellow in the slot below it.


    public void checkHorizontalWin(){
    //Check if there are 4 same color in a row within the grid
}

public void checkVerticalWin(){
    //Check if there are 4 same color in the col within the grid
}

public void checkDiagonalWin(){
    //check diagnoal in the matrix
}
}
