/**
 * Shop sorts using merge and displays inv after sorting using displayInventory();
 * @author Toby Tan
 * @version 1.0.7
*/

import java.util.List;

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
        bubbleSort("price");
    }

    public void sortHealth() {
        bubbleSort("health");
    }

    public void sortLevel() {
        bubbleSort("level");
    }

    public void sortDamage() {
        bubbleSort("damage");
    }

    private void bubbleSort(String attribute) {
        for (int i = 0; i < inventory.size() - 1; i++) {
            for (int j = 0; j < inventory.size() - i - 1; j++) {
                Pokemon a = inventory.get(j);
                Pokemon b = inventory.get(j + 1);
                boolean shouldSwap = false;

                switch (attribute) {
                    case "price":
                        shouldSwap = a.getPrice() > b.getPrice();
                        break;
                    case "health":
                        shouldSwap = a.getHp() > b.getHp();
                        break;
                    case "level":
                        shouldSwap = a.getLevel() > b.getLevel();
                        break;
                    case "damage":
                        shouldSwap = a.getDamage() > b.getDamage();
                        break;
                }

                if (shouldSwap) {
                    inventory.set(j, b);
                    inventory.set(j + 1, a);
                }
            }
        }
    }

    public Pokemon seePokemon(int index) {
        return inventory.get(index);
    }

    public Pokemon buyPokemon(int index) {
        return inventory.remove(index);
    }

    public int getInventorySize() {
        return inventory.size();
    }
}