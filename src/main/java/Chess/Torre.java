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
        
        
        //Recorrer hacia arriba
        //Recorrer hacia abajo
        //Recorrer hacia izquierda
        //Recorrer hacia derecha
            //si no sale del array
                //si posición no es null y tiene el mismo color
                    //para
                //si es null 
                    //sigue
                //si no es null y no es el mismo color
                    //añade y para

                    
        
            
       
//            if() {
//                
//            }
//            movimientosAbsolutos.add(new int[]{y-2 , x-1});
//
//            

        // Cambio a true de las posiciones restantes válidas
        for(int[] mov:movimientosAbsolutos) {
            tablero[mov[0]][mov[1]] = true;
        }
        return tablero;
    }
}