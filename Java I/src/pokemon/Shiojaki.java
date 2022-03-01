package pokemon;

public class Shiojaki extends Pokemon{
	public Shiojaki() {
		super("Shiojaki", 3, 120, "Shiojaki.png", new Move[] { new Move("Crucifixion", 3, 15, 4), new Move("Faith's Shield", 3, 12, 0), new Move("Via Dolorosa", 3, 30, 0),  new Move("Normal Attack", 0, 20, 0)});
		// 1050 
		// 2*(total health) + (total damage dealt by all moves) + 30*(number of moves that cause an effect).
	}



}
