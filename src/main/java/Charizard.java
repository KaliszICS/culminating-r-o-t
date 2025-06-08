/**
 * Class Charizard inherits class Pokemon
 * @author Radin Ajorlou
 * @version 1.0.0
 */

class Charizard extends Pokemon{

    /**
     * Charizard constructor every param except level and price mandetory
     * @param level int - set to 1 by default
     * @param hp double
     * @param energy int 
     * @param price int (Will automatically set to 0 if not provided)
     */
    public Charizard(int level, double hp, int energy, int price){
        super("Charizard", level, hp, "Fire", energy, price);
    }

    //Constructor without level
    public Charizard(double hp, int energy, int price){
        super ("Charizard", hp, "Fire", energy, price);
    }

    //Constructor without price
    public Charizard(int level, double hp, int energy){
        super ("Charizard", level, hp, "Fire", energy);
    }

    //Constructor without level and price
    public Charizard(double hp, int energy){
        super ("Charizard", hp, "Fire", energy);
    }

    @Override
    public String specialMove(Pokemon opponent){
        opponent.setShield(1); //removes the opponenets shield
        this.attack(opponent); // does a basic attack
        return ("Charizard used Fireball!");
    }

}
