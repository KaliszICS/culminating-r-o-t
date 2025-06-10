/**
 * Main part of the Pokemon game the user interacts with
 * @author Radin Ajorlou
 * @author Toby Tan
 * @version 1.0.0
 */
import java.util.*;

public class Main {

	public static void main(String args[]) {
		Trainer trainer = new Trainer();
		List<Pokemon> pokemonList = new ArrayList<>();
		pokemonList.add(new Pikachu(80.0, 40, 10));     // Adjust as needed(add bulbasaur class)
		pokemonList.add(new Charizard(100.0, 50, 25));  
		pokemonList.add(new Bulbasaur(90.0, 35, 15));   // Adjust as needed (add bulbasaur class)

		Shop shop = new Shop(pokemonList);
		Scanner scanner = new Scanner(System.in);
		String choice;

		//Asks user if they want to start a new game or load a saved one 
		do{
			System.out.println("1. New game   2. Load game");
			choice = scanner.nextLine();

			//Starts a new game 
			if (choice.equals("1")){
				System.out.println("Choose your trainer's name: ");
				String name = scanner.nextLine();
				System.out.println("Here's your first Pokemon: CHARIZARD!");
				Charizard charizard = new Charizard(100.0, 0);
				trainer = new Trainer(name, charizard); //creates a new trainer with the users Charizard
				trainer.addPokemon(charizard); //adds the Charizard to the trainer's team
			}

		}
		while (!choice.equals("1") && !choice.equals("2")); // runs until user inputs 1 or 2

		while (true){
			System.out.println("1. Fight   2. Go to shop   3. Save game   4. Quit game");
			choice = scanner.nextLine();
			switch(choice){
				case "1": //The user decides to fight
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
					break; //user decided to go back 
				}

				else if(choice.equals("1")){ // user decided to play with active Pokemon
					boolean wonOrLost = trainer.getActivePokemon().playLevel(levelChoice); //battles level choice with active Pokemon
					if (wonOrLost == true && levelChoice > trainer.getGameLevel()){
						trainer.setGameLevel(levelChoice);
						System.out.println(trainer.getName() + " has reached level " + trainer.getGameLevel() + " and can play level " + (trainer.getGameLevel() + 1));
					}
				}

				else{ // user decided to switch Pokemon
					String originalChoice = "";
					System.out.println("Here are your Pokemon: ");
					trainer.teamToString();
					while (!originalChoice.equals("b")){
						System.out.println("\n1. Sort   2. Search   3. Switch   b. Go back");
						originalChoice = scanner.nextLine();
						choice = originalChoice;
						while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("b")){
							System.out.println("Not a real choice");
							choice = scanner.nextLine();
						}
						switch (choice){
	
							case "1": // User decided to sort their team
							System.out.println("Sort by: 1. Name   2. Level   3. Damage   4. Health   5. Shield   b. Go back");
							choice = scanner.nextLine();
							while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5") && !choice.equals("b")){
								System.out.println("Not a real choice");
								choice = scanner.nextLine();
							}
							switch (choice){
								case "1": //User decided to sort by name
									trainer.sortName();
									trainer.teamToString();
									break;

								case "2": //User decided to sort by level
									trainer.sortLevel();
									trainer.teamToString();
									break;

								case "3": //User decided to sort by damage
									trainer.sortDamage();
									trainer.teamToString();
									break;

								case "4": //User decided to sort by health
									trainer.sortHealth();
									trainer.teamToString();
									break;

								case "5": //User decided to sort by shield
									trainer.sortShield();
									trainer.teamToString();
									break;

								case "b": //User decided to go back
									break;
							}
							break;


							case "2": // User decided to search for a Pokemon
							System.out.println("Search by: 1. Name   2. Type   b. Go back");
							choice = scanner.nextLine();
							while (!choice.equals("1") && !choice.equals("2") && !choice.equals("b")){
								System.out.println("Not a real choice");
								choice = scanner.nextLine();
							}

							if (choice.equals("b")){
								break; //User decided to go back
							}

							else if (choice.equals("1")){ //User decided to search by name
								System.out.println("Enter the name of the Pokemon you want to search for: ");
								String name = scanner.nextLine();
								trainer.searchName(name);
							}

							else{ //User decided to search by type
								System.out.println("Enter the type of the Pokemon you want to search for: ");
								String type = scanner.nextLine();
								trainer.searchType(type);
							}
							break;


							case "3": // User decided to switch Pokemon
							System.out.println("Enter the name of the Pokemon or the placement of the Pokemon in your team that you want to switch to: ");
							String pokemonName = scanner.nextLine();
							try{
								int pokemonNum = Integer.parseInt(pokemonName);
								//trainer.switchPokemon(pokemonNum);
							}
							catch (Exception e){
								trainer.switchPokemon(pokemonName);
							}

	
						}
					}
				}
			break;

			case "2":
			System.out.println("Welcome to the shop!");
			boolean stayInShop = true;

			while (stayInShop) {
				//Displays shop choices
				System.out.println("What would you like to do?");
				System.out.println("1. Display Inventory");
				System.out.println("2. Sort by Price");
				System.out.println("3. Sort by Health");
				System.out.println("4. Sort by Level");
				System.out.println("5. Sort by Damage");
				System.out.println("6. Purchase Pokemon");
				System.out.println("7. Exit shop");
				String shopChoice = scanner.nextLine();
				//Enables shop
				switch(shopChoice) {
					case "1":
					boolean viewingInventory = true;
						while (viewingInventory) {
							System.out.println("\n--- Shop Inventory ---");
							shop.displayInventory();
							System.out.println("Enter 'b' to go back to the shop menu and select purchase to buy a pokemon.");
							String backChoice = scanner.nextLine();
							if (backChoice.equalsIgnoreCase("b")) {
								viewingInventory = false;
							} else {
								System.out.println("Invalid input. Type 'b' to go back.");
							}
						}
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
					shop.displayInventory();
					System.out.println("Your balance: $" + trainer.getCurrency());
					System.out.println("Enter the number of the Pokémon you want to buy (1 to " + shop.getInventorySize() + "):");
					try {
						int index = Integer.parseInt(scanner.nextLine()) - 1;
						if (index >= 0 && index < shop.getInventorySize()) {
							Pokemon selected = shop.seePokemon(index); // new method to just view without removing
							int cost = selected.getPrice();

							if (trainer.spendCurrency(cost)) {
								Pokemon purchased = shop.buyPokemon(index); // now safe to remove
								trainer.addPokemon(purchased);
								System.out.println("You bought " + purchased.getName() + " for $" + cost + "!");
								System.out.println("Remaining balance: $" + trainer.getCurrency());
							} else {
								System.out.println("Not enough money! " + selected.getName() + " costs $" + cost + " but you only have $" + trainer.getCurrency());
							}
						} else {
							System.out.println("Invalid selection.");
						}
					} catch (Exception e) {
						System.out.println("Invalid input. Purchase cancelled.");
					}
					break;
					case "7":
						stayInShop = false;
						break;
					default:
						System.out.println("Invalid choice.");
						break;
					}
				}
				break;//out of shop
			}
		}
	}
}
