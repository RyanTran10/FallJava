package inheritance;

public class SarcasticBot extends ChatBot {

	public SarcasticBot() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sayHi() {
		System.out.println("I don't say Hi.");

	}

	@Override
	public void sayBye() {
		System.out.println("Hope to see you again, Jk.");

	}

	@Override
	public void startConversation() {
		System.out.println("Do you like to program? Oh wait, I don't care.");

	}

	@Override
	public void askFirstQuestion() {
		System.out.println("What is your favorite color? Oh wait, I don't care.");

	}

	@Override
	public void askSecondQuestion() {
		System.out.println("What is your favorite food? Oh wait, I don't care.");

	}

	@Override
	public void askThirdQuestion() {
		System.out.println("Who is your best friend? Oh wait, I don't care.");

	}

}
