package game;

public class Player extends Game{
    private String name;
    private int PlayerValue;

    public Player(String name, int value) {
        this.name = name;
        this.PlayerValue = value;
    }

    public String getName() {
        return name;
    }

}