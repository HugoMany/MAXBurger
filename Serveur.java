import java.util.ArrayList;

public class Serveur extends Personnel {
    
    protected ArrayList<Table> tablesGeres;

    Serveur(String nom, String prenom, ArrayList<Table> listTables) {
        super(nom, prenom);
        this.tablesGeres = listTables;
    }
    
}
