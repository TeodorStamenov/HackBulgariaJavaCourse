package oop.task8;

public class TestPixelProject {

	public static void main(String[] args) {
		Pixel pix = new Pixel(20, 30, 40);
		System.out.println(pix.toString());
		Pixel[][] pixelMatrix = {{pix, pix},{pix, pix}};
		Matrix matrix = new Matrix(pixelMatrix);
		matrix.setPixel(0, 1, new Pixel(160,1,5));
		System.out.println(matrix.toString());
		matrix.operate(new Grayscale());
		System.out.println(matrix.toString());
		matrix.operate(new BrightnessReduce());
		System.out.println(matrix.toString());
	}
}
