# Sensor project
Product of the Hanze University of Applied Science honoursprogramme Sensor project.

# Logical design
To track the movements of a motor rider, his body must be translated to a model that can be stored. To achieve this, the body has been defined as a collection of axis (bones) and joints, where the axis are connected. The axis is made up from two extremes, while a joint can contains 1 or more. Each extreme is contained both in an axis and a joint, and contains a rotation value. This value tells the amount of rotation along the axis of which the extreme is a part in radians. A joint contains a position value, which tells it’s coördinates in three-dimensional space. Using these values, the rotation of both extremes in an axis and the position of the extremes in a joint, the length of an axis or the angle between two axis’ can be calculated.

To initialize a body, or a just a part of the body, every bone can be constructed as an axis. Each axis will automatically contains two extreme, the lower and the higher, with a default rotation of zero. These extreme can individually be retrieved using the getLower and getHigher methods, so that they can be used for the initialisation of joints.

```
// initiate two axis with extreme that have a default rotation (0)
Axis upperarm = new Axis();
Axis forearm = new Axis();

Joint shoulder = new Joint(new Position(600, 0, 0),
	upperarm.getHigher());
Joint elbow = new Joint(new Position(0, 0, 0), upperarm.getLower(),
	forearm.getHigher());
Joint wrist = new Joint(new Position(0, 500, 0), upperarm.getLower());
// 600mm
double lengthUpperarm = Position.calculateDistance(
	shoulder.getPosition(), elbow.getPosition());

// 500mm
double lengthForearm = Position.calculateDistance(
	elbow.getPosition(), wrist.getPosition());
```
