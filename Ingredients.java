public class Ingredients {
    String nom;
    public Ingredients(String nom){
        this.nom=nom;
    }
    @Override
    public String toString() {
        return this.nom;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Ingredients other = (Ingredients) obj;

        // Comparaison basée sur les noms
        return nom.equals(other.nom);
    }
}
