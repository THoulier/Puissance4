package game;

public class Displayer {

    Displayer(){ }

    void displayStartInformation(Player [] tabPlayers, int round){
        System.out.println("Score : "+ tabPlayers[1].getWin() +" - "+ tabPlayers[2].getWin());
        System.out.println("Round n° " + round);
    }

    void displayTurn(int realTurn){
        System.out.println("turn n° " + realTurn);
    }

    void displayRoundWon(Player [] tabPlayers, int playerNb){
        System.out.println(tabPlayers[playerNb].getName() + " won the round");
    }

    void displayEquality() {
        System.out.println("Round ended in a draw, there is no winner");
    }

    void displayEndGame(Player [] tabPlayers){
        System.out.println("Final score is : "+tabPlayers[1].getWin() + " - " + tabPlayers[2].getWin());
        if (tabPlayers[1].getWin() == 3) {
            System.out.println("Player " + tabPlayers[1].getName() + " won the match");
        } else {
            System.out.println("Player " + tabPlayers[2].getName() + " won the match");
        }
    }

    void displayInvalidCol(int nbcol){
        System.out.println("Column number must be between 1 and " + nbcol);
    }

    void displayFullCol(int col){
        System.out.println("Column number " + col + " is full");
    }

    //Display grid
    void gridDisplay(Grid grid){
        System.out.println();
        for (int j = 1; j<=grid.getNbcol(); j++){
            System.out.print(" " + j + " ");
        }
        System.out.println();
        for (int i = 0; i<grid.getNbline(); i++){
            for (int j = 0; j<grid.getNbcol(); j++){
                if (grid.getCell(i,j) == 0) {
                    System.out.print(" " + "." + " ");
                }
                if (grid.getCell(i,j) == 1) {
                    System.out.print(" " + "x" + " ");
                }
                if (grid.getCell(i,j) == 2) {
                    System.out.print(" " + "o" + " ");
                }
            }
            System.out.println();
        }

    }
}
