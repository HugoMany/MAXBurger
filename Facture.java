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

	protected Double montantTotalJournee = 0.0;
	protected ArrayList<TicketResume> listeTickets = new ArrayList<TicketResume>();
	protected int nbFactureDemandee = 1;


	public void setNouveauTicket(int numTable, int numCommande, Double montant) {
        TicketResume newTicket = new TicketResume(numTable, numCommande, montant);
        listeTickets.add(newTicket);
    }

	public void incrNbFactureDemandee() {
		nbFactureDemandee++;
	}


	public void affichageMenuStatsTickets() {
		System.out.println("### Facture journaliere ###\n");

		String texte = "# Facture journaliere\n\n\n";

		System.out.println("####### Nb tables servies aujourd'hui " + listeTickets.size());
		
		for(int i = 0; i < listeTickets.size(); i++) {
			texte += "Table numero " + listeTickets.get(i).numTable + " - Commande numéro " + listeTickets.get(i).numCommande + "\n";
			texte += listeTickets.get(i).montantPaye + " euros\n\n";
			montantTotalJournee += listeTickets.get(i).montantPaye;
		}
        
        
        texte += "\n\nTotal percu ce jour : " + montantTotalJournee;

        if (montantTotalJournee >= 2) {
            texte += " euros";
        }
        else {
            texte += " euro";
        }

		System.out.print(texte);

		System.out.println("\n###########\n### FIN ###\n###########\n");
	}


	public void editionFichier(int numJour) {
        Charset charset = Charset.forName ("windows-1252");
        String nomFichier = "Jour" + numJour + "\\Facture journaliere";
        String texte = "# Facture journaliere\n\n\n";


		texte += "####### Nb tables servies aujourd'hui " + listeTickets.size();
		for(int i = 0; i < listeTickets.size(); i++) {
			texte += "Table numero " + listeTickets.get(i).numTable + " - Commande numero " + listeTickets.get(i).numCommande + "\n";
			texte += listeTickets.get(i).montantPaye + " euros\n\n";
			montantTotalJournee += listeTickets.get(i).montantPaye;
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
            System.out.println("Facture éditée avec succès");
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
