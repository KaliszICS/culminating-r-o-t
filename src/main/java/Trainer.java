import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

/**
 * The trainer class represents a Pokemon trainer (player) with a name, a team of pokemon, an active Pokemon, and a game level.
 * This class can: switch the active Pokemon in play, save and load game data, and sort/search teams based on various attributes.
 * @author Olivier Tan
 * @author Radin Arjoulou
 * @author Toby Tan
 * @version 1.0.6?
 */
public class Trainer {
    private String name = "";
    private ArrayList<Pokemon> team = new ArrayList<>();
    private Pokemon activePokemon = null;
    private int gameLevel = 0;
    private int finalTeamSize = 6;
    private int currency = 100;

    /**
     * Constructors initializing the name and game level.
     * @param name
     * @param gameLevel
     */
    public Trainer(String name, int gameLevel) {
        this.name = name;
        this.gameLevel = gameLevel;
        this.team = new ArrayList<>();
    }

    /**
     * Constructor initializing the name and active Pokemon.
     * @param name
     * @param activePokemon
     */
    public Trainer(String name, Pokemon activePokemon) {
        this.name = name;
        this.gameLevel = 0;
        this.activePokemon = activePokemon;
        this.team = new ArrayList<>();
        this.team.add(activePokemon);
    }

    /**
     * Constructor initializing all values.
     * @param name
     * @param team
     * @param activePokemon
     * @param gameLevel
     */
    public Trainer(String name, ArrayList<Pokemon> team, Pokemon activePokemon, int gameLevel) {
        this.name = name;
        this.team = team;
        this.activePokemon = activePokemon;
        this.gameLevel = gameLevel;
    }

    /**
     * Constructor initializing name and team. This is for the shop's use.
     * @param name
     * @param team
     */
    public Trainer(String name, ArrayList<Pokemon> team) {
        this.name = name;
        this.gameLevel = 0;
        this.team = team;
    }

    public Trainer() {}

    /**
     * Adds a Pokemon to the team if it's not full.
     * @param p
     */
    public void addPokemon(Pokemon p) {
        if (team.size() < finalTeamSize) {
            team.add(p);
            if (activePokemon == null) {
                activePokemon = p;
            }
        } else {
            System.out.println("Team is full");
        }
    }

    /**
     * Removes a Pokemon from your team by name.
     * @param name
     * @return true if removed
     */
    public boolean removePokemon(String name) {
        for (int i = 0; i < team.size(); i++) {
            Pokemon p = team.get(i);
            if (p.getName().equalsIgnoreCase(name)) {
                team.remove(i);
                System.out.println(p.getName() + " has been removed.");
                if (p == activePokemon) {
                    if (!team.isEmpty()) {
                        activePokemon = team.get(0);
                        System.out.println(activePokemon.getName() + " is now your active Pokemon");
                    } else {
                        activePokemon = null;
                        System.out.println("You currently have no active Pokemon");
                    }
                }
                return true;
            }
        }
        System.out.println("No pokemon with that name was found on your team");
        return false;
    }


    /**
     * Switch active Pokemon by its name (direct method)
     * @param name name of the Pokemon to switch to
     */
    public void switchPokemon(String name) {
        for (Pokemon p : team) {
            if (p.getName().equalsIgnoreCase(name)) {
                activePokemon = p;
                System.out.println(p.getName() + " is now your active Pokémon.");
                return;
            }
        }
        System.out.println("No Pokémon named \"" + name + "\" found in your team.");
    }
    /**
     * Switch active Pokémon by its 1-based index in the team.
     */
    public void switchPokemon(int index) {
        if (index >= 1 && index <= team.size()) {
            activePokemon = team.get(index - 1);
            System.out.println(activePokemon.getName() + " is now your active Pokémon.");
        } else {
            System.out.println("Invalid Pokémon number: " + index);
        }
    }
        /**
     * Allow the user to switch Pokemon by entering a name or number.
     * @return the new active Pokemon
     */
    public Pokemon switchPokemon() {
        if (team.isEmpty()) {
            System.out.println("You have no Pokemon to swap to.");
            return null;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Choose a Pokemon to switch to:");
        for (int i = 0; i < team.size(); i++) {
            System.out.println((i + 1) + ". " + team.get(i).getName());
        }
        System.out.println("Enter the name or number of the Pokemon:");
        String userInput = input.nextLine().trim();
        try {
            int choice = Integer.parseInt(userInput);
            if (choice >= 1 && choice <= team.size()) {
                activePokemon = team.get(choice - 1);
                System.out.println(activePokemon.getName() + " is now your active Pokemon!");
                return activePokemon;
            } else {
                System.out.println("That Pokemon does not exist!");
            }
        } catch (NumberFormatException e) {
            for (Pokemon p : team) {
                if (p.getName().equalsIgnoreCase(userInput)) {
                    activePokemon = p;
                    System.out.println(p.getName() + " is now your active Pokemon!");
                    return p;
                }
            }
            System.out.println("That Pokemon does not exist!");
        }
        return null;
    }

    /**
     * Method to sort the team by damage
     */
    public void sortDamage() {
        team.sort((a, b) -> Double.compare(a.getDamage(), b.getDamage()));
    }

    /**
     * Method to sort the team by health
     */
    public void sortHealth() {
        team.sort((a, b) -> Double.compare(a.getHp(), b.getHp()));
    }

    /**
     * Method to sort the team by level
     */
    public void sortLevel() {
        team.sort((a, b) -> a.getLevel() - b.getLevel());
    }

    /**
     * Method to sort the team by shield
     */
    public void sortShield() {
        team.sort((a, b) -> Double.compare(a.getOriginalShield(), b.getOriginalShield()));
    }

    /**
     * Method to sort the team by name
     */
    public void sortName() {
        team.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));
    }

    /**
     * Method to search for a Pokemon by type
     */
    public void searchType(String type) {
        boolean found = false;
        for (Pokemon p : team) {
            if (p.getType().equalsIgnoreCase(type)) {
                System.out.println(p.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No Pokemon of type " + type + " found in your team.");
    }

    /**
     * Method to search for a Pokemon by name
     */
    public void searchName(String name) {
        boolean found = false;
        for (Pokemon p : team) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(p.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No Pokemon with name " + name + " found in your team.");
    }

    /**
     * Save the trainer's data to a file.
     */
    public void saveGame(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(name);
            writer.println(gameLevel);
            writer.println(team.size());
            for (Pokemon p : team) {
                writer.printf("%s,%d,%.2f,%d,%d\n", p.getClass().getSimpleName(), p.getLevel(), p.getHp(), p.getEnergy(), p.getPrice());
            }
            writer.println(activePokemon != null ? activePokemon.getName() : "null");
            System.out.println("Trainer saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving data");
        }
    }

    /**
     * Load trainer data from a file.
     */
    public static Trainer loadGame(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            Trainer t = new Trainer();
            t.name = reader.readLine();
            t.gameLevel = Integer.parseInt(reader.readLine());
            int size = Integer.parseInt(reader.readLine());
            Pokemon first = null;
            for (int i = 0; i < size; i++) {
                String[] parts = reader.readLine().split(",");
                String type = parts[0]; int lvl = Integer.parseInt(parts[1]);
                double hp = Double.parseDouble(parts[2]);
                int energy = Integer.parseInt(parts[3]);
                int price = Integer.parseInt(parts[4]);
                Pokemon p;
                switch (type) {
                    case "Pikachu": p = new Pikachu(lvl, hp, energy, price); break;
                    case "Charizard": p = new Charizard(lvl, hp, energy, price); break;
                    case "Bulbasaur": p = new Bulbasaur(lvl, hp, energy, price); break;
                    default: p = null;
                }
                if (p != null) {
                    t.addPokemon(p);
                    if (first == null) first = p;
                }
            }
            String activeName = reader.readLine();
            t.activePokemon = first;
            for (Pokemon p : t.team) {
                if (p.getName().equalsIgnoreCase(activeName)) {
                    t.activePokemon = p; break;
                }
            }
            System.out.println("Trainer loaded from " + filename);
            return t;
        } catch (IOException|NumberFormatException e) {
            System.out.println("Error loading trainer's data");
            return null;
        }
    }

    // Getters and setters
    public String getName() { 
        return name; 
    }
    public ArrayList<Pokemon> getTeam() { 
        return team;
    }
    public Pokemon getActivePokemon() {
        return activePokemon; 
    }
    public int getGameLevel() {
        return gameLevel;
    }
    public void setGameLevel(int gameLevel) { 
        this.gameLevel = gameLevel;
    }
    /**
     * Save the trainer's data to a file.
     */

     /**
     * Display the player's team in a numbered list format
     */
    public void teamToString() {
        for (int i = 0; i < team.size(); i++) {
            System.out.println((i + 1) + ". " + team.get(i).toString());
        }
    }

            /**
     * Gets the current currency of the trainer.
     * @return current coins
     */
    public int getCurrency() {
        return currency;
    }

    /**
     * Attempts to spend currency; returns true if successful.
     * @param amount cost
     * @return true if enough funds
     */
    public boolean spendCurrency(int amount) {
        if (currency >= amount) {
            currency -= amount;
            return true;
        }
        System.out.println("Not enough currency. You have: " + currency);
        return false;
    }

    /**
     * Adds currency to the trainer's balance.
     * @param amount to add
     */
    public void addCurrency(int amount) {
        currency += amount;
    }

}