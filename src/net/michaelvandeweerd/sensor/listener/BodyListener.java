package net.michaelvandeweerd.sensor.listener;

import net.michaelvandeweerd.sensor.event.BodyEvent;

/**
 * To be implemented by classes that need to be updated when the body is
 * updated.
 * 
 * @author Michaël van de Weerd
 */
public interface BodyListener {
	/**
	 * Called when the positions of the joints in the body are updated.
	 * 
	 * @param event
	 *            The body event containing a reference to the body.
	 */
	public void jointPositionUpdated(BodyEvent event);
}
