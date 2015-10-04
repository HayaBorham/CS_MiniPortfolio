package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class WrongAgeException extends AmuserException {
	private static final String DEFAULT_AGE = "Amusers of this type cannot have the specified age.";
	private String message;

	public WrongAgeException() {
		this.message = DEFAULT_AGE;
	}

	public WrongAgeException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
