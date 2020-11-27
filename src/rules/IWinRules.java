package rules;

import game.*;

public class IWinRules {

    protected static boolean isWinning(int column, int line, int i, int [][] grid){
        int playerValue = 0;
        if (i%2 == 0){
            playerValue = 1;
        } else{
            playerValue = 2;
        }

        int align = 0; int max = 0;

        int col = column; int li = line;
        //Vertical
        while (li < Grid.getNbline() && grid[li][col] == playerValue){ li ++; align ++; }
        if (align > max){ max = align; }

        //Horizontal
        align = -1; col = column; li = line;
        while (col < Grid.getNbcol() && grid[li][col] == playerValue){ col ++; align ++; }
        col = column; li = line;
        while (col >= 0 && grid[li][col] == playerValue){ col --; align ++; }
        if (align > max){ max = align; }

        //Diag1
        align = -1; col = column; li = line;
        while (li < Grid.getNbline() && col < Grid.getNbcol() && grid[li][col] == playerValue){ col ++; li ++; align ++; }
        col = column; li = line;
        while (li >= 0 && col >= 0 && grid[li][col] == playerValue){ col --; li --; align ++; }
        if (align > max){ max = align; }

        //Diag2
        align = -1; col = column; li = line;
        while (li < Grid.getNbline() && col >= 0 && grid[li][col] == playerValue){ col --; li ++; align ++; }
        col = column; li = line;
        while (li >= 0 && col < Grid.getNbcol() && grid[li][col] == playerValue){ col ++; li --; align ++; }
        if (align > max){ max = align; }

        if (max >= 4){
            return true;
        }

        return false;
    }
}