package exceptions.task4;

public class NullKeyException extends IllegalArgumentException {
	private static final String NULL_NOT_ALLOW = "Null is not allow!";
	
	private String message;
	
	public NullKeyException(String message) {
		this.message = message;
	}
	
	public NullKeyException() {
		this(NULL_NOT_ALLOW);
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
