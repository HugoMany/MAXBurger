public class Addition {
    
    protected int numTable;
    protected int nbUtilisation;
    protected double somme;



    public void initAddition(int numTable, int nbUtilisation) {
        this.numTable = numTable;
        this.nbUtilisation = nbUtilisation;
        this.somme = 0;
    }

    public Addition(int numTable, int nbUtilisation, double montant) {
        this.numTable = numTable;
        this.nbUtilisation = nbUtilisation;
        this.somme = montant;
    }


}
