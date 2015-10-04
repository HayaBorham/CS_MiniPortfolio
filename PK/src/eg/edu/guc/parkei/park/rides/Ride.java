package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.exceptions.AlreadyBoardingException;
import eg.edu.guc.parkei.exceptions.CannotBoardException;
import eg.edu.guc.parkei.exceptions.CannotOperateException;
import eg.edu.guc.parkei.exceptions.CannotUnboardException;
import eg.edu.guc.parkei.exceptions.FullRideException;
import eg.edu.guc.parkei.exceptions.LocationException;
import eg.edu.guc.parkei.exceptions.OutOfOrderException;

//Ride is the generic superclass which is inherited by subclasses FunRide and TransportRide.
public abstract class Ride {
	private String name; //name of ride
	private int duration; //duration of ride
	private int batchSize; //maximum capacity of the ride
	private int ridesToMaintain; //the number of times a ride can run before being maintained. All rides can only run 10 times. 
	private ArrayList<Amuser> currentAmusers; //list of passengers taking a ride now

	//constructor creating an object of type Ride when called
	public Ride(String name, int duration, int batchSize) {
		this.setName(name);
		this.setDuration(duration);
		this.setBatchSize(batchSize);
		setCurrentAmusers(new ArrayList<Amuser>()); 
		setRidesToMaintain(10); //to countdown till it reaches 0, then the ride is maintained.

	}

	/**
	 * @param boarder
	 * @return
	 * 
	 *         Nobody can board a ride that is being maintained. A full ride can
	 *         not be boarded by someone else. An amuser riding this/or
	 *         different ride can not ride this one. Only amusers in same
	 *         location as the ride can board it.
	 */
	public boolean board(Amuser boarder) throws CannotBoardException,
			OutOfOrderException {
		if (inMaintenance()) {
			throw new OutOfOrderException("The ride is being maintained");
		}
		if (getCurrentAmusers().size() == getBatchSize()) {
			throw new FullRideException();
		}
		if (boarder.isRiding()) {
			throw new AlreadyBoardingException(
					"You are already boarding a different ride");
		}
		if (getCurrentAmusers().contains(boarder)) {
			throw new AlreadyBoardingException(
					"You are already boarding this ride");
		}
		if (!correctLocation(boarder)) {
			throw new LocationException(
					"You should move to the ride to board it");
		}
		getCurrentAmusers().add(boarder); //if none of the above conditions apply, the amuser boards & number of boarders increments
		boarder.setRiding(true); 
		return true;
	}

	protected abstract boolean correctLocation(Amuser am);

	//this method resets list of ride amusers when all unboard
	public void unBoard() {
		setCurrentAmusers(new ArrayList<Amuser>());
	}
	
	//this method allows an amuser to unboard the ride. It returns true if the user unboarded.
	public boolean unBoard(Amuser boarder) throws CannotUnboardException {
		if (!getCurrentAmusers().contains(boarder)) {
			throw new CannotUnboardException();
		}
		getCurrentAmusers().remove(boarder);
		return true;
	}
 
	/*This method runs the ride. Playing has several effects on the ride and the passengers. 
	* The effects depend on the type of the ride.
	  Mainly, it should edit the ridesToMaintain variable.
	*/
	public boolean start() throws CannotOperateException {
		if (inMaintenance()) {
			throw new OutOfOrderException(
					"This ride is being maintained! You can not ride it");
		}
		setRidesToMaintain(getRidesToMaintain() - 1);
		return true;
	}

	public boolean inMaintenance() {
		return (getRidesToMaintain() == 0);
	}

	public void endMaintenance() {
		setRidesToMaintain(10);
	}

	//This method returns true if the ride can be taken by any amuser. Otherwise, it returns false.
	public boolean availableForAll() {
		return false; 
	}

	//attribute batchSize setter and getter
	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

	public int getBatchSize() {
		return batchSize;
	}
	
	//attribute currentAmusers setter and getter
	public void setCurrentAmusers(ArrayList<Amuser> currentAmusers) {
		this.currentAmusers = currentAmusers;
	}

	public ArrayList<Amuser> getCurrentAmusers() {
		return currentAmusers;
	}

	//attribute name setter and getter
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	//attribute duration setter and getter
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getDuration() {
		return duration;
	}
	
	//attribute ridesToMaintain setter and getter
	public void setRidesToMaintain(int ridesToMaintain) {
		this.ridesToMaintain = ridesToMaintain;
	}

	public int getRidesToMaintain() {
		return ridesToMaintain;
	}
}
