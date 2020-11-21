package rules;

import game.*;
import user_interface.UI;

public class GameManager extends Game{

    public static void On_update(Grid grid){
        grid.display();
        int col = 0;
        int line = 0;
        int tour = 1;
        while(tour<=(grid.getNbline()*grid.getNbcol())){
            System.out.println("tour numero"+ tour);
            col = UI.get_user_entry(); //get column number
            if (col != -1) {
                line = grid.update_grid(col, tour); //get line number
                if (line != -1) {
                    grid.display();
                    if (IWinRules.is_winning(col, line, tour, grid.getGrid()) == true) {
                        System.out.println("Gagné!");
                        break;
                    }
                    tour++;
                }
            }


        }
    }
}