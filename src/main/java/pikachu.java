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
     * Charizard's special move is Lightning stun which skips the opponent's turn and does a basic attack 
     * By skipping their turn it also resets their shield to their original shield if they used defend the previous turn
     * @param opponent Pokemon - the opponent being attacked
     */
    @Override
    public void specialMove(Pokemon opponent){
        this.attack(opponent); // does a basic attack
        opponent.setShield(opponent.getOriginalShield()); // resets the opponent's shield to their original shield
        System.out.println("Picachu used lighting stun!");
    }

    /**
     * Overrides the attack method from Pokemon class for Charizard
     * If the opponent is a water or grass type, it does double damage
     * @param opponent Pokemon - the opponent being attacked
     */
    @Override 
    public void attack(Pokemon opponent) {
        if (opponent.getType().equals("Water") || opponent.getType().equals("Grass")) {
            opponent.takeDamage((this.getDamage() / opponent.getShield()) * 2 + 5); // double damage if opponent is water type
        }
        else{
            super.attack(opponent);
        }
    }

}
