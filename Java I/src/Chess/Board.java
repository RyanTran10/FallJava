package Chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.Toolkit;
import java.util.Arrays;
import java.util.HashMap;

public class Board {
	
	// keeps track of the position of each king. First row is the position of the white king, 
	// second row is the black king.
	private int[][] kingPositions = new int[2][2];

	// represents the entire board - make sure to initialize!.
	private Piece[][] board = new Piece[8][8];
	
	public Board() {
		
		// loads the images into a map
		HashMap<String, Image> images = loadImages();
		
		
		for(int i = 0; i < 8; i++) {
			board[i][6] = new Pawn(1, images.get("BlackPawn"));
			board[i][1] = new Pawn(0, images.get("WhitePawn"));
		}
		//setting up all of the pieces
		
		board[4][7] = new King(1, images.get("BlackKing"));
		kingPositions[1] = new int[] {4,7};
		board[4][0] = new King(0, images.get("WhiteKing"));
		kingPositions[0] = new int[] {4,0};
		
		board[3][7] = new Queen(1, images.get("BlackQueen"));
		board[3][0] = new Queen(0, images.get("WhiteQueen"));
		
		board[0][7] = new Rook(1, images.get("BlackRook"));
		board[7][7] = new Rook(1, images.get("BlackRook"));
		board[0][0] = new Rook(0, images.get("WhiteRook"));
		board[7][0] = new Rook(0, images.get("WhiteRook"));
		
		board[2][7] = new Bishop(1, images.get("BlackBishop"));
		board[5][7] = new Bishop(1, images.get("BlackBishop"));
		board[2][0] = new Bishop(0, images.get("WhiteBishop"));
		board[5][0] = new Bishop(0, images.get("WhiteBishop"));
		
		board[1][7] = new Knight(1, images.get("BlackKnight"));
		board[6][7] = new Knight(1, images.get("BlackKnight"));
		board[1][0] = new Knight(0, images.get("WhiteKnight"));
		board[6][0] = new Knight(0, images.get("WhiteKnight"));
		
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
		// draws the background of the board and draws the pictures
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				g.setColor(r%2 == c%2 ? Color.white: Color.blue);
				if(board[c][r] == curr) {
					g.setColor(Color.yellow);
				}
				g.fillRect(r*sw, c*sw, sw, sw);
				board[c][r].draw(g, 5+r*sw, 5+c*sw);
			}
		}
		
	}
	
	// moves the piece currently at (r, c) to (newR, newC), filling 
	// in the vacated space with an empty square.
	// returns 0 for a normal move, 1 for a check move, 2 for a checkmate move
	public int move(int r, int c, int newR, int newC) {
		// ends the game if it is a king that is taken
		if(board[newR][newC].isKing()) {
			board[newR][newC] = board[r][c];
			board[r][c] = new Empty();
			return 2;
		}else {
			//if moving the king updates the king positions
			if(board[r][c].isKing()) {
				kingPositions[board[r][c].getTeam()] = new int[] {newR, newC};
			}
			board[newR][newC] = board[r][c];
			board[r][c] = new Empty();
			return check() ? 1:0;
		}
		
	}
	
	// determines if either team is in check. 
	public boolean check() {
		// checks if any piece puts either king into check
		for(int r = 0; r < 8; r++) {
			for(int c = 0; c < 8; c++) {
				int opp = (board[r][c].getTeam()+1)%2;
				if(board[r][c].check(kingPositions[opp][0], kingPositions[opp][1], r, c, this)) {
					return true;
				}
			}
		}
		return false;
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
