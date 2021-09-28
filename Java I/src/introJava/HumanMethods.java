package introJava;

public class HumanMethods {
//A setAge method, which takes an age as input, and saves it as an instance variable. 
//A setGender method, which takes a character as input ('g' represents a girl, 'b' represents a boy), and saves this character as an instance variable. Why do we need these saved as instance variables??
//A method that determines whether this person can vote. A person can vote once they are 18 years or older. 
//A method that determines whether the person needs a tetanus shot. Humans need tetanus shots once every 4 years (when they are 0, 4, 8, 12, etc...).
//A method that prints out one of three things: if this person is a toddler boy (a toddler is younger than 4), a toddler girl, or not a toddler. 
//A method that determines whether this person gets movie discounts. Senior citizens (above 65) and children (younger than 12) get the discount.
//A method that determines if the person is a teenager. A teenager is between 12 and 18.
//Challenge: Write a method that takes another Human as a parameter, and determines if they can be "teammates". Two humans can be teammates if they are the same gender and within 2 years of each other's age. 
	private int age;
	private char gender;
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public void canVote() {
		if (age >= 18) {
			System.out.println("Can vote!");
		}
		else {
			System.out.println("Can not vote!");
		}
	}
	
	public void needShot() {
		if (((age%4) == 0) || age == 0) {
			System.out.println("You need a shot!");
		}
		else {
			System.out.println("You do not need a shot!");
		}
	}
	
	public void isToddler() {
		if ((age < 4) && (gender == 'b')) {
			System.out.println("Toddler Boy!");
		}
		else if ((age < 4) && (gender == 'g')) {
			System.out.println("Toddler Girl!");
		}
		else {
			System.out.println("Not a toddler!");
		}
	}
	
	public void movieDiscounts() {
		if (age > 65 || age < 12) {
			System.out.println("You get a discount!");
		}
		else {
			System.out.println("No discount for you!");
		}
	}
	
	public void teen() {
		if (age > 12 && age < 18) {
			System.out.println("Teen!");
		}
		else {
			System.out.println("Not a teen!");
		}
	}
	
	public void teammates(int age, char gender) {
		if ((this.gender == gender) && ((this.age - age) <= 2)) {
			System.out.println("You are teammates!");
		}
		else {
			System.out.println("You are not teammates!");
		}
	}
	public static void main(String[] args) {
		HumanMethods runner = new HumanMethods();
		
		
		runner.setAge(16);
		runner.setGender('g');
		runner.canVote();
		runner.needShot();
		runner.isToddler();
		runner.movieDiscounts();
		runner.teen();
		runner.teammates(17, 'g');
		
	}
}
