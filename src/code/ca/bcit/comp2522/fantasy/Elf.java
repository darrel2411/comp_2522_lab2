package ca.bcit.comp2522.fantasy;

/**
 * Creates Elf subclass from Creature.
 *
 * @author Darrel Tapilaha.
 * @version 1.0
 */

public class Elf extends Creature {
    private int mana;

    private static final int MAX_MANA = 50;
    private static final int MIN_MANA = 0;
    private final static int REDUCED_MANA = 5;
    private final static int DAMAGE_GIVEN = 10;

    /**
     * It creates a creature object.
     *
     * @param name        represents the name of the elf
     * @param dateOfBirth represents the date of birth of the elf
     * @param health      represents the health of the elf
     * @param mana        represents the mana of the elf
     */
    public Elf(final String name,
               final Date dateOfBirth,
               final int health,
               final int mana) {
        super(name, dateOfBirth);
        super.setHealth(health);

        validateMana(mana);
        this.mana = mana;
    }

    /*
     validate the input mana within limits
     */
    private static void validateMana(final int mana) {
        if(mana < MIN_MANA ||
           mana > MAX_MANA) {
            throw new IllegalArgumentException("Mana must be between "
                    + MIN_MANA + " and " + MAX_MANA);
        }
    }

    /**
     * Cast spell method use to give damage to target.
     * @param target = the target to be hit
     */
    public void castSpell(final Creature target) {
        if(this.mana < REDUCED_MANA){
            throw new LowManaException("Mana is too low");
        } else {
            this.mana -= REDUCED_MANA;

            target.takeDamage(DAMAGE_GIVEN);
            System.out.println("Casting a spell to " + target.getName() +
                    "! Health is now " + target.getHealth() + "\n" +
                    super.getName() + "'s mana is now " + this.mana);
        }
    }

    /**
     * Restore mana of the elf method.
     * @param restoreMana = incoming mana to restore
     */
    public void restoreMana(final int restoreMana) {
        final int totalPower ;
        totalPower = this.mana + restoreMana;
        if(totalPower > MAX_MANA){
            this.mana = MAX_MANA;
        } else {
            this.mana += restoreMana;
        }
    }

    /**
     * Gets the details (name, DOB, age, health, mana) of the Elf
     * @return a string with the information about the Elf
     */
    @Override
    public String getDetails(){
        StringBuilder str;
        str = new StringBuilder();
        str.append(super.getDetails());
        str.append("\nMana Power: " + this.mana);
        return str.toString();
    }

}
