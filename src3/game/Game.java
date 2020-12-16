package game;

import java.util.Scanner;
import userInterface.*;
import java.io.File;

public class Game{
    //Attributes
    private final Player [] tabPlayers;
    private final Grid grid;
    private final UInterface ui;
    private final FileWritter fileWritter;
    private final Displayer displayer;
    private int exit;

    //Constructor
    Game(){
        displayer = new Displayer();
        ui = new UI();
        fileWritter = new FileWritter();
        tabPlayers = ui.interfacePlayer(); //Get the filled in tab players
        grid = new Grid(7,6); //Create the grid
        exit = 0;
    }

    //Main function :  run the game
    public static void main(String[] var0) {
        File log = new File("log.txt");
        log.delete();
        Game game = new Game(); //Create a new game
        game.runGame(); //Run the main function
        game.gameEnds(); //game ends
    }





    //Run the main game
    void runGame(){

        int round = 1;

        while (tabPlayers[1].getWin() < 3 && tabPlayers[2].getWin() < 3 && exit != 1) {
            writeLogText("Round begins\n");

            displayer.displayStartInformation(tabPlayers, round);
            displayer.gridDisplay(grid);

            int col = 0; int line = 0;
            int tour = 0; int offset = 0;
            int realTurn = 1; int playerNb = 1;
            if (round%2 == 0){ tour = 1; offset = 1; }
            else { tour = 0; offset = 0; }

            while (tour < ((grid.getNbline() * grid.getNbcol()) + offset)) {
                if (tour%2 != 0){ playerNb = 2; }
                else{ playerNb = 1; }

                displayer.displayTurn(realTurn);

                col = tabPlayers[playerNb].play(grid, tour, ui); //player[playerNb] plays

                if (tabPlayers[1].getExit() == 1 || tabPlayers[2].getExit() == 1){
                    exit = 1;
                    break;
                }

                if (grid.colValidity(col, playerNb) == true) {

                    writeLogText("Player " + tabPlayers[playerNb].getNb()+" plays " + (col+1) +"\n");
                    line = grid.updateGrid(col, tour); //get line number

                    if (line != -1) {
                        displayer.gridDisplay(grid);
                        if (grid.isWinning(col, line, tour) == true) {
                            displayer.displayRoundWon(tabPlayers, playerNb);
                            tabPlayers[playerNb].setWin(1);
                            grid.initGrid();

                            writeLogText("Player "+ playerNb + " wins\n");
                            writeLogText("Score "+ tabPlayers[1].getWin() +" - "+ tabPlayers[2].getWin() + "\n");
                            break;
                        }
                        else if (grid.isWinning(col, line, tour) == false && tour == ((grid.getNbline() * grid.getNbcol()) + offset)-1){
                            displayer.displayEquality();
                            grid.initGrid();
                            writeLogText("Equality\n");
                            break;
                        }
                        tour++;
                        realTurn++;
                    }
                }
            }
            round ++;
        }
    }

    //game ends
    void gameEnds(){
        if (exit == 1){
            writeLogText("Player quit\n");
        } else {
            displayer.displayEndGame(tabPlayers);
            writeLogText("Game ends\n");
        }
    }

    //Write in logs file
    void writeLogText(String logText){
        fileWritter.fillInLog(logText);
    }
}