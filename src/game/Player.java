package game;

import userInterface.*;

public class Player {
    private String name;
    private int playerValue;
    private int win;
    private int playerNb;

    public Player(String name, int value, int nb) {
        this.name = name;
        this.playerValue = value;
        this.win = 0;
        this.playerNb = nb;
    }
    int randomIa (Grid grid, int tour){
        int col = (int)(Math.random() * (grid.getNbcol()-1));
        return col;
    }

    String getName() {
        return name;
    }
    int getPlayerValue() { return playerValue; }
    int getWin() {
        return win;
    }
    int getNb() {
        return playerNb;
    }
    int setWin(int value) { win = win + value; return win; }

}