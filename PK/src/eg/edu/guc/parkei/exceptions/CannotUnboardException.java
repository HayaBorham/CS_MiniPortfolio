package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class CannotUnboardException extends ParkeiException {
	private static final String DEFAULT_UNBOARD = "You are not boarding the ride already!";
	private String message;

	public CannotUnboardException() {
		this.message = DEFAULT_UNBOARD;
	}

	public CannotUnboardException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
