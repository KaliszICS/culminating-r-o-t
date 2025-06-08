/**
 * Abstract class for Pokemons
 * @author Radin Ajorlou
 * @version 1.0.0
 */

abstract class Pokemon{
    private String name = "";
    private double level = 1;
    private double hp = 0;
    private String type = "";
    private int energy = 0;
    private double shield = 1;
    private int price = 0;

    public final int MAX_LEVEL = 10;
    
    /**
     * Pokemon constructor
     * Everything must be provided except level and price
     * @param name String 
     * @param level int (Will automatically set to 1 if not provided)
     * @param hp double 
     * @param type String 
     * @param energy int 
     * @param price int (Will automatically set to 0 if not provided)
     */
    public Pokemon(String name, int level, double hp, String type, int energy, int price){
        this.name = name;
        this.level = level;
        this.hp = hp; 
        this.type = type;
        this.energy = energy;
        this.price = price;
    }


    //No level constructor
    public Pokemon(String name, double hp, String type, int energy, int price){
        this.name = name;
        this.hp = hp;
        this.type = type;
        this.energy = energy;
        this.price = price;
    }

    //No price constructor
    public Pokemon(String name, int level, double hp, String type, int energy){
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.type = type;
        this.energy = energy;
    }

    //No price and no level constructor
    public Pokemon(String name, double hp, String type, int energy){
        this.name = name;
        this.hp = hp;
        this.type = type;
        this.energy = energy;
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
        this.level = level;
    }

    /**
     * Gets the health of the Pokemon
     * @return double - the health of the Pokemon
     */
    public double getHp(){
        return this.level;
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


    //Method to attack the oppponent
    public void attack(Pokemon opponent){
        opponent.takeDamage((this.level * this.level/opponent.getShield()) + 5); // damages the opponent by the level of the pokemon^2/shield of opponent + 5
        this.energy += (this.level + 1) * (this.level + 1); //Adds to the pokemons energy by the (level + 1)^2
        opponent.setShield(opponent.getLevel()); //resets the shield of the opponent to their level
    }

    //Method to defend
    public String defend(Pokemon opponent){
        this.shield += this.level * 2;   //defends by increasing the pokemons shield by its level * 2
        return (name + " gained " + shield + " shield!");
    }

    //Method to heal
    public String heal(){
        this.hp += this.level * 2; //Adds to the health of the Pokemon by its level * 2
        return (name + " now has " + hp + " hp!");
    }

    //Method for special move (Each Pokemon must have at least 1)
    abstract String specialMove(Pokemon opponent);

    //Method for taking damage
    public String takeDamage(double damage){
        this.hp -= damage;
        return (name + " took " + damage + " damage! Current health: " + this.hp);
    }
}