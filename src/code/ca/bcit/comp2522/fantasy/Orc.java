package ca.bcit.comp2522.fantasy;

/**
 * Creates Orc subclass from Creature.
 *
 * @author Manases Villalobos
 * @author Darrel Tapilaha.
 * @version 1.0
 */

public class Orc extends Creature {
    private int rage;

    private static final int MAX_RAGE = 30;
    private static final int TWENTY = 20;
    private static final int MIN_RAGE = 0;
    private final static int REDUCED_RAGE = 5;

    /**
     * It creates a creature object.
     *
     * @param name        represents the name of the Orc
     * @param dateOfBirth represents the date of birth of the Orc
     * @param health      represents the health of the Orc
     * @param rage        represents the rage of the Orc
     */
    public Orc(final String name,
               final Date dateOfBirth,
               final int health,
               final int rage) {
        super(name, dateOfBirth);
        super.setHealth(health);
        validateRage(rage);
        this.rage = rage;
    }

    /*
    validate rage input to be within limits
     */
    private static void validateRage(final int rage) {
        if(rage < MIN_RAGE ||
                rage > MAX_RAGE) {
            throw new IllegalArgumentException("Mana must be between "
                    + MIN_RAGE + " and " + MAX_RAGE);
        }
    }

    /**
     * Berserk method use to attack a creature.
     * @param target = target creature
     */
    public void berserk(final Creature target) {
        rage += 5;
        if(this.rage < REDUCED_RAGE) {
            throw new LowRageException("Rage is too low");
        } else {
            if(this.rage > TWENTY){
                target.takeDamage(MAX_RAGE);
                System.out.println("Berserk applied to " + target.getName() +
                                   "! Health is now " + target.getHealth() +
                                   "\n" + super.getName() + "'s rage is now " +
                                   this.rage);
            } else {
                target.takeDamage(this.rage);
            }
        }
    }

    /**
     * Gets the details (name, DOB, age, health, rage) of the Orc
     * @return a string with the information about the Orc
     */
    @Override
    public String getDetails(){
        StringBuilder str;
        str = new StringBuilder();
        str.append(super.getDetails());
        str.append("\nRage Power: " + this.rage);
        return str.toString();
    }
}
