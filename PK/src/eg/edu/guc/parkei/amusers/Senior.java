package eg.edu.guc.parkei.amusers;

import eg.edu.guc.parkei.exceptions.WrongAgeException;
import eg.edu.guc.parkei.exceptions.WrongTicketException;
import eg.edu.guc.task.Gender;
import eg.edu.guc.parkei.utilities.Ticket;

public class Senior extends Amuser { //OOP feature: inheritance

	//subclass constructor with age check that throws exception when violated
	public Senior(final String name, final int age, final double height)
			throws WrongAgeException {
		super(name, age, height);
		if (age < 61) {
			throw new WrongAgeException(
					"An amuser younger than 4 years is not considered a senior yet");
		}
	}
	
	//constructing Senior attribute Gender (by calling superclass Amuser)
	public Senior(Gender x) {

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
			throw new WrongTicketException("Seniors can only get Mini tickets");
		}
		setTicket(ticket);
	}
}
