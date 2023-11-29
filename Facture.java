import java.util.ArrayList;
    
public class Facture {
	
	protected int listeAdditions[];
	protected ArrayList<Integer> Additions = new ArrayList<Integer>();
	

	
	public void setAdditions(int numTable, int montant) {
		while (Additions.size() < numTable) {
			Additions.add(0);
		}
		Additions.add(montant);
		this.listeAdditions[numTable] = montant;
	}
	
	public void nouvelleListe() {

    }
}
