package Chess;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Rey extends Pieza {
    
    public Rey(Color color) {
        super(color, color == Color.BLANCAS ? "&#9812;": "&#9818;");
    }
    
    @Override
    public boolean puedeAscender(int y, int x, Partida partida) {
        return false;
    }
    
    @Override
    public boolean[][] movimientosValidos(int y, int x, Partida partida) {
        boolean[][] tablero = new boolean[8][8];
        
        List<int[]> movimientosAbsolutos = new ArrayList();
        movimientosAbsolutos.add(new int[]{y-1 , x});
        movimientosAbsolutos.add(new int[]{y-1 , x+1});
        movimientosAbsolutos.add(new int[]{y , x+1});
        movimientosAbsolutos.add(new int[]{y+1 , x+1});
        movimientosAbsolutos.add(new int[]{y+1 , x});
        movimientosAbsolutos.add(new int[]{y+1 , x-1});
        movimientosAbsolutos.add(new int[]{y , x-1});
        movimientosAbsolutos.add(new int[]{y-1 , x-1});
        
        Pieza.iterarFijos(y, x, movimientosAbsolutos, partida); 

        Pieza.insertarValidos(tablero, movimientosAbsolutos);
        
        return tablero;
    }
}
