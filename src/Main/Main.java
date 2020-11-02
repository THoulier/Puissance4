
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {


        for (int i = 0; i < 2; i++) {

            System.out.println("Entrez le nom du joueur" + i + " : ");


            Scanner clavier = new Scanner(System.in);
            String nom_Joueur = clavier.next();

            Joueur joueur = new Joueur(nom_Joueur, "x");

            System.out.println("Le nom du joueur"+ i + " est : " + joueur.nom + " et sa forme est :" + joueur.forme);
        }
    }

}
