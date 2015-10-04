package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class FullRideException extends CannotBoardException {
	private static final String DEFAULT_FULL = "There is no place available onboard!";
	private String message;

	public FullRideException() {
		this.message = super.getMessage() + DEFAULT_FULL;
	}

	public FullRideException(String message) {
		this.message = super.getMessage() + message;
	}

	public String getMessage() {
		return message;
	}
}
