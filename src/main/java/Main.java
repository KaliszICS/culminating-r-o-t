import java.util.*;

public class Main {

	public static void main(String args[]) {
		//Test values for shop sort functions
		String[] names = {"Toby", "Radin", "Olivier", "Hernandez"};
		int[] prices = {300, 250, 200, 225};
		int[] damage = {30, 31, 30, 500};
		int[] health = {42, 30, 31, 999};

		Shop shop = new Shop(names, prices);

		Shop shopStats = new Shop(damage, health);
		//before sort
		shop.displayInventory();
		//Sort price
		shop.sortPrice();
		//Shows shop
		shop.displayInventory();
	}
}
