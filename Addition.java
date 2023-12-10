import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.NumberFormat;


public class Addition {
    
    protected int numTable;
    protected double somme = 0;
    protected ArrayList<Plat> listeDesPlats;
    protected ArrayList<Boisson> listeDesBoissons;


    // Obsolète - On crée une addition vierge avec le numéro de la table et une somme nulle
    public void initAddition(int numTable, int nbUtilisation) {
        this.numTable = numTable;
        this.somme = 0;
    }

    public Addition() {
    
    }

    // Obsolète - On crée une addition complète avec le numéro de la table et la somme à payer
    public Addition(int numTable, double montant) {
        this.numTable = numTable;
        this.somme = montant;
    }

    // On récupère tous les éléments commandés pour ensuite pouvoir calculer le montant à payer
    void calculAddition() {
        if (listeDesPlats == null) {}
        else {
            for (int i = 0; i < listeDesPlats.size(); i++) {
                somme += listeDesPlats.get(i).getPrix();
            }
        }
        if (listeDesBoissons == null) {}
        else {
            for (int i = 0; i < listeDesBoissons.size(); i++) {
                somme += listeDesBoissons.get(i).getPrix();
            }
        }
    }

    // On récupère les éléments commandéss de la classe Commande entrée en paramètre et on lance le calcul de l'addition
    public void newAddition(Commande maCommande) {
        this.listeDesPlats = new ArrayList<Plat> (maCommande.getPlat());
        this.listeDesBoissons = new ArrayList<Boisson> (maCommande.getBoisson());
        calculAddition();
    }

    // On prépare une liste textuelle des plats
    public String listeDesPlatsTicket() {
        String liste = "";
        if (this.listeDesPlats == null) { return "Aucun plat\n";}
        else {
            for (int i = 0; i < listeDesPlats.size(); i++) {
                liste += listeDesPlats.get(i).getNom() + "- \t" + listeDesPlats.get(i).getPrix() + " €\n";
            }
            return liste;
        }
    }

    // On prépare une liste textuelle des boissons
    public String listeDesBoissonsTicket() {
        String liste = "";
        if (this.listeDesPlats == null) { return "Aucune boisson\n";}
        else {
            for (int i = 0; i < listeDesBoissons.size(); i++) {
                liste += listeDesBoissons.get(i).getNom() + "- \t" + listeDesBoissons.get(i).getPrix() + " €\n";
            }
            return liste;
        }
    }

    
    // On crée un fichier au nom voulu
    public void enregistrementFichier() {
        String cheminDuFichier = "Ticket Table n" + numTable;
        // Créez gn qbdet File pour le fichSgc
        File fichier = new File(cheminDuFichier);
        try {
            // méthode createNewFi1e() pour créer le fichier
            boolean fichierCree = fichier.createNewFile();
            if (fichierCree) {
                System.out.println("Enregistrement du ticket effectué avec succès.");}
            else {
                System.out.println("Erreur, table déjà existante.");
            }
        } catch (IOException e) {
            System.err.println("Une erreur s'est produite lors de l'enregistrement du ticket." + e.getMessage());
        }
    }

    // On teste ici son ouverture
    public void testOuverture() {
        Path fichier = Path.of("monFichier.txt");
        boolean estAccessible = Files.isRegularFile(fichier) && Files.isReadable(fichier) && Files.isExecutable(fichier);
        System.out.println(estAccessible);
    }

    // A faire ! Permet de stocker un bref récap de la commande pour éditer un ticket final de la journée
    public void editionTicketResume() {
        
    }

    // On enregistre toute la commande dans un fichier texte
    public void editionTicket() {
        // try-with-resources
        Charset charset = Charset.forName ("windows-1252");
        String nomFichier = "Ticket Table n" + numTable;
        String texte = "# Ticket Table n" + numTable + "\n\n\n";

        texte += listeDesPlatsTicket();
        texte += listeDesBoissonsTicket();
        texte += "\n\nA payer : " + somme;

        if (somme >= 2) {
            texte += " euros";
        }
        else {
            texte += " euro";
        }


        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(nomFichier), charset)) {

            writer.write(texte);
            System.out.println("toutBon");
        }
        catch (IOException x) {
            System.err.format("IOException : %s%n", x);
        }

    }

    





}
