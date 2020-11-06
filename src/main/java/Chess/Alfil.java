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

        int yArriba
                = y
                - 1;
        while (true) {
            //si sale del array
            if (yArriba
                    < 0
                    || yArriba
                    > 7) {
                break;
            }
            //si pieza mismo color
            if (partida.getTablero()[yArriba][x]
                    != null
                    && partida.getTablero()[yArriba][x].getColor()
                    == partida.getTablero()[y][x].getColor()) {
                break;
            }
            //si pieza color diferente
            if (partida.getTablero()[yArriba][x]
                    != null
                    && partida.getTablero()[yArriba][x].getColor()
                    != partida.getTablero()[y][x].getColor()) {
                movimientosAbsolutos.add(new int[]{yArriba,
                    x});
                break;
            }
            //si es null
            if (partida.getTablero()[yArriba][x]
                    == null) {
                movimientosAbsolutos.add(new int[]{yArriba,
                    x});
            }
            yArriba--;
        }


        // Cambio a true de las posiciones restantes válidas
        for (int[] mov : movimientosAbsolutos) {
            tablero[mov[0]][mov[1]]
                    = true;
        }
        return tablero;    
    }
}
