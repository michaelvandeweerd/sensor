package net.michaelvandeweerd.sensor.event;

import java.util.EventObject;

import net.michaelvandeweerd.sensor.data.Body;

/**
 * Stores a reference to the body that fired the current event.
 * 
 * @author Michaël van de Weerd
 */
public class BodyEvent extends EventObject {

    /**
     * Construct a body event.
     * 
     * @param source The body that fired the current event.
     */
    public BodyEvent(Body body) {
	super(body);
    }

}