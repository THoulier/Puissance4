package game;

import java.util.Scanner;
import user_interface.*;

public class Game{

    public static void main(String[] var0) {

        UI.interface_player();

        Grid grid = new Grid(6,7);
        grid.display();


        int col = 0;
        for (int i=1; i<(grid.getNbline()*grid.getNbcol()); i++){
            col = UI.get_user_entry();
            grid.update_grid(col,i);
            grid.display();
        }

    }
}