package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class NoRouteException extends CannotOperateException {
	private static final String DEFAULT_ROUTE = "This ride has no definied route yet!";
	private String message;

	public NoRouteException() {
		this.message = DEFAULT_ROUTE;
	}

	public NoRouteException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
