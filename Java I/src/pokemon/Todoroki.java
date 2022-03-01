package pokemon;

public class Todoroki extends Pokemon{
	public Todoroki() {
		super("Todoroki", 1, 100, "Todoroki.png", new Move[] { new Move("Flashfire Fist", 1, 20, 3), new Move("Flashfreeze Heatwave", 1, 28, 0), new Move("Heaven-Piercing Ice Wall ", 2, 10, 1),  new Move("Wall of Flames", 1, 25, 0)});
		// 1050 
		// 2*(total health) + (total damage dealt by all moves) + 30*(number of moves that cause an effect).
	}



}
