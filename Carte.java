public class Carte {
    
    protected Plat[] cartePlat = 
    {
        new Plat(1, "Salade"),
        new Plat(2, "Salade Tomate"),
        new Plat(3, "Potage Potimarron"),
        new Plat(4, "Potage Tomate"),
        new Plat(5, "Potage champignon"),
        new Plat(6, "Burger Max"),
        new Plat(7, "Burger M"),
        new Plat(8, "Burger miniMax"),
        new Plat(9, "Pizza Classico"),
        new Plat(10, "Pizza Classico Champi"),
        new Plat(11, "Pizza Classico Chorizo"),
        

    } ;
    protected Boisson[] carteBoisson = 
    {
        new Boisson(1, "Limonade"),
        new Boisson(2, "Cidre doux"),
        new Boisson(3, "Biere sans alcool"),
        new Boisson(4, "Jus de fruit"),
        new Boisson(5, "Verre d'eau")
    } ;

    public void printCartePlat() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
         for(int idx=0; idx< (this.cartePlat.length);idx++){
            System.out.println(this.cartePlat[idx]);
         }
        }
    public void printCarteBoisson() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); 
        for(int idx=0; idx< (this.carteBoisson.length);idx++){
            System.out.println(this.carteBoisson[idx]);
         }
    }


}
