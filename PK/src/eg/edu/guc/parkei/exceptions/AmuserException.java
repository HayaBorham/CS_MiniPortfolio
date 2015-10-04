package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class AmuserException extends ParkeiException {
	private static final String DEFAULT_AMUSER = "You are trying to misuse Amuser!.";
	private String message;

	public AmuserException() {
		this.message = DEFAULT_AMUSER;
	}

	public AmuserException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
