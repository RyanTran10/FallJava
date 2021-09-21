package introJava;

public class Sep21Class {
	private String myWord = "hi";
	
	
	public void setWord(String myWord) {
		this.myWord = myWord;
	}

	public void sayWord() {
		
		System.out.println(myWord);
	}
	
	public void sayOtherWord() {
		
		System.out.println("hello");
		
		System.out.println(myWord);
		
	}
	
	public static void main(String[] args) {
		
		Sep21Class runner = new Sep21Class();
		
		runner.sayWord();
		runner.sayOtherWord();
		
	}
	

}
