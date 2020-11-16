
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {


        for (int i = 0; i < 2; i++) {

            System.out.println("Entrez le nom du joueur" + i + " : ");


            Scanner kayboard = new Scanner(System.in);
            String name_Player = keyboard.next();

            Player player = new Player(nom_Joueur, "x");

            System.out.println("Le nom du joueur"+ i + " est : " + player.name + " et sa forme est :" + player.shape);
        }
    }

}
