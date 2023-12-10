import java.util.ArrayList;

public class Commande {
	
	protected int numeroDeCommande;
	protected boolean pret = false;
	protected boolean regle = false;
	protected ArrayList<Plat> listeDesPlatsCommandes = new ArrayList<Plat>();
	protected ArrayList<Boisson> listeDesBoissonsCommandees = new ArrayList<Boisson>();
	protected double addition = 0;
	
	//Creation d'une commande
	public Commande(int numeroDeCommande) {
		this.numeroDeCommande = numeroDeCommande;
	}
	
	public double getAddition() { return this.addition; }
	public boolean isPret() { return this.pret; }
	public boolean isRegle() { return this.regle; }
	public ArrayList<Plat> getPlat() { return this.listeDesPlatsCommandes; }
	public ArrayList<Boisson> getBoisson() { return this.listeDesBoissonsCommandees; }

	public void setPret(boolean bool) { this.pret = bool;	}
	public void setRegle(boolean bool) { this.regle = bool; }
	

	// Ajout d'un plat à la commande
	public void ajoutPlatALaCommande(Plat newPlat) {
		listeDesPlatsCommandes.add(newPlat);
	}
	// Ajout d'une boisson à la commande
	public void ajoutBoissonALaCommande(Boisson newBoisson) {
		listeDesBoissonsCommandees.add(newBoisson);
	}
	
	
	public ArrayList<Ingredients> getAllIngredientsFromPlat(){
		ArrayList<Ingredients> retListOfIngredients = new ArrayList<Ingredients>();
		for (int i = 0; i < listeDesPlatsCommandes.size(); i++) {
			for (int j = 0; j < listeDesPlatsCommandes.get(i).listeDIngredient.length; j++) {
				// System.out.println(listeDesPlatsCommandes.get(i).listeDIngredient[j]);
				retListOfIngredients.add(listeDesPlatsCommandes.get(i).listeDIngredient[j]);
			}
		}
		return retListOfIngredients;
	}

}
