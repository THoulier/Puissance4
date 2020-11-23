package rules;

import game.*;
import user_interface.UI;

public class GameManager extends Game{

    public static void On_update(Grid grid, Player [] tab_players){

        while (tab_players[1].getWin() < 3 && tab_players[2].getWin() < 3) {
            System.out.println("Score : "+ tab_players[1].getWin() +" - "+ tab_players[2].getWin());
            grid.display();
            int col = 0;
            int line = 0;
            int tour = 0;
            while (tour < (grid.getNbline() * grid.getNbcol())) {
                System.out.println("turn n° " + tour);
                col = UI.get_user_entry(); //get column number
                if (col != -1) {
                    line = grid.update_grid(col, tour); //get line number
                    if (line != -1) {
                        grid.display();
                        if (IWinRules.is_winning(col, line, tour, grid.getGrid()) == true) {
                            if (tour % 2 == 0) {
                                System.out.println(tab_players[1].getName() + " won the round");
                                tab_players[1].setWin(1);
                            } else {
                                System.out.println(tab_players[2].getName() + " won the round");
                                tab_players[2].setWin(1);
                            }
                            grid.init_grid();
                            break;
                        }
                        tour++;
                    }
                }
            }
        }
        System.out.println("Final score is : "+tab_players[1].getWin() + " - " + tab_players[2].getWin());
        if (tab_players[1].getWin() == 3) {
            System.out.println("Player " + tab_players[1].getName() + " won the match");
        } else {
            System.out.println("Player " + tab_players[2].getName() + " won the match");
        }
    }
}