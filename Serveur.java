public class Serveur extends Personnel {

    public static final int NOMBRE_TABLE = 15;
    
    protected int gereLaTableNumero;

    Serveur(String nom, String prenom, int numeroTable) {
        super(nom, prenom);
        this.gereLaTableNumero = numeroTable;
    }

    // Conduire des clients à une table
    public void conduireATable(int nbClient) {
    	for (int numTable = 0; numTable < NOMBRE_TABLE; numTable++) {
    		//if (getTablesOccupees()[numTable] == false) {
    		//	this.tablesOccupees[numTable] = true;
    		//}
    	}
    }
    
}
