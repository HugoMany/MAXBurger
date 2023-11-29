import java.util.ArrayList;

public class Table {

	public static final int NOMBRE_TABLE = 15;
	protected boolean[] tablesOccupees = new boolean[NOMBRE_TABLE];
	protected ArrayList<Commande> tableauDeCommande;
	protected int nbClient;
	protected double addition;
	
	public boolean[] getTablesOccupees() { return this.tablesOccupees; }
	public ArrayList<Commande> getTableauDeCommande() { return this.tableauDeCommande; }
	public int getNbClient() { return this.nbClient; }
	public double getAddition() { return this.addition; }


	//Conduire nos clients à une table
	public void conduireATable(int nbClient) {
		for (int numTable = 0; numTable < NOMBRE_TABLE; numTable++) {
			if (getTablesOccupees()[numTable] == false) {
				this.tablesOccupees[numTable] = true;
			}
		}
	}

	public void ajoutPlatALaCommande(String nomClient, Plat newPlat) {
		Commande newCommande = new Commande(nomClient, false);
		this.tableauDeCommande.add(newCommande);
	}
	
}
