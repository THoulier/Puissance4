public class Joueur {
    public String nom;
    public String forme;

    public Joueur(String nom, String forme) {
        this.nom = nom;
        this.forme = forme;
    }

    public String getNom() {
        return nom;
    }

    public String getForme() {
        final String forme = this.forme;
        return forme;
    }
}