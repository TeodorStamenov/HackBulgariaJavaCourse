package threads.task3;

import java.util.List;
import java.util.Map;

public class MyThread extends Thread {
	private List<Point> list;
	private int indexFrom;
	private int indexTo;
	private Map<Point, Point> outMap;
	
	public MyThread(List<Point> list, int indexFrom, int indexTo, Map<Point, Point> outMap) {
		this.list = list;
		this.indexFrom = indexFrom;
		this.indexTo = indexTo;
		this.outMap = outMap;
	}
	
	@Override
	public void run() {
		OperationsWithPoints.doCalculation(list, indexFrom, indexTo, outMap);
	}
}
