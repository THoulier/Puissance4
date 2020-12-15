package game;

import userInterface.UInterface;

public class Human extends Player{

    private int exit;

    public Human(String name, int value, int type) {
        super(name, value, type);
        exit = 0;
    }

    int play (Grid grid, int tour, UInterface ui){

        int col = ui.getUserEntry();

        if (ui.getExit() == true){
            exit = 1;
        }
        return col;
    }

    int getExit(){ return exit;}
}
