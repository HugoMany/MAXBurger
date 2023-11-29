import java.util.ArrayList;

public class Table {

	public static final int NOMBRE_TABLE = 15;

	protected int numeroTable;
	protected int nombreDeCommandeTable = 0;
	protected boolean tableOccupee = false;
	protected ArrayList<Commande> tableauDeCommande;
	protected int nbClient = 0;

	public int getNumeroTable() { return this.numeroTable; }
	public int getNombreDeCommandeTable() { return this.nombreDeCommandeTable; }
	public boolean isTableOccupee() { return this.tableOccupee; }
	public ArrayList<Commande> getTableauDeCommande() { return this.tableauDeCommande; }
	public Commande getCommande(int numeroDeCommande) { return this.tableauDeCommande.get(numeroDeCommande); }
	public int getNbClient() { return this.nbClient; }

	public void incrNombreDeCommandeTable() { this.nombreDeCommandeTable++; }
	public void decrNombreDeCommandetable() { this.nombreDeCommandeTable--; }

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

	public void ajouterCommande(String nomClient, ArrayList<Plat> listePlat, ArrayList<Boisson> listeBoisson) {
		incrNombreDeCommandeTable();
		Commande commande = new Commande(nomClient, getNombreDeCommandeTable());
		// On ajoute tout les plats à la liste des plats de la commande
		for (int platN = 0; platN < listePlat.size(); platN++) {
			commande.ajoutPlatALaCommande(listePlat.get(platN));
		}
		// On ajoute toutes les boissons à la liste des boissons de la commande
		for (int boissonN = 0; boissonN < listeBoisson.size(); boissonN++) {
			commande.ajoutBoissonALaCommande(listeBoisson.get(boissonN));
		}
		this.tableauDeCommande.add(commande);
	}

	public void ajouterPlatsALaCommande(ArrayList<Plat> listePlat, int numeroDeCommande) {
		for (int platN = 0; platN < listePlat.size(); platN++) {
			//setCommande(getCommande(numeroDeCommande).ajoutPlatALaCommande(listePlat.get(platN)));
		}
	}

	public void ajouterBoissonALaCommande() {

	}

	public void annulerCommande(int numeroDeCommande) {

	}

}
