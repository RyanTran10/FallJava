package pokemon;

public class Pikachu extends Pokemon {

	public Pikachu() {
		super("Pikachu", 3, 100, "pikachu4.png", new Move[] 
			{new Move("roar", 3, 15, 3),
			new Move("rage", 1, 15, 2),
			new Move("magic powder", 2, 15, 0),
			new Move("low sweep", 1, 15, 4)});

	}
	
	
}