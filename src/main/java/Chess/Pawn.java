package Chess;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece 
{
    
    public Pawn(Colour colour) 
    {
        super(colour, colour == Colour.WHITE ? "&#9817;": "&#9823;");
    }
    
    @Override
    public boolean canAscend(int y, int x) 
    {
        return y == 0 || y == 7;
    }
    
    @Override
    public boolean[][] validMovements(int y, int x, Game game) 
    {
        boolean[][] board = new boolean[8][8];
        List<int[]> absoluteMovements = new ArrayList();

        Piece.iteratePawn(y, x, game.getBoard()[y][x].getColour(), absoluteMovements, game);
        
        Piece.insertValidMovements(board, absoluteMovements);
        
        return board;
    }  
}
