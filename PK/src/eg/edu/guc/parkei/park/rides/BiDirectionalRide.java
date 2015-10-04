package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;
import java.util.Stack;

import eg.edu.guc.parkei.amusers.Amuser;

//the BiDirectionalRide starts at a location, goes to another one as per the routeLocations and then returns
//to its start position. It does so by following the same route but from the other direction.

public class BiDirectionalRide extends TransportRide { //OOP feature: inheritance
	private static int path; 
	private Stack<FunRide> route;

	//subclass constructor that creates object BiDirectionalRide
	public BiDirectionalRide(String name, int duration, int batchSize,
			ArrayList<FunRide> locations) {
		super(name, duration, batchSize, locations);
		route = new Stack<FunRide>();
		path = 1;
	}

	/**
	 * @return
	 * 
	 *         After visiting all locations in the route, the ride should return
	 *         all the way back through the same stops back to it's start.
	 */
	public String getFullRoute() {
		String route = super.getFullRoute();
		ArrayList<FunRide> locations = getRouteLocations();
		int size = locations.size() - 1;
		for (int i = size - 1; i > 0; i--) {
			route += locations.get(i).getName() + ", ";
		}
		route += locations.get(0).getName();
		return route;
	}

	/**
	 * If the ride is going forward then remove the current location and add it
	 * to a stack. If you reach the last location, then the way backward should
	 * start.
	 * 
	 * If the ride is going backward, remove what is on the top of the stack and
	 * put it back to the list. Once the stack is empty, the route should start
	 * from the very beginning.
	 */
	public void move() {
		if (path == 1) {
			if (getMoveLocations().size() == 1) {
				path = 2;
				getMoveLocations().add(0, route.pop());
			} else {
				route.push(getMoveLocations().remove(0));
			}
		} else {
			if (route.isEmpty()) {
				path = 1;
				route.push(getMoveLocations().remove(0));
			} else {
				getMoveLocations().add(0, route.pop());
			}
		}
		ArrayList<Amuser> amus = getCurrentAmusers();
		FunRide loc = getCurrentLocation();
		for (Amuser am : amus) {
			am.move(loc);
		}
	}

}
