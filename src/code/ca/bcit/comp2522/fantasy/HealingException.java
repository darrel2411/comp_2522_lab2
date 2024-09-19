package ca.bcit.comp2522.fantasy;
/**
 * Healing exception that is thrown when a damage operation fails.
 *
 * @author Manases Villalobos
 * @author Darrel Tapilaha.
 * @version 1.0
 */

public class HealingException extends RuntimeException {
    /**
     * Constructs a new DamageException with the specified message.
     *
     * @param message the error message
     */
    HealingException(String message)
    /**
     * Constructs a new DamageException with the specified message.
     *
     * @param message the error message
     */{
        super(message);
    }
}