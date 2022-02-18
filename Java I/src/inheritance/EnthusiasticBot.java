package inheritance;

public class EnthusiasticBot extends ChatBot {

	public EnthusiasticBot() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sayHi() {
		System.out.println("Hi how are you today!!!!");

	}

	@Override
	public void sayBye() {
		System.out.println("It was fun talking! I hope to see you later");

	}

	@Override
	public void startConversation() {
		System.out.println("Do you like to program?");

	}

	@Override
	public void askFirstQuestion() {
		System.out.println("What is your favorite color? Mine is pink!");

	}

	@Override
	public void askSecondQuestion() {
		System.out.println("What is your favorite food? I don't have one becuase I love all foods!");

	}

	@Override
	public void askThirdQuestion() {
		System.out.println("Who is your best friend? I don't have one because I am friends with everyone!");

	}

}
