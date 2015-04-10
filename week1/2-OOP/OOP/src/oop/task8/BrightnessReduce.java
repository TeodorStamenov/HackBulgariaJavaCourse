package oop.task8;

public class BrightnessReduce implements MatrixOperation {

	@Override
	public Pixel withPixel(int x, int y, Pixel[][] matrix) {
		return new Pixel(matrix[x][y].getRed() / 2, matrix[x][y].getRed() / 2, matrix[x][y].getRed() / 2);
	}
	
}
