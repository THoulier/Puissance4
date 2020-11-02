
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        System.out.println("Entrez le nom du joueur 1 : ");

        Scanner clavier = new Scanner(System.in);
        String nom_Joueur1 = clavier.next();

        Joueur joueur1 = new Joueur(nom_Joueur1, "x");
        System.out.println("Le nom du joueur 1 est : "+ joueur1.nom +"et sa forme est :" + joueur1.forme);
    }

}
