package threads.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class OperationsWithPoints {
	private static List<Point> list = new ArrayList<Point>();
	private static Point point;
	private static Random random = new Random();
	private static Map<Point, Point> mapOfPoints = new HashMap<Point, Point>();

	public static List<Point> generatePoints() {
		for (int i = 0; i < 100_000; i++) {
			point = new Point();
			point.setCoordinates(random.nextInt(10_000), random.nextInt(10_000));
			list.add(point);
		}
		return list;
	}

	public static Map<Point, Point> getNearestPoint(List<Point> list)
			throws InterruptedException {
		MyThread t1 = new MyThread(list, 0, 25000, mapOfPoints);
		MyThread t2 = new MyThread(list, 25000, 50000, mapOfPoints);
		MyThread t3 = new MyThread(list, 50000, 75000, mapOfPoints);
		MyThread t4 = new MyThread(list, 75000, list.size(), mapOfPoints);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		return mapOfPoints;
	}

	public static void doCalculation(List<Point> inPoints, int indexFrom,
			int indexTo, Map<Point, Point> outMap) {
		int xd = 0;
		int yd = 0;
		int t = 0;
		double distance = 0;
		for (int i = indexFrom; i < indexTo - 1; i++) {
			boolean flag = false;
			for (int j = i + 1; j < inPoints.size(); j++) {
				xd = list.get(j).getX() - list.get(i).getX();
				yd = list.get(j).getY() - list.get(i).getY();
				if (list.get(i).getX() != list.get(j).getX()
						|| list.get(i).getY() != list.get(j).getY()) {
					distance = Math.sqrt(xd * xd + yd * yd);
					if (distance < list.get(i).getDistanceToNearestPoint()) {
						list.get(i).setDistanceToNearestPoint(distance);
						list.get(j).setDistanceToNearestPoint(distance);
						t = j;
						flag = true;
					}
				}
			}
			if (flag) {
				outMap.put(list.get(i), list.get(t));
				outMap.put(list.get(t), list.get(i));
			}
		}
	}
}
