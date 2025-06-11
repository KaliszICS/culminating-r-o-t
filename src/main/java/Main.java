/**
 * Main Class
 * @author Radin Ajorlou
 * @author Toby Tan
 * @version 1.0.3
 */


 //WORK ON CHANGE PRICES, WHITE SPACE, JAVADOCS, other stuff too TBD

import java.util.*;


public class Main {

    public static void main(String args[]) {
        Trainer trainer = new Trainer();
        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(new Pikachu(85.0, 0, 10));
        pokemonList.add(new Machop(100.0, 0, 25));
        pokemonList.add(new Bulbasaur(62.0, 0, 18));
        pokemonList.add(new Ditto(1, 100.0, 25, 99));
        pokemonList.add(new Mewtwo(1, 1000, 0, 25, 0, 1));
        pokemonList.add(new Snorlax(1, 100.0 ,0, 25));



        Shop shop = new Shop(pokemonList);
        Scanner scanner = new Scanner(System.in);
        String choice;

        //Start menu
        do {
            System.out.println("1. New game   2. Load game");
            choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Choose your trainer's name: ");//Chooses name
                String name = scanner.nextLine();
                System.out.println("Here's your first Pokemon: CHARIZARD!");//gives user first pokemon
                Charizard charizard = new Charizard(100.0, 0);
                trainer = new Trainer(name, charizard);
            } else if (choice.equals("2")) {
                System.out.println("Enter load slot (1–3):");//Save slot
                String slot = scanner.nextLine();
                String filename = "save" + slot + ".txt";
                Trainer loaded = Trainer.loadGame(filename);
                if (loaded != null) {
                    trainer = loaded;
                    System.out.println("Game loaded successfully!");
                } else {
                    System.out.println("Failed to load game.");
                }
            }
        } while (!choice.equals("1") && !choice.equals("2"));

        // Main game loop
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Fight   2. Go to shop   3. Save game   4. Load game   5. Quit game");
            choice = scanner.nextLine();

            switch (choice) {
                case "1": //User decided to fight
                    System.out.println("Choose Level: 1 - " + (trainer.getGameLevel() + 1) + "\nb. Go back");
                    choice = scanner.nextLine();
                    if (choice.equals("b")) break;

                    int levelChoice;
                    try {
                        levelChoice = Integer.parseInt(choice);
                    } catch (Exception e) {
                        levelChoice = 0;
                    }

                    if (levelChoice < 1 || levelChoice > trainer.getGameLevel() + 1) {
                        System.out.println("You cannot play this level.");
                        break;
                    }

                    System.out.println("1. Play with active Pokemon   2. Switch Pokemon   b. Go back"); //2nd menu
                    choice = scanner.nextLine();
                    if (choice.equals("b")) break;

                    if (choice.equals("1")) {
                        boolean won = trainer.getActivePokemon().playLevel(levelChoice);
                        if (won && levelChoice > trainer.getGameLevel()) {
                            trainer.setGameLevel(levelChoice);
                            trainer.addCurrency(50);
                            System.out.println("You earned $50.");
                            System.out.println(trainer.getName() + " reached level " + trainer.getGameLevel() + "!");
                        }
                        else if(won){
                            trainer.addCurrency(25);
                            System.out.println("You earned $25.");
                        }
                    } else if (choice.equals("2")) {
                        System.out.println("Here are your Pokemon:");
                        trainer.teamToString();
                        boolean switching = true;
                        while (switching) {
                            System.out.println("\n1. Sort   2. Search   3. Switch   b. Go back");
                            String subChoice = scanner.nextLine();
                            switch (subChoice) {
                                case "1":
                                    System.out.println("Sort by: 1. Name   2. Level   3. Damage   4. Health   5. Shield   b. Back");
                                    String sortChoice = scanner.nextLine();
                                    switch (sortChoice) {
                                        case "1": trainer.sortName(); break;
                                        case "2": trainer.sortLevel(); break;
                                        case "3": trainer.sortDamage(); break;
                                        case "4": trainer.sortHealth(); break;
                                        case "5": trainer.sortShield(); break;
                                    }
                                    trainer.teamToString();
                                    break;
                                case "2":
                                    System.out.println("Search by: 1. Name   2. Type   b. Back");
                                    String searchChoice = scanner.nextLine();
                                    if (searchChoice.equals("1")) {
                                        System.out.print("Name: ");
                                        trainer.searchName(scanner.nextLine());
                                    } else if (searchChoice.equals("2")) {
                                        System.out.print("Type: ");
                                        trainer.searchType(scanner.nextLine());
                                    }
                                    break;
                                case "3":
                                    trainer.switchPokemon();
									break;
                                case "b":
                                    switching = false;
                                    break;
                            }
                        }
                    }
                    break;

                case "2":
                    boolean inShop = true;
                    while (inShop) {
                        System.out.println("\n1. Display Inventory");
                        System.out.println("2. Sort by Price");
                        System.out.println("3. Sort by Health");
                        System.out.println("4. Sort by Level");
                        System.out.println("5. Sort by Damage");
                        System.out.println("6. Purchase Pokemon");
                        System.out.println("7. Exit shop");
                        System.out.println("\n");

                        String shopChoice = scanner.nextLine();
                        switch (shopChoice) {
                        	case "1": shop.displayInventory(); 
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
                                System.out.println("Enter number of Pokemon to buy:");
                                try {
                                    int idx = Integer.parseInt(scanner.nextLine()) - 1;
                                    if (idx >= 0 && idx < shop.getInventorySize()) {
                                        Pokemon selected = shop.seePokemon(idx);
                                        int cost = selected.getPrice();
                                        if (trainer.spendCurrency(cost)) {
                                            trainer.addPokemon(shop.buyPokemon(idx));
                                            System.out.println("You bought " + selected.getName() + "!");
                                        } else {
                                            System.out.println("Not enough money.");
                                        }
                                    } else {
                                        System.out.println("Invalid selection.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Invalid input.");
                                }
                                break;
                            case "7": inShop = false; break;
                        }
                    }
                    break;

                case "3":
                    System.out.println("Enter save slot (1–3):");
                    String saveSlot = scanner.nextLine();
                    trainer.saveGame("save" + saveSlot + ".txt");
                    System.out.println("Game saved to save" + saveSlot + ".txt");
                    break;

                case "4":
                    System.out.println("Enter load slot (1–3):");
                    String loadSlot = scanner.nextLine();
                    Trainer loadedTrainer = Trainer.loadGame("save" + loadSlot + ".txt");
                    if (loadedTrainer != null) {
                        trainer = loadedTrainer;
                        System.out.println("Game loaded from save" + loadSlot + ".txt");
                    } else {
                        System.out.println("Failed to load save.");
                    }
                    break;

                case "5":
                    System.out.println("Thanks for playing!");//QUIT GAME
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
