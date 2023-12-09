import java.util.ArrayList;

public class Commande {
	
	protected String nomClient;
	protected int numeroDeCommande;
	protected boolean pret = false;
	protected ArrayList<Plat> listeDesPlatsCommandes = new ArrayList<Plat>();
	protected ArrayList<Boisson> listeDesBoissonsCommandees = new ArrayList<Boisson>();
	protected double addition = 0;
	
	//Creation d'une commande
	public Commande(String nomClient, int numeroDeCommande) {
		this.nomClient = nomClient;
		this.numeroDeCommande = numeroDeCommande;
	}
	// Ajout d'un plat à la commande
	public void ajoutPlatALaCommande(Plat newPlat) {
		listeDesPlatsCommandes.add(newPlat);
	}
	// Ajout d'une boisson à la commande
	public void ajoutBoissonALaCommande(Boisson newBoisson) {
		listeDesBoissonsCommandees.add(newBoisson);
	}
		

	public String getNomClient() { return nomClient; }
	public double getAddition() { return this.addition; }

	public boolean isPret() {
		return pret;
	}
	public void setPret(boolean bool) {
		this.pret=bool;
	}

	public ArrayList<Plat> getPlat() {
		return listeDesPlatsCommandes;
	}

	public ArrayList<Boisson> getBoisson() {
		return listeDesBoissonsCommandees;
	}
	public void getAllIngredientsFromPlat(){
		for (int i = 0; i < listeDesPlatsCommandes.size(); i++) {
			for (int j = 0; j < listeDesPlatsCommandes.get(i).listeDIngredient.length; j++) {
				System.out.println(listeDesPlatsCommandes.get(i).listeDIngredient[j]);
				
			}
		}
	}

}
