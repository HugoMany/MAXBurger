import java.util.ArrayList;

public class Plat {

    protected int id;
    protected String nom;
    protected double prix;
    protected Ingredients[] listeDIngredient ;
    protected Plat(int id, String nom, double prix,Ingredients[] listeDIngredient){
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.listeDIngredient = listeDIngredient;
    }
    
    public int getId() { return this.id ; }
    public String getNom() { return this.nom ; }
    public double getPrix() { return this.prix ; }
    
    // overriding the toString() method
    @Override
    public String toString() {
        return this.id + "- \t" + this.nom + " "; // ajouter prix, voir quel affichage
    }
}