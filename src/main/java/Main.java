/**
 * Main part of the Pokemon game the user interacts with
 * @author Radin Ajorlou
 * @version 1.0.0
 */
import java.util.*;

public class Main {

	public static void main(String args[]) {
		Trainer trainer = new Trainer();
		Shop shop = new Shop(
		new String[]{"Pikachu", "Charizard", "Bulbasaur"},
		new int[]{200, 450, 100},  // Prices
		new int[]{60, 250, 80},     // Health
		new int[]{5, 15, 4},        // Level
		new int[]{55, 122, 49},     // Damage
		new String[]{"Electric", "Fire", "Grass"}  // Types
		);
		Scanner scanner = new Scanner(System.in);
		String choice;

		//Asks user if they want to start a new game or load a saved one 
		do{
			System.out.println("1. New game   2. Load game");
			choice = scanner.nextLine();
			if (choice.equals("1")){
				System.out.println("Choose your trainer's name: ");
				String name = scanner.nextLine();
				System.out.println("Choose your starting Pokemon\n" +
									"1. Charizard   2. b   3. c");
				
				Charizard charizard = new Charizard(100, 0);
				trainer = new Trainer(name, charizard); //creates a new trainer with the users chosen name
			}

		}
		while (!choice.equals("1") && !choice.equals("2"));

		while (true){
			System.out.println("1. Fight   2. Go to shop   3. Save game   4. Load File");
			choice = scanner.nextLine();
			switch(choice){
				case "1":
				System.out.println("Choose Level: 1 - " + (trainer.getGameLevel() + 1) + "\nb. Go back");
				choice = scanner.nextLine();
				int levelChoice;

				try{
					levelChoice = Integer.parseInt(choice);
				}
				catch(Exception e){
					levelChoice = 0;
				}
				while (levelChoice < 1 && levelChoice > trainer.getGameLevel() + 1 && !choice.equals("b")){
					System.out.println("You can not play this level.");
					choice = scanner.nextLine();
				}

				if(choice.equals("b")){
					break; //if user enters b go back to start
				}

				System.out.println("1. Play with active Pokemon   2. Switch Pokemon   b. Go back");
				choice = scanner.nextLine();
				while (!choice.equals("1") && !choice.equals("2") && !choice.equals("b")){
					System.out.println("Not a real choice");
					choice = scanner.nextLine();
				}

				if (choice.equals("b")){
					break;
				}

				else if(choice.equals("1")){ 
					boolean wonOrLost = trainer.getActivePokemon().playLevel(levelChoice); //battles level choice with active Pokemon
					if (wonOrLost == true && levelChoice > trainer.getGameLevel()){
						trainer.setGameLevel(levelChoice);
						System.out.println(trainer.getName() + " has reached level " + trainer.getGameLevel() + " and can play level " + (trainer.getGameLevel() + 1));
					}
				}

				else{

				}
			break;

			case "2":
			System.out.println("Welcome to the shop!");
			boolean stayInShop = true;

			while (stayInShop) {
				System.out.println("What would you like to do?");
				System.out.println("1. Display Inventory");
				System.out.println("2. Sort by Price");
				System.out.println("3. Sort by Health");
				System.out.println("4. Sort by Level");
				System.out.println("5. Sort by Damage");
				System.out.println("6. Exit shop");
				String shopChoice = scanner.nextLine();

				switch(shopChoice) {
					case "1":
						shop.displayInventory();
						break;
					case "2":
						shop.sortPrice();
						System.out.println("Sorted by price.");
						shop.displayInventory();
						break;
					case "3":
						shop.sortHealth();
						System.out.println("Sorted by health.");
						shop.displayInventory();
						break;
					case "4":
						shop.sortLevel();
						System.out.println("Sorted by level.");
						shop.displayInventory();
						break;
					case "5":
						shop.sortDamage();
						System.out.println("Sorted by damage.");
						shop.displayInventory();
						break;
					case "6":
						stayInShop = false;
						break;
					default:
						System.out.println("Invalid choice.");
						break;
				}
			}
			break;
		}
	}
		
		




	}

}
