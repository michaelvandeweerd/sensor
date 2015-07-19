package net.michaelvandeweerd.sensor.data;

/**
 * A joint gives a position to multiple nodes.
 * 
 * @author Michaël van de Weerd
 */
public class Joint {
    /**
     * The name of the current joint.
     */
    private String name;

    /**
     * The position of the current joint.
     */
    private Position position;

    /**
     * The nodes contained in the current joint.
     */
    private Extreme[] extremes;

    /**
     * Construct the joint with extremes.
     * 
     * @param name
     *            The name of the joint to construct.
     * @param position
     *            The position of the joint to construct.
     * @param extremes
     *            The extremes to be contained in the joint to construct.
     */
    public Joint(String name, Position position, Extreme... extremes) {
	this.name = name;
	this.position = position;
	this.extremes = extremes;
    }

    /**
     * Return the name of the current joint.
     * 
     * @return The name of the current joint.
     */
    public String getName() {
	return name;
    }

    /**
     * Return the position of the current joint.
     * 
     * @return The position of the current joint.
     */
    public Position getPosition() {
	return position;
    }

    /**
     * Return the extremes of the current joint.
     * 
     * @return The extremes of the current joint.
     */
    public Extreme[] getExtremes() {
	return extremes;
    }
    
    /**
     * Set the position of the current joint.
     * 
     * @param position The new position of the current joint.
     */
    public void setPosition(Position position) {
	this.position = position;
    }

    /**
     * Return true if the current joint contains the specified extreme,
     * otherwise return false.
     * 
     * @param extreme
     *            The extreme that is or is not contained within the current
     *            joint.
     * @return True if the current joint contains the specified extreme,
     *         otherwise false.
     */
    public boolean contains(Extreme extreme) {
	// check all contained extreme for a match with the specified extreme
	for (Extreme containedExtreme : extremes)
	    if (containedExtreme.equals(extreme))
		return true;

	return false;
    }

}
