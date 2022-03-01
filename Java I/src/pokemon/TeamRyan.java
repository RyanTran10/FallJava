package pokemon;

import java.util.ArrayList;

public class TeamRyan extends PokeTeam {

	public TeamRyan() {
		super("TeamRyan");
	}

	@Override
	public ArrayList<Pokemon> createTeam() {
		ArrayList<Pokemon> team = new ArrayList<Pokemon>();
		team.add(new Jacob());
		team.add(new Ryan());
		team.add(new James());
		return team;
		//slightly less than 30 mins lv 111
	}

}
