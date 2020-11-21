package game;

import java.util.Scanner;
import user_interface.*;
import rules.*;

public class Game{

    public static void main(String[] var0) {

        UI.interface_player(); //Create two players
        Grid grid = new Grid(6,7); //Create the grid

        GameManager.On_update(grid); //Update the grid

    }
}