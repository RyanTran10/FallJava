package Chess;

import java.awt.Image;
import java.util.ArrayList;

public class Queen extends Piece {

	public Queen(int turn, Image img) {
		super(turn, img);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<int[]> getMoves(Board board, int r, int c) {
		ArrayList<int[]> moves = new ArrayList<int[]>();
		for(int i = 0 ; i < 8; i++) {
			//horizontal moves
			if(i != c)
				moves.add(new int[] {r, i});
			// verticle moves
			if(i != r)
				moves.add(new int[] {i, c});
			// diagonal moves
			if(i != r && i != c)
				moves.add(new int[] {i, i});
			// other diagonals
			if(i != r && 8 - i != c)
				moves.add(new int[] {i, 8-i});
		}
		return moves;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean check(int kingr, int kingc, int r, int c, Board board) {
		ArrayList<int[]> moves = new ArrayList<int[]>();
		moves = getMoves(board, r, c);
		if(moves.contains(new int[] {kingr, kingc}))
			return true;
		return false;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
