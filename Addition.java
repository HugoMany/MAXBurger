import java.util.ArrayList;

public class Addition {
    
    protected int numTable;
    protected double somme;
    protected ArrayList<Plat> listeDesPlats;
    protected ArrayList<Boisson> listeDesBoissons;


    public void initAddition(int numTable, int nbUtilisation) {
        this.numTable = numTable;
        this.somme = 0;
    }

    public Addition(int numTable, double montant) {
        this.numTable = numTable;
        this.somme = montant;
    }


    public void newAddition(int numCommande) {
        //Commande test = getCommande(numCommande);
        
    }





}
