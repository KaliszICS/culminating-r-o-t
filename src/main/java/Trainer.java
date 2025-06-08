import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Trainer {
    private String name;
    private ArrayList<Pokemon>team;
    private Pokemon activePokemon;
    private int gameLevel;


public Trainer (String name, int gameLevel){
    this.name = name;
    this.gameLevel = gameLevel;
    this.team = new ArrayList<>();
}

public Trainer (String name){
    this.name = name;
    this.gameLevel = 0;
}


public void addPokemon (Pokemon p){
    if (team.size()<6){
        team.add(p);
        if (activePokemon == null){
            activePokemon = p;
        }
        else {
            System.out.println("Team is full");
        }

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

}