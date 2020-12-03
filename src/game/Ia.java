package game;


public class Ia extends Player{
    int iaType;
    public Ia(String name, int value, int type, int nb) {
        super(name, value, nb);
        this.iaType = type;
    }

    int play (Grid grid){
        int col = (int)(Math.random() * (grid.getNbcol()-1)) + 1;
        return col;
    }

}