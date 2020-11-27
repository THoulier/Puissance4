package game;

import java.util.Scanner;
import userInterface.*;
import rules.*;

public class Game{

    public static void main(String[] var0) {

        Player [] tabPlayers = UI.interfacePlayer(); //Create two players
        Grid grid = new Grid(3,4); //Create the grid

        GameManager.onUpdate(grid, tabPlayers); //Update the grid

    }
}