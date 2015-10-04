package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class NoRidersException extends CannotOperateException {
	private static final String DEFAULT_ROUTE = "This ride has no amusers riding yet!";
	private String message;

	public NoRidersException() {
		this.message = DEFAULT_ROUTE;
	}

	public NoRidersException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
