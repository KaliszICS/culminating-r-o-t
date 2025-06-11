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
        super ("Charizard", hp, "Fire", energy, price, 3);
    }

    //Constructor without price
    public Charizard(int level, double hp, int energy){
        super ("Charizard", level, hp, "Fire", energy, 3);
    }

    //Constructor without level and price
    public Charizard(double hp, int energy){
        super ("Charizard", hp, "Fire", energy, 3);
    }

    /**
     * Overrides the specialMove method from Pokemon class for Charizard
     * Charizard's special move is Fireball which skips his turn but doubles his damage for the remainder of the fight
     * @param opponent Pokemon - the opponent being attacked
     */
    @Override
    public void specialMove(Pokemon opponent){
        this.setDamage(this.getDamage() * 2); // doubles the damage for the remainder of the fight
        System.out.println("Charizard used Fireball!");
    }

    /**
     * Overrides th attack method from Pokemon class for Charizard
     * If the opponent is a grass type, it does double damage
     * @param opponent Pokemon - the opponent being attacked
     */
    @Override 
    public void attack(Pokemon opponent) {
        if (opponent.getType().equals("Grass")){
            opponent.takeDamage((this.getDamage() / opponent.getShield()) * 2 + 5); // double damage if opponent is grass type
        }
        else{
            super.attack(opponent);
        }
    }

}
