package iaAlgo;

import game.Grid;

public class MonkeyIa extends Algorithm{
    public int iaPlay(int i, Grid grid){

        int[][] gridBis = grid.copyGrid(); //copy the real grid in a virtual one
        int playerValue = 0;
        if (i%2 == 0){
            playerValue = 1;
        } else{
            playerValue = 2;
        }

        int [] tabMax = new int[grid.getNbcol()];

        int align = 0; int max = 0;
        //simulate each plays and calculate the alignment. The play with the best alignment will be the next play
        for (int j = 0; j< grid.getNbcol(); j++) {

            if (grid.colIsFull(j) == false) {



                int line = grid.getNbline() - 1;
                while (line > 0 && grid.getCell(line, j) != 0) {
                    line--;
                }
                gridBis[line][j] = playerValue;
                int li = line;
                int col = j;

                //Vertical
                align = 0;
                max = 0;
                while (li < grid.getNbline() && gridBis[li][col] == playerValue) {
                    li++;
                    align++;
                }
                if (align > max) {
                    max = align;
                }


                //Horizontal
                align = -1;
                col = j;
                li = line;
                while (col < grid.getNbcol() && gridBis[li][col] == playerValue) {
                    col++;
                    align++;
                }
                col = j;
                li = line;
                while (col >= 0 && gridBis[li][col] == playerValue) {
                    col--;
                    align++;
                }
                if (align > max) {
                    max = align;
                }

                //Diag1
                align = -1;
                col = j;
                li = line;
                while (li < grid.getNbline() && col < grid.getNbcol() && gridBis[li][col] == playerValue) {
                    col++;
                    li++;
                    align++;
                }
                col = j;
                li = line;
                while (li >= 0 && col >= 0 && gridBis[li][col] == playerValue) {
                    col--;
                    li--;
                    align++;
                }
                if (align > max) {
                    max = align;
                }

                //Diag2
                align = -1;
                col = j;
                li = line;
                while (li < grid.getNbline() && col >= 0 && gridBis[li][col] == playerValue) {
                    col--;
                    li++;
                    align++;
                }
                col = j;
                li = line;
                while (li >= 0 && col < grid.getNbcol() && gridBis[li][col] == playerValue) {
                    col++;
                    li--;
                    align++;
                }
                if (align > max) {
                    max = align;
                }

                tabMax[j] = max;

                gridBis[line][j] = 0;
            }
        }

        int bestPlay = 0; int bestCol = 0;
        for (int k = 0; k< grid.getNbcol(); k++){

            if (tabMax[k] > bestPlay){
                bestPlay = tabMax[k];
                bestCol = k;
            }
        }
        return bestCol;
    }
}
