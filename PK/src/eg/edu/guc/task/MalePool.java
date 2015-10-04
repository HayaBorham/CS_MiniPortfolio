package eg.edu.guc.task;

import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.exceptions.CanNotSwimException;


public class MalePool extends Pool { //OOP feature: inheritance
	
	//default constructor 
	public MalePool() {
		
		super();
		
	}
	
	//subclass constructor calling superclass constructor to create object of type MalePool
	public MalePool(int l, int w, int d, int maxC) {
		
		super(l, w, d, maxC);
		
	}
	
	@Override //overrides superclass method: canSwim(Amuser a)
	public boolean canSwim(Amuser a) throws CanNotSwimException {
		
		if (a.getGender() != Gender.Male) {
			throw new CanNotSwimException("Only male amusers are allowed to swim in this pool!");
		}
		return (a.getGender() == Gender.Male);
		
	}
	
	
	

}
