import java.util.ArrayList;

public class Commande {
	
	protected String nomClient;
	protected int numeroDeCommande;
	protected boolean pret = false;
	protected ArrayList<Plat> listeDesPlatCommander = new ArrayList<Plat>();
	protected ArrayList<Boisson> listeDesBoissonCommander = new ArrayList<Boisson>();
	protected double addition = 0;
	
	//Creation d'une commande
	protected Commande(String nomClient, int numeroDeCommande) {
		this.nomClient = nomClient;
		this.numeroDeCommande = numeroDeCommande;
	}
	// Ajout d'une commande de plat
	public void ajoutPlatALaCommande(Plat newPlat) {
		listeDesPlatCommander.add(newPlat);
	}
	// Ajout d'une boisson de plat
	public void ajoutBoissonALaCommande(Boisson newBoisson) {
		listeDesBoissonCommander.add(newBoisson);
	}
		

	public String getNomClient() { return nomClient; }
	public double getAddition() { return this.addition; }

	public boolean isPret() {
		return pret;
	}
}
