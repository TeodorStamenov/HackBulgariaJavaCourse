package threads.task3;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		List<Point> listOfpoints = OperationsWithPoints.generatePoints();
		Map<Point, Point> map = OperationsWithPoints.getNearestPoint(listOfpoints);
		System.out.println(map.toString());
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime)/1000 + " sec");
	}
}
