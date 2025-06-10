/**
 * Shop sorts using merge and displays inv after sorting using displayInventory();
 * @author Toby Tan
 * @version 1.0.5
*/

import java.util.List;
import java.util.ArrayList;

public class Shop extends Trainer {
    private List<Pokemon> inventory;

    public Shop(List<Pokemon> inventory) {
        this.inventory = inventory;
    }

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

    private void swap(int i, int j) {
        Pokemon temp = inventory.get(i);
        inventory.set(i, inventory.get(j));
        inventory.set(j, temp);
    }
}
