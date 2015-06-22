package net.michaelvandeweerd.hanze.sensor.data;

/**
 * An extreme contains rotation around a single axis.
 * 
 * @author Michaël van de Weerd
 */
public class Extreme {
    /**
     * The default rotation of an extreme.
     */
    private final static double DEFAULT_ROTATION = 0;

    /**
     * The rotation of the current extreme in radians.
     */
    private double rotation;

    /**
     * Construct an extreme with a default rotation.
     */
    public Extreme() {
	this(DEFAULT_ROTATION);
    }

    /**
     * Construct an extreme with a specified rotation.
     * 
     * @param rotation
     *            The rotation of the extreme to construct.
     */
    public Extreme(double rotation) {
	this.rotation = rotation;
    }

    /**
     * Return the rotation of the current extreme in radians.
     * 
     * @return The rotation of the current extreme in radians.
     */
    public double getRotationInRadians() {
	return rotation;
    }

    /**
     * Return the rotation of the current extreme in degrees.
     * 
     * @return The rotation of the current extreme in degrees.
     */
    public double getRotationInDegrees() {
	return rotation * (180 / Math.PI);
    }

    /**
     * Set the rotation of the current extreme in radians.
     * 
     * @param double The new rotation of the current extreme in radians.
     */
    public void setRotationInRadians(double rotation) {
	this.rotation = rotation;
    }

    /**
     * Set the rotation of the current extreme in degrees.
     * 
     * @param double The new rotation of the current extreme in degrees.
     */
    public void setRotationInDegrees(double rotation) {
	this.rotation = rotation * (Math.PI / 180);
    }

}
