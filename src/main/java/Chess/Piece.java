package Chess;

import java.util.Iterator;
import java.util.List;

public abstract class Piece 
{
        private Colour colour;
        private String asciiCode;
        
        public Piece(Colour colour, String asciiCode) 
        {
            this.colour = colour;
            this.asciiCode = asciiCode;
        }
        
        public String getAsciiCode()
        {
            return this.asciiCode;
        }
        
        public Colour getColour() 
        {
            return this.colour;
        }
        
        public abstract boolean[][] validMovements(int y, int x, Game game);
		
        public boolean canAscend(int y, int x)
        {
            return false;
        }
        
        public static void iteratePawn(int y, int x, Colour colour, List<int[]> absoluteMovements, Game game) 
        {
            int yDifferent = colour == Colour.WHITE ? y - 1 : y + 1;
            int exitRow = colour == Colour.WHITE ? 6 : 1;
                        
            if(yDifferent <= 7 && yDifferent >= 0) 
            {
                if ( x - 1 <= 7 && x - 1 >= 0 && game.getBoard()[yDifferent][x - 1] != null && game.getBoard()[yDifferent][x - 1].getColour() != game.getBoard()[y][x].getColour()) 
                {
                    absoluteMovements.add(new int[]{yDifferent, x - 1});
                }
                if (x + 1 <= 7 && x + 1 >= 0 && game.getBoard()[yDifferent][x + 1] != null && game.getBoard()[yDifferent][x + 1].getColour() != game.getBoard()[y][x].getColour()) 
                {
                    absoluteMovements.add(new int[]{yDifferent, x + 1});
                }
            }
            
            if (exitRow == y) 
            {
                while(yDifferent != y - 3 && yDifferent != y + 3) 
                {
                    if(yDifferent < 0 || yDifferent > 7) 
                    {
                        break;
                    }
                    if(game.getBoard()[yDifferent][x] != null && game.getBoard()[yDifferent][x].getColour() == game.getBoard()[y][x].getColour()) 
                    {
                       break; 
                    }
                    if(game.getBoard()[yDifferent][x] != null && game.getBoard()[yDifferent][x].getColour() != game.getBoard()[y][x].getColour()) 
                    {
                        break;           
                    }
                    if(game.getBoard()[yDifferent][x] == null) 
                    {
                        absoluteMovements.add(new int[]{yDifferent, x});
                    }
                    
                    if(yDifferent < y) 
                    {
                        yDifferent--;
                    } else if (yDifferent > y) 
                    {
                        yDifferent++;
                    } 
                }
            } else 
            {
                if (yDifferent <= 7 && yDifferent >= 0 && x <= 7 && x >= 0 && game.getBoard()[yDifferent][x] == null) 
                {
                    absoluteMovements.add(new int[]{yDifferent, x});
                }                
            }
        }
        
        public static void insertValidMovements(boolean[][] board, List<int[]> absoluteMovements) 
        {
            for(int[] mov:absoluteMovements) 
            {
                board[mov[0]][mov[1]] = true;
            }
        }
        
        public static void iterateFixedPositions(int y, int x, List<int[]> absoluteMovements, Game game) 
        {
            for(Iterator<int[]> iterator = absoluteMovements.iterator(); iterator.hasNext(); )
            {
                int[] move = iterator.next();
            
                if(move[0] > 7 || move[0] < 0 || move[1] > 7 || move[1] < 0)
                {
                    iterator.remove();
                    continue;
                }
           
                if(game.getBoard()[move[0]][move[1]] != null) 
                {
                    if (game.getBoard()[move[0]][move[1]].getColour() == game.getBoard()[y][x].getColour()){
                        iterator.remove();
                        continue;
                    }               
                }
            }
        }
        
        public static void iterateDirection(int y, int x, int yDifferent, int xDifferent, List<int[]> absoluteMovements, Game game) 
        {
            while(true) 
            {
                if(yDifferent < 0 || yDifferent > 7 || xDifferent < 0 || xDifferent > 7) 
                {
                    break;
                }   
                
                if(game.getBoard()[yDifferent][xDifferent] != null && game.getBoard()[yDifferent][xDifferent].getColour() == game.getBoard()[y][x].getColour()) 
                {
                   break; 
                }
                
                if(game.getBoard()[yDifferent][xDifferent] != null && game.getBoard()[yDifferent][xDifferent].getColour() != game.getBoard()[y][x].getColour()) 
                {
                    absoluteMovements.add(new int[]{yDifferent, xDifferent});
                    break;           
                }
                
                if(game.getBoard()[yDifferent][xDifferent] == null) 
                {
                    absoluteMovements.add(new int[]{yDifferent, xDifferent});
                }
               
                if(yDifferent < y) 
                {
                    yDifferent--;
                } else if (yDifferent > y) 
                {
                    yDifferent++;
                }
                if(xDifferent < x) 
                {
                    xDifferent--;
                } else if (xDifferent > x) 
                {
                    xDifferent++;
                }    
            }
        }
}
