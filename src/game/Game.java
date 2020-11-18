
import java.util.Scanner;


public class Game{

    public static void main(String[] var0) {
        Scanner keyboard = new Scanner(System.in);

        for (int i = 1;i<3;i++) {
            System.out.println("Joueur "+ i +" ? : <human/ia> <name>");
            String entree = keyboard.nextLine();

            String player_type = (entree + " ").split(" ")[0];
            String player_name = (entree + " ").split(" ")[1];

            if (player_type.equals("human") == true) {
                Player player = new Player(player_name, 1);
                System.out.println(player.name);
            }
            if (player_type.equals("ia") == true) {
                Ia ia = new Ia(player_name, 2);
                System.out.println(ia.name);
            }
            System.out.println("Player "+ i +" is "+ player_name + " ("+player_type+")");
        }


        Grid grid = new Grid(6,7);
        grid.display();
        int col = 0;
        for (int i=1; i<(grid.getNbline()*grid.getNbcol()); i++){

            col = keyboard.nextInt();
            grid.update_grid(col,i);
            grid.display();
        }

    }
}