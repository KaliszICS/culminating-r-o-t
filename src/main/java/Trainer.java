import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

/**
 * The trainer class represents a Pokemon trainer (player) with a name, a team of pokemon, an active Pokemon, and a game level.
 * This class can: switch the active Pokemon in play, save and load game data, sort/search teams based on various attributes, 
 * add/remove Pokemon, and handle in game currency.
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
     * @param name - name of the trainer
     * @param gameLevel - level that the trainer is at
     */
    public Trainer(String name, int gameLevel) {
        this.name = name;
        this.gameLevel = gameLevel;
        this.team = new ArrayList<>();
    }

  

    /**
     * Constructor initializing the name and active Pokemon.
     * @param name - name of the Pokemon.
     * @param activePokemon - the Pokemon that is currently active and will be next in play.
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
     * @param name - name of the trainer.
     * @param team - team of Pokemon that the trainer has.
     * @param activePokemon - the current Pokemon that is active.
     * @param gameLevel - the trainer's current game level.
     */
    public Trainer(String name, ArrayList<Pokemon> team, Pokemon activePokemon, int gameLevel) {
        this.name = name;
        this.team = team;
        this.activePokemon = activePokemon;
        this.gameLevel = gameLevel;
    }

  

    /**
     * Constructor initializing name and team. This is for the shop's use.
     * @param name - string: The trainer's name. 
     * @param team - arraylist: the list of Pokemon.
     */
    public Trainer(String name, ArrayList<Pokemon> team) {
        this.name = name;
        this.gameLevel = 0;
        this.team = team;
    }


  
    /**
     * 
     * @param name - string: name of the trainer.
     */
    public Trainer(String name) {
        this.name = name;
        this.gameLevel = 0;
        this.team = new ArrayList<>();
    }


 
    public Trainer() {}

    /**
     * Adds a Pokemon to the team if it's not full.
     * @param p - Pokemon: the Pokemon that is trying to be added to the team.
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
     * @param name - string: name of Pokemon that is getting removed.
     * @return True if the Pokemon is found and removed.
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
     * @param name - string: name of the Pokemon that is getting switched into the active position. 
     */
    public void switchPokemon(String name) {
        for (Pokemon p : team) {
            if (p.getName().equalsIgnoreCase(name)) {
                activePokemon = p;
                System.out.println(p.getName() + " is now your active Pokemon.");
                return;
            }
        }
        System.out.println("No Pokemon named \"" + name + "\" found in your team.");
    }
    

    
    /**
     * Switch active Pokemon by its index in the team.
     */
    public void switchPokemon(int index) {
    if (index >= 1 && index <= team.size()) {
        activePokemon = team.get(index - 1);
        System.out.println(activePokemon.getName() + " is now your active Pokemon.");
    } else {
        System.out.println("Invalid Pokemon number: " + index);
        }
    }
  
    
   
    /**
     * Allow the user to switch Pokemon by entering a name or index.
     * @return the new active Pokemon.
     */
public Pokemon switchPokemon() {
    if (team.size() == 0) {
        System.out.println("You have no Pokemon to switch to.");
        return null;
    }

    Scanner input = new Scanner(System.in);
    System.out.println("Choose a Pokemon to switch to:"); //Ask the player to choose a new active Pokemon.
    for (int i = 0; i < team.size(); i++) {
        System.out.println((i + 1) + ". " + team.get(i).getName()); //Display which Pokemon the player can switch to.
    }

    System.out.print("Enter name or number: "); //Let the player give a name or number that corresponds to the Pokemon in the list.
    String userInput = input.nextLine().trim();

    try {
        int choice = Integer.parseInt(userInput);
        if (choice >= 1 && choice <= team.size()) {
            activePokemon = team.get(choice - 1);
            System.out.println(activePokemon.getName() + " is now your active Pokemon."); //Switch active Pokemon by index value.
            return activePokemon;
        }
    } catch (NumberFormatException e) {
        for (Pokemon p : team) {
            if (p.getName().equalsIgnoreCase(userInput)) {
                activePokemon = p;
                System.out.println(activePokemon.getName() + " is now your active Pokemon."); //Switch active Pokemon by name.
                return activePokemon;
            }
        }
    }

    System.out.println("Invalid selection."); //If a name or index that does not exist is give, let them know.
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
     * Method to search for a Pokemon by name.
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
     * Load trainer data from a file. Allows player to continue from where they left off.
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
     * @param amount - int: cost
     * @return true if enough funds
     */
    public boolean spendCurrency(int amount) {
        if (this.getCurrency() >= amount) {
            this.currency -= amount;
            return true;
        }
        System.out.println("Not enough currency. You have: " + currency);
        return false;
    }

    
    
    /**
     * Adds currency to the trainer's balance.
     * @param amount - int: to add
     */
    public void addCurrency(int amount) {
        this.currency += amount;
    }



}