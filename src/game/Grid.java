package game;

import rules.*;
import userInterface.FileWritter;

public class Grid {

    //Attributes
    private final int nbcol;
    private final int nbline;
    private final int [][] grid;

    //Constructor
    Grid(int c, int l){
        nbcol = c;
        nbline = l;
        grid = new int [nbline][nbcol];
        for (int i = 0; i<nbline; i++){
            for (int j = 0; j<nbcol; j++){
                grid[i][j] = 0;
            }
        }
    }
    //Get functions
    int getNbcol() { return nbcol; }
    int getNbline(){
        return nbline;
    }
    //int getCell(int i , int j){ return grid[i][j]; }

    //Col number validity
    boolean colValidity(int col, int playerNb){
        String logText = "";

        col ++;
        if (col > nbcol || col<1){
            System.out.println("Column number must be between 1 and " + nbcol);
            logText = "Error column invalid " + col + "\n";
            FileWritter.fillInLog(logText);
            return false;
        }
        col--;
        if (grid[0][col] != 0) {
            System.out.println("Column number " + col + " is full");
            logText = "Error column full " + (col+1) + "\n";
            FileWritter.fillInLog(logText);
            return false;
        }
        return true;
    }

    //Winner
    boolean isWinning(int column, int line, int i){
        int playerValue = 0;
        if (i%2 == 0){
            playerValue = 1;
        } else{
            playerValue = 2;
        }

        int align = 0; int max = 0;

        int col = column; int li = line;
        //Vertical
        while (li < nbline && grid[li][col] == playerValue){ li ++; align ++; }
        if (align > max){ max = align; }

        //Horizontal
        align = -1; col = column; li = line;
        while (col < nbcol && grid[li][col] == playerValue){ col ++; align ++; }
        col = column; li = line;
        while (col >= 0 && grid[li][col] == playerValue){ col --; align ++; }
        if (align > max){ max = align; }

        //Diag1
        align = -1; col = column; li = line;
        while (li < nbline && col < nbcol && grid[li][col] == playerValue){ col ++; li ++; align ++; }
        col = column; li = line;
        while (li >= 0 && col >= 0 && grid[li][col] == playerValue){ col --; li --; align ++; }
        if (align > max){ max = align; }

        //Diag2
        align = -1; col = column; li = line;
        while (li < nbline && col >= 0 && grid[li][col] == playerValue){ col --; li ++; align ++; }
        col = column; li = line;
        while (li >= 0 && col < nbcol && grid[li][col] == playerValue){ col ++; li --; align ++; }
        if (align > max){ max = align; }

        if (max >= 4){
            return true;
        }

        return false;
    }


    //Update grid
    int updateGrid(int col, int tour){
        int cpt = nbline - 1;
        while (grid[cpt][col] != 0 && cpt != -1) {
            cpt--;
        }
        if (tour % 2 == 0) {
            grid[cpt][col] = 1;
        } else {
            grid[cpt][col] = 2;
        }
        return cpt;
    }

    //Re initialize the grid
    void initGrid(){
        for (int i = 0; i<nbline; i++){
            for (int j = 0; j<nbcol; j++){
                grid[i][j] = 0;
            }
        }
    }
    //Display grid
    void display(){
        System.out.println();
        for (int j = 1; j<=nbcol; j++){
                System.out.print(" " + j + " ");
        }
        System.out.println();
        for (int i = 0; i<nbline; i++){
            for (int j = 0; j<nbcol; j++){
                if (grid[i][j] == 0) {
                    System.out.print(" " + "." + " ");
                }
                if (grid[i][j] == 1) {
                    System.out.print(" " + "x" + " ");
                }
                if (grid[i][j] == 2) {
                    System.out.print(" " + "o" + " ");
                }
            }
            System.out.println();
        }

    }
}