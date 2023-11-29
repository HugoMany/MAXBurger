public class Plat {

    protected int id;
    protected String nom;
    
    protected Plat(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    public int getId() { return this.id ; }
    public String getNom() { return this.nom ; }
    
    // overriding the toString() method
    @Override
    public String toString() {
        return this.id + " " + this.nom + " ";
    }
}