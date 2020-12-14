package game;

import userInterface.UInterface;

public class Human extends Player{

    private int exit;

    public Human(String name, int value, int type) {
        super(name, value, type);
        exit = 0;
    }

    int play (Grid grid, int tour, UInterface ui){
        int col = 0;
        String str = ui.getUserEntry();
        if (ui.userExit(str) == true){
            exit = 1;
        } else {
            col = ui.userEntry2Col(str);
        }
        return col;
    }

    int getExit(){ return exit;}
}
