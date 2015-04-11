package exceptions.task2;

public class Service {
	
	public static void userService() throws ServiceNotAvailableAtTheMoment {
		throw new ServiceNotAvailableAtTheMoment();
	}
}
