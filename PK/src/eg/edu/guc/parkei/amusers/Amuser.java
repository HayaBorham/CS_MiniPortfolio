package eg.edu.guc.parkei.amusers;

import java.util.ArrayList;

import eg.edu.guc.parkei.park.rides.FunRide;
import eg.edu.guc.parkei.utilities.Effect;
import eg.edu.guc.task.Gender;
import eg.edu.guc.parkei.utilities.Ticket;


//Amuser is the generic superclass which is inherited by subclasses Baby, Kid, Adult and Senior.
public abstract class Amuser implements Rider {

	private String name; //name of amusement park visitor (amuser)
	private int age; //age of amuser
	private double height; //height of amuser
	private FunRide location; //place where amuser is currently at in the park
	private boolean riding; //we need to check whether amuser is currently on a ride (cannot be riding two rides at the same time)
	private Ticket ticket; //enumerated type; which type of ticket the amuser has purchased
	private ArrayList<Effect> effects; //enumerated type; arraylist of effects of rides on each amuser
	private Gender x; //enumerated type; M or F

	//attribute Gender getter and setter
	public Gender getGender() {
		return x;
	}

	public void setGender(Gender x) {
		this.x = x;
	}

	//constructor creating an object of type Amuser when called
	public Amuser(String name, int age, double height) {
		this.setName(name);
		this.setAge(age);
		this.setHeight(height);
		effects = new ArrayList<Effect>();
		
	}
	
	//this method sets amuser gender 
	public Amuser(Gender x) {
		
		this.x = x;
		
	}

	//this method calls the method setLocation (which executes) and then returns true
	public boolean move(FunRide newLocation) {
		this.setLocation(newLocation);
		return true;
	}

	//this method sets the attribute location to the current location of the Amuser
	public void setLocation(FunRide location) {
		this.location = location;
	}
	
	//this method returns the location of the amuser in the amusement park
	public FunRide getLocation() {
		return location;
	}
	
	//attribute name setter and getter
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	//attribute age setter and getter
	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	//attribute height setter and getter
	public void setHeight(double height) {
		this.height = height;
	}

	public double getHeight() {
		return height;
	}
	
	//attribute riding setter
	public void setRiding(boolean riding) {
		this.riding = riding;
	}

	//this method returns a boolean value of whether an amuser is currently on a ride or not
	public boolean isRiding() {
		return riding;
	}

	//this method adds effect of individual rides on amuser to the arraylist effects
	public void applyEffects(Effect effect) {
		effects.add(effect);
	}
	
	//attribute effects getter and setter
	public ArrayList<Effect> getEffects() {
		return effects;
	}
	
	public void setEffects(ArrayList<Effect> effects) {
		this.effects = effects;
	}

	//attribute ticket setter and getter
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Ticket getTicket() {
		return ticket;
	}

}
