package Chess;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Caballo extends Pieza {
        
    public Caballo(Color color) {
        super(color, color == Color.BLANCAS ? "&#9816;": "&#9822;");
    }

    @Override
    public boolean[][] movimientosValidos(int y, int x, Partida partida) {
        boolean[][] tablero = new boolean[8][8];
        
        List<int[]> movimientosAbsolutos = new ArrayList();
        movimientosAbsolutos.add(new int[]{y-2 , x-1});
        movimientosAbsolutos.add(new int[]{y-2 , x+1});
        movimientosAbsolutos.add(new int[]{y-1 , x-2});
        movimientosAbsolutos.add(new int[]{y-1 , x+2});
        movimientosAbsolutos.add(new int[]{y+1 , x-2});
        movimientosAbsolutos.add(new int[]{y+1 , x+2});
        movimientosAbsolutos.add(new int[]{y+2 , x-1});
        movimientosAbsolutos.add(new int[]{y+2 , x+1});
              
        Pieza.iterarFijos(y, x, movimientosAbsolutos, partida); 
        
        Pieza.insertarValidos(tablero, movimientosAbsolutos);

        return tablero;
    }
}
