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
        
        // Todos los movimientos posibles si no hubiesen piezas
        List<int[]> movimientosAbsolutos = new ArrayList();
        movimientosAbsolutos.add(new int[]{y-2 , x-1});
        movimientosAbsolutos.add(new int[]{y-2 , x+1});
        movimientosAbsolutos.add(new int[]{y-1 , x-2});
        movimientosAbsolutos.add(new int[]{y-1 , x+2});
        movimientosAbsolutos.add(new int[]{y+1 , x-2});
        movimientosAbsolutos.add(new int[]{y+1 , x+2});
        movimientosAbsolutos.add(new int[]{y+2 , x-1});
        movimientosAbsolutos.add(new int[]{y+2 , x+1});
        
        // Sustracción de movimientos no válidos
        for(Iterator<int[]> iterator = movimientosAbsolutos.iterator(); iterator.hasNext(); ){
            int[] movimiento = iterator.next();
            
            //Si está fuera del tablero
            if(movimiento[0] > 7 || movimiento[0] < 0 || movimiento[1] > 7 || movimiento[1] < 0){
                  iterator.remove();
                  continue;
            }
           
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
