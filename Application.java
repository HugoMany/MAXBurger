import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    protected ArrayList<Journee> listeDesJournée =new ArrayList<Journee>();
    public Carte carteDuRestorant = new Carte();
    //Ajout d'une journée dans l'application
    public void addAJournee(Journee newJournee){
        this.listeDesJournée.add(newJournee);
    }

    //Retourne la listes des journées
    public ArrayList<Journee> getListeDesJournée() {
        return listeDesJournée;
    }
    //Demarrage de l'application dans le Menu Principal
    public void startApp(){
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
                    printReturnEcranCommande();
                    
                    break;
                case 2:
                    carteDuRestorant.printCarteBoisson();
                    printReturnEcranCommande();


                    break;
                default:
                    startApp();
                    break;
            }
        }
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

    private void printReturnEcranCommande(){
        System.out.println("0- Retour");
        try (Scanner scanner = new Scanner(System.in)) {
        int choixEcran2 = scanner.nextInt();
        if (choixEcran2==0) {
        ecranCommande();
        }
        }
    }
}
