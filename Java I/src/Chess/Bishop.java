package Chess;

import java.awt.Image;
import java.util.ArrayList;

public class Bishop extends Piece {

	public Bishop(int turn, Image img) {
		super(turn, img);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<int[]> getMoves(Board board, int r, int c) {
		ArrayList<int[]> moves = new ArrayList<int[]>();
		//nw (c- r-)
		for(int i = 1; i < 8; i++) {
			if((r-i < 0 || c-i < 0) || board.getBoard()[r-i][c-i].getTeam() == getTeam()) {
				break;
			} else if (board.getBoard()[r-i][c-i].isEmpty()) {
				moves.add(new int[] {r-i,c-i});
			} else {
				moves.add(new int[] {r-i,c-i});
				break;
			}
		}
//		//se (c+ r+)
		for(int i = 1; i < 8; i++) {
			if((r+i > 7 || c+i > 7 ) || board.getBoard()[r+i][c+i].getTeam() == getTeam()) {
				break;
			} else if (board.getBoard()[r+i][c+i].isEmpty()) {
				moves.add(new int[] {r+i, c+i});
			} else {
				moves.add(new int[] {r+i, c+i});
				break;
			}
		}
//		
//		//ne (c+ r-)
		for(int i = 1; i < 8; i++) {
			if((r-i < 0 || c+i > 7 ) || board.getBoard()[r-i][c+i].getTeam() == getTeam()) {
				break;
			} else if (board.getBoard()[r-i][c+i].isEmpty()) {
				moves.add(new int[] {r-i, c+i});
			} else {
				moves.add(new int[] {r-i, c+i});
				break;
			}
		}
//		//sw (c- r+)
		for(int i = 1; i < 8; i++) {
			if((r+i > 7 || c-i < 0 ) || board.getBoard()[r+i][c-i].getTeam() == getTeam()) {
				break;
			} else if (board.getBoard()[r+i][c-i].isEmpty()) {
				moves.add(new int[] {r+i, c-i});
			} else {
				moves.add(new int[] {r+i, c-i});
				break;
			}
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
