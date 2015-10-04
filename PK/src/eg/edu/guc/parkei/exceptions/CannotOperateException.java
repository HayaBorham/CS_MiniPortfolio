package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class CannotOperateException extends ParkeiException {
	private static final String DEFAULT_OPERATION = "This ride cannot operate!";
	private String message;

	public CannotOperateException() {
		this.message = DEFAULT_OPERATION;
	}

	public CannotOperateException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
