package net.michaelvandeweerd.hanze.sensor.exception;

import net.michaelvandeweerd.hanze.sensor.data.Extreme;

/**
 * Thrown when a joint specified by its name or an extreme it contains has not
 * been found.
 * 
 * @author Michaël van de Weerd
 */
public class JointNotFoundException extends Exception {
    /**
     * The message to be used when the joint was supposed to be found by its
     * name.
     */
    private final static String NOT_FOUND_BY_NAME_MESSAGE = "Joint with name <NAME> has not been found";

    /**
     * The message to be used when the joint was supposed to be found by an
     * extreme it contains.
     */
    private final static String NOT_FOUND_BY_EXTREME_MESSAGE = "Joint with node <EXTREME> has not been found";

    /**
     * The extreme that is contained in the joint that was supposed to be found.
     */
    private Extreme extreme;

    /**
     * Construct a joint not found exception.
     * 
     * @param name
     *            The name of the joint that has not been found.
     */
    public JointNotFoundException(String name) {
	super(NOT_FOUND_BY_NAME_MESSAGE.replace("<NAME>", name));
    }

    /**
     * Construct a joint not found exception.
     * 
     * @param extreme
     *            The extreme contained in the joint that has not been found.
     */
    public JointNotFoundException(Extreme extreme) {
	super(NOT_FOUND_BY_EXTREME_MESSAGE.replace("<EXTREME>",
		extreme.toString()));

	this.extreme = extreme;
    }

    /**
     * Return the extreme that is contained in the joint that was supposed to be
     * found.
     * 
     * @return The extreme that is contianed in the joint that was supposed to
     *         be found.
     */
    public Extreme getExtreme() {
	return extreme;
    }
}
