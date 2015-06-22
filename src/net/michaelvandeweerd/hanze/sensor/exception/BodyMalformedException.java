package net.michaelvandeweerd.hanze.sensor.exception;

import net.michaelvandeweerd.hanze.sensor.data.Body;

/**
 * Thrown when a body does not contain the joints or axis that it is expected to
 * contain.
 * 
 * @author Michaël van de Weerd
 */
public class BodyMalformedException extends Exception {
    /**
     * The body that caused the throwing of this exception.
     */
    private Body body;

    /**
     * Construct a body malformed exception.
     * 
     * @param message
     *            The message.
     * @param body
     *            The body that caused the throwing of this exception.
     */
    public BodyMalformedException(String message, Body body) {
	super(message);

	this.body = body;
    }

    /**
     * Return the body that caused the throwing of this exception.
     * 
     * @return The body that caused the throwing of this exception.
     */
    public Body getBody() {
	return body;
    }
}
