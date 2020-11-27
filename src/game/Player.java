package game;

public class Player {
    private String name;
    private int PlayerValue;
    private int win;

    public Player(String name, int value) {
        this.name = name;
        this.PlayerValue = value;
        this.win = 0;
    }

    public String getName() {
        return name;
    }
    public int getWin() {
        return win;
    }
    public int setWin(int value) { win = win + value; return win; }

}