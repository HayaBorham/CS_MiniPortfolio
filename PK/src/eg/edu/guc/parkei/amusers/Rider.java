package eg.edu.guc.parkei.amusers;

import eg.edu.guc.parkei.exceptions.WrongTicketException;
import eg.edu.guc.parkei.utilities.Ticket;

public interface Rider {
	Ticket getTicket();

	/**
	 * @param ticket
	 * @throws WrongTicketException
	 * 
	 *             A Rider can buy a ticket that corresponds to their age
	 *             category. Either the Rider succeeds in buying the ticket or
	 *             an Exception is thrown.
	 */
	void buyTicket(Ticket ticket) throws WrongTicketException;
}
