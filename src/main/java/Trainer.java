import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Trainer {
    private String name = "";
    public ArrayList<Pokemon>team = new ArrayList<>();
    private Pokemon activePokemon = null;
    private int gameLevel = 0;


    public Trainer (String name, int gameLevel){
        this.name = name;
        this.gameLevel = gameLevel;
        this.team = new ArrayList<>();
    }

    public Trainer (String name, Pokemon activePokemon ){
        this.name = name;
        this.gameLevel = 0;
        this.activePokemon = activePokemon;
        this.team = new ArrayList<>();
        this.team.add(activePokemon);
    }

    public Trainer (String name, ArrayList<Pokemon> team, Pokemon activePokemon, int gameLevel){
        this.name = name;
        this.team = team;
        this.activePokemon = activePokemon;
        this.gameLevel = gameLevel;
    }

    // Will be used to create shop 
    public Trainer (String name, ArrayList<Pokemon> team){
        this.name = name;
        this.gameLevel = 0;
        this.team = team;
    }


    public Trainer(){};

    public void addPokemon (Pokemon p){
        if (team.size()<6){
            team.add(p);
            if (activePokemon == null){
                activePokemon = p;
            }
        }
        else {
            System.out.println("Team is full");
        }

            
    }

    //switch active pokemon out for another.
    public Pokemon switchPokemon (String name){
        for (Pokemon p: team){
            if(p.getName().equalsIgnoreCase(name)){
                activePokemon = p;
                System.out.println(p.getName() + "is now your active pokemon." + p.getName() + "is now ready to battle!");
                return null;
            }
        }
    }

    //save data to a file
    //Getters
    public String getName(){
        return name;
    }

    public ArrayList<Pokemon> getTeam(){
        return team;
    }

    public Pokemon getActivePokemon(){
        return activePokemon;
    }

    public int getGameLevel(){
        return gameLevel;
    }


    public void teamToString(){
        int length = this.getTeam().size();
		for (int i = 0; i < length; i++){
			System.out.println((i + 1) + ". " + this.getTeam().get(i).toString());
        }
    }


    /**
     * Method to set the maximum reached level of the trainer
     * @param gameLevel - int the new maximum reached level of the trainer
     */
    public void setGameLevel(int level) {
    this.gameLevel = level;
    }

    /**
     * Method to sort the team by damage
     */
    public void sortDamage(){
        ArrayList<Pokemon> pokemons = this.getTeam();
        int length = pokemons.size();
        for (int i = 0; i < length; i++){
            for (int j = i + 1; j < length; j++){
                if (pokemons.get(i).getDamage() < pokemons.get(j).getDamage()){
                    Pokemon temp = pokemons.get(i);
                    pokemons.set(i, pokemons.get(j));
                    pokemons.set(j, temp);
                }
            }
        }
    }

    /**
     * Method to sort the team by health
     */
    public void sortHealth(){
        ArrayList<Pokemon> pokemons = this.getTeam();
        int length = pokemons.size();
        for (int i = 0; i < length; i++){
            for (int j = i + 1; j < length; j++){
                if (pokemons.get(i).getHp() < pokemons.get(j).getHp()){
                    Pokemon temp = pokemons.get(i);
                    pokemons.set(i, pokemons.get(j));
                    pokemons.set(j, temp);
                }
            }
        }
    }

    /**
     * Method to sort the team by level
     */
    public void sortLevel(){
        ArrayList<Pokemon> pokemons = this.getTeam();
        int length = pokemons.size();
        for (int i = 0; i < length; i++){
            for (int j = i + 1; j < length; j++){
                if (pokemons.get(i).getLevel() < pokemons.get(j).getLevel()){
                    Pokemon temp = pokemons.get(i);
                    pokemons.set(i, pokemons.get(j));
                    pokemons.set(j, temp);
                }
            }
        }
    }

    /**
     * Method to sort the team by shield
     */
    public void sortShield(){
        ArrayList<Pokemon> pokemons = this.getTeam();
        int length = pokemons.size();
        for (int i = 0; i < length; i++){
            for (int j = i + 1; j < length; j++){
                if (pokemons.get(i).getOriginalShield() < pokemons.get(j).getOriginalShield()){
                    Pokemon temp = pokemons.get(i);
                    pokemons.set(i, pokemons.get(j));
                    pokemons.set(j, temp);
                }
            }
        }
    }

    
    /**
     * Method to sort the team by name
     */
    public void sortName(){
        ArrayList<Pokemon> pokemons = this.getTeam();
        int length = pokemons.size();
        for (int i = 0; i < length; i++){
            for (int j = i + 1; j < length; j++){
                if (pokemons.get(i).getName().compareTo(pokemons.get(j).getName()) > 0){
                    Pokemon temp = pokemons.get(i);
                    pokemons.set(i, pokemons.get(j));
                    pokemons.set(j, temp);
                }
            }
        }
    }

    /**
     * Method to search for a Pokemon by type
     * This will print all Pokemon of the specified type in the team or a message saying none are found.
     * @param type String - the type of Pokemon to search for
     */
    public void searchType(String type){
        ArrayList<Pokemon> pokemons = this.getTeam();
        boolean found = false;
        for (Pokemon p : pokemons) {
            if (p.getType().equalsIgnoreCase(type)) {
                System.out.println(p.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Pokemon of type " + type + " found in your team.");
        }
    }


    public void searchName(String name){
        ArrayList<Pokemon> pokemons = this.getTeam();
        boolean found = false;
        for (Pokemon p : pokemons) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(p.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Pokemon with name " + name + " found in your team.");
        }
    }

    //CURRENCY FOR SHOP AND REWARDS
    private int currency = 100;

    public int getCurrency() {
    return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public void addCurrency(int amount) {
        currency += amount;
    }

    public boolean spendCurrency(int amount) {
        if (currency >= amount) {
            currency -= amount;
            return true;
        } else {
            return false;
        }
    }

    







    public void setActivePokemon(Pokemon p) {
        this.activePokemon = p;
    }   



    //ADD AFTER OLIVIER'S CODE:
    public void setName(String name) {
        this.name = name;
    }


    public void saveGame(String filename) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filename));
            writer.println(name);
            writer.println(currency);
            writer.println(gameLevel);
            writer.println(team.size());

            for (Pokemon p : team) {
                writer.println(p.getClass().getSimpleName() + "," + p.getLevel() + "," + p.getHp() + "," + p.getEnergy() + "," + p.getPrice());
            }

            if (activePokemon != null) {
                writer.println(activePokemon.getName()); // Save active Pokémon by name
            } else {
                writer.println("null");
            }

            writer.close();
            System.out.println("Game saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }

    public static Trainer loadGame(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String name = reader.readLine();
            int currency = Integer.parseInt(reader.readLine());
            int gameLevel = Integer.parseInt(reader.readLine());
            int teamSize = Integer.parseInt(reader.readLine());

            Trainer trainer = new Trainer();
            trainer.setName(name);
            trainer.setCurrency(currency);
            trainer.setGameLevel(gameLevel);

            List<Pokemon> team = new ArrayList<>();
            Pokemon first = null;

            for (int i = 0; i < teamSize; i++) {
                String[] parts = reader.readLine().split(",");
                String type = parts[0];
                int level = Integer.parseInt(parts[1]);
                double hp = Double.parseDouble(parts[2]);
                int energy = Integer.parseInt(parts[3]);
                int price = Integer.parseInt(parts[4]);

                Pokemon p = null;
                switch (type) {
                    case "Pikachu":
                        p = new Pikachu(level, hp, energy, price);
                        break;
                    case "Charizard":
                        p = new Charizard(level, hp, energy, price);
                        break;
                    case "Bulbasaur":
                        p = new Bulbasaur(level, hp, energy, price);
                        break;
                    default:
                        System.out.println("Unknown Pokémon type: " + type);
                }

                if (p != null) {
                    trainer.addPokemon(p);
                    if (first == null) {
                        first = p; // Save first as fallback for active
                    }
                }
            }

            String activeName = reader.readLine();
            reader.close();

            for (Pokemon p : trainer.team) {
                if (p.getName().equalsIgnoreCase(activeName)) {
                    trainer.setActivePokemon(p);
                    break;
                }
            }

            // fallback in case saved active was null or didn't match
            if (trainer.getActivePokemon() == null && first != null) {
                trainer.setActivePokemon(first);
            }

            System.out.println("Game loaded from " + filename);
            return trainer;

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading game: " + e.getMessage());
            return null;
        }
    }
}