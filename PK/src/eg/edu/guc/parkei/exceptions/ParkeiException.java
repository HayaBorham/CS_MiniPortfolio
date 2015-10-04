package eg.edu.guc.parkei.exceptions;

@SuppressWarnings("serial")
public class ParkeiException extends Exception {

	private static final String DEFAULT_PARKEI =
		"This situation is not allowed in PARKEI.";
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}

	public ParkeiException() {
		this.message = DEFAULT_PARKEI;
	}
	
	public ParkeiException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
