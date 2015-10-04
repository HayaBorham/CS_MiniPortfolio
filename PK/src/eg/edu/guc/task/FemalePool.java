package eg.edu.guc.task;

import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.amusers.Baby;
import eg.edu.guc.parkei.exceptions.CanNotSwimException;

public class FemalePool extends Pool { //OOP feature: inheritance

	//default constructor
	public FemalePool() {

		super();

	}

	//subclass constructor calling superclass constructor to create object of type FemalePool.
	public FemalePool(int l, int w, int d, int maxC) {

		super(l, w, d, maxC);

	}

	@Override //overrides superclass method: canSwim(Amuser a)
	public boolean canSwim(Amuser a) throws CanNotSwimException {

		if (a.getGender() != Gender.Female || (a.getGender()) == Gender.Male
				&& !(a instanceof Baby)) {
			throw new CanNotSwimException(
					"Only female amusers and male babies are allowed to swim in this pool!");
		}

		return (a.getGender() == Gender.Female 
				|| (a.getGender() == Gender.Male && a instanceof Baby));

	}

}
