package Chess;

import java.util.ArrayList;
import java.util.List;

public class Caballo extends Pieza {
        
    public Caballo(Color color) {
        super(color, color == Color.BLANCAS ? "&#9816;": "&#9822;");
    }

    @Override
    public Boolean[][] movimientosValidos(String pos) {
        Boolean[][] tablero = new Boolean[8][8];
        
        int posX = pos.charAt(1) - 1;
        int posY = Move.charToNum(pos.charAt(0));
        
        // Todos los movimientos posibles si no hubiesen piezas
        List<int[]> movimientosAbsolutos = new ArrayList();
        movimientosAbsolutos.add(new int[]{posY-2 , posX-1});
        movimientosAbsolutos.add(new int[]{posY-2 , posX+1});
        movimientosAbsolutos.add(new int[]{posY-1 , posX-2});
        movimientosAbsolutos.add(new int[]{posY-1 , posX+2});
        movimientosAbsolutos.add(new int[]{posY+1 , posX-2});
        movimientosAbsolutos.add(new int[]{posY+1 , posX+2});
        movimientosAbsolutos.add(new int[]{posY+2 , posX-1});
        movimientosAbsolutos.add(new int[]{posY+2 , posX+1});
        
        for(int i = 0; i < movimientosAbsolutos.size(); i++) {
            
//            // Si está fuera del tablero
//            if(movimientosAbsolutos.get(i)[0] > 7 || movimientosAbsolutos.get(i)[0] < 0 || movimientosAbsolutos.get(i)[1] > 7 || movimientosAbsolutos.get(i)[1] < 0){
//                movimientosAbsolutos.remove(i);
//            }
//            // Si casilla destino tiene pieza del mismo color
//            if (this.getColor() == partida.getTablero()[movimientosAbsolutos.get(i)[0]][movimientosAbsolutos.get(i)[1]].getColor()){
//                
//            }
            
            
            
        }
        
        
        
        
        return tablero;

    }
}
