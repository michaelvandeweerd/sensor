package net.michaelvandeweerd.sensor.io;

import java.util.Map;

import net.michaelvandeweerd.sensor.data.Body;
import net.michaelvandeweerd.sensor.data.Joint;
import net.michaelvandeweerd.sensor.data.Position;

/**
 * A sensor that detects changes in the position of joints in the physical body
 * and updates the joints in the body model accordingly.
 * 
 * @author Michaël van de Weerd
 */
public abstract class Sensor implements Runnable {
	/**
	 * The booleans indicating the state of the sensor thread.
	 */
	private boolean running, paused;

	/**
	 * The amount of milliseconds the sensor threads wait between attempts to
	 * read joint positions in the physical body.
	 */
	private final static int DELAY = 500;

	/**
	 * The body that should be updated, based on the observations of the current
	 * sensor.
	 */
	protected Body body;

	/**
	 * Construct a sensor containing a body to update.
	 * 
	 * @param body
	 *            The body that should be updated, based on the observations of
	 *            the sensor to construct.
	 */
	public Sensor(Body body) {
		this.body = body;
	}

	/**
	 * Read the positions of the joints in the physical body and return a map,
	 * associating each joint with a new position.
	 * 
	 * @return A map associating each joint with a new position.
	 */
	protected abstract Map<Joint, Position> readPositions();

	/**
	 * Stop the sensor.
	 */
	public void stop() {
		running = false;
	}

	/**
	 * Stop reading position and updating the body, but keep the thread alive.
	 */
	public void pause() {
		paused = true;
	}

	/**
	 * Resume reading positions and updating the body.
	 */
	public void resume() {
		paused = false;
	}

	/**
	 * Run the sensor.
	 */
	public void run() {
		while (running) {
			if (!paused)
				for (Map.Entry<Joint, Position> read : readPositions().entrySet())
					read.getKey().setPosition(read.getValue());

			try {
				wait(DELAY);
			} catch (InterruptedException ie) {
				System.out.println(ie);
			}
		}
	}
}
