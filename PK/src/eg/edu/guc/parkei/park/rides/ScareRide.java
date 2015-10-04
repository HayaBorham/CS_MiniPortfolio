package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.Adult;
import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.exceptions.CannotBoardException;
import eg.edu.guc.parkei.exceptions.UnsuitableAgeCategoryException;
import eg.edu.guc.parkei.utilities.Effect;

public class ScareRide extends FunRide { //OOP feature: inheritance

	//subclass constructor that creates object ScareRide
	public ScareRide(String name, int duration, int batchSize) {
		super(name, duration, batchSize);
	}

	@Override //overrides superclass method: eligibleToRide(Amuser first)
	public boolean eligibleToRide(Amuser first) throws CannotBoardException {
		if (!(first instanceof Adult)) {
			throw new UnsuitableAgeCategoryException();
		}
		return true;
	}

	@Override //overrides superclass method: affects(Amuser am)
	public ArrayList<Effect> affects(Amuser am) {

		if (am instanceof Adult) {
			ArrayList<Effect> effects = new ArrayList<Effect>();
			effects.add(Effect.Scared);
			return effects;
		}
		return null;
	}
}
