package Main;

public class Player extends Token{
    public String name;
    public int PlayerValue;

    public Player(String name, String shape) {
        this.name = name;
        this.shape = shape;
    }

    public String getName() {
        return name;
    }

    public String getShape() {
        final String shape = this.shape;
        return shape;
    }
}