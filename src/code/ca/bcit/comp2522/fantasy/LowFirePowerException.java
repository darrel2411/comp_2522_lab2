package ca.bcit.comp2522.fantasy;
/**
 * Low Fire exception that is thrown when a damage operation fails.
 *
 * @author Manases Villalobos
 * @author Darrel Tapilaha.
 * @version 1.0
 */

public class LowFirePowerException extends Exception {
    /**
     * Constructs a new DamageException with the specified message.
     *
     * @param message the error message
     */
    public LowFirePowerException(String message)
    {
        super(message);
    }
}
