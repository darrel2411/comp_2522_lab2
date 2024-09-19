package ca.bcit.comp2522.fantasy;
/**
 * Low Rage exception that is thrown when a damage operation fails.
 *
 * @author Manases Villalobos
 * @author Darrel Tapilaha.
 * @version 1.0
 */

public class LowRageException extends RuntimeException {
    /**
     * Constructs a new DamageException with the specified message.
     *
     * @param message the error message
     */
    public LowRageException(String message)
    {
        super(message);
    }
}
