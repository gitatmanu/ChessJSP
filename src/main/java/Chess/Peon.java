package Chess;

import java.util.ArrayList;
import java.util.List;

public class Peon extends Pieza 
{
    
    public Peon(Color color) 
    {
        super(color, color == Color.BLANCAS ? "&#9817;": "&#9823;");
    }
    
    @Override
    public boolean puedeAscender(int y, int x, Partida partida) 
    {
        return y == 0 || y == 7;
    }
    
    @Override
    public boolean[][] movimientosValidos(int y, int x, Partida partida) 
    {
        boolean[][] tablero = new boolean[8][8];
        List<int[]> movimientosAbsolutos = new ArrayList();

        Pieza.iterarPeon(y, x, partida.getTablero()[y][x].getColor(), movimientosAbsolutos, partida);
        
        Pieza.insertarValidos(tablero, movimientosAbsolutos);
        
        return tablero;
    }  
}
