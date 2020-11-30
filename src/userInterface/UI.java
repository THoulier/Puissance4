package userInterface;

import game.*;

import java.util.Scanner;

public class UI {

    public static int getUserEntry(int tour){
        Scanner keyboard = new Scanner(System.in);
        int col = 0;
        int i;
        if (tour %2 == 0) {
            i = 1;
        }
        else {
            i = 2;
        }
        try{
            col =  keyboard.nextInt();
        }
        catch(Exception e){
            System.out.println("You must enter an integer!");
        }
        String log = ("Player " + i + " played in column " + col + "\n");
        FileWritter.fillInLog(log);
        return col-1;
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
                    playerType = tab_entry[0];
                    playerName = tab_entry[1];

                    for (int k = 2; k<tab_entry.length; k++) {
                        playerName = playerName +" "+ tab_entry[k];
                    }

                    if (playerType.equals("human") == true || playerType.equals("ia") == true) {
                        if (playerType.equals("human") == true) {
                            tabPlayers[i] = new Player(playerName, 1);
                            String log = ("Player " + i + " is human " + playerName + "\n");
                            FileWritter.fillInLog(log);
                        }
                        if (playerType.equals("ia") == true) {
                            tabPlayers[i] = new Ia(playerName, 2, 1);
                            String log = ("Player " + i + " is IA " + playerName + "\n");
                            FileWritter.fillInLog(log);
                        }
                    }else { end = false; }
                }

                if (end == false) {
                    System.out.print("You must enter a player type followed by a player name\n");
                } else {
                    System.out.println("Player " + i + " is " + playerName + " (" + playerType + ")");
                }
            } while(!end);
            i++;
        }



        return tabPlayers;
    }
}