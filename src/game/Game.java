package game;

import java.util.Scanner;
import userInterface.*;
import rules.*;
import java.io.File;

public class Game{

    //Constructor
    Game(){}

    //Main function :  run the game
    public static void main(String[] var0) {
        Game game = new Game(); //Create a new game

        Player [] tab_players = game.gameInit(); //Get the filled in tab players
        int endType = game.runGame(tab_players, game); //Run the main function

        game.gameEnds(tab_players, game, endType); //game ends

    }

    //Init game
    Player [] gameInit(){
        File log = new File("log.txt");
        log.delete();
        Player [] tab_players = UI.interfacePlayer(); //Create two players
        return tab_players;
    }

    //Run the main game
    int runGame(Player [] tab_players, Game game){
        Grid grid = new Grid(6,7); //Create the grid

        int round = 1;
        int exit1 = 0;
        while (exit1 != 1 && tab_players[1].getWin() < 3 && tab_players[2].getWin() < 3) {
            game.writeLogText("Round begins\n");

            System.out.println("Score : "+ tab_players[1].getWin() +" - "+ tab_players[2].getWin());
            System.out.println("Round n° " + round);
            grid.display();

            int col = 0; int line = 0;
            int tour = 0; int offset = 0;
            int real_turn = 1; int playerNb = 1;
            if (round%2 == 0){ tour = 1; offset = 1; }
            else { tour = 0; offset = 0; }

            int exit2 = 0;
            while (exit2 != 1 && tour < ((grid.getNbline() * grid.getNbcol()) + offset)) {
                if (tour%2 != 0){ playerNb = 2; }
                else{ playerNb = 1; }
                System.out.println(playerNb);
                System.out.println(tab_players[playerNb].getPlayerValue());
                System.out.println("turn n° " + real_turn);

                int [] tabPlay = tab_players[playerNb].play(grid, tour); //player[playerNb] plays
                col = tabPlay[0];
                exit1 = tabPlay[1];
                if (exit1 == 1){
                    break;
                }
                System.out.println(exit1);

                if (grid.colValidity(col, playerNb) == true) {

                    game.writeLogText("Player " + tab_players[playerNb].getNb()+" plays " + (col+1) +"\n");
                    line = grid.updateGrid(col, tour); //get line number

                    if (line != -1) {
                        grid.display();
                        if (grid.isWinning(col, line, tour) == true) {
                            System.out.println(tab_players[playerNb].getName() + " won the round");
                            tab_players[playerNb].setWin();

                            game.writeLogText("Player "+ playerNb + " wins\n");
                            game.writeLogText("Score "+ tab_players[1].getWin() +" - "+ tab_players[2].getWin() + "\n");
                            grid.initGrid();
                            exit2 = 1;
                        }
                        else if (grid.isWinning(col, line, tour) == false && tour == ((grid.getNbline() * grid.getNbcol()) + offset)-1){
                            System.out.println("Round ended in a draw, there is no winner");
                            grid.initGrid();
                            game.writeLogText("Equality\n");
                            exit2 = 1;
                        }
                        tour++;
                        real_turn++;
                    }
                }
            }
            round ++;
        }
        return exit1;
    }

    //game ends
    void gameEnds(Player [] tab_players, Game game, int endType){

        if (endType == 0) {
            System.out.println("Final score is : " + tab_players[1].getWin() + " - " + tab_players[2].getWin());
            if (tab_players[1].getWin() == 3) {
                System.out.println("Player " + tab_players[1].getName() + " won the match");
            } else {
                System.out.println("Player " + tab_players[2].getName() + " won the match");
            }
            game.writeLogText("Game ends\n");
        } else {
            System.out.println("A player has left the game\n");
            game.writeLogText("A player has left the game\n");
            game.writeLogText("Game ends\n");
        }
    }

    //Write in logs file
    void writeLogText(String logText){
        FileWritter.fillInLog(logText);
    }
}