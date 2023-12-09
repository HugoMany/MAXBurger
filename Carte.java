public class Carte {
    
    protected Plat[] cartePlat = 
    {
        new Plat(1, "Salade",9.0, {new Ingredients("Salade")}),
        new Plat(2, "Salade Tomate",9.0),
        new Plat(3, "Potage Potimarron",8.0),
        new Plat(4, "Potage Tomate",8.0),
        new Plat(5, "Potage champignon",8.0),
        new Plat(6, "Burger Max",15.0),
        new Plat(7, "Burger M",15.0),
        new Plat(8, "Burger miniMax",15.0),
        new Plat(9, "Pizza Classico",12.0),
        new Plat(10, "Pizza Classico Champi",12.0),
        new Plat(11, "Pizza Classico Chorizo",12.0),
        

    } ;
    protected Boisson[] carteBoisson = 
    {
        new Boisson(1, "Limonade",4),
        new Boisson(2, "Cidre doux",5),
        new Boisson(3, "Biere sans alcool",5),
        new Boisson(4, "Jus de fruit",5),
        new Boisson(5, "Verre d'eau",0)
    } ;
    public Boisson[] getCarteBoisson() {
        return carteBoisson;
    }
    public Plat[] getCartePlat() {
        return cartePlat;
    }
    public void printCartePlat() {
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
