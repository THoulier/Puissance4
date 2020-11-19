package game;


public class Ia extends Game{
    public String name;
    public int ia_value;

    public Ia(String name, int value) {
        this.name = name;
        this.ia_value = value;
    }

    public String getName() {
        return name;
    }


}