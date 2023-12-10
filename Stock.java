import java.util.ArrayList;
import java.util.Iterator;

public class Stock {
    public ArrayList<Ingredients> listDesIngredientsDispo = new ArrayList<Ingredients>();


    public void removeStock(ArrayList<Ingredients> listDesIngredientsToRemove) {
        for (Ingredients ingredientToRemove : listDesIngredientsToRemove) {
            boolean removed = false;

            Iterator<Ingredients> iterator = this.listDesIngredientsDispo.iterator();

            while (iterator.hasNext()) {
                Ingredients ingredient = iterator.next();

                if (ingredient.equals(ingredientToRemove)) {
                    iterator.remove();
                    removed = true;
                    break;  // Arrêtez la boucle après avoir trouvé et supprimé le premier élément
                }
            }

            if (!removed) {
                System.out.println("Les "+ingredientToRemove.nom + " ont été supprimer du stock.");
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
