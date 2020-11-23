package game;
public class Grid extends Game{

    //Attributes
    private static int nbcol;
    private static int nbline;
    private int [][] grid;

    //Constructor
    public Grid(int c, int l){
        nbcol = c;
        nbline = l;
        grid = new int [nbline][nbcol];
        for (int i = 0; i<nbline; i++){
            for (int j = 0; j<nbcol; j++){
                grid[i][j] = 0;
            }
        }
    }
    //Get functions
    public static int getNbcol() { return nbcol; }
    public static int getNbline(){
        return nbline;
    }
    public int [][] getGrid(){ return grid;}



    //Update grid
    public int update_grid(int col, int tour){
        int c = col+1;
        if (grid[0][col] != 0) {
            System.out.println("Column number " + c + " is full");
            return -1;
        } else {
            int cpt = nbline - 1;
            while (grid[cpt][col] != 0 && cpt != -1) {
                cpt--;
            }
            if (tour % 2 == 0) {
                grid[cpt][col] = 1;
            } else {
                grid[cpt][col] = 2;
            }
            return cpt;
        }

    }

    //Re initialize the grid

    public void init_grid(){
        for (int i = 0; i<nbline; i++){
            for (int j = 0; j<nbcol; j++){
                grid[i][j] = 0;
            }
        }
    }
    //Display grid
    public void display(){
        System.out.println();
        for (int j = 1; j<=nbcol; j++){
                System.out.print(" " + j + " ");
        }
        System.out.println();
        for (int i = 0; i<nbline; i++){
            for (int j = 0; j<nbcol; j++){
                if (grid[i][j] == 0) {
                    System.out.print(" " + "." + " ");
                }
                if (grid[i][j] == 1) {
                    System.out.print(" " + "x" + " ");
                }
                if (grid[i][j] == 2) {
                    System.out.print(" " + "o" + " ");
                }
            }
            System.out.println();
        }

    }
}