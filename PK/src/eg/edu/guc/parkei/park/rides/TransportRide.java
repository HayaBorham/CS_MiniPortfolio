package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.exceptions.CannotOperateException;
import eg.edu.guc.parkei.exceptions.NoRouteException;

public abstract class TransportRide extends Ride { //OOP feature: inheritance
	private ArrayList<FunRide> routeLocations; //TransportRide route stops/stations of type FunRide (stationary route overview)
	private ArrayList<FunRide> moveLocations; //TransportRide route current locations of type FunRide (as TransportRide moves)

	//subclass constructor that creates object and adds FunRide stops to routeLocations and updates current moveLocation
	public TransportRide(String name, int duration, int batchSize,
			ArrayList<FunRide> locations) {
		super(name, duration, batchSize);
		routeLocations = new ArrayList<FunRide>();
		setRouteLocations(locations);
		moveLocations = new ArrayList<FunRide>();
		for (FunRide funRide : locations) {
			moveLocations.add(funRide);
		}
	}
	
	//this method returns true at all times as TransportRides are available for all amusers
	public boolean availableForAll() {
		return true;
	}

	/**
	 * @return
	 * 
	 *         A ride in maintenance cannot start. When a transport ride starts,
	 *         it decreases the rides to maintain. Also it moves.
	 */
	public boolean start() throws CannotOperateException {
		if (routeLocations == null || routeLocations.size() == 0) {
			throw new NoRouteException();
		}
		super.start();
		move();
		return true;
	}

	//this method evacuates the ride from all passengers
	public void unBoard() {
		for (Amuser am : getCurrentAmusers()) {
			am.setLocation(routeLocations.get(0));
		}
		super.unBoard();
	}

	 //this method changes location of the ride to the next location on the route. 
     //It should also change the locations of all amusers on board. To do this
	//in the right way, the method can only call a responsible method for moving an amuser 
   //in the subclass.
	public abstract void move(); 

	//attribute routeLocations setter and getter
	public void setRouteLocations(ArrayList<FunRide> routeLocations) {
		this.routeLocations = routeLocations;
	}

	public ArrayList<FunRide> getRouteLocations() {
		return routeLocations;
	}

	//this method gets the currentLocation by calling the getMoveLocations method and returning the latest location update "get(0)
	public FunRide getCurrentLocation() {
		return getMoveLocations().get(0);
	}

	/**
	 * @return
	 * 
	 *         The method returns a string representation of all the locations
	 *         in the route.
	 */
	public String getFullRoute() {
		String route = "The followed route is: ";
		ArrayList<FunRide> locations = getRouteLocations();
		for (FunRide location : locations) {
			route += location.getName() + ", ";
		}
		return route;
	}

	//all TransportRides are available for all amusers
	protected boolean eligible(Amuser boarder) {
		return true;
	}

	//this method checks whether or not the amuser is where s/he is supposed to be
	protected boolean correctLocation(Amuser boarder) {
		return boarder.getLocation() != null
				&& boarder.getLocation().equals(getCurrentLocation());
	}

	//attribute moveLocations setter and getter
	public void setMoveLocations(ArrayList<FunRide> moveLocations) {
		this.moveLocations = moveLocations;
	}

	public ArrayList<FunRide> getMoveLocations() {
		return moveLocations;
	}

}
