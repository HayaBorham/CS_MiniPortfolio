package eg.edu.guc.santorini.exceptions;

public class InvalidMoveException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidMoveException() {
		
	}
	
	public InvalidMoveException(String e) {
		super(e);
	}
}
