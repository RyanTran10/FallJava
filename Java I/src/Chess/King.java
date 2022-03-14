package Chess;

import java.awt.Image;
import java.util.ArrayList;

public class King extends Piece {

	public King(int turn, Image img) {
		super(turn, img);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<int[]> getMoves(Board board, int r, int c) {
		ArrayList<int[]> moves = new ArrayList<int[]>();
		for(int k = -1; k <= 1; k++) {
			for(int l = -1; l <= 1; l++) {
				if(!(k == 0 && l == 0) && !(r+k < 0 || r+k > 8 || c+l < 0 || c+l > 8)) {
					moves.add(new int[] {r+k, c+l});
				}
			}
		}
		return moves;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean isKing() {
		return true;
	}

	@Override
	public boolean check(int kingr, int kingc, int r, int c, Board board) {
		return false;
	}

}
