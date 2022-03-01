package pokemon;

import java.util.ArrayList;

public class TeamTiffany extends PokeTeam{

	public TeamTiffany() {
		super("Team Tiffany");

	}

	public ArrayList<Pokemon> createTeam() {
		
		ArrayList<Pokemon> myTeam = new ArrayList<Pokemon>();
		
		myTeam.add(new Jiro());
		myTeam.add(new Shiojaki());
		myTeam.add(new Todoroki());
		
		
		return myTeam;
	}

}
