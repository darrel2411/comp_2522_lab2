package ca.bcit.comp2522.fantasy;
/**
 * A creature that can heal other creatures.
 *
 * @author Manases
 * @author Darrel Tapilaha
 * @version 1.0
 */

import java.util.Random;

public class CreatureHealer  extends Creature {

    private static final int ZERO = 0;
    private static final int MAX_HEALTH = 100;

    /**
     * Constructor for the object
     * @param name represents the name of the creature
     * @param dateOfBirth represents the birthday of the
     */
    public CreatureHealer(final String name,
                          final Date dateOfBirth,
                          final int health)
    {
        super(name, dateOfBirth);
        super.setHealth(health);
    }

    /**
     * Heals a target creature.
     *
     * @param target the creature to be healed
     */
    public void healCreature(Creature target){
        // Starts a random object
        Random generator = new Random();

        // Generates a random number and store it
        // in the variable healingAmount
        int healingAmount = generator.nextInt(MAX_HEALTH);


        System.out.println("Attempting to heal " + target.getName());
        System.out.println("Healing amount applied will be " + healingAmount);

        if(healingAmount < ZERO){
            // when the healing amount applied is a negative
            // an exception will be thrown
            throw new HealingException(
                            "healingAmount cannot be negative!" +
                            "\nHealingAmount is " + healingAmount);
        } else{
            target.heal(healingAmount);
            System.out.println(target.getName() + " healed!" + "\n" +
                                target.getName() + "'s heath is now " +
                                target.getHealth());
        }

    }
}
