package Chess;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece 
{
    public Queen(Colour colour) 
    {
        super(colour, colour == Colour.WHITE ? "&#9813;": "&#9819;");
    }
    
    @Override
    public boolean[][] validMovements(int y, int x, Game game) 
    {
        boolean[][] board = new boolean[8][8];
        List<int[]> absoluteMovements = new ArrayList();

        Piece.iterateDirection(y, x, y - 1, x + 1, absoluteMovements, game);
        Piece.iterateDirection(y, x, y + 1, x + 1 , absoluteMovements, game);
        Piece.iterateDirection(y, x, y + 1, x - 1, absoluteMovements, game);
        Piece.iterateDirection(y, x, y - 1, x - 1, absoluteMovements, game);
        
        Piece.iterateDirection(y, x, y - 1, x, absoluteMovements, game);
        Piece.iterateDirection(y, x, y + 1, x, absoluteMovements, game);
        Piece.iterateDirection(y, x, y, x - 1, absoluteMovements, game);
        Piece.iterateDirection(y, x, y, x + 1, absoluteMovements, game);   
        
        Piece.insertValidMovements(board, absoluteMovements);

        return board;    
    }

}
