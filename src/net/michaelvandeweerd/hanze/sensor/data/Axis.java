package net.michaelvandeweerd.hanze.sensor.data;

/**
 * An connection between two nodes.
 * 
 * @author Michaël van de Weerd
 */
public class Axis {
    /**
     * The name of the current axis.
     */
    private String name;

    /**
     * The lower node of the current axis.
     */
    private Extreme lower;

    /**
     * The higher node of the current axis.
     */
    private Extreme higher;

    /**
     * Construct an axis and two extremes.
     */
    public Axis() {
	this(new Extreme(), new Extreme());
    }

    /**
     * Construct an axis with a name, and two extremes.
     */
    public Axis(String name) {
	this();
	this.name = name;
    }

    /**
     * Construct an axis with two extremes.
     * 
     * @param lower
     *            The lower extreme of the axis to construct.
     * @param higher
     *            The higher extreme of the axis to construct.
     */
    public Axis(Extreme lower, Extreme higher) {
	this.lower = lower;
	this.higher = higher;
    }

    /**
     * Construct an axis with a name and two extremes.
     * 
     * @param name
     *            The name of the axis to construct.
     * @param lower
     *            The lower extreme of the axis to construct.
     * @param higher
     *            The higher extreme of the axis to construct.
     */
    public Axis(String name, Extreme lower, Extreme higher) {
	this(lower, higher);
	this.name = name;
    }

    /**
     * Return the name of the current axis.
     * 
     * @return The name of the current axis.
     */
    public String getName() {
	return name;
    }

    /**
     * Return the lower extreme of the current axis.
     * 
     * @return The lower extreme of the current axis.
     */
    public Extreme getLower() {
	return lower;
    }

    /**
     * Return the higher extreme of the current axis.
     * 
     * @return The higher extreme of the current axis.
     */
    public Extreme getHigher() {
	return higher;
    }

}
