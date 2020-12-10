package game;

import userInterface.UInterface;

public class Human extends Player{

    public Human(String name, int value, int type) {
        super(name, value, type);
    }

    int play (Grid grid, int tour, UInterface ui){
        int col = ui.getUserEntry();
        return col;
    }
}
