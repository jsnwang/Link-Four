public class Board {

    private int rowSize;
    private int colSize;
    private int spotsLeft=0;
    private int [][] gridArray;

    public Board() {
        rowSize = 7;
        colSize = 6;

        gridArray = new int[rowSize][colSize];
        for(int j = 0; j <rowSize; j++) {
            for (int k =0; k <colSize; k++) {
                gridArray[j][k] = 0;
                spotsLeft++;
            }
        }
    }

    public int findFreeSpot(int i) {
        int j =-1;
        for(int k = 0; k <colSize; k++){
            if (gridArray[i][k] == 0) {
                j=k;
            }
        }
        return j;
    }

public int getRowSize(){
        return rowSize;
}
public int getColSize(){
        return colSize;
}

public int getSpotsLeft(){
        return spotsLeft;
}

}
