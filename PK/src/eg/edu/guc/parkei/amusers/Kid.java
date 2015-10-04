package eg.edu.guc.parkei.amusers;

import eg.edu.guc.parkei.exceptions.WrongAgeException;
import eg.edu.guc.parkei.exceptions.WrongTicketException;
import eg.edu.guc.task.Gender;
import eg.edu.guc.parkei.utilities.Ticket;

public class Kid extends Amuser { //OOP feature: inheritance

	//subclass constructor with age check that throws exception when violated
	public Kid(final String name, final int age, final double height)
			throws WrongAgeException {
		super(name, age, height);
		if (age < 4) {
			throw new WrongAgeException(
					"An amuser younger than 4 years is not considered a kid yet");
		}
		if (age > 14) {
			throw new WrongAgeException(
					"An amuser older than 4 years is not considered a kid anymore");
		}
	}

	//constructing Kid attribute Gender (by calling superclass Amuser)
	public Kid(Gender x) {

		super(x);

	}

	@Override
	public Ticket getTicket() {
		return super.getTicket();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eg.edu.guc.parkei.amusers.Rider#buyTicket(eg.edu.guc.parkei.utilities
	 * .Ticket)
	 */
	@Override
	public void buyTicket(Ticket ticket) throws WrongTicketException {
		if (!ticket.equals(Ticket.Mini)) {
			throw new WrongTicketException("Kids can only get Mini tickets");
		}
		setTicket(ticket);
	}
}
