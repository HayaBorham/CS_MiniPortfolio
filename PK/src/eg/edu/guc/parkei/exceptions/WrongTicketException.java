package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class WrongTicketException extends AmuserException {
	private static final String DEFAULT_TICKET = "Amusers of this type cannot get this ticket.";
	private String message;

	public WrongTicketException() {
		this.message = DEFAULT_TICKET;
	}

	public WrongTicketException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
