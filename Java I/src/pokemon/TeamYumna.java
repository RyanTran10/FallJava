package pokemon;

import java.util.ArrayList;

public class TeamYumna extends PokeTeam {
	
	public TeamYumna() {
		super("Team Yumna");
	}
	
	public ArrayList<Pokemon> createTeam() {
		
		ArrayList<Pokemon> team = new ArrayList<Pokemon>();
		team.add(new Pikachu());
		team.add(new Glaceon());
		team.add(new Eevee());
		
		return team;
		
	}
	
}