package game;


public class Ia extends Player{
    int iaType;
    public Ia(String name, int value, int type, int nb) {
        super(name, value, nb);
        this.iaType = type;
    }

    int randomIa (Grid grid){
        int col = (int)(Math.random() * grid.getNbcol());
        col ++;
        return col;
    }

}