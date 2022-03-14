package Chess;

import java.awt.Image;
import java.util.ArrayList;

public class Rook extends Piece {

	public Rook(int turn, Image img) {
		super(turn, img);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<int[]> getMoves(Board board, int r, int c) {
		ArrayList<int[]> moves = new ArrayList<int[]>();
		//vertical up
		for(int i = r-1; i >= 0; i--) {
			if(board.getBoard()[i][c].isEmpty()) {
				moves.add(new int[] {i,c});
			} else if (board.getBoard()[i][c].getTeam() != getTeam()) {
				moves.add(new int[] {i,c});			
				break;
			}else {
				break;
			}
			}
		//vertical down
		for(int i = r+1; i < 8; i++) {
			if(board.getBoard()[i][c].isEmpty()) {
				moves.add(new int[] {i,c});
			}	else if (board.getBoard()[i][c].getTeam() != getTeam()) {
				moves.add(new int[] {i,c});
				break;
			}else
				break;
			}
		//horizontal left
		for(int i = c-1; i >= 0; i--) {
			if(board.getBoard()[r][i].isEmpty()) {
				moves.add(new int[] {r,i});
			} else if (board.getBoard()[r][i].getTeam() != getTeam()) {
				moves.add(new int[] {r,i});
				break;
			} else
				break;
			}
		//horizontal right
		for(int i = c+1; i < 8; i++) {
			if(board.getBoard()[r][i].isEmpty()) {
				moves.add(new int[] {r,i});
			} else if (board.getBoard()[r][i].getTeam() != getTeam()) {
				moves.add(new int[] {r,i});
				break;
			} else
				break;
			}
		return moves;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	// gets moves and checks if the king's position is in it
	public boolean check(int kingr, int kingc, int r, int c, Board board) {
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
