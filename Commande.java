import java.util.ArrayList;

public class Commande {
	
	protected String nomClient;
	protected boolean pret;
	protected ArrayList<Plat> listeDesPlatCommander = new ArrayList<Plat>();
	protected ArrayList<Boisson> listeDesBoissonCommander = new ArrayList<Boisson>();

	
	//Creation d'une commande
	protected Commande(String nomClient,boolean pret) {
		this.nomClient=nomClient;
		this.pret=pret;
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

	public boolean isPret() {
		return pret;
	}
}
