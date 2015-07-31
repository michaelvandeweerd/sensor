package net.michaelvandeweerd.sensor.data;

/**
 * A position in a three-dimensional space. This class also provides several
 * static functions, that can be used to calculate certain values of relations
 * between positions.
 * 
 * @see https://en.wikipedia.org/wiki/Cartesian_coordinate_system
 * @see https://en.wikipedia.org/wiki/Dot_product
 * @see https://en.wikipedia.org/wiki/Magnitude_(mathematics)
 * 
 * @author Michaël van de Weerd
 */
public class Position {
	/**
	 * The format of the textual representation of a position.
	 */
	private final static String STRING_FORMAT = "(X,Y,Z)";

	/**
	 * The abscissa of the current node.
	 */
	private double x;

	/**
	 * The ordinate of the current node.
	 */
	private double y;

	/**
	 * The applicate of the current node.
	 */
	private double z;

	/**
	 * Construct a position with the specified abscissa, ordinate and applicate.
	 * 
	 * @param x
	 *            The abscissa of the position to be constructed.
	 * @param y
	 *            The ordinate of the position to be constructed.
	 * @param z
	 *            The applicate of the position to be constructed.
	 */
	public Position(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Return the abscissa of the current position.
	 * 
	 * @return The abscissa of the current position.
	 */
	public double getX() {
		return x;
	}

	/**
	 * Return the ordinate of the current position.
	 * 
	 * @return The ordinate of the current position.
	 */
	public double getY() {
		return y;
	}

	/**
	 * The applicate of the current position.
	 * 
	 * @return The applicate of the current position.
	 */
	public double getZ() {
		return z;
	}

	/**
	 * Return a boolean indicating wether or not the current position is equal
	 * to the specified object.
	 * 
	 * @param object
	 *            The object to which the current position is or is not equal.
	 * @return True if the current position is equals to the specified position,
	 *         otherwise false.
	 */
	@Override
	public boolean equals(Object object) {
		return object instanceof Position && ((Position) object).getX() == x && ((Position) object).getY() == y
				&& ((Position) object).getZ() == z;
	}

	/**
	 * Return the textual representation of the current position.
	 */
	@Override
	public String toString() {
		return STRING_FORMAT.replace("X", String.valueOf(x)).replace("Y", String.valueOf(y)).replace("Z",
				String.valueOf(z));
	}

	/**
	 * Return the distance between two positions.
	 * 
	 * @see http://en.wikipedia.org/wiki/Cartesian_coordinate_system#
	 *      Distance_between_two_points
	 * 
	 * @param position1
	 *            The first position.
	 * @param position2
	 *            The second position.
	 * @return The distance between two positions.
	 */
	public static double calculateDistance(Position position1, Position position2) {
		return Math.sqrt(
				Math.pow((position2.getX() - position1.getX()), 2) + Math.pow((position2.getY() - position1.getY()), 2)
						+ Math.pow((position2.getZ() - position1.getZ()), 2));
	}

	/**
	 * Return the angle of a line connection the two specified positions in
	 * radians.
	 * 
	 * @param position1
	 *            The first position.
	 * @param position2
	 *            The second position.
	 * @return The angle of a line connecting the two specified positions in
	 *         radians.
	 */
	public static double calculateAngle(Position position1, Position position2) {
		return (Math.acos(calculateDotProduct(position1, position2) / calculateMagnitude(position1)
				* calculateMagnitude(position2))) * Math.PI / 180;
	}

	/**
	 * Return the dot product of the coördinates of the two specified positions.
	 * 
	 * @see https://en.wikipedia.org/wiki/Dot_product#Algebraic_definition
	 * 
	 * @param position1
	 *            The first position.
	 * @param position2
	 *            The second position.
	 * @return The dot product of the coördinates of the two specified
	 *         positions.
	 */
	public static double calculateDotProduct(Position position1, Position position2) {
		return position1.getX() * position2.getX() + position1.getY() * position2.getY()
				+ position1.getZ() * position2.getZ();
	}

	/**
	 * Return the magnitude of the coördinates of the specified position.
	 * 
	 * @see https ://en.wikipedia.org/wiki/Magnitude_(mathematics)#
	 *      Euclidean_vector_space
	 * 
	 * @param position
	 *            The position.
	 * @return The magnitude of the coördinates of the specified position.
	 */
	public static double calculateMagnitude(Position position) {
		return Math.sqrt(Math.pow(position.getX(), 2) + Math.pow(position.getY(), 2) + Math.pow(position.getZ(), 2));
	}

}
