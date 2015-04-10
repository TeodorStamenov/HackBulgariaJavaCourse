package oop.task8;

public class Matrix {
	private Pixel[][] matrix;
	
	public Matrix(Pixel[][] matrix){
		this.matrix = matrix;
	}
	
	public void operate (MatrixOperation op) {
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[x].length; y++) {
				matrix[x][y] = op.withPixel(x, y, matrix);
			}
		}
	}
	
	public boolean setPixel(int x, int y, Pixel pixel) {
		this.matrix[x][y] = pixel;
		return true;
	}
	
	public Pixel getPixel(int x, int y) {
		return matrix[x][y];
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[x].length; y++) {
				str.append(getPixel(x, y).toString());
				str.append("|");
			}
			str.append("\n");
		}
		return str.toString();
	}
}
