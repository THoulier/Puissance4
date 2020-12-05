package game;


public class Ia extends Player{
    int iaType;

    public Ia(String name, int value, int type, int nb) {
        super(name, value, nb);
        this.iaType = type;
    }

    int play (Grid grid, int tour){
        int col = 0;
        if (iaType == 1) {
            col = randomIa(grid);
        }
        else if (iaType == 2){
            //col = bestPlay(tour, grid);
        }
        return col;
    }

    int randomIa(Grid grid){
        return (int) (Math.random() * (grid.getNbcol() - 1)) + 1;
    }

/*
    int bestPlay(int i, Grid grid){
        int playerValue = 0;
        if (i%2 == 0){
            playerValue = 1;
        } else{
            playerValue = 2;
        }
        System.out.println("player : " + playerValue);
        int [] tabMax = new int[grid.getNbcol()];

        int align = 1; int max = 0;

        for (int j = 0; j< grid.getNbcol(); j++) {

            int line = grid.getNbline() - 1;
            while (grid.getCell(line,j) != 0 && line != -1) {
                line--;
            }

            System.out.println("line : " + line);
            System.out.println("test : " + grid.getCell(line, 0));
            int li = line; int col = j;
            li++;
            //Vertical
            while (li < grid.getNbline() && grid.getCell(li, col) == playerValue) {
                li++;
                align++;
            }
            if (align > max) {
                max = align;
            }
            System.out.println("vertical : " + max);
            //Horizontal
            align = 0;
            col = j;
            li = line;
            li++; col++;
            while (li < grid.getNbline() && col < grid.getNbcol() && grid.getCell(li, col) == playerValue) {
                col++;
                align++;
            }
            col = j;
            li = line;
            li++; col++;
            while (li < grid.getNbline() && col >= 0 && grid.getCell(li, col) == playerValue) {
                col--;
                align++;
            }
            if (align > max) {
                max = align;
            }
            System.out.println("horizontal : " + max);

            //Diag1
            align = 0;
            col = j;
            li = line;
            li++; col++;
            while (li < grid.getNbline() && col < grid.getNbcol() && grid.getCell(li, col) == playerValue) {
                col++;
                li++;
                align++;
            }
            col = j;
            li = line;
            li++; col++;
            while (li < grid.getNbline() && li >= 0 && col >= 0 && grid.getCell(li, col) == playerValue) {
                col--;
                li--;
                align++;
            }
            if (align > max) {
                max = align;
            }

            //Diag2
            align = 0;
            col = j;
            li = line;
            li++; col++;
            while (li < grid.getNbline() && col >= 0 && grid.getCell(li, col) == playerValue) {
                col--;
                li++;
                align++;
            }
            col = j;
            li = line;
            li++; col++;
            while (li < grid.getNbline() && li >= 0 && col < grid.getNbcol() && grid.getCell(li, col) == playerValue) {
                col++;
                li--;
                align++;
            }
            if (align > max) {
                max = align;
            }
            System.out.println("diag2 : " + max);

            tabMax[j] = max;
        }
        int bestCol = 0;
        for (int k = 0; k< grid.getNbcol(); k++){
            System.out.println(tabMax[k]);
            if (tabMax[k] > bestCol){
                bestCol = tabMax[k];
            }
        }
        System.out.println("bestcol : " + bestCol);
        return bestCol;
    }*/
}