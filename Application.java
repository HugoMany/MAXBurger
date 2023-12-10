import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    //
    // Constantes
    //
    public static final int NOMBRE_TABLE = 15;
    public static final int NOMBRE_BOISSON_CARTE = 5;
    public static final int NOMBRE_PLAT_CARTE = 11;
    public static final int H_OUVERTURE = 10;
    public static final int H_FERMETURE = 10;

    //
    // Variables
    //
    protected ArrayList<Journee> listeDesJournée = new ArrayList<>();
    public int currentDay = 0;
    public Carte carteDuRestorant = new Carte();
    protected ArrayList<Personnel> listeDesEmployees = new ArrayList<Personnel>();
    protected Boolean tableDuJourDejaDistribué = false;
    protected Stock stockGlbaleStock = new Stock();

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

    public ArrayList<Personnel> getListeDesEmployees() {
        return this.listeDesEmployees;
    }

    public Boolean isTableDuJourDejaDistribuee() {
        return this.tableDuJourDejaDistribué;
    }

    public void addAJournee(Journee newJournee) {
        this.listeDesJournée.add(newJournee);
        for (int i = 1; i <= NOMBRE_TABLE; i++) {
            newJournee.listeDesTables.add(new Table(i, getRandomNumber(1, 5) * 2));
        }
    }

    public void ajouterEmploye(Personnel personnel) {
        this.listeDesEmployees.add(personnel);
    }

    //
    // Méthodes
    //
    public void startApp() {
        addAJournee(new Journee(H_OUVERTURE, H_FERMETURE));
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
            case 6:
                affichageStock(scanner);
            case 7:
                nextDay(scanner);
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
                    demandeNomEtNumeroTable(0, scanner);
                    break;
                case 2:
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
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("1-Nouveau client : ");
        System.out.println("2-Client ayant deja une table: ");
        while (!scanner.hasNextInt()) {
            System.err.println("Erreur : Veuillez entrer un nombre valide.");
            scanner.next(); // Consommer la saisie incorrecte
        }
        int choixNewOrOld = scanner.nextInt();

        // Choix Si NOUVEAU CLIENTS
        if (choixNewOrOld == 1) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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
        // Choix Si LES CLIENTS ONT DEJA UNE TABLE
        else {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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

        carteDuRestorant.printCartePlat();
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
            if (choixEcran != 0 && choixEcran <= NOMBRE_PLAT_CARTE) {
                listePlatCommande.add(choixEcran);
                System.out.println(carteDuRestorant.cartePlat[choixEcran - 1].nom);
            } else if (choixEcran > NOMBRE_PLAT_CARTE) {
                System.err.println("Erreur Chiffre mauvais");
                System.out.println("0- Pour continuer");
                scanner.nextInt();
                mainMenu(scanner);
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
        carteDuRestorant.printCarteBoisson();

        while (!commandeEnd) {
            System.out.println("Saisissez le n° de la boisson choisi.(0 : pour valider la commande, -1 : annuler)");
            int choixEcran = scanner.nextInt();
            if (choixEcran == -1) {
                commandeEnd = true;
                return;
            }
            if (choixEcran != 0 && choixEcran <= NOMBRE_BOISSON_CARTE) {
                listeBoissonCommande.add(choixEcran);
                System.out.println(carteDuRestorant.carteBoisson[choixEcran - 1].nom);
            } else if (choixEcran > NOMBRE_BOISSON_CARTE) {
                System.err.println("Erreur Chiffre mauvais");
                System.out.println("0- Pour continuer");
                scanner.nextInt();
                mainMenu(scanner);
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
                int indexPrint = 0;
                for (int i = 0; i < allTables.size(); i++) {
                    for (int y = 0; y < allTables.get(i).tableauDeCommandes.size(); y++) {
                        indexPrint++;
                        if (!allTables.get(i).tableauDeCommandes.get(y).isPret()) {
                            System.out.println(indexPrint + "- "
                                    + allTables.get(i).tableauDeCommandes.get(y).listeDesPlatsCommandes);
                        }

                    }
                }
                System.out.println("0- Pour continuer \n 1à99- Pour Valider");
                int choixCommandePrete = scanner.nextInt();
                if (choixCommandePrete == 0) {
                    mainMenu(scanner);
                } else {
                    int indexChoisi = 0;
                    for (int i = 0; i < allTables.size(); i++) {
                        for (int y = 0; y < allTables.get(i).tableauDeCommandes.size(); y++) {
                            indexChoisi++;
                            if (choixCommandePrete == indexChoisi) {
                                allTables.get(i).tableauDeCommandes.get(y).setPret(true);
                                Commande commandeModifie = allTables.get(i).tableauDeCommandes.get(y);
                                Journee journeeActuelle = listeDesJournée.get(currentDay);

                                // Récupérer la liste des tables de la journée actuelle
                                ArrayList<Table> listeDesTables = journeeActuelle.listeDesTables;

                                // Récupérer la table spécifique à mettre à jour
                                Table tableAModifier = listeDesTables.get(i);

                                // Ajouter une nouvelle commande à la table
                                tableAModifier.tableauDeCommandes.add(commandeModifie);

                                // Mettre à jour la table dans la liste des tables
                                listeDesTables.set(i, tableAModifier);

                                // Mettre à jour la journée dans la liste générale
                                listeDesJournée.set(currentDay, journeeActuelle);
                                ArrayList<Ingredients> retListOfIngredients = commandeModifie
                                        .getAllIngredientsFromPlat();
                                stockGlbaleStock.removeStock(retListOfIngredients);
                                System.out.println("Ingrédients Supprimer du stock");

                            }
                            // System.out.println(indexPrint+"-
                            // "+allTables.get(i).tableauDeCommandes.get(y).listeDesPlatsCommandes);
                            System.out.println("Commande N°" + indexChoisi + " à été validé");

                        }
                    }
                }
                System.out.println("0- Pour continuer");
                scanner.nextInt();
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
                ArrayList<Table> allTables = this.listeDesJournée.get(currentDay).listeDesTables;
                int indexPrint = 0;
                for (int i = 0; i < allTables.size(); i++) {
                    for (int y = 0; y < allTables.get(i).tableauDeCommandes.size(); y++) {
                        indexPrint++;
                        if (!allTables.get(i).tableauDeCommandes.get(y).isPret()) {
                            System.out.println(indexPrint + "- "
                                    + allTables.get(i).tableauDeCommandes.get(y).listeDesBoissonsCommandees);
                        }

                    }
                }
                System.out.println("0- Pour continuer \n 1à99- Pour Valider");
                int choixCommandePrete = scanner.nextInt();
                if (choixCommandePrete == 0) {
                    mainMenu(scanner);
                } else {
                    int indexChoisi = 0;
                    for (int i = 0; i < allTables.size(); i++) {
                        for (int y = 0; y < allTables.get(i).tableauDeCommandes.size(); y++) {
                            indexChoisi++;
                            if (choixCommandePrete == indexChoisi) {
                                allTables.get(i).tableauDeCommandes.get(y).setPret(true);
                                Commande commandeModifie = allTables.get(i).tableauDeCommandes.get(y);
                                Journee journeeActuelle = listeDesJournée.get(currentDay);

                                // Récupérer la liste des tables de la journée actuelle
                                ArrayList<Table> listeDesTables = journeeActuelle.listeDesTables;

                                // Récupérer la table spécifique à mettre à jour
                                Table tableAModifier = listeDesTables.get(i);

                                // Ajouter une nouvelle commande à la table
                                tableAModifier.tableauDeCommandes.add(commandeModifie);

                                // Mettre à jour la table dans la liste des tables
                                listeDesTables.set(i, tableAModifier);

                                // Mettre à jour la journée dans la liste générale
                                listeDesJournée.set(currentDay, journeeActuelle);

                            }
                            // System.out.println(indexPrint+"-
                            // "+allTables.get(i).tableauDeCommandes.get(y).listeDesPlatsCommandes);
                            System.out.println("Commande N°" + indexChoisi + " à été validé");

                        }
                    }
                }
                System.out.println("0- Pour continuer");
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
        System.out.println("0- Pour continuer");
        scanner.nextInt();
        mainMenu(scanner);
        // Ajouter demande si enregistrement dans un fichier
    }

    public void ecranGestionPersonnel(Scanner scanner) {
        displayGestionPersonnelMenu();
        int choixEcran = scanner.nextInt();

        switch (choixEcran) {

            case 1: // Ajouter serveur
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
                scanner.nextLine();

                Serveur newServeur = new Serveur(nom, prenom);
                ajouterEmploye(newServeur);
                break;

            case 2: // Distribution des tables
                if (getListeDesEmployees().isEmpty()) {
                    System.err.println("Il n'y a pas de serveurs embauchés.");
                    System.out.println("0- Pour continuer");
                    scanner.nextInt();
                    mainMenu(scanner);
                    break;
                }
                // On récupère en premier la liste des serveurs
                ArrayList<Serveur> listeDesServeurs = new ArrayList<>();
                for (Personnel iPersonnel : getListeDesEmployees()) { // Pour tout le personnel
                    if (iPersonnel instanceof Serveur) { // On verifie si le personnel est un serveur
                        listeDesServeurs.add((Serveur) iPersonnel); // on cast le personnel en serveur et on
                                                                    // l'ajoute dans la liste des serveurs
                    }
                }

                // Distribution des tables (une fois par jour)
                if (isTableDuJourDejaDistribuee() == false) {
                    int nbServeurs = listeDesServeurs.size();
                    int nbTablesParServeur = NOMBRE_TABLE / nbServeurs;
                    int resteDivisionEuclidienne = NOMBRE_TABLE % nbServeurs; // On va compter les tables "en trop"
                                                                              // comme un decompteur
                    int nbTableDejaDistribuee = 0; // On va compter le nombre de table que l'on distribue comme un
                                                   // compteur

                    for (Serveur iServeur : listeDesServeurs) { // Pour tout les serveur
                        ArrayList<Table> tableDuServeur = new ArrayList<>(); // On cree sa liste de table
                        int dernierNumeroTableADistribuerACeServeur = nbTablesParServeur + nbTableDejaDistribuee; // On
                                                                                                                  // regarde
                                                                                                                  // quel
                                                                                                                  // sera
                                                                                                                  // la
                                                                                                                  // derniere
                                                                                                                  // table
                                                                                                                  // à
                                                                                                                  // donner
                                                                                                                  // à
                                                                                                                  // ce
                                                                                                                  // serveur
                        for (int iTable = nbTableDejaDistribuee; iTable < dernierNumeroTableADistribuerACeServeur; iTable++) {

                            Journee journee = getListeDesJournée().get(getCurrentDay()); // On récupère la journée
                            tableDuServeur.add(journee.getListeDesTables().get(iTable)); // On ajoute cette table a la
                                                                                         // liste
                            nbTableDejaDistribuee++;
                        }
                        if (resteDivisionEuclidienne > 0) {
                            Journee journee = getListeDesJournée().get(getCurrentDay()); // On récupère la journée
                            tableDuServeur.add(journee.getListeDesTables().get(nbTableDejaDistribuee)); // On ajoute
                                                                                                        // cette table a
                                                                                                        // la liste
                            nbTableDejaDistribuee++;
                            resteDivisionEuclidienne--;
                        }
                        iServeur.addTables(tableDuServeur);
                        this.tableDuJourDejaDistribué = true;
                    }
                }

                // Affichage des tables
                System.out.println("\nDistribution du jour :");
                for (Serveur iServeur : listeDesServeurs) {
                    iServeur.printTableGeres();
                }
                System.out.println("\n0- Pour continuer");
                scanner.nextInt();
                mainMenu(scanner);
                break;

            default:
                startApp();
                break;
        }

    }

    public void affichageStock(Scanner scanner) {
        for (int i = 0; i < this.stockGlbaleStock.listDesIngredientsDispo.size(); i++) {
            System.out.print(this.stockGlbaleStock.listDesIngredientsDispo.get(i).nom + " ; ");
        }
        System.out.println("\n0- Pour continuer");
        scanner.nextInt();
        mainMenu(scanner);
    }

    private void nextDay(Scanner scanner) {
        this.currentDay++;
        addAJournee(new Journee(H_FERMETURE, H_OUVERTURE));
        System.out.println("Journée suivante!");
        System.out.println("\n0- Pour continuer");
        scanner.nextInt();

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
        System.out.println("6- Afficher Stock");
        System.out.println("7- Prochaine Journée");
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

}