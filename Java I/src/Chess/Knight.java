package Chess;

import java.awt.Image;
import java.util.ArrayList;

public class Knight extends Piece {

	public Knight(int turn, Image img) {
		super(turn, img);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<int[]> getMoves(Board board, int r, int c) {
		ArrayList<int[]> moves = new ArrayList<int[]>();
		//Top 2
		if(!(r-2 > 7 || r-2 < 0) && !(c-1 > 7 || c-1 < 0) && board.getBoard()[r-2][c-1].getTeam() != getTeam()) {
			moves.add(new int[] {r-2,c-1});
		}
		if(!(r-2 > 7 || r-2 < 0) && !(c+1 > 7 || c+1 < 0) && board.getBoard()[r-2][c+1].getTeam() != getTeam()) {
			moves.add(new int[] {r-2,c+1});
		}
		//Right 2
		if(!(r-1 > 7 || r-1 < 0) && !(c+2 > 7 || c+2 < 0) && board.getBoard()[r-1][c+2].getTeam() != getTeam()) {
			moves.add(new int[] {r-1,c+2});
		}
		if(!(r+1 > 7 || r+1 < 0) && !(c+2 > 7 || c+2 < 0) && board.getBoard()[r+1][c+2].getTeam() != getTeam()) {
			moves.add(new int[] {r+1,c+2});
		}
		//Bottom 2
		if(!(r+2 > 7 || r+2 < 0) && !(c-1 > 7 || c-1 < 0) && board.getBoard()[r+2][c-1].getTeam() != getTeam()) {
			moves.add(new int[] {r+2,c-1});
		}
		if(!(r+2 > 7 || r+2 < 0) && !(c+1 > 7 || c+1 < 0) && board.getBoard()[r+2][c+1].getTeam() != getTeam()) {
			moves.add(new int[] {r+2,c+1});
		}
		//Left 2
		if(!(r-1 > 7 || r-1 < 0) && !(c-2 > 7 || c-2 < 0) && board.getBoard()[r-1][c-2].getTeam() != getTeam()) {
			moves.add(new int[] {r-1,c-2});
		}
		if(!(r+1 > 7 || r+1 < 0) && !(c-2 > 7 || c-2 < 0) && board.getBoard()[r+1][c-2].getTeam() != getTeam()) {
			moves.add(new int[] {r+1,c-2});
		}
		return moves;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean check(int kingr, int kingc, int r, int c, Board board) {
		// gets moves and checks if the king's position is in it
		ArrayList<int[]> moves = new ArrayList<int[]>();
		moves = getMoves(board, r, c);
		for(int[] a: moves) {
			if(a[0] == kingr && a[1] == kingc) {
			return true;
			}
		}
		return false;
	}

}
