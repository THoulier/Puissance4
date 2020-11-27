package rules;

import game.*;
import userInterface.UI;

public class GameManager {

<<<<<<< HEAD
    public static void onUpdate(Grid grid, Player [] tab_players){

=======
    public static void onUpdate(Grid grid, Player [] tapPlayers){
        int round = 1;
        while (tapPlayers[1].getWin() < 3 && tapPlayers[2].getWin() < 3) {
            System.out.println("Score : "+ tapPlayers[1].getWin() +" - "+ tapPlayers[2].getWin());
            System.out.println("Round n° " + round);
            grid.display();

            int col = 0; int line = 0;
            int tour = 0; int offset = 0;

            if (round%2 == 0){ tour = 1; offset = 1; }
            else { tour = 0; offset = 0; }

            while (tour < ((grid.getNbline() * grid.getNbcol()) + offset)) {
                System.out.println("turn n° " + tour);
                col = UI.getUserEntry(); //get column number
                if (col != -1) {
                    line = grid.updateGrid(col, tour); //get line number
                    if (line != -1) {
                        grid.display();
                        if (IWinRules.isWinning(col, line, tour, grid.getGrid()) == true) {
                            if (tour % 2 == 0) {
                                System.out.println(tapPlayers[1].getName() + " won the round");
                                tapPlayers[1].setWin(1);
                            } else {
                                System.out.println(tapPlayers[2].getName() + " won the round");
                                tapPlayers[2].setWin(1);
                            }
                            grid.initGrid();
                            break;
                        }
                        else if (IWinRules.isWinning(col, line, tour, grid.getGrid()) == false && tour == ((grid.getNbline() * grid.getNbcol()) + offset)-1){
                            System.out.println("Round ended in a draw, there is no winner");
                            grid.initGrid();
                            break;
                        }
                        tour++;
                    }
                }
            }
            round ++;
        }
        System.out.println("Final score is : "+tapPlayers[1].getWin() + " - " + tapPlayers[2].getWin());
        if (tapPlayers[1].getWin() == 3) {
            System.out.println("Player " + tapPlayers[1].getName() + " won the match");
        } else {
            System.out.println("Player " + tapPlayers[2].getName() + " won the match");
        }
>>>>>>> 7f86f17b0120b6fda702f5fb09c7275e2ba00d81
    }
}