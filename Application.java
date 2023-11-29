import java.util.ArrayList;

public class Application {
    protected ArrayList<Journee> listeDesJournée =new ArrayList<Journee>();

    public void addAJournee(Journee newJournee){
        this.listeDesJournée.add(newJournee);
    }
    public ArrayList<Journee> getListeDesJournée() {
        return listeDesJournée;
    }

    public void startApp(){
        
    }
    
}
