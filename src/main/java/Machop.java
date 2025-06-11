public class Machop extends Pokemon {

    /**
     * Machop constructor every param except level and price mandetory
     * @param level int - set to 1 by default
     * @param hp double
     * @param energy int 
     * @param price int (Will automatically set to 0 if not provided)
     */
    public Machop(int level, double hp, int energy, int price) {
        super("Machop", level, hp, "Fighting", energy, price);
    }

    //Constructor without level
    public Machop(double hp, int energy, int price) {
        super("Machop", hp, "Fighting", energy, price, 3);
    }

    //Constructor without price
    public Machop(int level, double hp, int energy) {
        super("Machop", level, hp, "Fighting", energy, 3);
    }

    //Constructor without level and price
    public Machop(double hp, int energy) {
        super("Machop", hp, "Fighting", energy, 3);
    }


    /**
     * Overrides the specialMove method from Pokemon class for Machop
     * Machop has 2 speical moves:
     * 1. Power Thrust - activates if his energy is above 100, opponents health at least 5 more than his, and hp < 30. This move sets the enemies health to 5 more than Machops making this a great move in losing fights
     * 2. Grownd Pound - does 20% more damage than normal attack
     * @param opponent Pokemon - the opponent being attacked
     */
    @Override 
    public void specialMove(Pokemon opponent) {
        if (this.getHp() < 30 && this.getEnergy() > 100 && opponent.getHp() > this.getHp() + 5) {
            this.setEnergy(this.getEnergy() - 100);
            opponent.setHp(this.getHp() + 10);
            System.out.println("Machop used power thrust");
        }
        else {
            opponent.takeDamage(this.getDamage() * 1.2);
            System.out.println("Machop used ground pound");
        }
    }

    /**
     * Overrides the attack method from Pokemon class for Machop
     * Machop does double damage to fire type Pokemon
     * @param opponent Pokemon - the opponent being attacked
     */
    public void attack(Pokemon opponent) {
        if (opponent.getType().equals("Fire")) {
            opponent.takeDamage((this.getDamage() / opponent.getShield()) * 2 + 5); // double damage if opponent is fire type
        } else {
            super.attack(opponent);
        }
    }
    
}
