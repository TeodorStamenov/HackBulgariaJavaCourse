package threads.task3;

public class Point {
	private int x;
	private int y;
	private double distance = Integer.MAX_VALUE;
	
	public void setCoordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setDistanceToNearestPoint(double distance) {
		this.distance = distance;
	}
	
	public double getDistanceToNearestPoint() {
		return distance;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("x:" + x + " " + "y:" + y);
		return s.toString();
	}
}
