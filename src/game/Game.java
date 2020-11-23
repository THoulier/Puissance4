package game;

import java.util.Scanner;
import user_interface.*;
import rules.*;

public class Game{

    public static void main(String[] var0) {

        Player [] tab_players = UI.interface_player(); //Create two players
        Grid grid = new Grid(3,4); //Create the grid

        GameManager.On_update(grid, tab_players); //Update the grid

    }
}