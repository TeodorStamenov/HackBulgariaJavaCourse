package exceptions.task2;

public class ServiceNotAvailableAtTheMoment extends Exception {
	private static String message = "Service is not available at the moment. Please try later.";
	
	public ServiceNotAvailableAtTheMoment() {
		this(message);
	}

	public ServiceNotAvailableAtTheMoment(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
}
