import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    //
    //  Constantes
    //
    public static final int NOMBRE_TABLE = 15;

    //
    //  Variabmes
    //
    protected ArrayList<Journee> listeDesJournée = new ArrayList<>();
    public int currentDay = 0;
    public Carte carteDuRestorant = new Carte();

    public void addAJournee(Journee newJournee) {
        this.listeDesJournée.add(newJournee);
        for (int i = 1; i <= NOMBRE_TABLE; i++) {
            newJournee.listeDesTables.add(new Table(i, getRandomNumber(1, 5) * 2));
        }
    }

    public ArrayList<Journee> getListeDesJournée() {
        return listeDesJournée;
    }

    public void startApp() {
        addAJournee(new Journee());
        mainMenu();
    }
    public void mainMenu(){
        displayMainMenu();

        try (Scanner scanner = new Scanner(System.in)) {
            int choixEcran = scanner.nextInt();
            switch (choixEcran) {
                case 0:
                    break;
                case 1:
                    ecranCommande(scanner);
                    break;
                case 2:
                    ecranCuisine(scanner);
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

    public void ecranCommande(Scanner scanner) {
        displayCommandeMenu();
        if (scanner.hasNextInt()) {
            int choixEcran = scanner.nextInt();
            switch (choixEcran) {
                case 1:
                    carteDuRestorant.printCartePlat();
                    demandeNomEtNumeroTable(0, scanner);
                    break;
                case 2:
                    carteDuRestorant.printCarteBoisson();
                    demandeNomEtNumeroTable(1, scanner);
                    break;
                default:
                    startApp();
                    break;
        }
        }
       
    }

    public void priseCommandePlat(String nomClient, int numTable, Scanner scanner) {
        //A finir
        nomClient ="many";

        Commande newCommande = new Commande(nomClient, numTable);
        ArrayList<Integer> listePlatCommande = new ArrayList<>();
        boolean commandeEnd = false;

        while (!commandeEnd) {
            System.out.println("Saisissez le n° du plat choisi.(0 : pour valider la commande, -1 : annuler)");
            int choixEcran = scanner.nextInt();
            if (choixEcran==-1) {
                commandeEnd=true;
                return;
            }
            if (choixEcran != 0) {
                listePlatCommande.add(choixEcran);
                System.out.println(carteDuRestorant.cartePlat[choixEcran].nom);
            } 
            else {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("La commande a été validée, elle contient :");
                for (int platCode : listePlatCommande) {
                    System.out.println(carteDuRestorant.cartePlat[platCode].nom);
                    newCommande.ajoutPlatALaCommande(carteDuRestorant.cartePlat[platCode]);
                    commandeEnd=true;
                }
                commandeEnd = true;
            }
        }
        // Récupérer la journée actuelle
        Journee journeeActuelle = listeDesJournée.get(currentDay);

        // Récupérer la liste des tables de la journée actuelle
        ArrayList<Table> listeDesTables = journeeActuelle.listeDesTables;

        // Récupérer la table spécifique à mettre à jour
        Table tableAModifier = listeDesTables.get(numTable);

        // Ajouter une nouvelle commande à la table
        tableAModifier.tableauDeCommandes.add(newCommande);

        // Mettre à jour la table dans la liste des tables
        listeDesTables.set(numTable, tableAModifier);

        // Mettre à jour la journée dans la liste générale
        listeDesJournée.set(currentDay, journeeActuelle);

        mainMenu();

    }

    public void demandeNomEtNumeroTable(int type, Scanner scanner) {
        String nom = "";
        int numeroTable = 0;

        //System.out.println("Entrez le nom du client : ");
        //nom = scanner.nextLine();

        System.out.println("Entrez le numéro de table : ");
        while (!scanner.hasNextInt()) {
            System.err.println("Erreur : Veuillez entrer un numéro de table valide.");
            scanner.next(); // Consommer la saisie incorrecte
        }
        numeroTable = scanner.nextInt();

        // Consommer la fin de la ligne pour éviter les problèmes de décalage
        scanner.nextLine();

        if (type == 0) {
            priseCommandePlat(nom, numeroTable, scanner);
        } else {
            // Ajoutez le code pour la prise de commande des boissons
        }
    }

    public void ecranCuisine( Scanner scanner) {
        displayCuisineMenu();

      
        int choixEcran = scanner.nextInt();
        switch (choixEcran) {
            case 1:
                ArrayList<Table> allTables=this.listeDesJournée.get(currentDay).listeDesTables;
                for (int i = 0; i < allTables.size() ; i++) {
                    for (int y = 0; y < allTables.get(i).tableauDeCommandes.size() ; y++) {
                        System.out.println(allTables.get(i).tableauDeCommandes.get(y).listeDesPlatsCommandes);
                        //(allTables.get(i).tableauDeCommandes.get(y).listeDesPlatsCommandes)
                    }
                }
                break;
            default:
                startApp();
                break;
        }
    
    }

    public void ecranBar() {
        displayBarMenu();

        try (Scanner scanner = new Scanner(System.in)) {
            int choixEcran = scanner.nextInt();
            switch (choixEcran) {
                case 1:
                    // Ajoutez le code pour afficher les commandes à faire au bar
                    break;
                default:
                    startApp();
                    break;
            }
        }
    }

    public void ecranMonitoring() {
        // Ajoutez le code pour l'écran de monitoring
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min + 1)) + min);
    }

    // Méthodes pour afficher les différents menus
    private void displayMainMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("------------------------------------------------------");
        System.out.println("-----------------Max Burger Application---------------");
        System.out.println("-----------------'Votre Burger Préféré'---------------");
        System.out.println("--------------------Copyright 2023--------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("\n\n");
        System.out.println("Quel écran souhaitez-vous afficher?");
        System.out.println("1- Ecran prise de commande");
        System.out.println("2- Ecran cuisine");
        System.out.println("3- Ecran bar");
        System.out.println("4- Ecran Monitoring");
        System.out.println("0- Exit");
    }

    private void displayCommandeMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("0- Retour");
        System.out.println("1- Menu des Plats");
        System.out.println("2- Menu des Boissons");
    }

    private void displayCuisineMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("0- Retour");
        System.out.println("1- Afficher les commandes à faire en cuisine");
    }

    private void displayBarMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("0- Retour");
        System.out.println("1- Afficher les commandes à faire au bar");
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.startApp();
    }
}
