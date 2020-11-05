package Chess;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Torre extends Pieza {
        
    public Torre(Color color) {
        super(color, color == Color.BLANCAS ? "&#9814": "&#9820;");
    }
    
    @Override
    public boolean[][] movimientosValidos(int y, int x, Partida partida) {
        boolean[][] tablero = new boolean[8][8];
        
        // Todos los movimientos posibles si no hubiesen piezas
        List<int[]> movimientosAbsolutos = new ArrayList();
        
        // Sustracción de movimientos no válidos
        for(Iterator<int[]> iterator = movimientosAbsolutos.iterator(); iterator.hasNext(); ){
            int[] movimiento = iterator.next();
            
            
//            if() {
//                
//            }
//            movimientosAbsolutos.add(new int[]{y-2 , x-1});
//
//            
            
            if(partida.getTablero()[movimiento[0]][movimiento[1]] != null) {
              // Si casilla destino tiene pieza del mismo color
              if (partida.getTablero()[movimiento[0]][movimiento[1]].getColor() == this.getColor()){
                  iterator.remove();
                  continue;
              }               
            }
        }
        // Cambio a true de las posiciones restantes válidas
        for(int[] mov:movimientosAbsolutos) {
            tablero[mov[0]][mov[1]] = true;
        }
        return tablero;
    }

}
