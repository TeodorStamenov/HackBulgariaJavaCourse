package oop.task8;

public class Pixel {
	private float red;
	private float green;
	private float blue;
	
	public Pixel(float r, float g, float b) {
		this.red = r;
		this.green = g;
		this.blue = b;
	}
	
	public boolean setRed(float r) {
		this.red = r;
		return true;
	}
	
	public boolean setGreen(float g) {
		this.green = g;
		return true;
	}
	
	public boolean setBlue(float b) {
		this.blue = b;
		return true;
	}
	
	public float getRed() {
		return red;
	}
	
	public float getGreen() {
		return green;
	}
	
	public float getBlue() {
		return blue;
	}
	
	@Override 
	public String toString() {
		return String.format("R-%.2f G-%.2f B-%.2f", getRed(), getGreen(), getBlue());
	}
}
