package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class OutOfOrderException extends CannotOperateException {
	private static final String DEFAULT_ORDER = "This ride is out of order, you cannot take it.";
	private String message;

	public OutOfOrderException() {
		this.message = DEFAULT_ORDER;
	}

	public OutOfOrderException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
