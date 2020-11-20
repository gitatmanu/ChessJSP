package Chess;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece 
{    
    public Bishop(Colour color) 
    {
        super(color, color == Colour.WHITE ? "&#9815;": "&#9821;");
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
        
        Piece.insertValidMovements(board, absoluteMovements);

        return board;    
    }
}