package introJava;

public class Garage {
	private Car[] cars;
	
	public Garage(int n) {
		cars = new Car[n];
	}
	
	public void addCar(int i, String name, int year, int mileage) {
		cars[i] = new Car(mileage, year, name);
	}
	
	public int totalWorth() {
		int total = 0;
		for(Car car : cars) {
			if(car != null)
				total += car.worth();
		}
		return total;
	}
	
	public int averageMileage() {
		int total = 0;
		int count = 0;
		for(Car car : cars) {
			if(car != null) {
				total += car.getMileage();
				count++;
			}
		}
		return count != 0 ? total/count: 0;
	}
	
	public void drive(int i, int n) {
		cars[i].drive(n);
	}

	public static void main(String[] args) {
		Garage g = new Garage(5); 
		g.addCar(0,"Audi", 2020, 14526);
		g.addCar(1,"Audi", 2010, 1526);
		g.addCar(2,"Audi", 2019, 18675);
		g.addCar(3,"Audi", 2020, 17654);
		
		System.out.println(g.averageMileage());
		System.out.println(g.totalWorth());
	}
}