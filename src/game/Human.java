package game;

import userInterface.UI;

public class Human extends Player{

    public Human(String name, int value, int type) {
        super(name, value, type);
    }

    int play (Grid grid, int tour){
        int col = UI.getUserEntry();
        return col;
    }
}
