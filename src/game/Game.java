package game;

import java.util.Scanner;
import userInterface.*;
import rules.*;
import java.io.File;

public class Game{

    public static void main(String[] var0) {
        File log = new File("log.txt");
        log.delete();
        Player [] tab_players = UI.interfacePlayer(); //Create two players
        Grid grid = new Grid(6,7); //Create the grid

        int round = 1;
        String logText = "";

        while (tab_players[1].getWin() < 3 && tab_players[2].getWin() < 3) {
            logText = "Round begins\n";
            FileWritter.fillInLog(logText);

            System.out.println("Score : "+ tab_players[1].getWin() +" - "+ tab_players[2].getWin());
            System.out.println("Round n° " + round);
            grid.display();

            int col = 0; int line = 0;
            int tour = 0; int offset = 0;
            int real_turn = 1; int playerNb = 1;
            if (round%2 == 0){ tour = 1; offset = 1; }
            else { tour = 0; offset = 0; }

            while (tour < ((grid.getNbline() * grid.getNbcol()) + offset)) {
                if (tour%2 != 0){ playerNb = 2; }
                else{ playerNb = 1; }
                System.out.println(playerNb);
                System.out.println(tab_players[playerNb].getPlayerValue());
                System.out.println("turn n° " + real_turn);

                if (tab_players[playerNb].getPlayerValue()==2) { //if player is ia
                    col = tab_players[playerNb].randomIa(grid, tour);
                } else {
                    col = UI.getUserEntry(); //get column number
                }

                if (grid.colValidity(col, playerNb) == true) {

                    logText = "Player " + tab_players[playerNb].getNb()+" plays " + (col+1) +"\n";
                    FileWritter.fillInLog(logText);

                    line = grid.updateGrid(col, tour); //get line number
                    if (line != -1) {
                        grid.display();
                        if (grid.isWinning(col, line, tour) == true) {
                            System.out.println(tab_players[playerNb].getName() + " won the round");
                            tab_players[1].setWin(1);

                            logText = "Player "+ playerNb + " wins\n";
                            FileWritter.fillInLog(logText);
                            logText = "Score "+ tab_players[1].getWin() +" - "+ tab_players[2].getWin() + "\n";
                            FileWritter.fillInLog(logText);
                            grid.initGrid();
                            break;
                        }
                        else if (grid.isWinning(col, line, tour) == false && tour == ((grid.getNbline() * grid.getNbcol()) + offset)-1){
                            System.out.println("Round ended in a draw, there is no winner");
                            grid.initGrid();
                            logText = "Equality\n";
                            FileWritter.fillInLog(logText);
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
        logText = "Game ends\n";
        FileWritter.fillInLog(logText);

    }
}