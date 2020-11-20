package Chess;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece 
{
        
    public Rook(Colour colour) 
    {
        super(colour, colour == Colour.WHITE ? "&#9814": "&#9820;");
    }
    
    @Override
    public boolean[][] validMovements(int y, int x, Game game) 
    {
        boolean[][] board = new boolean[8][8];        
        List<int[]> absoluteMovements = new ArrayList();
   
        Piece.iterateDirection(y, x, y - 1, x, absoluteMovements, game);
        Piece.iterateDirection(y, x, y + 1, x, absoluteMovements, game);
        Piece.iterateDirection(y, x, y, x - 1, absoluteMovements, game);
        Piece.iterateDirection(y, x, y, x + 1, absoluteMovements, game);
        
        Piece.insertValidMovements(board, absoluteMovements);

        return board;
    }
}