package Chess;

import java.util.ArrayList;
import java.util.List;

public class Reina extends Pieza {
    
    public Reina(Color color) {
        super(color, color == Color.BLANCAS ? "&#9813;": "&#9819;");
    }
    
    @Override
    public boolean puedeAscender(int y, int x, Partida partida) {
        return false;
    }
    
    @Override
    public boolean[][] movimientosValidos(int y, int x, Partida partida) {
        boolean[][] tablero
                = new boolean[8][8];
        List<int[]> movimientosAbsolutos = new ArrayList();

        Pieza.iterarLado(y, x, y - 1, x + 1, movimientosAbsolutos, partida);
        Pieza.iterarLado(y, x, y + 1, x + 1 , movimientosAbsolutos, partida);
        Pieza.iterarLado(y, x, y + 1, x - 1, movimientosAbsolutos, partida);
        Pieza.iterarLado(y, x, y - 1, x - 1, movimientosAbsolutos, partida);
        
        Pieza.iterarLado(y, x, y - 1, x, movimientosAbsolutos, partida);
        Pieza.iterarLado(y, x, y + 1, x, movimientosAbsolutos, partida);
        Pieza.iterarLado(y, x, y, x - 1, movimientosAbsolutos, partida);
        Pieza.iterarLado(y, x, y, x + 1, movimientosAbsolutos, partida);   
        
        Pieza.insertarValidos(tablero, movimientosAbsolutos);

        return tablero;    
    }

}
