package introJava;

public class Car {
	private int mileage;
	private int year;
	private String name;
	
	public Car(int m, int y, String n) {
		mileage = m;
		year = y;
		name = n;
	}
	
	public void drive(int distance) {
		mileage += distance;
	}
	
	public int worth() {
		return year - mileage/500;
	}
	
	public int getMileage() {
		return mileage;
	}
////first, a method called drive. This method takes a parameter distance. When this method is called, the mileage increases by the 
//	distance driven.
////second, a method called worth. This method should return a number representing how much this Car is currently worth. 
//	Come up with a formula to calculate the Car's worth - it should involve how old it is and how many miles it's driven 
//	(this does not need to be an amazing formula).
////finally, a simple method called getMileage. All this method does is return the car's mileage - this is how we'll access 
//	the car's mileage in the other class, since mileage is a private variable.

	public static void main(String[] args) {
	}
}