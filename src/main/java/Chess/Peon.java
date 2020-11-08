package Chess;

import java.util.ArrayList;
import java.util.List;

public class Peon extends Pieza {
    
    public Peon(Color color) {
        super(color, color == Color.BLANCAS ? "&#9817;": "&#9823;");
    }
    
    @Override
    public boolean[][] movimientosValidos(int y, int x, Partida partida) {
        boolean[][] tablero = new boolean[8][8];
        List<int[]> movimientosAbsolutos = new ArrayList();

        if(partida.getTablero()[y][x].getColor() == Color.NEGRAS) {
            //Si arriba es null o color diferente
            if(partida.getTablero()[y + 1][x] == null) {
                movimientosAbsolutos.add(new int[]{y + 1, x});
            }
            //Si es color igual

            //Si a la izquierda o derecha no es null y color diferente
            if(y + 1 <= 7 && y + 1 >= 0 && x - 1 <= 7 && x - 1 >= 0 && partida.getTablero()[y + 1][x - 1] != null && partida.getTablero()[y + 1][x - 1].getColor() != partida.getTablero()[y][x].getColor()) {
                movimientosAbsolutos.add(new int[]{y + 1, x - 1});
            }

            if(y + 1 <= 7 && y + 1 >= 0 && x + 1 <= 7 && x + 1 >= 0 && partida.getTablero()[y + 1][x + 1] != null && partida.getTablero()[y + 1][x + 1].getColor() != partida.getTablero()[y][x].getColor()) {
                movimientosAbsolutos.add(new int[]{y + 1, x + 1});
            }    

            //Si peon está en casilla de salida
        } else {
            //Si arriba es null o color diferente
            if(partida.getTablero()[y - 1][x] == null) {
                movimientosAbsolutos.add(new int[]{y - 1, x});
            }
            //Si es color igual
            
            //Si a la izquierda o derecha no es null y color diferente
            if(y - 1 <= 7 && y - 1 >= 0 && x - 1 <= 7 && x - 1 >= 0 && partida.getTablero()[y - 1][x - 1] != null && partida.getTablero()[y - 1][x - 1].getColor() != partida.getTablero()[y][x].getColor()) {
                movimientosAbsolutos.add(new int[]{y - 1, x - 1});
            }

            if(y - 1 <= 7 && y - 1 >= 0 && x + 1 <= 7 && x + 1 >= 0 && partida.getTablero()[y - 1][x + 1] != null && partida.getTablero()[y - 1][x + 1].getColor() != partida.getTablero()[y][x].getColor()) {
                movimientosAbsolutos.add(new int[]{y - 1, x + 1});
            }    

            //Si peon está en casilla de salida      
        }
        
        
        for (int[] mov : movimientosAbsolutos) {
            tablero[mov[0]][mov[1]]
                    = true;
        }
        
        return tablero;
    }  
}
