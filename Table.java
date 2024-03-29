import java.util.ArrayList;

public class Table {

	protected int numeroTable;
	protected int nombreDeCommandesTable = 0;
	protected boolean tableOccupee = false;
	protected ArrayList<Commande> tableauDeCommandes = new ArrayList<Commande>();
	protected int nbClientMax;

	public int getNumeroTable() { return this.numeroTable; }
	public int getNombreDeCommandesTable() { return this.nombreDeCommandesTable; }
	public boolean isTableOccupee() { return this.tableOccupee; }
	public ArrayList<Commande> getTableauDeCommande() { return this.tableauDeCommandes; }
	public Commande getCommande(int numeroDeCommande) { return this.tableauDeCommandes.get(numeroDeCommande); }
	public int getNbClientMax() { return this.nbClientMax; }

	public void incrNombreDeCommandesTable() { this.nombreDeCommandesTable++; }
	//public void decrNombreDeCommandesTable() { this.nombreDeCommandesTable--; }
	public void setTableOccupee(boolean isOccupee) { this.tableOccupee = isOccupee; }

	public Table(int numeroTable, int nbClientMax) {
		this.numeroTable = numeroTable;
		this.nbClientMax = nbClientMax;
	}

	// public void ajouterCommande(ArrayList<Plat> listePlats, ArrayList<Boisson> listeBoissons) {
	// 	incrNombreDeCommandesTable();
	// 	Commande commande = new Commande(getNombreDeCommandesTable());
	// 	// On ajoute tout les plats à la liste des plats de la commande
	// 	for (int platN = 0; platN < listePlats.size(); platN++) {
	// 		commande.ajoutPlatALaCommande(listePlats.get(platN));
	// 	}
	// 	// On ajoute toutes les boissons à la liste des boissons de la commande
	// 	for (int boissonN = 0; boissonN < listeBoissons.size(); boissonN++) {
	// 		commande.ajoutBoissonALaCommande(listeBoissons.get(boissonN));
	// 	}
	// 	this.tableauDeCommandes.add(commande);
	// }

	// public void ajouterPlatsALaCommande(ArrayList<Plat> listePlats, int numeroDeCommande) {
	// 	for (int platN = 0; platN < listePlats.size(); platN++) {
	// 		tableauDeCommandes.get(numeroDeCommande).ajoutPlatALaCommande(listePlats.get(platN));
	// 	}
	// }

	// public void ajouterBoissonALaCommande(ArrayList<Boisson> listeBoissons, int numeroDeCommande) {
	// 	for (int boissonN = 0; boissonN < listeBoissons.size(); boissonN++) {
	// 		tableauDeCommandes.get(numeroDeCommande).ajoutBoissonALaCommande(listeBoissons.get(boissonN));
	// 	}
	// }

	// public void annulerCommande(int numeroDeCommande) {
	// 	this.tableauDeCommandes.remove(numeroDeCommande);
	// 	decrNombreDeCommandesTable();
	// }

}
