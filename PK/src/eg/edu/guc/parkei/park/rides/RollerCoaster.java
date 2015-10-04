package eg.edu.guc.parkei.park.rides;

import java.util.ArrayList;

import eg.edu.guc.parkei.amusers.Adult;
import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.amusers.Baby;
import eg.edu.guc.parkei.utilities.Effect;
import eg.edu.guc.parkei.amusers.Kid;
import eg.edu.guc.parkei.amusers.Senior;
import eg.edu.guc.parkei.exceptions.CannotBoardException;
import eg.edu.guc.parkei.exceptions.UnsuitableAgeCategoryException;
import eg.edu.guc.parkei.exceptions.UnsuitableHeightException;

public class RollerCoaster extends FunRide { //OOP feature: inheritance

	//subclass constructor that creates object RollerCoaster
	public RollerCoaster(String name, int duration, int batchSize) {
		super(name, duration, batchSize);
	}

	@Override //overrides superclass method: eligibleToRide(Amuser first)
	public boolean eligibleToRide(Amuser first) throws CannotBoardException {
		if (first instanceof Baby || first instanceof Senior) {
			throw new UnsuitableAgeCategoryException();
		}
		if (first instanceof Kid && first.getHeight() <= 140) {
			throw new UnsuitableHeightException();
		}
		return true;
	}

	@Override //overrides superclass method: affects(Amuser am)
	public ArrayList<Effect> affects(Amuser am) {
		if (am instanceof Baby || am instanceof Senior
				|| (am instanceof Kid && am.getHeight() < 140)) {
			return null;
		}
		ArrayList<Effect> effects = new ArrayList<Effect>();
		if (am instanceof Kid) {
			effects.add(Effect.Sick);
		} else {
			if (am instanceof Adult) {
				effects.add(Effect.High);
			}
		}
		return effects;
	}
}
