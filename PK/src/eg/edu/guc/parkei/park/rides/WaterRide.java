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

public class WaterRide extends FunRide { //OOP feature: inheritance

	//subclass constructor that creates object WaterRide
	public WaterRide(String name, int duration, int batchSize) {
		super(name, duration, batchSize);
	}

	@Override //overrides superclass method: eligibleToRide(Amuser first)
	public boolean eligibleToRide(Amuser first) throws CannotBoardException {
		if (first instanceof Baby) {
			throw new UnsuitableAgeCategoryException();
		}
		return true;
	}

	@Override //overrides superclass method: affects(Amuser am)
	public ArrayList<Effect> affects(Amuser am) {
		if (am instanceof Baby) {
			return null;
		}
		ArrayList<Effect> effects = new ArrayList<Effect>();
		effects.add(Effect.Wet);
		if (am instanceof Kid) {
			effects.add(Effect.Thrilled);
		} else {
			if (am instanceof Adult) {
				effects.add(Effect.Happy);
			} else {
				if (am instanceof Senior) {
					effects.add(Effect.Angry);
				}
			}
		}
		return effects;
	}
}
