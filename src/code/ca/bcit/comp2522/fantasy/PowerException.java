package ca.bcit.comp2522.fantasy;
/**
 * Power exception that is thrown when a damage operation fails.
 *
 * @author Manases Villalobos
 * @author Darrel Tapilaha.
 * @version 1.0
 */

public class PowerException extends RuntimeException {
    /**
     * Constructs a new DamageException with the specified message.
     *
     * @param message the error message
     */
    public PowerException(String message)
    {
        super(message);
    }
}
