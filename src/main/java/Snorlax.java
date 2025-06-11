class Snorlax extends Pokemon{
    public Snorlax(double hp, int energy) {
        super("Snorlax", 1, hp, "Normal", energy, 0, 20, 2);
        this.setRequiredEnergy(60); // Setting the required energy for Snorlax's special move
    }

    /**
     * Snorlax's special move is Rest.
     * It heals itself and doubles its shield.
     * @param opponent The opponent Pokemon (not used in this move)
     */
    @Override
    void specialMove(Pokemon opponent) {
        System.out.println(this.getName() + " uses Rest!");
        this.heal(); // Snorlax heals itself
        this.setShield(this.getOriginalShield() * 2); // Doubles its shield
        System.out.println(this.getName() + " now has " + this.getShield() + " shield!");
    }

    @Override 
    public void attack(Pokemon opponent) {

        if (opponent.getType.equals("Fighting")) {
            opponent.takeDamage((this.getDamage()/1.2)); // Fighting type Pokemon take 20% less damage from Normal type attacks
            this.defend(); Snorlax //defends itself every time it attacks when fighting a Fighting type Pokemon
        } else {
            super.attack(opponent); // Normal attack if opponent is not Fighting type
        }
    }
}