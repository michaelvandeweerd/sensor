package net.michaelvandeweerd.sensor.data;

import java.util.ArrayList;
import java.util.List;

import net.michaelvandeweerd.sensor.exception.AxisNotFoundException;
import net.michaelvandeweerd.sensor.exception.BodyMalformedException;
import net.michaelvandeweerd.sensor.exception.JointNotFoundException;

/**
 * A collection of joints and axis, needed to calculate relations between both.
 * 
 * @author Michaël van de Weerd
 */
public class Body {
    /**
     * The axis' contained in the current body.
     */
    private List<Axis> axiss;

    /**
     * The joints contained in the current body.
     */
    private List<Joint> joints;

    /**
     * Construct a body.
     */
    public Body() {
	axiss = new ArrayList<Axis>();
	joints = new ArrayList<Joint>();
    }

    /**
     * Add the specified axis to the current body.
     * 
     * @param axis
     *            The axis to add to the current body.
     */
    public void add(Axis axis) {
	axiss.add(axis);
    }

    /**
     * Add the specified joint to the current body.
     * 
     * @param joint
     *            The joint to add to the body.
     */
    public void add(Joint joint) {
	joints.add(joint);
    }

    /**
     * Return the axis contained in the current body with a name that matches
     * the specified name.
     * 
     * @param name
     *            The name of the axis to be returned.
     * @return The axis that has a name that matches the specified name.
     * @throws AxisNotFoundException
     *             When no axis with a name that matches the specified name has
     *             been found.
     */
    public Axis getAxisByName(String name) throws AxisNotFoundException {
	// check every axis for a matching name
	for (Axis axis : axiss)
	    if (axis.getName().equals(name))
		return axis;

	// not axis with a name that matches the specified name has been found
	throw new AxisNotFoundException(name);
    }

    /**
     * Return the axis contained in the current body containing the specified
     * extreme.
     * 
     * @param extreme
     *            The extreme contained in the axis to be returned.
     * @return The axis that contains the specified extreme.
     * @throws AxisNotFoundException
     *             When no axis containing the specified extreme has been found.
     */
    public Axis getAxisByNode(Extreme extreme) throws AxisNotFoundException {
	// check every axis for a matching extreme
	for (Axis axis : axiss)
	    if (axis.getHigher() == extreme || axis.getLower() == extreme)
		return axis;

	// no axis containing the specified extreme has been found
	throw new AxisNotFoundException(extreme);
    }

    /**
     * Return the joint contained in the current body with a name matching the
     * specified name.
     * 
     * @param name
     *            The name of the joint to be returned.
     * @return The joint that has a name that matches the specified name.
     * @throws JointNotFoundException
     *             When no joint with a name that matches the specified name has
     *             been found.
     */
    public Joint getJointByName(String name) throws JointNotFoundException {
	// check every joint for a matching name
	for (Joint joint : joints)
	    if (joint.getName().equals(name))
		return joint;

	// no joint with a name that matches the specified name has been found
	throw new JointNotFoundException(name);
    }

    /**
     * Return the joint contained in the current body that contains the
     * specified extreme.
     * 
     * @param extreme
     *            The extreme contained in the joint to be returned.
     * @return The joint that contains the specified extreme.
     * @throws JointNotFoundException
     *             When no joint containing the specified extreme has been
     *             found.
     */
    public Joint getJointByExtreme(Extreme extreme)
	    throws JointNotFoundException {
	// check every joint for a matching extreme
	for (Joint joint : joints)
	    if (joint.contains(extreme))
		return joint;

	throw new JointNotFoundException(extreme);
    }
    
    /**
     * Return the joint contained in the current body that is positioned at the specified position.
     * 
     * @param position The position that should be equal the the joint to be returned.
     * @return The joint position at the specified position.
     * @throws JointNotFoundException
     * 		When no joint positioned at the specified position has been found.
     */
    public Joint getJointByPosition(Position position) throws JointNotFoundException {
	// check every joint for a matching position
	for(Joint joint : joints)
	    if(joint.getPosition().equals(position))
		return joint;
	
	throw new JointNotFoundException(position);
    }

    /**
     * Return true if the current body contains the specified axis, otherwise
     * return false.
     * 
     * @param axis
     *            The axis that is or is not contained within the current body.
     * @return True if the current body contains the specified axis, otherwise
     *         false.
     */
    public boolean contains(Axis axis) {
	return axiss.contains(axis);
    }

    /**
     * Return true if the current body contains the specified joint, otherwise
     * return false.
     * 
     * @param joint
     *            The joint that is or is not contained within the current body.
     * @return True if the current body contains the specified joint, otherwise
     *         false.
     */
    public boolean contains(Joint joint) {
	return joints.contains(joint);
    }

    /**
     * Return the length of the specified axis.
     * 
     * @param axis
     *            The axis of which the length is returned.
     * @return The length of the specified axis.
     * @throws BodyMalformedException
     *             When the body does not contain the part needed to calculate
     *             the length of the specified axis.
     */
    public double calculateLength(Axis axis) throws BodyMalformedException {
	try {
	    // retrieve the joints at the higher and lower end of the axis'
	    Joint higher = getJointByExtreme(axis.getHigher());
	    Joint lower = getJointByExtreme(axis.getLower());

	    // return the length between the positions of the two joints
	    return Position.calculateDistance(higher.getPosition(),
		    lower.getPosition());
	} catch (JointNotFoundException e) {
	    throw new BodyMalformedException("Missing joint", this);
	}
    }
}
