public class Ditto extends Pokemon
{
        /**
     * ditto constructor every param except level and price mandetory
     * @param level int - set to 1 by default
     * @param hp double
     * @param energy int 
     * @param price int (Will automatically set to 0 if not provided)
     */
    public Ditto(int level, double hp, int energy, int price) {
        super("Dito", 1, 100.0, "Water", 50, 25, 10, 1);
    }
    public Ditto(int level, double hp, String type, int energy, int price, double damage, int shield) {
        super("Dito", 1, 100, "Water", 50, 25, 10, 1);
    }
    
    public Ditto() {
        super("Dito", 1, 100, "Water", 0, 0, 10, 1);
    }

    public Ditto (int level, double hp, int energy, int price, double damage, int shield) {
        super("Deto", level, hp, "Water", energy, price, damage, shield);
    }

    public Ditto (int level, double hp, int energy) {
        super("Dito", level, hp, "Water", energy, 0, 10, 1);
    }


    /**
     * Ditto's special move is COPYCAT.
     * It copies the opponent's damage * 1.2, hp * 1.2, and shield * 2.
     * If used more than once it will not have any effects.
     * @param opponent The opponent Pokemon whose stats will be copied.
     */
    @Override
    public void specialMove(Pokemon opponent) {
        System.out.println(this.getName() + " uses COPYCAT!");
        this.setDamage(opponent.getDamage() * 1.2);
        this.setHp(opponent.getHp()*1.2);
        this.setShield((int)opponent.getShield() * 2);

    }
    
}
