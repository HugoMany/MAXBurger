import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    //
    //      Constantes
    //
    public static final int NOMBRE_TABLE = 15;

    //
    //      Variables
    //
    protected ArrayList<Journee> listeDesJournée =new ArrayList<Journee>();
    public int currentDay = 0;
    public Carte carteDuRestorant = new Carte();


    //Ajout d'une journée dans l'application
    public void addAJournee(Journee newJournee){
        this.listeDesJournée.add(newJournee);
        for (int i = 1; i <= NOMBRE_TABLE; i++) {
            newJournee.listeDesTables.add(new Table(i,getRandomNumber(1,5)*2));
        }
    }

    //Retourne la listes des journées
    public ArrayList<Journee> getListeDesJournée() {
        return listeDesJournée;
    }
    //Demarrage de l'application dans le Menu Principal
    public void startApp(){
        //Ajout de la premiere Journée.
        addAJournee(new Journee());
        
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("------------------------------------------------------");
        System.out.println("-----------------Max Burger Application---------------");
        System.out.println("-----------------'Votre Burger Préféré'---------------");
        System.out.println("--------------------Copyright 2023--------------------");
        System.out.println("------------------------------------------------------");

        System.out.println("\n\n");

        System.out.println("Quel écran souhaitez vous afficher?");
        System.out.println("1- Ecran prise de commande");
        System.out.println("2- Ecran cuisine");
        System.out.println("3- Ecran bar");
        System.out.println("4- Ecran Monitoring");
        System.out.println("0- Exit");
        try (Scanner scanner = new Scanner(System.in)) {
            int choixEcran = scanner.nextInt();
            //System.out.println("Vous avez choisi l'écran: " + choixEcran);
             switch (choixEcran) {
                case 0:

                    break;
                case 1:
                    ecranCommande();
                    break;
                case 2:
                    ecranCuisine();
                    break;
                case 3:
                    ecranBar();
                    break;
                case 4:
                    ecranMonitoring();
                    break;
                default:
                    startApp();
                    break;
            }
        }

    }
    //Affiche un Sous menu concernant les commandes 
    public void ecranCommande(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        //System.out.println("Quel écran souhaitez vous afficher?");
        System.out.println("0- Retour");
        System.out.println("1- Menu des Plats");
        System.out.println("2- Menu des Boissons");
        try (Scanner scanner = new Scanner(System.in)) {
            int choixEcran = scanner.nextInt();
            switch (choixEcran) {
                case 1:
                    carteDuRestorant.printCartePlat();
                    priseCommandePlat();
                    break;
                case 2:
                    carteDuRestorant.printCarteBoisson();
                    priseCommandeBoisson();



                    break;
                default:
                    startApp();
                    break;
            }
        }
    }

    private void priseCommandeBoisson() {

    }

    private void priseCommandePlat() {
        //A continuer
        String nomClient="MANY";
        //int numTable = demandeNumeroTable();
        int numTable = 1;
        Commande newCommande = new Commande(nomClient, numTable);
        ArrayList<Integer> listePlatCommande = new ArrayList<Integer>();
        boolean commandeEnd= false;
        try (Scanner scanner = new Scanner(System.in)) {
            while (!commandeEnd) {
                int choixEcran = scanner.nextInt();
                if (choixEcran != 0) {
                    listePlatCommande.add(choixEcran);
                    System.out.println(carteDuRestorant.cartePlat[choixEcran].nom);
                } 
                else {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("La commande a été valider elle contient :");
                    for (int i = 0; i < listePlatCommande.size(); i++) {
                        System.out.println(carteDuRestorant.cartePlat[i].nom);
                        newCommande.ajoutPlatALaCommande(carteDuRestorant.cartePlat[i]);
                    }
                    //System.out.println(newCommande);
                    commandeEnd = true;
                }
                
            }
        }
        
        
    

    }
    private int demandeNumeroTable(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Quelle Numéro de table");
        int userValue = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            userValue = scanner.nextInt();

        }
        
        return userValue;
        
    }
    public void ecranCuisine(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        //System.out.println("Quel écran souhaitez vous afficher?");
        System.out.println("0- Retour");
        System.out.println("1- Afficher les commandes à faire");
        System.out.println("2- Commmande pret à servir");
        try (Scanner scanner = new Scanner(System.in)) {
            int choixEcran = scanner.nextInt();
            switch (choixEcran) {
                case 1:
                    
                    break;
            
                default:
                    startApp();
                    break;
            }
        }
    }

    public void ecranBar(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        //System.out.println("Quel écran souhaitez vous afficher?");
        System.out.println("0- Retour");
        System.out.println("1- Afficher les commandes à faire");
        System.out.println("2- Commmande pret à servir");
        try (Scanner scanner = new Scanner(System.in)) {
            int choixEcran = scanner.nextInt();
            switch (choixEcran) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                default:
                    startApp();
                    break;
            }
        }
    }

    public void ecranMonitoring(){
        
    }

    
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
