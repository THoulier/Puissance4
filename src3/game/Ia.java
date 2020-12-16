package game;

import userInterface.UInterface;
import iaAlgo.*;

public class Ia extends Player{
    private final int iaType;
    private final Algorithm algo;

    public Ia(String name, int value, int type, int nb) {
        super(name, value, nb);
        this.iaType = type;
        algo = new RandomIa();

    }

    int play (Grid grid, int tour, UInterface ui){
        int col = 0;
        col = algo.iaPlay(tour, grid);
        return col;
    }

    int getExit(){
        return 0;
    }
}