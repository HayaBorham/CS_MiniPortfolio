package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.Amuser;

//CircularRide is circular where the ride starts and ends in the same place. It does so, without repeating the same stations.

public class CircularRide extends TransportRide { //OOP feature: inheritance
	
	//subclass constructor that creates object CircularRide
	public CircularRide(String name, int duration, int batchSize,
			ArrayList<FunRide> locations) {
		super(name, duration, batchSize, locations);
	}

	/**
	 * @return
	 * 
	 *         After visiting all locations in the route, the ride should return
	 *         to it's starting destination directly without revisiting
	 *         intermediate stations.
	 */
	public String getFullRoute() {
		String route = super.getFullRoute();
		route += getRouteLocations().get(0).getName();
		return route;
	}

	/**
	 * Move in a circular ride will just remove the first location and put it in
	 * the end of the list.
	 */
	public void move() {
		getMoveLocations().add(getMoveLocations().remove(0));
		ArrayList<Amuser> amus = getCurrentAmusers();
		// This for means: "for each Amuser in amus, which is a list, reference it as am and do the following" {...}.
		for (Amuser am : amus) {
			am.move(getMoveLocations().get(0));
		}
		setRouteLocations(getMoveLocations());
	}

}
