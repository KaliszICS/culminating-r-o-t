/**
 * Shop sorts using merge and displays inv after sorting using displayInventory();
 * @author Toby Tan
 * @version 1.0.6
*/

import java.util.List;

public class Shop extends Trainer {
    private List<Pokemon> inventory;

    public Shop(List<Pokemon> inventory) {
        this.inventory = inventory;
    }
    //displays what the shop has for sale
    public void displayInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            Pokemon p = inventory.get(i);
            System.out.println((i + 1) + ". " + p.getName() +
                    " $" + p.getPrice() +
                    " HP: " + p.getHp() +
                    " Level: " + p.getLevel() +
                    " DMG: " + p.getDamage() +
                    " Type: " + p.getType());
        }
    }
    //sorts price using merge
    public void sortPrice() {
        int n = inventory.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (inventory.get(j).getPrice() > inventory.get(j + 1).getPrice()) {
                    swap(j, j + 1);
                }
            }
        }
    }
    //creates a swap for cleaner code
    private void swap(int i, int j) {
        Pokemon temp = inventory.get(i);
        inventory.set(i, inventory.get(j));
        inventory.set(j, temp);
    }
    public Pokemon buyPokemon(int index) {
    if (index >= 0 && index < inventory.size()) {
        Pokemon bought = inventory.get(index);
        inventory.remove(index);
        return bought;
    } else {
        System.out.println("Invalid index. Please select a valid Pokémon.");
        return null;
        }
    }
    public int getInventorySize() {
    return inventory.size();
    }
    public Pokemon seePokemon(int index) {
    if (index >= 0 && index < inventory.size()) {
        return inventory.get(index);
    }
    return null;
    }
}
