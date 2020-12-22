package iaAlgo;

import game.Grid;

public class RandomIa extends Algorithm{
    public int iaPlay(int i, Grid grid){
        return (int) (Math.random() * (grid.getNbcol() - 1)) + 1;
    }
}
