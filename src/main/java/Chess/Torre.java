package Chess;

import java.util.ArrayList;
import java.util.List;

public class Torre extends Pieza 
{
        
    public Torre(Color color) 
    {
        super(color, color == Color.BLANCAS ? "&#9814": "&#9820;");
    }
    
    @Override
    public boolean[][] movimientosValidos(int y, int x, Partida partida) 
    {
        boolean[][] tablero = new boolean[8][8];        
        List<int[]> movimientosAbsolutos = new ArrayList();
   
        Pieza.iterarLado(y, x, y - 1, x, movimientosAbsolutos, partida);
        Pieza.iterarLado(y, x, y + 1, x, movimientosAbsolutos, partida);
        Pieza.iterarLado(y, x, y, x - 1, movimientosAbsolutos, partida);
        Pieza.iterarLado(y, x, y, x + 1, movimientosAbsolutos, partida);
        
        Pieza.insertarValidos(tablero, movimientosAbsolutos);

        return tablero;
    }
}