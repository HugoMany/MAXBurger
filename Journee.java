import java.util.ArrayList;

public class Journee {

    protected ArrayList<Table> listeDesTables = new ArrayList<Table>();
    public int hOuverture;
    public int hFermeture;
    
    protected Facture factureJournee;

    public ArrayList<Table> getListeDesTables() { return this.listeDesTables; }

    

    public Journee(int hOuverture,int hFermeture){
        this.hFermeture=hFermeture;
        this.hOuverture=hOuverture;
    }
    public int conduireATable(int nbClient) {
        boolean tableIdeale = false; // On utilise ce boolean pour trouver la table la plus adapaté au nombre de clients
        for (int numTable = 0; numTable < listeDesTables.size(); numTable++) {
            // Si on trouve une table non occupe et avec le nombre exact de place necessaire
            if (listeDesTables.get(numTable).isTableOccupee() == false && listeDesTables.get(numTable).getNbClientMax() == nbClient && tableIdeale == false) {
            	//this.listeDesTables.get(numTable).setTableOccupee(true); // On dit que cette table est desormais occupée
                tableIdeale = true;
                numTable++;
                System.out.println("\nAller à la table n°" + numTable);

                //TEST QUI AFFICHE LA LISTE DES TABLES AVEC LEURS NOMBRE DE PLACE MAXIMUM
                // for (Table tabli : getListeDesTables()) {
                //     System.out.println("table n°" + tabli.getNumeroTable() + " | " + tabli.getNbClientMax() + " | " + tabli.isTableOccupee());
                // }

                return numTable;
            }
        }
        // si on n'a pas su trouver la table parfaite, on cherche une table avec le moins de place en trop possible
        if (tableIdeale == false) {
            for (int numTable = 0; numTable < listeDesTables.size(); numTable++) {
                // Si on trouve une table non occupe et avec 2 places au max en trop
                if (listeDesTables.get(numTable).isTableOccupee() == false && listeDesTables.get(numTable).getNbClientMax() <= nbClient + 2 && tableIdeale == false) {
            	    //this.listeDesTables.get(numTable).setTableOccupee(true); // On dit que cette table est desormais occupe
                    tableIdeale = true;
                    numTable++;
                    System.out.println("Aller à la table n°" + numTable);

                    //TEST QUI AFFICHE LA LISTE DES TABLES AVEC LEURS NOMBRE DE PLACE MAXIMUM
                    // for (Table tabli : getListeDesTables()) {
                    //     System.out.println("table n°" + tabli.getNumeroTable() + " | " + tabli.getNbClientMax() + " | " + tabli.isTableOccupee());
                    // }

                    return numTable;
                }
            }
        }
        // si on n'a toujours pas trouvé de table adapté, on continue
        if (tableIdeale == false) {
            for (int numTable = 0; numTable < listeDesTables.size(); numTable++) {
                // Si on trouve une table non occupe et avec 4 places au max en trop
                if (listeDesTables.get(numTable).isTableOccupee() == false && listeDesTables.get(numTable).getNbClientMax() <= nbClient + 4 && tableIdeale == false) {
            	    //this.listeDesTables.get(numTable).setTableOccupee(true); // On dit que cette table est desormais occupe
                    tableIdeale = true;
                    numTable++;
                    System.out.println("Aller à la table n°" + numTable);

                    //TEST QUI AFFICHE LA LISTE DES TABLES AVEC LEURS NOMBRE DE PLACE MAXIMUM
                    // for (Table tabli : getListeDesTables()) {
                    //     System.out.println("table n°" + tabli.getNumeroTable() + " | " + tabli.getNbClientMax() + " | " + tabli.isTableOccupee());
                    // }

                    return numTable;
                }
            }
        }
        // dernier essai
        if (tableIdeale == false) {
            for (int numTable = 0; numTable < listeDesTables.size(); numTable++) {
                // Si on trouve une table non occupe et avec 6 places au max en trop
                if (listeDesTables.get(numTable).isTableOccupee() == false && listeDesTables.get(numTable).getNbClientMax() <= nbClient + 6 && tableIdeale == false) {
            	    //this.listeDesTables.get(numTable).setTableOccupee(true); // On dit que cette table est desormais occupe
                    tableIdeale = true;
                    numTable++;
                    System.out.println("Aller à la table n°" + numTable);

                    //TEST QUI AFFICHE LA LISTE DES TABLES AVEC LEURS NOMBRE DE PLACE MAXIMUM
                    for (Table tabli : getListeDesTables()) {
                        System.out.println("table n°" + tabli.getNumeroTable() + " | " + tabli.getNbClientMax() + " | " + tabli.isTableOccupee());
                    }

                    return numTable;
                }
            }
        }
        // si on n'a pas trouvé de table, c'est qu'il n'y en a pas de disponible ...
        System.err.println("Il n'y a plus de table disponible.");
        return 0;
    }

    protected void nettoyage(){

    }
    protected void ajoutTable(){

    }
}
