package game;

import userInterface.*;

abstract public class Player {
    private final String name;
    private final int playerValue;
    private int win;
    private final int playerNb;

    public Player(String name, int value, int nb) {
        this.name = name;
        this.playerValue = value;
        this.win = 0;
        this.playerNb = nb;
    }

    abstract int play (Grid grid);

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