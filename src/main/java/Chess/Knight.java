package Chess;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece 
{
    public Knight(Colour colour) 
    {
        super(colour, colour == Colour.WHITE ? "&#9816;": "&#9822;");
    }

    @Override
    public boolean[][] validMovements(int y, int x, Game game) 
    {
        boolean[][] board = new boolean[8][8];
        
        List<int[]> absoluteMovements = new ArrayList();
        absoluteMovements.add(new int[]{y-2 , x-1});
        absoluteMovements.add(new int[]{y-2 , x+1});
        absoluteMovements.add(new int[]{y-1 , x-2});
        absoluteMovements.add(new int[]{y-1 , x+2});
        absoluteMovements.add(new int[]{y+1 , x-2});
        absoluteMovements.add(new int[]{y+1 , x+2});
        absoluteMovements.add(new int[]{y+2 , x-1});
        absoluteMovements.add(new int[]{y+2 , x+1});
              
        Piece.iterateFixedPositions(y, x, absoluteMovements, game); 
        
        Piece.insertValidMovements(board, absoluteMovements);

        return board;
    }
}
