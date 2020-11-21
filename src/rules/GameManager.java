package rules;

import game.*;
import user_interface.UI;

public class GameManager extends Game{

    public static void On_update(Grid grid, Player [] tab_players){
        grid.display();
        int col = 0;
        int line = 0;
        int tour = 0;
        while(tour<(grid.getNbline()*grid.getNbcol())){
            System.out.println("tour numero"+ tour);
            col = UI.get_user_entry(); //get column number
            if (col != -1) {
                line = grid.update_grid(col, tour); //get line number
                if (line != -1) {
                    grid.display();
                    if (IWinRules.is_winning(col, line, tour, grid.getGrid()) == true) {
                        if (tour%2 == 0){
                            System.out.println(tab_players[1].getName() + " a gagné la manche");
                        } else{
                            System.out.println(tab_players[2].getName() + " a gagné la manche");
                        }
                        break;
                    }
                    tour++;
                }
            }


        }
    }
}