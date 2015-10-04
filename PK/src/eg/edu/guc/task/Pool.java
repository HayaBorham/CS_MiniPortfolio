package eg.edu.guc.task;

import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.exceptions.CanNotSwimException;

//Amusement Park happens to have pools as well...

public abstract class Pool {
	
	private int length; //pool length
	private int width; //pool width
	private int depth; //pool depth
	private int maxCapacity; //maximum number of amusers a pool can take
	
	//default constructor
	public Pool() {
		
	}
	
	//constructor creating an object of type Pool
	public Pool(int len, int wid, int dep, int maxCapacity) {
		
		length = len;
		width = wid;
		depth = dep;
		this.maxCapacity = maxCapacity;
		
	}
	
	//this method can only call a responsible method in the subclasses of Pool of whether or not an amuser can swim.
	public abstract boolean canSwim(Amuser a) throws CanNotSwimException;

	//attribute length getter and setter
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	//attribute width getter and setter
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	//attribute depth getter and setter
	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	//attribute maxCapacity getter and setter
	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
}
