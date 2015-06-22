package net.michaelvandeweerd.hanze.sensor.exception;

import net.michaelvandeweerd.hanze.sensor.data.Extreme;

/**
 * Thrown when a axis specified by its name or an extreme it contains has not
 * been found.
 * 
 * @author Michaël van de Weerd
 */
public class AxisNotFoundException extends Exception {
    /**
     * The message to be used when the axis was supposed to be found by its
     * name.
     */
    private final static String NOT_FOUND_BY_NAME_MESSAGE = "Axis with name <NAME> has not been found";

    /**
     * The message to be used when the axis was supposed to be found by an
     * extreme it contains.
     */
    private final static String NOT_FOUND_BY_NODE_MESSAGE = "Axis with node <EXTREME> has not been found";

    /**
     * The extreme that is contained in the axis that was supposed to be found.
     */
    private Extreme extreme;

    /**
     * Construct an axis not found exception.
     * 
     * @param name
     *            The name of the axis that has not been found.
     */
    public AxisNotFoundException(String name) {
	super(NOT_FOUND_BY_NAME_MESSAGE.replace("<NAME>", name));
    }

    /**
     * Construct an axis not found exception.
     * 
     * @param extreme
     *            The extreme contained in the the axis that has not been found.
     */
    public AxisNotFoundException(Extreme extreme) {
	super(NOT_FOUND_BY_NODE_MESSAGE
		.replace("<EXTREME>", extreme.toString()));

	this.extreme = extreme;
    }

    /**
     * Return the extreme that is contained in the axis that was supposed to be
     * found.
     * 
     * @return The extreme that is contianed in the axis that was supposed to be
     *         found.
     */
    public Extreme getExtreme() {
	return extreme;
    }

}
