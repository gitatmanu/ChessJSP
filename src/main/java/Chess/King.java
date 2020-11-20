package Chess;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece 
{
    
    public King(Colour colour) 
    {
        super(colour, colour == Colour.WHITE ? "&#9812;": "&#9818;");
    }
    
    @Override
    public boolean[][] validMovements(int y, int x, Game game) 
    {
        boolean[][] board = new boolean[8][8];
        
        List<int[]> absoluteMovements = new ArrayList();
        absoluteMovements.add(new int[]{y-1 , x});
        absoluteMovements.add(new int[]{y-1 , x+1});
        absoluteMovements.add(new int[]{y , x+1});
        absoluteMovements.add(new int[]{y+1 , x+1});
        absoluteMovements.add(new int[]{y+1 , x});
        absoluteMovements.add(new int[]{y+1 , x-1});
        absoluteMovements.add(new int[]{y , x-1});
        absoluteMovements.add(new int[]{y-1 , x-1});
        
        Piece.iterateFixedPositions(y, x, absoluteMovements, game); 

        Piece.insertValidMovements(board, absoluteMovements);
        
        return board;
    }
}
