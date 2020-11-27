package userInterface;

import game.*;

import java.util.Scanner;

public class UI {

    public static int getUserEntry(){

        Scanner keyboard = new Scanner(System.in);
        int col =  keyboard.nextInt();

        if (col>Grid.getNbcol() || col<1){
            System.out.println("Column number must be between 1 and " + Grid.getNbcol());
            return -1;
        }
        return col-1;
    }

    public static Player[] interfacePlayer() {
        Player [] tabPlayers = new Player[3];
        Scanner keyboard = new Scanner(System.in);

        for (int i = 1; i < 3; i++) {
            System.out.println("Joueur " + i + " ? : <human/ia> <name>");
            String entree = keyboard.nextLine();

            String playerType = (entree + " ").split(" ")[0];
            String playerName = (entree + " ").split(" ")[1];

            if (playerType.equals("human") == true) {
                tabPlayers[i] = new Player(playerName, 1);
            }
            if (playerType.equals("ia") == true) {
                tabPlayers[i] = new Player(playerName, 2);
            }
            System.out.println("Player " + i + " is " + playerName + " (" + playerType + ")");
        }
        return tabPlayers;
    }
}