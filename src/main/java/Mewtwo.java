/**
 * class Mewtwo extends Pokemon
 * @author Radin Ajorlou
 * @version 1.0.0
 */

class Mewtwo extends Pokemon {

    public Mewtwo() {
        super("Mewtwo", 1, 100, "Psychic", 50, 0, 10, 1);
    }

    public Mewtwo(int level, double hp, int energy, int price, double damage, int shield) {
        super("Mewtwo", level, hp, "Psychic", energy, price, damage, shield);
    }

    public Mewtwo(int level, double hp, int energy) {
        super("Mewtwo", level, hp, "Psychic", energy, 0, 10, 1);
    }

    public Mewtwo(double hp, int energy, int price) {
        super("Mewtwo", hp, "Psychic", energy, price, 10);
    }

    /**
     * Special move for Mewtwo
     * Mewtwo steals the opponent's shield and takes it dor itself
     * @param opponent Pokemon - the opponent that Mewtwo is attacking
     */
    @Override 
    public void specialMove(Pokemon opponent){
        this.setShield((int)opponent.getShield()); //sets its shield to the opponent's shield
        opponent.setShield(1); //sets the opponent's shield to 1
        this.attack(opponent);
        System.out.println("Mewtwo used SCRATCH!");
    }

    /**
     * Overrides the basic attack for Mewtwo
     * Mewtow ignores the opponent's shield if its original shield is greater than 5
     * @param opponent Pokemon - the opponent that Mewtwo is attacking
     */
    @Override
    public void attack(Pokemon opponent) {
        if (opponent.getOriginalShield() > 5){
            opponent.takeDamage(this.getDamage() + 5); // Ignores the opponent's shield if its original shield is greater than 5
        }
        else{
            super.attack(opponent);
        }
        }    
}
