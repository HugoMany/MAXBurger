public class Boisson {

    protected int id;
    protected String nom;
    protected double prix;
    
    public Boisson(int id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }
    
    public int getId() { return this.id ; }
    public String getNom() { return this.nom ; }
    public double getPrix() { return this.prix ; }
    
    // overriding the toString() method
    @Override
    public String toString() {
        return this.id + " " + this.nom + " "; // ajouter prix, voir quel affichage
    }
}