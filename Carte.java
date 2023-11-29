public class Carte {
    
    protected Plat[] cartePlat = 
    {
        new Plat(0, "Steak"),
        new Plat(0, "Steak"),
        new Plat(0, "Steak"),
        new Plat(0, "Steak"),
        new Plat(0, "Steak"),
        new Plat(0, "Steak"),
        new Plat(0, "Steak"),
        new Plat(0, "Steak"),

    } ;
    protected Boisson[] carteBoisson = 
    {
        new Boisson(0, "Porto"),
        new Boisson(0, "Porto"),
        new Boisson(0, "Porto"),
        new Boisson(0, "Porto"),
        new Boisson(0, "Porto"),
        new Boisson(0, "Porto"),
        new Boisson(0, "Porto"),
        new Boisson(0, "Porto"),

    } ;

    public void printCartePlat() {
         for(int idx=0; idx< (this.cartePlat.length);idx++){
            System.out.println(this.cartePlat[idx]);
         }
        }
    public void printCarteBoisson() { 
        for(int idx=0; idx< (this.carteBoisson.length);idx++){
            System.out.println(this.carteBoisson[idx]);
         }
    }


}
