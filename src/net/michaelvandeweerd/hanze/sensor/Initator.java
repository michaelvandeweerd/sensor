package net.michaelvandeweerd.hanze.sensor;

import net.michaelvandeweerd.hanze.sensor.data.Axis;
import net.michaelvandeweerd.hanze.sensor.data.Joint;
import net.michaelvandeweerd.hanze.sensor.data.Position;

/**
 * Contains the main function, used to initiate the application.
 * 
 * @author Michaël van de Weerd
 */
public class Initator {

    public static void main(String[] args) {
	// TEST
	Axis bovenarm = new Axis();
	Axis onderarm = new Axis();

	Joint schouder = new Joint("schouder", new Position(600, 0, 0),
		bovenarm.getHigher());
	Joint elleboog = new Joint("elleboog", new Position(0, 0, 0),
		bovenarm.getLower(), onderarm.getHigher());
	Joint pols = new Joint("pols", new Position(0, 500, 0),
		bovenarm.getLower());

	// 600mm
	double lengteBovenarm = Position.calculateDistance(
		schouder.getPosition(), elleboog.getPosition());

	// 500mm
	double lengteOnderarm = Position.calculateDistance(
		elleboog.getPosition(), pols.getPosition());
    }

}
