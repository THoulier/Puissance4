package game;
public class Grid extends Game{
    //Attributes
    private int nbcol;
    private int nbline;
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
    public int getNbcol() { return nbcol; }
    public int getNbline(){
        return nbline;
    }




    //Update grid
    public void update_grid(int col, int tour){
        if (col>nbcol || col<1){
            System.out.println("Column number must be between 1 and " + nbcol);
        }

        else {
            col = col-1;
            if (grid[0][col] != 0) {
                System.out.println("Column number " + col + " is full");
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