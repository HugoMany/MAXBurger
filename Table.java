import java.util.ArrayList;

public class Table {

	public static final int NOMBRE_TABLE = 15;

	protected int numeroTable;
	protected int nombreDeCommandesTable = 0;
	protected boolean tableOccupee = false;
	protected ArrayList<Commande> tableauDeCommandes;
	protected int nbClient = 0;

	public int getNumeroTable() { return this.numeroTable; }
	public int getNombreDeCommandesTable() { return this.nombreDeCommandesTable; }
	public boolean isTableOccupee() { return this.tableOccupee; }
	public ArrayList<Commande> getTableauDeCommande() { return this.tableauDeCommandes; }
	public Commande getCommande(int numeroDeCommande) { return this.tableauDeCommandes.get(numeroDeCommande); }
	public int getNbClient() { return this.nbClient; }

	public void incrNombreDeCommandesTable() { this.nombreDeCommandesTable++; }
	public void decrNombreDeCommandesTable() { this.nombreDeCommandesTable--; }

	public Table(int numeroTable) {
		this.numeroTable = numeroTable;
	}

	//// Conduire nos clients à une table
	// public void conduireATable(int nbClient) {
	// 	for (int numTable = 0; numTable < NOMBRE_TABLE; numTable++) {
	// 		if (getTablesOccupees()[numTable] == false) {
	// 			this.tablesOccupees[numTable] = true;
	// 		}
	// 	}
	// }

	public void ajouterCommande(String nomClient, ArrayList<Plat> listePlats, ArrayList<Boisson> listeBoissons) {
		incrNombreDeCommandesTable();
		Commande commande = new Commande(nomClient, getNombreDeCommandesTable());
		// On ajoute tout les plats à la liste des plats de la commande
		for (int platN = 0; platN < listePlats.size(); platN++) {
			commande.ajoutPlatALaCommande(listePlats.get(platN));
		}
		// On ajoute toutes les boissons à la liste des boissons de la commande
		for (int boissonN = 0; boissonN < listeBoissons.size(); boissonN++) {
			commande.ajoutBoissonALaCommande(listeBoissons.get(boissonN));
		}
		this.tableauDeCommandes.add(commande);
	}

	public void ajouterPlatsALaCommande(ArrayList<Plat> listePlats, int numeroDeCommande) {
		for (int platN = 0; platN < listePlats.size(); platN++) {
			tableauDeCommandes.get(numeroDeCommande).ajoutPlatALaCommande(listePlats.get(platN));
		}
	}

	public void ajouterBoissonALaCommande(ArrayList<Boisson> listeBoissons, int numeroDeCommande) {
		for (int boissonN = 0; boissonN < listeBoissons.size(); boissonN++) {
			tableauDeCommandes.get(numeroDeCommande).ajoutBoissonALaCommande(listeBoissons.get(boissonN));
		}
	}

	public void annulerCommande(int numeroDeCommande) {
		this.tableauDeCommandes.remove(numeroDeCommande);
		decrNombreDeCommandesTable();
	}

}
