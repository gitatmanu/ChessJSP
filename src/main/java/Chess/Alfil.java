package Chess;

import java.util.ArrayList;
import java.util.List;

public class Alfil extends Pieza 
{    
    public Alfil(Color color) 
    {
        super(color, color == Color.BLANCAS ? "&#9815;": "&#9821;");
    }

    @Override
    public boolean[][] movimientosValidos(int y, int x, Partida partida) 
    {
        boolean[][] tablero = new boolean[8][8];
        List<int[]> movimientosAbsolutos = new ArrayList();

        Pieza.iterarLado(y, x, y - 1, x + 1, movimientosAbsolutos, partida);
        Pieza.iterarLado(y, x, y + 1, x + 1 , movimientosAbsolutos, partida);
        Pieza.iterarLado(y, x, y + 1, x - 1, movimientosAbsolutos, partida);
        Pieza.iterarLado(y, x, y - 1, x - 1, movimientosAbsolutos, partida);       
        
        Pieza.insertarValidos(tablero, movimientosAbsolutos);

        return tablero;    
    }
}