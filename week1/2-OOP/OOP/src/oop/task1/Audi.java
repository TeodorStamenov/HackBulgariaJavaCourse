package oop.task1;

public class Audi extends Car{
	
	public Audi() {	
	}
	
	public Audi(String model, int year, int mileage, int horsepower) {
		this.model = model;
		this.yearOfManufacturing = year;
		this.mileage = mileage;
		this.horsepower = horsepower;
	}
	
	@Override
	public void getMileage() {
		System.out.println("Mileage: " + mileage);
	}

	@Override
	public void printData() {
		System.out.println
			("Brand: Audi" + "\nModel: " + model + "\nYear of manufacturing: " 
			+ yearOfManufacturing + "\nMileage: " + mileage + "\nHorsepower: " + horsepower);
	}
}
