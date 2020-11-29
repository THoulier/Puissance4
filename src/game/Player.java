package game;

public class Player {
    private String name;
    private int playerValue;
    private int win;

    public Player(String name, int value) {
        this.name = name;
        this.playerValue = value;
        this.win = 0;
    }
    int randomIa (Grid grid){

        int col = (int)(int)(Math.random() * ((grid.getNbcol() - 1) + 1)) + 1;
        return col;
    }

    String getName() {
        return name;
    }
    int getPlayerValue() { return playerValue; }
    int getWin() {
        return win;
    }
    int setWin(int value) { win = win + value; return win; }

}