import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Addition {
    
    protected int numTable;
    protected double somme;
    protected ArrayList<Plat> listeDesPlats;// = new ArrayList<>();
    protected ArrayList<Boisson> listeDesBoissons;// = new ArrayList<Boisson>();


    public void initAddition(int numTable, int nbUtilisation) {
        this.numTable = numTable;
        this.somme = 0;
    }

    public Addition() {

    }

    public Addition(int numTable, double montant) {
        this.numTable = numTable;
        this.somme = montant;
    }


    public void newAddition(Commande maCommande) {

        
        //this.listeDesPLats.addAll(maCommande.getPlat());
        this.listeDesPlats = new ArrayList<Plat> (maCommande.getPlat());
        this.listeDesBoissons = new ArrayList<Boisson> (maCommande.getBoisson());
        
        

    }

    public void enregistrementFichier() {
        String cheminDuFichier = "monFichier.txt";
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

    public void testOuverture() {
        Path fichier = Path.of("monFichier.txt");
        boolean estAccessible = Files.isRegularFile(fichier) && Files.isReadable(fichier) && Files.isExecutable(fichier);
        System.out.println(estAccessible);
    }

    public void editionFichier() {
        // try-with-resources
        Charset charset = Charset.forName ("windows-1252");
        String nomFichier = "monFichier.txt";
        String texte = "hellkf\naa";
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(nomFichier), charset)) {

            writer.write(texte);
            System.out.println("toutBon");
        }
        catch (IOException x) {
            System.err.format("IOException : %s%n", x);
        }

    }





}
