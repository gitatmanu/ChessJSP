package Chess;

import java.util.ArrayList;
import java.util.List;

public class Alfil extends Pieza {
    
    public Alfil(Color color) {
        super(color, color == Color.BLANCAS ? "&#9815;": "&#9821;");
    }

    @Override
    public boolean[][] movimientosValidos(int y, int x, Partida partida) {
        boolean[][] tablero
                = new boolean[8][8];
        List<int[]> movimientosAbsolutos = new ArrayList();

        Pieza.iterar(y, x, y - 1, x + 1, movimientosAbsolutos, partida);
        Pieza.iterar(y, x, y + 1, x + 1 , movimientosAbsolutos, partida);
        Pieza.iterar(y, x, y + 1, x - 1, movimientosAbsolutos, partida);
        Pieza.iterar(y, x, y - 1, x - 1, movimientosAbsolutos, partida);       
        
        // Cambio a true de las posiciones restantes válidas
        for (int[] mov : movimientosAbsolutos) {
            tablero[mov[0]][mov[1]]
                    = true;
        }
        return tablero;    
    }
}
