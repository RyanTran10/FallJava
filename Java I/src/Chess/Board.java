package Chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;

public class Board {
	
	// keeps track of the position of each king. First row is the position of the white king, 
	// second row is the black king.
	private int[][] queenPositions = new int[2][2];

	// represents the entire board - make sure to initialize!.
	private Piece[][] board;
	
	public Board() {
		
		// loads the images into a map
		HashMap<String, Image> images = loadImages();
		
		
//		board[3][7] = new King(1, images.get("BlackKing"));
//		board[3][0] = new King(0, images.get("WhiteKing"));
//		kingPositions[0] = new int[]{3, 0};
//		kingPositions[1] = new int[] {3, 7};
		board[3][7] = new Queen(1, images.get("BlackQueen"));
		queenPositions[1] = new int[]{3, };
		
		// fill in the rest of the chess board here
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(board[i][j] == null) {
					board[i][j] = new Empty();
				}
			}
		}
		
	}
	
	// draws the board. There should be a grid of 8x8 squares, and each piece in their location. 
	// the last clicked piece (curr) should be drawn on a yellow background.
	public void draw(Graphics g, Piece curr) {
		
		int sw = Chess.SQUARE_WIDTH;	// the width of each square on the board
		
		// your code here
		
	}
	
	// moves the piece currently at (r, c) to (newR, newC), filling 
	// in the vacated space with an empty square.
	// returns 0 for a normal move, 1 for a check move, 2 for a checkmate move
	public int move(int r, int c, int newR, int newC) {
		
		if(board[newR][newC].isKing()) {
			board[newR][newC] = board[r][c];
			board[r][c] = new Empty();
			return 2;
		}else {
			board[newR][newC] = board[r][c];
			board[r][c] = new Empty();
			return 0;
		}
		
	}
	
	// determines if the non-current team is in check. 
	public boolean check() {
		d
	}
	
	
	/******** DON'T TOUCH THE BELOW CODE ****************/
	
	// loads all necessary images into a map. Key = piece name, value = corresponding image
	public HashMap<String, Image> loadImages() {
		String[] pieces = {"King", "Queen", "Rook", "Bishop", "Knight", "Pawn"};
		
		HashMap<String, Image> images = new HashMap<String, Image>();
		
		for (String p : pieces) {
			for (String color : new String[] {"Black", "White"}) {
				Image img = Toolkit.getDefaultToolkit().getImage("Images/" + color + p + ".png");	
				images.put(color + p, img.getScaledInstance(Chess.IMG_WIDTH, Chess.IMG_WIDTH, Image.SCALE_SMOOTH));
			}
		}
		return images;
	}
	
	public Piece[][] getBoard() {
		return board;
	}
}
