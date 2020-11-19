package game;

public class Player extends Game{
    public String name;
    public int PlayerValue;

    public Player(String name, int value) {
        this.name = name;
        this.PlayerValue = value;
    }

    public String getName() {
        return name;
    }

}