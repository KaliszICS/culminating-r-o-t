/**
 * Class Pikachu inherits class Pokemon
 * @author Toby Tan
 * @version 1.0.0
 */

 //CHANGE VALUES AND SUPER?

class Pikachu extends Pokemon{

    /**
     * Pikachu constructor every param except level and price mandetory
     * @param level int - set to 1 by default
     * @param hp double
     * @param energy int 
     * @param price int (Will automatically set to 0 if not provided)
     */
    public Pikachu(int level, double hp, int energy, int price){
        super("Pikachu", level, hp, "lightning", energy, price);
    }

    //Constructor without level
    public Pikachu(double hp, int energy, int price){
        super ("Pikachu", hp, "lightning", energy, price, 3);
    }

    //Constructor without price
    public Pikachu(int level, double hp, int energy){
        super ("Pikachu", level, hp, "lightning", energy, 3);
    }

    //Constructor without level and price
    public Pikachu(double hp, int energy){
        super ("Pikachu", hp, "lightning", energy, 3);
    }
    
    //ADD SPECIALMOVE / CHANGE FOR PIKACHU AND BULBASAUR









    /**
     * Overrides the specialMove method from Pokemon class for Charizard
     * Charizard's special move is Fireball which removes the opponent's shield and does a basic attack
     * @param opponent Pokemon - the opponent being attacked
     */
    @Override
    public void specialMove(Pokemon opponent){
        opponent.setShield(1); //removes the opponenets shield
        this.attack(opponent); // does a basic attack
        System.out.println("Bulbsaur used Vine Whip!");
    }

    /**
     * Overrides th attack method from Pokemon class for Charizard
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
