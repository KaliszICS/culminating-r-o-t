/**
 * Abstract class for Pokemons
 * @author Radin Ajorlou
 * @version 1.0.0
 */

import java.util.Random;
import java.util.Scanner;

abstract class Pokemon{
    private String name = "";
    private double level = 1;
    private double hp = 0;
    private String type = "";
    private int energy = 0;
    private double shield = 1;
    private int price = 0;
    private double damage = 1;
    private int originalShield = 1;
    private int requiredEnergy = 50; //Default energy required for special move
    private double originalDamage = 1;
    
    /**
     * Pokemon constructor
     * Everything must be provided except level and price
     * @param name String 
     * @param level int (Will automatically set to 1 if not provided)
     * @param hp double 
     * @param type String 
     * @param energy int 
     * @param price int (Will automatically set to 0 if not provided)
     * @param damage double 
     */
    public Pokemon(String name, int level, double hp, String type, int energy, int price, double damage, int shield){
        this.name = name;
        this.level = level;
        this.hp = hp; 
        this.type = type;
        this.energy = energy;
        this.price = price;
        this.damage = damage * level;
        this.shield = shield;
        this.originalShield = shield;
        this.originalDamage = this.damage;
    }


    //No level constructor
    public Pokemon(String name, double hp, String type, int energy, int price, double damage){
        this.name = name;
        this.hp = hp;
        this.type = type;
        this.energy = energy;
        this.price = price;
        this.damage = damage * level;
        this.originalDamage = this.damage;
    }

    //No price constructor
    public Pokemon(String name, int level, double hp, String type, int energy, double damage){
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.type = type;
        this.energy = energy;
        this.damage = damage * level;
        this.originalDamage = this.damage;
    }

    //No price and no level constructor
    public Pokemon(String name, double hp, String type, int energy, double damage){
        this.name = name;
        this.hp = hp;
        this.type = type;
        this.energy = energy;
        this.damage = damage * level;
        this.originalDamage = this.damage;
    }

    /**
     * Gets the name of the Pokemon
     * @return String - name of Pokemon
     */
    public String getName(){
        return this.name;
    }

    /**
     * Sets a new name to the Pokemon
     * @param name String - the new name of the Pokemon
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Gets the level of the Pokemon
     * @return int - the level of the Pokemon
     */
    public int getLevel(){
        return (int)this.level;
    }

    /**
     * Sets a new level to the Pokemon
     * @param level int - new level of the Pokemon
     */
    public void setLevel(double level){
        this.setDamage(this.getDamage() * level);
        this.level = level;
    }

    /**
     * Gets the health of the Pokemon
     * @return double - the health of the Pokemon
     */
    public double getHp(){
        return this.hp;
    }

    /**
     * Sets a new health to the Pokemon
     * @param newhp double - the new hp of the Pokemon
     */
    public void setHp(double hp){
        this.hp = hp;
    }

    /**
     * Gets the type of the Pokemon
     * @return String - the type of the Pokemon
     */
    public String getType(){
        return this.type;
    }

    /**
     * Sets the pokemon to a new type 
     * @param type String - the new type of the pokemon
     */
    public void setType(String type){
        this.type = type;
    }

    /**
     * Gets the energy of the Pokemon
     * @return int - energy of the Pokemon
     */
    public int getEnergy(){
        return this.energy;
    }

    /**
     * Sets a new energy to the Pokemon
     * @param energy int - the new energy of the Pokemon
     */
    public void setEnergy(int energy){
        this.energy = energy;
    }

    /**
     * Gets the price of the Pokemon
     * @return int - price of the pokemon
     */
    public int getPrice(){
        return this.price;
    }

    /**
     * Sets a new price to the Pokemon
     * @param price int - new price of the pokemon
     */
    public void setPrice(int price){
        this.price = price;
    }

    /**
     * Gets the shield of the pokemon
     * @return double - shield of the pokemon
     */
    public double getShield(){
        return this.shield;
    }

    /**
     * Sets the shield of the pokemon
     * @param shield int - the shield of the Pokemon
     */
    public void setShield(int shield){
        this.shield = shield;
    }

    /**
     * Method to get the damage of the pokemon
     * @return double - the damage of the pokemon
     */
    public double getDamage(){
        return this.damage;
    }

    /**
     * Method to set the damage of the pokemon
     * @param damage double - damage will equal (damage + level)^2
     */
    public void setDamage(double damage){
        this.damage = (damage * this.level);
    }

    /**
     * Method to get the original shield of the pokemon
     * @return int - the original shield of the pokemon
     */
    public int getOriginalShield(){
        return this.originalShield;
    }

    /**
     * Method to set the original shield of the pokemon
     * @param shield int - the original shield of the pokemon
     */
    public void setOriginalShield(int shield){
        this.originalShield = shield;
    }

    /**
     * Method to get the required energy for the special move
     * @return int - the required energy for the special move
     */
    public int getRequiredEnergy(){
        return this.requiredEnergy;
    }


    /**
     * Method to set the required energy for the special move
     * @param requiredEnergy int - the required energy for the special move
     */
    public void setRequiredEnergy(int requiredEnergy){
        this.requiredEnergy = requiredEnergy;
    }


    /**
     * Method to get the original damage of the pokemon
     * @return double - the original damage of the pokemon
     */
    public double getOriginalDamage(){
        return this.originalDamage;
    }

    /**
     * Method to set the original damage of the pokemon
     * @param originalDamage double - the original damage of the pokemon
     */
    public void setOriginalDamage(double originalDamage){
        this.originalDamage = originalDamage;
    }

    /**
     * Method to attack the opponent Pokemon
     * It damages the opponent by the damage of the pokemon/shield of opponent + 5
     * It also adds to the Pokemons energy by (level + 1)^2
     * @param opponent Pokemon - the opponent Pokemon
     */
    public void attack(Pokemon opponent){
        opponent.takeDamage((this.damage/opponent.getShield()) + 5); // damages the opponent by the damage of the pokemon/shield of opponent + 5
        this.energy += (this.level + 1) * (this.level + 1); //Adds to the pokemons energy by the (level + 1)^2
        pause(1);
        System.out.println(this.getName() + " used basic attack");;
    }

    /**
     * Method to defend the Pokemon 
     * It increased the Pokemons shield by its level * 2
     * It also adds to the Pokemons energy by (level + 1)^2
     */
    public void defend(){
        this.shield += this.originalShield * this.level * 2;   //defends by increasing the pokemons shield by its level * 2
        this.energy += (this.level + 1) * (this.level + 1); //Adds to the pokemons energy by its level * 2
        pause(1);
        System.out.println(this.getName() + " now has " + this.getShield() + " shield!");
    }

    /**
     * Method to heal the Pokemon
     * Heals the Pokemon by its (level *2) + 20
     */
    public void heal(){
        this.hp += 2 * this.level + 20; //Adds to the health of the Pokemon by its level * 2
        pause(1);
        System.out.println (name + " now has " + hp + " hp!");
    }

    //Method for special move (Each Pokemon must have at least 1)
    abstract void specialMove(Pokemon opponent);

    /**
     * Method to take damage
     * @param damage double - the amount of damage the Pokemon takes
     */
    public void takeDamage(double damage){
        this.hp -= damage;
        pause(1);
        System.out.println (name + " took " + damage + " damage! Current health: " + this.hp);
    }

    /**
     * Method to get the stats of the Pokemon 
     * Less detailed than toString only stats that are useful during the fight
     * @return String - the stats of the Pokemon
     */
    public String getStats(){
        pause(1);
        return (this.getName() + ": Hp = " + this.getHp() + ", energy = " + this.getEnergy() + ", level = " + this.getLevel() + ", damage = " + this.getDamage() + ", current shield = " + this.getShield());
    }


    /**
     *Method for moving the Pokemon 
     *@param opponent Pokemon - the opponent Pokemon
     *@param choice String - the move the user wants to make (1 - attack, 2 - defend, 3 - heal, 4 - special move)
     *@return booleam - true if the move was valid, false if it was not (move doesnt exist or not enough energy)
     */
    public boolean move(Pokemon opponent, String choice){

        switch (choice){
            case "1":
            this.attack(opponent);
            return true;
                    
            case "2":
            this.defend();
            return true;
                    
            case "3":
            if (this.getEnergy() > 30){
                this.heal();
                this.setEnergy(this.getEnergy() - 30);
                return true;
            }
            pause(1);
            System.out.println("Not enough energy to heal");
            return false;
                    
            case "4":
            if (this.getEnergy() > this.getRequiredEnergy()){
                this.setEnergy(this.getEnergy() - this.getRequiredEnergy());
                pause(1);
                this.specialMove(opponent);
                if (this.getName().equals("Pikachu")){
                    return false; //Returns false so that Pikatchu special move skips the opponent's turn
                }
                return true;
            }        
            pause(1);
            System.out.println("Not enough energy for special move");
            return false;
                    
            default:
                System.out.println("Move not valid");
                return false;
        }
                
	}

    /**
     * toString method to print the Pokemon's stats 
     * @return String - the stats of the Pokemon
     */
    @Override
    public String toString(){
        return "Name: " + this.getName() + ", Level: " + this.getLevel() + ", HP: " + this.getHp() + ", Type: " + this.getType() + ", Energy: " + this.getEnergy() + ", Price: " + this.getPrice() + ", Damage: " + this.getDamage() + ", Shield: " + this.getShield();
    }
    

    /**
     * Method for choosing the level the user wants to play (Pokemon.playLevel(level))
     * @param level int - the level the user wants to play (1 - the maximum reached level)
     */
    public boolean playLevel (int level){
        int pokemonLevel = 1;
        if (level > 7){
            pokemonLevel = (level/7) + 1;
            level -= 7; //Anything after level 7 is just the same pokemon but with higher stats 
        }
		switch (level){
			case 1:
			Charizard opponent = new Charizard(1 * pokemonLevel, 100.0 * pokemonLevel, 50);
            return this.fight(opponent);  


            case 2:
            Bulbasaur opponent2 = new Bulbasaur(2 * pokemonLevel, 150.0 * pokemonLevel, 50);
            return this.fight(opponent2);

            case 3:
            Pikachu opponent3 = new Pikachu(3 * pokemonLevel, 150.0 * pokemonLevel, 50);
            return this.fight(opponent3);

            case 4:
            Machop opponent4 = new Machop(4 * pokemonLevel, 150.0 * pokemonLevel, 100);
            return this.fight(opponent4);

            case 5:
            Ditto opponent5 = new Ditto(5 * pokemonLevel, 150.0 * pokemonLevel, 100);
            return this.fight(opponent5);

            case 6:
            Mewtwo opponent6 = new Mewtwo(6 * pokemonLevel, 200.0 * pokemonLevel, 70);
            return this.fight(opponent6);

            case 7: 
            Snorlax opponent7 = new Snorlax(7 * pokemonLevel, 200.0 * pokemonLevel, 70);
            return this.fight(opponent7);


            
            

            default:
            System.out.println("You can't play this level");
            return false;
        }


        
    }
    



    /**
     * Method for fighting the opponent (Pokemon.fight(Pokemon))
     * @param opponent Pokemon
     * @return boolean - true if user won the fight false if they lost
     */
    public boolean fight(Pokemon opponent){
        
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        int firstToGo = rand.nextInt(2);
        boolean validMove = false;

        if (firstToGo == 0){
            pause(1);
            System.out.println(this.getName() + " goes first");
        }
        else{
            pause(1);
            System.out.println(opponent.getName() + " goes first");
            validMove = true;
        }
        while (this.getHp() > 0 && opponent.getHp() > 0){ //Runs until one of the Pokemons has less than 0 hp
            while (validMove == false){
            this.setShield(this.getOriginalShield());
            pause(1);
            System.out.println("Your turn");
            pause(1);
            System.out.println("Your " + this.getStats());
            System.out.println(opponent.getStats());
            pause(1);
            System.out.println("Choose your move: 1. Attack   2. Defend   3. Heal   4. Special Move");
            String choice = scanner.nextLine();
            validMove = this.move(opponent, choice);
           } 
    
            validMove = false;
            while (validMove == false){
                opponent.setShield(opponent.getOriginalShield());
                pause(1);
                System.out.println("Opponenet's turn");
                int opponentMove = rand.nextInt(4) + 1;
                validMove = opponent.move(this, Integer.toString(opponentMove));
            }
            validMove = false;
        }

        //Resets all the stats that have been increased during the fight
        this.setDamage(this.getOriginalDamage());
        this.setShield(this.getOriginalShield());
        opponent.setDamage(opponent.getOriginalDamage());
        opponent.setShield(opponent.getOriginalShield());
    
        if (this.getHp() <= 0){
            pause(1);
            System.out.println("You Lose");
            this.setHp(100);
            this.setEnergy(0);
            return false;
        }
        else{
            this.setLevel(this.getLevel() + 1 - Math.log((int)this.getLevel()));
            pause(1);
            System.out.println("You Won\n" +
                                this.getName() + "'s new level: " + this.getLevel());
            this.setHp(100);
            this.setEnergy(0);
            return true;
        }
    }




    /**
     * Method to pause
     * To make the printing slower during fight 
     * @param seconds double - the amount of seconds you want to pause
     */
    public static void pause(double seconds){
        try {
            Thread.sleep((long) (seconds * 1000));
        }
        catch(InterruptedException e){
        }
    }
}