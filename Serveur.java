import java.util.ArrayList;

public class Serveur extends Personnel {
    
    protected ArrayList<Table> tablesGeres;

    public Serveur(String nom, String prenom) {
        super(nom, prenom);
    }

    public void printTableGeres() {
        System.out.println(super.getNom());
        for (Table iTable : this.tablesGeres) {
            System.out.println(iTable.getNumeroTable());
        }
    }

    public void addTables(ArrayList<Table> listTables) {
        this.tablesGeres = listTables;
    }
}
