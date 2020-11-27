package user_interface;

import game.*;

import java.util.Scanner;

public class UI {

    public static int get_user_entry(){

        Scanner keyboard = new Scanner(System.in);
        int col =  keyboard.nextInt();

        if (col>Grid.getNbcol() || col<1){
            System.out.println("Column number must be between 1 and " + Grid.getNbcol());
            return -1;
        }
        return col-1;
    }

    public static Player[] interface_player() {
        Player [] tab_players = new Player[3];
        Scanner keyboard = new Scanner(System.in);

        for (int i = 1; i < 3; i++) {
            System.out.println("Joueur " + i + " ? : <human/ia> <name>");
            String entree = keyboard.nextLine();

            String player_type = (entree + " ").split(" ")[0];
            String player_name = (entree + " ").split(" ")[1];

            if (player_type.equals("human") == true) {
                tab_players[i] = new Player(player_name, 1);
            }
            if (player_type.equals("ia") == true) {
                tab_players[i] = new Player(player_name, 2);
            }
            System.out.println("Player " + i + " is " + player_name + " (" + player_type + ")");
        }
        return tab_players;
    }
}