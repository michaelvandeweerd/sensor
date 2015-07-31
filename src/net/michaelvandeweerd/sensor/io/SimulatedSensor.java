package net.michaelvandeweerd.sensor.io;

import java.util.Map;

import net.michaelvandeweerd.sensor.data.Body;
import net.michaelvandeweerd.sensor.data.Joint;
import net.michaelvandeweerd.sensor.data.Position;

/**
 * A sensor that simulates receiving input.
 * 
 * @author Michaël van de Weerd
 */
public class SimulatedSensor extends Sensor {

	public SimulatedSensor(Body body) {
		super(body);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Map<Joint, Position> readPositions() {
		// TODO Auto-generated method stub
		return null;
	}

}
