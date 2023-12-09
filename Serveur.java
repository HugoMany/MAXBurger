import java.util.ArrayList;

public class Serveur extends Personnel {
    
    protected ArrayList<Table> tablesGeres = new ArrayList<>();

    public Serveur(String nom, String prenom) {
        super(nom, prenom);
    }

    public void printTableGeres() {
        if(this.tablesGeres.isEmpty() == false) { // Si des tables ont été attribuées au serveur
            System.out.print("- " + super.getPrenom() + " " + super.getNom() + " s'occupe des tables : ");
            for (Table iTable : this.tablesGeres) {
                System.out.print(iTable.getNumeroTable() + " ");
            }
            System.out.print("\n");
        }
        else {
            System.out.println("- " + super.getPrenom() + super.getNom() + " : Pas de table pour ce serveur aujourd'hui.");
        }
    }

    public void addTables(ArrayList<Table> listTables) {
        this.tablesGeres = listTables;
    }
}
