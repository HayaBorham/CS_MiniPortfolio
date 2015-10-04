package eg.edu.guc.parkei.amusers;

import eg.edu.guc.parkei.exceptions.WrongAgeException;
import eg.edu.guc.parkei.exceptions.WrongTicketException;
import eg.edu.guc.task.Gender;
import eg.edu.guc.parkei.utilities.Ticket;


public class Adult extends Amuser { //OOP feature: inheritance

	//subclass constructor with age check that throws exception when violated
	public Adult(final String name, final int age, final double height) throws WrongAgeException {
		super(name, age, height);
		if (age < 14) {
			throw new WrongAgeException(
					"An amuser younger than 14 years is not considered an adult yet");
		}
		if (age > 60) {
			throw new WrongAgeException(
					"An amuser older than 4 years is not considered an adult");
		}
	}
	
	//constructing Adult attribute Gender (by calling superclass Amuser)
	public Adult(Gender x) {
		
		super(x);
		
	}

	@Override
	public Ticket getTicket() {
		return super.getTicket();
	}

	
	/* (non-Javadoc)
	 * @see eg.edu.guc.parkei.amusers.Rider#buyTicket(eg.edu.guc.parkei.utilities.Ticket)
	 */
	@Override
	public void buyTicket(Ticket ticket) throws WrongTicketException {
		if (!ticket.equals(Ticket.Maxi)) {
			throw new WrongTicketException("Adults can only get Maxi tickets");
		}
		setTicket(ticket);
	}
}
