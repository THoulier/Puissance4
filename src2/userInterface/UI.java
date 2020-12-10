package userInterface;

import game.*;

import java.util.Scanner;

public class UI implements UInterface{
    private final FileWritter fileWritter;
    //Constructor
    public UI(){
        fileWritter = new FileWritter();
    }

    public int getUserEntry(){
        Scanner keyboard = new Scanner(System.in);
        String str = "";
        int col = 0;

        str =  keyboard.nextLine();

        try {
            col = Integer.parseInt(str);
        }
        catch(NumberFormatException e){
            String log = ("Error cell input " + str + "\n");
            fileWritter.fillInLog(log);
            System.out.println("Colomn must be an integer");
        }

        return col-1;
    }

    public Player[] interfacePlayer() {
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
                    String [] tabEntry= entry.split(" ");
                    if (tabEntry.length == 1) {
                        end = false;
                    }
                    else {
                        playerName = tabEntry[1];
                        playerType = tabEntry[0];
                    }
                    for (int k = 2; k<tabEntry.length; k++) {
                        playerName = playerName +" "+ tabEntry[k];
                    }

                    if (playerType.equals("human") == true || playerType.equals("ia") == true) {
                        if (playerType.equals("human") == true) {

                            tabPlayers[i] = new Human(playerName, 1,i);
                            String log = ("Player " + i + " is human " + playerName + "\n");
                            fileWritter.fillInLog(log);
                        }
                        if (playerType.equals("ia") == true) {
                            if(playerName.equals("monkey") == true){
                                tabPlayers[i] = new Ia(playerName, 2, 2,i);
                            }
                            else{
                                tabPlayers[i] = new Ia(playerName, 2, 1,i);
                            }
                            String log = ("Player " + i + " is ia " + playerName + "\n");
                            fileWritter.fillInLog(log);
                        }
                    }else { end = false; }
                }

                if (end == false) {
                    System.out.print("You must enter a player type followed by a player name\n");
                    String log = ("Error bad input player " + i + "\n");
                    fileWritter.fillInLog(log);
                } else {
                    System.out.println("Player " + i + " is " + playerName + " (" + playerType + ")");
                }
            } while(!end);
            i++;
        }

        return tabPlayers;
    }

    public int interfaceRounds(){
        int rounds = 0;
        String str = "";
        int i = 1;
        Scanner keyboard = new Scanner(System.in);
        while (i < 2) {
            boolean end = false;


            System.out.println("How many rounds? (1 to 9)");
            do {
                str = keyboard.nextLine();
                try {
                    rounds = Integer.parseInt(str);
                } catch(NumberFormatException e){
                    end = false;
                }

                if (rounds<10 && rounds>0){
                    end = true;
                }

                if (end == false) {
                    String log = ("Error rounds number input " + rounds + "\n");
                    fileWritter.fillInLog(log);
                    System.out.println("Rounds number must be an integer between 1 and 9");
                } else {
                    System.out.println("You must win "+ rounds +" to win the game\n");
                }
            } while (!end);
            i++;
        }
        return rounds;
    }

    public int [] interfaceGridSize(){
        int [] tabGridSize = new int[2];
        String str = "";
        int i = 1;
        int col = 0; int line = 0;
        Scanner keyboard = new Scanner(System.in);
        while (i < 2) {
            boolean end = false;

            System.out.println("Size of the grid? <linexcolumn>");
            do {
                str = keyboard.nextLine();
                String [] tabEntry = str.split("x");

                if (tabEntry.length != 2) {
                    end = false;
                } else {
                    try {
                        col = Integer.parseInt(tabEntry[1]);
                        line = Integer.parseInt(tabEntry[0]);
                    } catch (NumberFormatException e) {
                        end = false;
                    }

                    if ((line * col) % 2 == 0 && col > 3 && (line * col) > 7) {
                        end = true;
                    }
                }

                if (end == false) {
                    String log = ("Error grid size input " + line +" x " + col + "\n");
                    fileWritter.fillInLog(log);
                    System.out.println("Incorrect grid size, reminder : line x column must be even and greater than 7, column must be greater than 3\n");
                } else {
                    tabGridSize[0] = line;
                    tabGridSize[1] = col;
                }
            } while (!end);
            i++;
        }
        return tabGridSize;
    }



}