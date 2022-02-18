package inheritance;

public class DepressedBot extends ChatBot {

	public DepressedBot() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sayHi() {
		System.out.println("I don't care how you are today.");

	}

	@Override
	public void sayBye() {
		System.out.println("I don't want to talk to you ever again");

	}

	@Override
	public void startConversation() {
		System.out.println("I hatae programming what about you.");

	}

	@Override
	public void askFirstQuestion() {
		System.out.println("I don't have a favorite color but if I had to choose one it would be black because death.");

	}

	@Override
	public void askSecondQuestion() {
		System.out.println("I don't have a favorite food I just eat everything.");

	}

	@Override
	public void askThirdQuestion() {
		System.out.println("I don't have friends. Do you?");

	}

}
