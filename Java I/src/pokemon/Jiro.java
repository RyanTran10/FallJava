package pokemon;

public class Jiro extends Pokemon{	
	public Jiro() {
		super("Jiro", 0, 115, "Jiro.png", new Move[] { new Move("normal Attack", 0, 10, 0), new Move("Counter-Balance", 1, 15, 1), new Move("Heartbeat Distortion ", 0, 20, 3),  new Move("Heartbeat Surround", 2, 25, 0)});
		// 1050 
		// 2*(total health) + (total damage dealt by all moves) + 30*(number of moves that cause an effect).
	}
}
