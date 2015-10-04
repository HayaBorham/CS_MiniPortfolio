package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class AlreadyBoardingException extends CannotBoardException {
	private static final String DEFAULT_BOARD = "You are already boarding a ride!";
	private String message;

	public AlreadyBoardingException() {
		this.message = super.getMessage() + DEFAULT_BOARD;
	}

	public AlreadyBoardingException(String message) {
		this.message = super.getMessage() + message;
	}

	public String getMessage() {
		return message;
	}
}
