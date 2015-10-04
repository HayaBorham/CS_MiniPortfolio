package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class LocationException extends CannotBoardException {
	private static final String DEFAULT_LOCATION = "You should go to its location to ride this ride!";
	private String message;

	public LocationException() {
		this.message = super.getMessage() + DEFAULT_LOCATION;
	}

	public LocationException(String message) {
		this.message = super.getMessage() + message;
	}

	public String getMessage() {
		return message;
	}
}
