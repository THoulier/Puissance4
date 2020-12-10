package userInterface;

import game.*;

import java.util.Scanner;

public class UI {

    public static int [] getUserEntry(){
        Scanner keyboard = new Scanner(System.in);
        String str = "";
        int col = 0; int exit = 0;
        int [] tab = new int[2];

        str =  keyboard.nextLine();

        if (str.equals("exit") == true){
            exit = 1;
            col = 1;
        } else {

            try {
                col = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                String log = ("Error cell input " + str + "\n");
                FileWritter.fillInLog(log);
                System.out.println("Colomn must be an integer");
            }
        }
        tab [0] = col-1;
        tab [1] = exit;
        return tab;
    }

    public static Player[] interfacePlayer() {
        Player [] tabPlayers = new Player[3];
        Scanner keyboard = new Scanner(System.in);
        int i = 1;

        while (i < 3){
            boolean end=false;
            System.out.println("Player " + i + " ? : <human/ia> <name>");
            do
            {
                String entry = keyboard.nextLine();
                String playerType = "";
                String playerName = "";

                if (entry.matches("^[a-zA-Z ]*$"))
                {
                    end = true;
                    String [] tab_entry= entry.split(" ");
                    if (tab_entry.length == 1) {
                        end = false;
                    }
                    else {
                        playerName = tab_entry[1];
                        playerType = tab_entry[0];
                    }
                    for (int k = 2; k<tab_entry.length; k++) {
                        playerName = playerName +" "+ tab_entry[k];
                    }

                    if (playerType.equals("human") == true || playerType.equals("ia") == true) {
                        if (playerType.equals("human") == true) {

                            tabPlayers[i] = new Human(playerName, 1,i);
                            String log = ("Player " + i + " is human " + playerName + "\n");
                            FileWritter.fillInLog(log);
                        }
                        if (playerType.equals("ia") == true) {
                            if(playerName.equals("monkey") == true){
                                tabPlayers[i] = new Ia(playerName, 2, 2,i);
                            }
                            else{
                                tabPlayers[i] = new Ia(playerName, 2, 1,i);
                            }
                            String log = ("Player " + i + " is ia " + playerName + "\n");
                            FileWritter.fillInLog(log);
                        }
                    }else { end = false; }
                }

                if (end == false) {
                    System.out.print("You must enter a player type followed by a player name\n");
                    String log = ("Error bad input player " + i + "\n");
                    FileWritter.fillInLog(log);
                } else {
                    System.out.println("Player " + i + " is " + playerName + " (" + playerType + ")");
                }
            } while(!end);
            i++;
        }



        return tabPlayers;
    }
}