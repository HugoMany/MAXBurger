//import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Facture {


	protected Double montantTotalJournee;
	protected ArrayList<TicketResume> listeTickets = new ArrayList<TicketResume>();


	public void setNouveauTicket(int numTable, int numCommande, Double montant) {
        TicketResume newTicket = new TicketResume(numTable, numCommande, montant);
        listeTickets.add(newTicket);
    }





	




	




	public void editionFactureJournaliere() {
		enregistrementFichier();
		editionFichier();

	}


	public void enregistrementFichier() {
        String cheminDuFichier = "Facture journaliere";
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


	public void affichageMenuStatsTickets() {
		System.out.println("### Facture journaliere ###\n");

		for(int i = 0; i < listeTickets.size(); i++) {
			System.out.println("Table numero " + listeTickets.get(i).numTable + "");
			System.out.println(listeTickets.get(i).montantPaye + " euros\n");
		}
		System.out.print("\nTotal percu ce jour : " + montantTotalJournee);
		if (montantTotalJournee >= 2) {
            System.out.println(" euros");
        }
        else {
            System.out.println(" euro");
        }

		System.out.println("\n###########\n### FIN ###\n###########\n");
	}


	public void editionFichier() {
        // try-with-resources
        Charset charset = Charset.forName ("windows-1252");
        String nomFichier = "Facture journaliere";
        String texte = "# Facture journaliere\n\n\n";

		System.out.println("####### Nb table dans ticket " + listeTickets.size());
		for(int i = 0; i < listeTickets.size(); i++) {
			texte += "Table numero " + listeTickets.get(i).numTable + "\n";
			texte += listeTickets.get(i).montantPaye + " euros\n\n";
		}
        
        
        texte += "\n\nTotal percu ce jour : " + montantTotalJournee;

        if (montantTotalJournee >= 2) {
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

	


	
	// protected int listeAdditions[];
	// // protected ArrayList<Integer> Additions = new ArrayList<Integer>();
	// // protected ArrayList<Addition> Additions = new ArrayList<Addition>();
	// protected Addition[] tabAdditions = new Addition[15];
	
	// protected double sommeJournee;
	// protected int nombreTables;

	
	// public Facture() {
	// 	this.sommeJournee = 0;
	// 	this.nombreTables = 0;
	// 	videTabAdditions;
	// }

	// public void videTabAdditions() {
	// 	for (int i = 0; i < 15; i++) {
	// 		tabAdditions[i].initAdditions();
	// 	}
	// }

	// public void newAddition(int numTable, double montant) {
	// 	Addition currentAddition = new Addition(numTable, montant);
	// 	Additions.add(currentAddition);
	// 	this.nombreTables += 1;
	// }


	// public void ajoutElementAddition(int numTable, int montant) {

	// }


	
}
