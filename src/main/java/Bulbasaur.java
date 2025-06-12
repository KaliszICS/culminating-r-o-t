/**
 * Class Bulbasaur inherits class Pokemon
 * @author Radin Ajorlou
 * @author Toby Tan
 * @version 1.0.0
 */



 //CHANGE VALUES
class Bulbasaur extends Pokemon{

    /**
     * Bulbasaur constructor every param except level and price mandetory
     * @param level int - set to 1 by default
     * @param hp double
     * @param energy int 
     * @param price int (Will automatically set to 0 if not provided)
     */
    public Bulbasaur(int level, double hp, int energy, int price){
        super("Bulbasaur", level, hp, "Grass", energy, price);
    }

    //Constructor without level
    public Bulbasaur(double hp, int energy, int price){
        super ("Bulbasaur", hp, "Grass", energy, price, 3);
    }

    //Constructor without price
    public Bulbasaur(int level, double hp, int energy){
        super ("Bulbasaur", level, hp, "Grass", energy, 3);
    }

    //Constructor without level and price
    public Bulbasaur(double hp, int energy){
        super ("Bulbasaur", hp, "Grass", energy, 3);
    }

    /**
     * Overrides the specialMove method from Pokemon class for Charizard
     * Bulbasaurs special attack sets its own original shield to double the opponents current for the rest of the fight and does a basic attack
     * @param opponent Pokemon - the opponent being attacked
     */
    @Override
    public void specialMove(Pokemon opponent){
        this.setOriginalShield((int)opponent.getShield() * 2); //sets its own shield to double the opponents current shield
        this.attack(opponent); // does a basic attack
        System.out.println("Bulbsaur used Vine Whip!");
    }

    /**
     * Overrides the attack method from Pokemon class for Charizard
     * If the opponent is a water type, it does double damage
     * @param opponent Pokemon - the opponent being attacked
     */
    @Override 
    public void attack(Pokemon opponent) {
        if (opponent.getType().equals("Water")){
            opponent.takeDamage((this.getDamage() / opponent.getShield()) * 2 + 5); // double damage if opponent is water type
        }
        else{
            super.attack(opponent);
        }
    }

}
