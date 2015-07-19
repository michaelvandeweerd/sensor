package net.michaelvandeweerd.sensor.exception;

import net.michaelvandeweerd.sensor.data.Extreme;
import net.michaelvandeweerd.sensor.data.Position;

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
     * The message to be used when the joint was supposed to be found by a
     * position.
     */
    private final static String NOT_FOUND_BY_POSITION_MESSAGE = "Joint with position <POSITION> has not been found";

    /**
     * The extreme that is contained in the joint that was supposed to be found.
     */
    private Extreme extreme;

    /**
     * The position at which no joint was found.
     */
    private Position position;

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
     * Construct a joint not found exception.
     * 
     * @param position
     *            The position of the joint that has not been found.
     */
    public JointNotFoundException(Position position) {
	super(NOT_FOUND_BY_POSITION_MESSAGE.replace("<POSITION>",
		position.toString()));

	this.position = position;
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
