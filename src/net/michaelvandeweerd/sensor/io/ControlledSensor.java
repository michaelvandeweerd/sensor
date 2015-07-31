package net.michaelvandeweerd.sensor.io;

import java.util.Map;

import net.michaelvandeweerd.sensor.data.Body;
import net.michaelvandeweerd.sensor.data.Joint;
import net.michaelvandeweerd.sensor.data.Position;

/**
 * A sensor whose input can be controlled using an interface.
 * 
 * @author Michaël van de Weerd
 */
public class ControlledSensor extends Sensor {

	public ControlledSensor(Body body) {
		super(body);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Map<Joint, Position> readPositions() {
		// TODO Auto-generated method stub
		return null;
	}

}
