package oop.task8;

public class Grayscale implements MatrixOperation {
	private float avg = 0;
	
	@Override
	public Pixel withPixel(int x, int y, Pixel[][] matrix) {
		avg = (matrix[x][y].getRed() + matrix[x][y].getGreen() + matrix[x][y].getBlue()) / 3;
		return new Pixel(avg, avg, avg);
	}
}
