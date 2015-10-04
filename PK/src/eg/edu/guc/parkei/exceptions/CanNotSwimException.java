package eg.edu.guc.parkei.exceptions;

public class CanNotSwimException extends ParkeiException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public CanNotSwimException() {
		
		super();
		
	}
	
	public CanNotSwimException(String message) {
		
	   super.setMessage(message);
		
	}

}
