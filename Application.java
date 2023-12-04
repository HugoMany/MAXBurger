import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    //
    // Constantes
    //
    public static final int NOMBRE_TABLE = 15;

    //
    // Variables
    //
    protected ArrayList<Journee> listeDesJournée = new ArrayList<>();
    public int currentDay = 0;
    public Carte carteDuRestorant = new Carte();

    //
    // Getters/Setters
    //
    public ArrayList<Journee> getListeDesJournée() {
        return this.listeDesJournée;
    }

    public int getCurrentDay() {
        return this.currentDay;
    }

    public Carte getCarteDuRestorant() {
        return this.carteDuRestorant;
    }

    public void addAJournee(Journee newJournee) {
        this.listeDesJournée.add(newJournee);
        for (int i = 1; i <= NOMBRE_TABLE; i++) {
            newJournee.listeDesTables.add(new Table(i, getRandomNumber(1, 5) * 2));
        }
    }

    //
    // Méthodes
    //
    public void startApp() {
        addAJournee(new Journee());
        try (Scanner scanner = new Scanner(System.in)) {
            mainMenu(scanner);
        }
    }

    public void mainMenu(Scanner scanner) {
        displayMainMenu();

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
                ecranBar(scanner);
                break;
            case 4:
                ecranMonitoring(scanner);
                break;
            case 5:
                ecranGestionPersonnel(scanner);
            default:
                startApp();
                break;
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

    public void demandeNomEtNumeroTable(int type, Scanner scanner) {
        String nom = "";
        int numeroTable = 0;

        // System.out.println("Entrez le nom du client : ");
        // nom = scanner.nextLine();

        // NOMBRE DE CLIENTS
        System.out.println("1-Nouveau client : ");
        System.out.println("2-Client ayant deja une table: ");
        while (!scanner.hasNextInt()) {
            System.err.println("Erreur : Veuillez entrer un nombre valide.");
            scanner.next(); // Consommer la saisie incorrecte
        }
        int choixNewOrOld = scanner.nextInt();

        //Choix Si NOUVEAU CLIENTS
        if (choixNewOrOld == 1) {
            System.out.println("Entrez le nombre de clients : ");
            while (!scanner.hasNextInt()) {
                System.err.println("Erreur : Veuillez entrer un nombre valide.");
                scanner.next(); // Consommer la saisie incorrecte
            }

            int nbClients = scanner.nextInt();
            if (nbClients > 8) {
                System.err.println("Erreur;");
                mainMenu(scanner);
                ;
            }
            // Consommer la fin de la ligne pour éviter les problèmes de décalage
            scanner.nextLine();

            // ASSIGNATION D'UNE TABLE
            Journee journee = getListeDesJournée().get(getCurrentDay());
            numeroTable = journee.conduireATable(nbClients);

            
        } 
         //Choix Si LES CLIENTS ONT DEJA UNE TABLE
        else {
            System.out.println("Entrez le numéro de table : ");
            while (!scanner.hasNextInt()) {
                System.err.println("Erreur : Veuillez entrer un numéro de table valide.");
                scanner.next(); // Consommer la saisie incorrecte
            }
            numeroTable = scanner.nextInt();
    
            // Consommer la fin de la ligne pour éviter les problèmes de décalage
            scanner.nextLine();
    
        }   
        if (type == 0) {
                        priseCommandePlat(nom, numeroTable, scanner);
                    } else if (type == 1) {
                        priseCommandeBoisson(nom, numeroTable, scanner);
        }
    }

    public void priseCommandePlat(String nomClient, int numTable, Scanner scanner) {
        // A finir
        nomClient = "many";

        Commande newCommande = new Commande(nomClient, numTable);
        ArrayList<Integer> listePlatCommande = new ArrayList<>();
        boolean commandeEnd = false;

        while (!commandeEnd) {
            System.out.println("Saisissez le n° du plat choisi.(0 : pour valider la commande, -1 : annuler)");
            int choixEcran = scanner.nextInt();
            if (choixEcran == -1) {
                commandeEnd = true;
                return;
            }
            if (choixEcran != 0) {
                listePlatCommande.add(choixEcran);
                System.out.println(carteDuRestorant.cartePlat[choixEcran - 1].nom);
            } else {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("La commande a été validée, elle contient :");
                for (int platCode : listePlatCommande) {
                    System.out.println(carteDuRestorant.cartePlat[platCode - 1].nom);
                    newCommande.ajoutPlatALaCommande(carteDuRestorant.cartePlat[platCode - 1]);
                    commandeEnd = true;
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
        System.out.println("0- Pour continuer");
        scanner.nextInt();
        mainMenu(scanner);

    }

    public void priseCommandeBoisson(String nomClient, int numTable, Scanner scanner) {
        // A finir
        nomClient = "many";

        Commande newCommande = new Commande(nomClient, numTable);
        ArrayList<Integer> listeBoissonCommande = new ArrayList<>();
        boolean commandeEnd = false;

        while (!commandeEnd) {
            System.out.println("Saisissez le n° de la boisson choisi.(0 : pour valider la commande, -1 : annuler)");
            int choixEcran = scanner.nextInt();
            if (choixEcran == -1) {
                commandeEnd = true;
                return;
            }
            if (choixEcran != 0) {
                listeBoissonCommande.add(choixEcran);
                System.out.println(carteDuRestorant.carteBoisson[choixEcran - 1].nom);
            } else {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("La commande a été validée, elle contient :");
                for (int boissonCode : listeBoissonCommande) {
                    System.out.println(carteDuRestorant.carteBoisson[boissonCode - 1].nom);
                    newCommande.ajoutBoissonALaCommande(carteDuRestorant.carteBoisson[boissonCode - 1]);
                    commandeEnd = true;
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

        mainMenu(scanner);
    }

    public void ecranCuisine(Scanner scanner) {
        displayCuisineMenu();

        int choixEcran = scanner.nextInt();
        switch (choixEcran) {
            case 1:
                ArrayList<Table> allTables = this.listeDesJournée.get(currentDay).listeDesTables;
                for (int i = 0; i < allTables.size(); i++) {
                    for (int y = 0; y < allTables.get(i).tableauDeCommandes.size(); y++) {
                        System.out.println(allTables.get(i).tableauDeCommandes.get(y).listeDesPlatsCommandes);
                        // (allTables.get(i).tableauDeCommandes.get(y).listeDesPlatsCommandes)
                    }
                }
                mainMenu(scanner);
                break;
            default:
                startApp();
                break;
        }

    }

    public void ecranBar(Scanner scanner) {
        displayBarMenu();

        int choixEcran = scanner.nextInt();
        switch (choixEcran) {
            case 1:
                ArrayList<Table> allTables = this.listeDesJournée.get(currentDay).listeDesTables; // Récupère la liste des tables
                for (int i = 0; i < allTables.size(); i++) {
                    for (int y = 0; y < allTables.get(i).tableauDeCommandes.size(); y++) {
                        System.out.println(allTables.get(i).tableauDeCommandes.get(y).listeDesBoissonsCommandees);
                        // (allTables.get(i).tableauDeCommandes.get(y).listeDesPlatsCommandes)
                    }
                }
                scanner.nextInt();
                mainMenu(scanner);
                break;
            default:
                startApp();
                break;
        }

    }

    public void ecranMonitoring(Scanner scanner) {
        // Ajoutez le code pour l'écran de monitoring
        Facture hello = new Facture();
		hello.lectureFichier();
		hello.affichageMenuStatsTickets();

        // Ajouter demande si enregistrement dans un fichier
    }

    public void ecranGestionPersonnel(Scanner scanner) {
        displayGestionPersonnelMenu();

        int choixEcran = scanner.nextInt();
        switch (choixEcran) {
            case 1:
                System.out.println("Entrez votre nom");
                while (!scanner.hasNext()) {
                    System.err.println("Erreur : Veuillez entrer votre nom");
                    scanner.next(); // Consommer la saisie incorrecte
                }
                String nom = scanner.next();
                // Consommer la fin de la ligne pour éviter les problèmes de décalage
                scanner.nextLine();
                System.out.println("Entrez votre prénom");
                while (!scanner.hasNext()) {
                    System.err.println("Erreur : Veuillez entrer votre prénom");
                    scanner.next(); // Consommer la saisie incorrecte
                }
                String prenom = scanner.next();
                // Consommer la fin de la ligne pour éviter les problèmes de décalage
                scanner.nextLine():

                break;
            
            case 2:
                
                break;

            default:
                startApp();
                break;
        }
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
        System.out.println("5- Ecran Gestion Personnel");
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

    private void displayGestionPersonnelMenu() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("0- Retour");
        System.out.println("1- Ajouter serveur");
        System.out.println("2- Distribution des tables");
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.startApp();
    }
}