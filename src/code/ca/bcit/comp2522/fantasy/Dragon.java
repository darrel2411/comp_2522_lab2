package ca.bcit.comp2522.fantasy;

/**
 * Creates Dragon subclass from Creature.
 *
 * @author Darrel.
 * @version 1.0
 */

public class Dragon extends Creature{

    private int firePower;

    private final static int MAX_POWER = 100;
    private final static int REDUCED_POWER = 10;
    private final static int DAMAGE_GIVEN = 20;
    private final static int MIN_POWER = 0;
    /**
     * It creates a creature object.
     *
     * @param name        represents the name of the creature
     * @param dateOfBirth represents the date of birth of the creature
     */
    public Dragon(final String name,
                  final Date dateOfBirth,
                  final int health,
                  final int firePower) {
        super(name, dateOfBirth);
        validateFirePower(firePower);
        this.firePower = firePower;
        super.setHealth(health);
    }

    /*
    validate the input fire power within limits.
     */
    private static void validateFirePower(final int firePower)
    {
        if(firePower < MIN_POWER ||
            firePower > MAX_POWER)
        {
            throw new DamageException("Power must be between "
                    + MIN_POWER + " and " + MAX_POWER);
        }
    }

    /**
     * Breathe fire method use to attack other creature.
     * @param target = creature to be hit
     */
    public void breatheFire(final Creature target)
            throws LowFirePowerException
    {
        if(this.firePower < REDUCED_POWER){
            throw new LowFirePowerException("Fire power is too low");
        } else {
            this.firePower -= REDUCED_POWER;
            target.takeDamage(DAMAGE_GIVEN);
            System.out.println (target.getName() + " burned" +
                                "! Health is now " + target.getHealth() +
                                "\n" + super.getName() + "'s fire power is now " +
                                 this.firePower);
        }
    }

    /**
     * Restore fire power method for the dragon.
     * @param restorePower = input restore fire power
     */
    public void restoreFirePower(final int restorePower)
    {
        final int totalPower ;
        totalPower = this.firePower + restorePower;
        if(totalPower > MAX_POWER){
            firePower = MAX_POWER;
        } else {
            this.firePower += restorePower;
        }
    }

    /**
     * Gets the details (name, DOB, age, health) of the creature
     * @return a string with the information about the creature
     */
    @Override
    public String getDetails(){
        StringBuilder str;
        str = new StringBuilder();
        str.append(super.getDetails());
        str.append("\nFire Power: " + this.firePower);
        return str.toString();
    }
}
