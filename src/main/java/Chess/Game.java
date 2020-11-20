package Chess;
import java.util.ArrayList;

public class Game
{

	private Piece[][] board;
	private ArrayList<Piece> cemetery = new ArrayList<>();
	private Colour turn = Colour.WHITE;
        private int[] previousSquare;
        
	public Game(Piece[][] tablero) 
        {
            this.board = tablero;
        }
        
	public Colour getTurn() 
        {
            return this.turn;
        }
	
        public void setPreviousSquare(int[] square) 
        {
            this.previousSquare = square;
        }
        
	public Piece[][] getBoard() 
        {
            return this.board;
        }

	public int[] getPreviousSquare() 
        {
            return this.previousSquare;
        }
        
	public ArrayList<Piece> getCemetery() 
        {
            return this.cemetery;
        }
	
	public void alternateTurn() 
        {
		this.turn = this.turn == Colour.WHITE ? Colour.BLACK : Colour.WHITE;
	}
	
        public static Piece[][] defaultBoardSet() 
        {
                
		Piece[][] board = new Piece[8][8]; // Inicializo board
		
                board[0][0] = new Rook(Colour.BLACK);
                board[0][1] = new Knight(Colour.BLACK);
                board[0][2] = new Bishop(Colour.BLACK);
                board[0][3] = new Queen(Colour.BLACK);
                board[0][4] = new King(Colour.BLACK);
		board[0][5] = new Bishop(Colour.BLACK);
                board[0][6] = new Knight(Colour.BLACK);
                board[0][7] = new Rook(Colour.BLACK);
                
                board[1][0] = new Pawn(Colour.BLACK);
                board[1][1] = new Pawn(Colour.BLACK);
                board[1][2] = new Pawn(Colour.BLACK);
                board[1][3] = new Pawn(Colour.BLACK);
                board[1][4] = new Pawn(Colour.BLACK);
                board[1][5] = new Pawn(Colour.BLACK);
                board[1][6] = new Pawn(Colour.BLACK);
                board[1][7] = new Pawn(Colour.BLACK);
                
                
                board[6][0] = new Pawn(Colour.WHITE);
                board[6][1] = new Pawn(Colour.WHITE);
                board[6][2] = new Pawn(Colour.WHITE);
                board[6][3] = new Pawn(Colour.WHITE);
                board[6][4] = new Pawn(Colour.WHITE);
                board[6][5] = new Pawn(Colour.WHITE);
                board[6][6] = new Pawn(Colour.WHITE);
                board[6][7] = new Pawn(Colour.WHITE);
                
                board[7][0] = new Rook(Colour.WHITE);
                board[7][1] = new Knight(Colour.WHITE);
                board[7][2] = new Bishop(Colour.WHITE);
                board[7][3] = new Queen(Colour.WHITE);
                board[7][4] = new King(Colour.WHITE);
		board[7][5] = new Bishop(Colour.WHITE);
                board[7][6] = new Knight(Colour.WHITE);
                board[7][7] = new Rook(Colour.WHITE);
		
                return board;
	}
        
        public boolean checkPromotion(int y, int x) 
        {
            return this.board[y][x].canAscend(y, x);
        }
        
	public boolean isValidPlay(int y, int x) 
        {
		boolean[][] validMovements = new boolean[8][8];
		validMovements = board[previousSquare[0]][previousSquare[1]].validMovements(previousSquare[0], previousSquare[1], this);
		
		return validMovements[y][x] == true;
	}
	
        public Piece[][] doPlay(int y, int x) 
        {
            boolean[][] validMovements = new boolean[8][8];
            validMovements = board[previousSquare[0]][previousSquare[1]].validMovements(previousSquare[0], previousSquare[1], this);
            
            if(validMovements[y][x] == true) 
            {
                if(board[y][x] != null) 
                {
                    sendToCemetery(board[y][x]);
                }
                
                board[y][x] = board[previousSquare[0]][previousSquare[1]];
                board[previousSquare[0]][previousSquare[1]] = null;

            }
            return board;
        }
        
        public Piece[][] ascendPiece(String chosenSquare) 
        {
            Piece piece = null;
	    
            switch(chosenSquare) 
            {
                case "Queen":
                    piece = new Queen(board[previousSquare[0]][previousSquare[1]].getColour());
                    break;
                    
                case "Knight":
                    piece = new Knight(board[previousSquare[0]][previousSquare[1]].getColour());
                    break;
                
                case "Bishop":
                    piece = new Bishop(board[previousSquare[0]][previousSquare[1]].getColour());
                    break;
                    
                case "Rook":
                    piece = new Rook(board[previousSquare[0]][previousSquare[1]].getColour());
                    break;      
            }
            
            this.board[previousSquare[0]][previousSquare[1]] = piece;
            return this.board;
        }
        
	public void sendToCemetery(Piece piece) 
        {
            cemetery.add(piece);
        }    
}