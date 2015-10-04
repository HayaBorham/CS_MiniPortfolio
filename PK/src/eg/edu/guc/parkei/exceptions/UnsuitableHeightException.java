package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class UnsuitableHeightException extends CannotBoardException {
	private static final String DEFAULT_HEIGHT = "You are too short for this ride.";
	private String message;

	public UnsuitableHeightException() {
		this.message = super.getMessage() + DEFAULT_HEIGHT;
	}

	public UnsuitableHeightException(String message) {
		this.message = super.getMessage() + message;
	}

	public String getMessage() {
		return message;
	}
}
