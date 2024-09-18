package ca.bcit.comp2522.fantasy;

import java.time.LocalDate;

/**
 * It is a super class, it will represent a fantasy creature
 *
 * @author Manases
 * @version 1.0
 */
public class Creature {
    private final String name;
    private final Date dateOfBirth;
    public int health;

    private final static int MAX_HEALTH = 100;
    private final static int MIN_HEALTH = 0;
    private final static int CURRENT_YEAR = 2024;

    /**
     * It creates a creature object.
     * @param name represents the name of the creature
     * @param dateOfBirth represents the date of birth of
     *                    the creature
     */
    public Creature(final String name,
                    final Date dateOfBirth)
    {
        this.name = validateString(name);
        this.dateOfBirth = isDateFuture(dateOfBirth);
        this.health = MAX_HEALTH;

    }

    /**
     * Returns true if the health is greater than zero
     * @return true if health is greater than zero
     */
    public boolean isAlive() {
        return health > MIN_HEALTH;
    }


    /**
     * It will affect the health negatively.
     * @param damage to represent the damage received
     */
    public void takeDamage(final int damage) {
        health -= damage;
        if(health < MIN_HEALTH){
            health = MIN_HEALTH;
            throw new DamageException("Severe Damage! " +
                                        this.name + " has died.");
        }
    }


    /**
     * It will affect the health positively
     * @param healthAmount represents the amount of health
     *                     the creature will receive.
     */
    public void heal(final int healthAmount) {
        health += healthAmount;
        if (health > MAX_HEALTH){
            health = MAX_HEALTH;
            throw new HealingException("Health exceeds the " +
                                            "maximum amount!");
        }
    }


    /**
     * It will calculate how old is the creature
     * @return age as an integer
     */
    public int getAgeYears(){

        return CURRENT_YEAR - dateOfBirth.getYear();
    }

    /**
     * Gets the details (name, DOB, age, health) of the creature
     * @return a string with the information about the creature
     */
    public String getDetails(){
        return "Name: " + name + "\nDate of Birth: " +
                dateOfBirth.getYyyyMmDd() + "\nAge: " +
                getAgeYears() + "\nHealth: " + health;
    }

    /*
    It will validate if a string is null or empty,
    and it will throw and illegal argument exception if
    that is the case.
     */
    private static String validateString(final String str) {
        // verify if the string is empty or null
        if (str == null || str.isEmpty()) {
            // if so it will throw an illegal argument exception
            throw new IllegalArgumentException(
                                "Name cannot be null or empty");
        }

        return str;
    }

    /*
    it will validate if a date is in the future, if it is
    it will throw illegal argument exception.
     */
    private static Date isDateFuture(final Date date){
        // An object with today's date
        LocalDate myObj = LocalDate.now();

        int dayBorn = date.getDay();
        int today = myObj.getDayOfMonth();

        int monthBorn = date.getMonth();
        int currentMonth = myObj.getMonthValue();

        int yearBorn = date.getYear();
        int currentYear = myObj.getYear();

        // Verify if the date is in the future
        if (yearBorn > currentYear) {
            throw new IllegalArgumentException(
                            "Year cannot be in the future");
        }
        else if (yearBorn == currentYear &&  monthBorn > currentMonth) {
            throw new IllegalArgumentException(
                            "Month cannot be in the future");
        }
        else if (yearBorn == currentYear &&
                   monthBorn == currentMonth &&
                   dayBorn > today)
        {
            throw new IllegalArgumentException(
                            "Day cannot be in the future");
        }


        return date;
    }
}
