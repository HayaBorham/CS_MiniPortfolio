package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class CannotBoardException extends ParkeiException {
	private static final String DEFAULT_RIDE = "You cannot board this ride! ";
	private String message;

	public CannotBoardException() {
		this.message = super.getMessage() + DEFAULT_RIDE;
	}

	public CannotBoardException(String message) {
		this.message = super.getMessage() + message;
	}

	public String getMessage() {
		return message;
	}
}
