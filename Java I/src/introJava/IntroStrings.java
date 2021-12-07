package introJava;

public class IntroStrings {

	public static void half(String str) {
		System.out.println(str.substring(str.length()/2));
	}
	
	public static void combineMinusFirst(String str, String str1) {
		System.out.println(str.substring(1) + str1.substring(1));
	}
	
	public static void isAdverb(String str) {
		System.out.println(str.substring(str.length()-2).equals("ly"));
	}
	public static void contains(String str, String str1) {
		System.out.println(str.contains(str1));
	}
	public static void backwards(String str) {
		for(int i = str.length()-1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}
	}
	public static void square(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.substring(i) + str.substring(0, i));
		}
	}
	public static void main(String[] args) {
		square("Hello");
	}
}