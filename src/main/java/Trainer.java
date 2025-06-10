import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Trainer {
    private String name = "";
    private ArrayList<Pokemon>team = new ArrayList<>();
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
    public void save() {
        try(FileWriter writer = new FileWriter(name + "_save.txt")){
            writer.write("Trainer: " + name + "\n");
            writer.write("Game Level: " + gameLevel + "\n");
            writer.write("Team: \n");
            for (Pokemon P: team) {
                writer.write ("- " + p.getName() + "Lv. " + p.getlevel() + "Hp: " + p.getHp());
            }
            System.out.println("Trainer saved successfully.");
        }   
        catch(IOexception e){
            System.out.println("Error saving data");
        }
    }

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
    public void setGameLevel(int gameLevel){
        this.gameLevel = gameLevel;
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

}