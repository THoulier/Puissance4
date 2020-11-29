package game;

import java.util.Scanner;
import userInterface.*;
import rules.*;

public class Game{

    public static void main(String[] var0) {

        Player [] tab_players = UI.interfacePlayer(); //Create two players
        Grid grid = new Grid(6,7); //Create the grid

        int round = 1;

        while (tab_players[1].getWin() < 3 && tab_players[2].getWin() < 3) {
            System.out.println("Score : "+ tab_players[1].getWin() +" - "+ tab_players[2].getWin());
            System.out.println("Round n° " + round);
            grid.display();

            int col = 0; int line = 0;
            int tour = 0; int offset = 0;
            int real_turn = 1;
            if (round%2 == 0){ tour = 1; offset = 1; }
            else { tour = 0; offset = 0; }

            while (tour < ((grid.getNbline() * grid.getNbcol()) + offset)) {

                System.out.println("turn n° " + real_turn);
                System.out.println(tab_players[1].getPlayerValue());
                System.out.println(tab_players[2].getPlayerValue());

                if (tab_players[1].getPlayerValue()==2  && tour%2==0) {
                    System.out.println(tab_players[1].randomIa(grid));
                    col = tab_players[1].randomIa(grid);
                }
                else if (tab_players[2].getPlayerValue()==2  && tour%2!=0){
                    col = tab_players[1].randomIa(grid);
                }
                else {
                    col = UI.getUserEntry(); //get column number
                }

                if (grid.colValidity(col) == true) {
                    line = grid.updateGrid(col, tour); //get line number
                    if (line != -1) {
                        grid.display();
                        if (grid.isWinning(col, line, tour) == true) {
                            if (tour % 2 == 0) {
                                System.out.println(tab_players[1].getName() + " won the round");
                                tab_players[1].setWin(1);
                            } else {
                                System.out.println(tab_players[2].getName() + " won the round");
                                tab_players[2].setWin(1);
                            }
                            grid.initGrid();
                            break;
                        }
                        else if (grid.isWinning(col, line, tour) == false && tour == ((grid.getNbline() * grid.getNbcol()) + offset)-1){
                            System.out.println("Round ended in a draw, there is no winner");
                            grid.initGrid();
                            break;
                        }
                        tour++;
                        real_turn++;
                    }
                }
            }
            round ++;
        }
        System.out.println("Final score is : "+tab_players[1].getWin() + " - " + tab_players[2].getWin());
        if (tab_players[1].getWin() == 3) {
            System.out.println("Player " + tab_players[1].getName() + " won the match");
        } else {
            System.out.println("Player " + tab_players[2].getName() + " won the match");
        }
    }
}