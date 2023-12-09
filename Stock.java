import java.util.ArrayList;

public class Stock {
    public ArrayList<Ingredients> listDesIngredientsDispo = new ArrayList<Ingredients>();

    

    public void removeStock(String nameToRemove) {
        for (int i = 0; i < this.listDesIngredientsDispo.size(); i++) {
            if (listDesIngredientsDispo.get(i).nom == nameToRemove) {
                this.listDesIngredientsDispo.remove(i);
            }
        }
    }
    public void removeStock(ArrayList<Ingredients> listDesIngredientsToRemove) {
        for (int i = 0; i < this.listDesIngredientsDispo.size(); i++) {
            for (int j = 0; j < listDesIngredientsToRemove.size(); j++) {
                if (listDesIngredientsDispo.get(i).nom == listDesIngredientsToRemove.get(j).nom) {
                    listDesIngredientsDispo.remove(i);
                }
            }
        }
    }
    public void addStock(Ingredients ingredientToAdd) {
        this.listDesIngredientsDispo.add(ingredientToAdd);
    }

    public Stock() {
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Tomate"));
        this.listDesIngredientsDispo.add(new Ingredients("Tomate"));
        this.listDesIngredientsDispo.add(new Ingredients("Tomate"));
        this.listDesIngredientsDispo.add(new Ingredients("Tomate"));
        this.listDesIngredientsDispo.add(new Ingredients("Champignon"));
        this.listDesIngredientsDispo.add(new Ingredients("Champignon"));
        this.listDesIngredientsDispo.add(new Ingredients("Champignon"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Chorizo"));
        this.listDesIngredientsDispo.add(new Ingredients("Chorizo"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Tomate"));
        this.listDesIngredientsDispo.add(new Ingredients("Tomate"));
        this.listDesIngredientsDispo.add(new Ingredients("Tomate"));
        this.listDesIngredientsDispo.add(new Ingredients("Tomate"));
        this.listDesIngredientsDispo.add(new Ingredients("Champignon"));
        this.listDesIngredientsDispo.add(new Ingredients("Champignon"));
        this.listDesIngredientsDispo.add(new Ingredients("Champignon"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Chorizo"));
        this.listDesIngredientsDispo.add(new Ingredients("Chorizo"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Tomate"));
        this.listDesIngredientsDispo.add(new Ingredients("Tomate"));
        this.listDesIngredientsDispo.add(new Ingredients("Tomate"));
        this.listDesIngredientsDispo.add(new Ingredients("Tomate"));
        this.listDesIngredientsDispo.add(new Ingredients("Champignon"));
        this.listDesIngredientsDispo.add(new Ingredients("Champignon"));
        this.listDesIngredientsDispo.add(new Ingredients("Champignon"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Chorizo"));
        this.listDesIngredientsDispo.add(new Ingredients("Chorizo"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Chorizo"));
        this.listDesIngredientsDispo.add(new Ingredients("Chorizo"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Tomate"));
        this.listDesIngredientsDispo.add(new Ingredients("Tomate"));
        this.listDesIngredientsDispo.add(new Ingredients("Tomate"));
        this.listDesIngredientsDispo.add(new Ingredients("Tomate"));
        this.listDesIngredientsDispo.add(new Ingredients("Champignon"));
        this.listDesIngredientsDispo.add(new Ingredients("Champignon"));
        this.listDesIngredientsDispo.add(new Ingredients("Champignon"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Chorizo"));
        this.listDesIngredientsDispo.add(new Ingredients("Chorizo"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Chorizo"));
        this.listDesIngredientsDispo.add(new Ingredients("Chorizo"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Salade"));
        this.listDesIngredientsDispo.add(new Ingredients("Tomate"));
        this.listDesIngredientsDispo.add(new Ingredients("Tomate"));
        this.listDesIngredientsDispo.add(new Ingredients("Tomate"));
        this.listDesIngredientsDispo.add(new Ingredients("Tomate"));
        this.listDesIngredientsDispo.add(new Ingredients("Champignon"));
        this.listDesIngredientsDispo.add(new Ingredients("Champignon"));
        this.listDesIngredientsDispo.add(new Ingredients("Champignon"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Steak"));
        this.listDesIngredientsDispo.add(new Ingredients("Chorizo"));
        this.listDesIngredientsDispo.add(new Ingredients("Chorizo"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Fromage"));
        this.listDesIngredientsDispo.add(new Ingredients("Pate"));
    }
}
