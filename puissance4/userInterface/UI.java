package userInterface;

import game.*;

import java.util.Scanner;

public class UI implements UInterface{
    private final FileWritter fileWritter;
    private boolean playerExit;
    //Constructor
    public UI(){
        fileWritter = new FileWritter();
        playerExit = false;
    }

    public boolean getExit(){
        return playerExit;
    }
    public int getUserEntry(){
        int col = 0;
        String str = "";
        boolean entryIsInvalid = true;
        Scanner keyboard = new Scanner(System.in);
        while (entryIsInvalid) {
            boolean end = false;

            do {
                str = keyboard.nextLine();
                if (str.equals("sortir")){
                    playerExit = true;
                    end = true;
                } else {
                    try {
                        col = Integer.parseInt(str);
                        end = true;
                    } catch (NumberFormatException e) {
                        end = false;
                    }
                }

                if (end == false) {
                    //String log = ("Error column input " + str + "\n");
                    //String log = ("Erreur saisie colonne " + str + "\n");
                    //fileWritter.fillInLog(log);
                    //System.out.println("Colomn must be an integer");
                    System.out.println("Erreur saisie colonne " + str);
                }

            } while (!end);
            entryIsInvalid = false;
        }
        return col-1;
    }

    public Player[] interfacePlayer() {
        Player [] tabPlayers = new Player[3];
        Scanner keyboard = new Scanner(System.in);
        int i = 1;

        while (i < 3){
            boolean end=false;
            //System.out.println("Player " + i + " ? : <human/ia> <name>");

            do
            {
                System.out.println("Joueur " + i + "?");
                String entry = keyboard.nextLine();
                String playerType = "";
                String playerName = "";

                if (entry.matches("^[a-zA-Z ]*$"))
                {
                    end = true;
                    String [] tabEntry= entry.split(" ");

                    if (tabEntry.length == 1) {
                        end = false;
                    } else {
                        playerName = tabEntry[1];
                        playerType = tabEntry[0];
                    }
                    for (int k = 2; k<tabEntry.length; k++) {
                        playerName = playerName +" "+ tabEntry[k];
                    }

                    if (playerType.equals("humain") == true || playerType.equals("ia") == true) {
                        if (playerType.equals("humain") == true) {

                            tabPlayers[i] = new Human(playerName, 1,i);
                            //String log = ("Player " + i + " is human " + playerName + "\n");
                            String log = ("Joueur " + i + " est humain " + playerName + "\n");
                            fileWritter.fillInLog(log);
                        }
                        if (playerType.equals("ia") == true) {
                            if(playerName.equals("monkey") == true){
                                tabPlayers[i] = new Ia(playerName, 2, 2,i);
                            }
                            else{
                                tabPlayers[i] = new Ia(playerName, 2, 1,i);
                            }
                            //String log = ("Player " + i + " is ia " + playerName + "\n");
                            String log = ("Joueur " + i + " est ia " + playerName + "\n");
                            fileWritter.fillInLog(log);
                        }
                    }else { end = false; }
                }

                if (end == false) {
                    //System.out.print("You must enter a player type followed by a player name\n");
                    System.out.print("Erreur saisie Joueur " + i + "\n");
                    //String log = ("Error bad input player " + i + "\n");
                    //String log = ("Erreur saisie Joueur " + i + "\n");
                    //fileWritter.fillInLog(log);
                } else {
                    //System.out.println("Player " + i + " is " + playerName + " (" + playerType + ")");
                }
            } while(!end);
            i++;
        }

        return tabPlayers;
    }



}