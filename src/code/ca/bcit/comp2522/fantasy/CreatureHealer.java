package ca.bcit.comp2522.fantasy;

import java.util.Random;

public class CreatureHealer  extends Creature {

    /**
     * Constructor for the object
     * @param name represents the name of the creature
     * @param dateOfBirth represents the birthday of the
     */
    public CreatureHealer(final String name,
                          final Date dateOfBirth)
    {
        super(name, dateOfBirth);
    }

    public void healCreature(Creature target){
        // Starts a random object
        Random generator = new Random();

        // Generates a random number and store it
        // in the variable healingAmount
        int healingAmount = generator.nextInt();


        if(healingAmount < 0){
            // when the healing amount applied is a negative
            // an exception will be thrown
            throw new HealingException(
                            "healingAmount cannot be negative");
        } else{
            target.heal(healingAmount);
        }

    }
}
