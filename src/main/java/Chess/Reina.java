package Chess;

import java.util.ArrayList;
import java.util.List;

public class Reina extends Pieza {
    
    public Reina(Color color) {
        super(color, color == Color.BLANCAS ? "&#9813;": "&#9819;");
    }

    @Override
    public boolean[][] movimientosValidos(int y, int x, Partida partida) {
        boolean[][] tablero
                = new boolean[8][8];
        List<int[]> movimientosAbsolutos = new ArrayList();

        int yArriba = y - 1;
        int xDerecha = x + 1;
        while (true) {
            //si sale del array
            if (yArriba
                    < 0
                    || yArriba
                    > 7 || xDerecha
                    < 0
                    || xDerecha
                    > 7) {
                break;
            }
            //si pieza mismo color
            if (partida.getTablero()[yArriba][xDerecha]
                    != null
                    && partida.getTablero()[yArriba][xDerecha].getColor()
                    == partida.getTablero()[y][x].getColor()) {
                break;
            }
            //si pieza color diferente
            if (partida.getTablero()[yArriba][xDerecha]
                    != null
                    && partida.getTablero()[yArriba][xDerecha].getColor()
                    != partida.getTablero()[y][x].getColor()) {
                movimientosAbsolutos.add(new int[]{yArriba,
                    xDerecha});
                break;
            }
            //si es null
            if (partida.getTablero()[yArriba][xDerecha]
                    == null) {
                movimientosAbsolutos.add(new int[]{yArriba,
                    xDerecha});
            }
            yArriba--;
            xDerecha++;
        }
        
        int yAbajo = y + 1;
        xDerecha = x + 1;
        while (true) {
            //si sale del array
            if (yAbajo
                    < 0
                    || yAbajo
                    > 7 || xDerecha
                    < 0
                    || xDerecha
                    > 7) {
                break;
            }
            //si pieza mismo color
            if (partida.getTablero()[yAbajo][xDerecha]
                    != null
                    && partida.getTablero()[yAbajo][xDerecha].getColor()
                    == partida.getTablero()[y][x].getColor()) {
                break;
            }
            //si pieza color diferente
            if (partida.getTablero()[yAbajo][xDerecha]
                    != null
                    && partida.getTablero()[yAbajo][xDerecha].getColor()
                    != partida.getTablero()[y][x].getColor()) {
                movimientosAbsolutos.add(new int[]{yAbajo,
                    xDerecha});
                break;
            }
            //si es null
            if (partida.getTablero()[yAbajo][xDerecha]
                    == null) {
                movimientosAbsolutos.add(new int[]{yAbajo,
                    xDerecha});
            }
            yAbajo++;
            xDerecha++;
        }
        
        yAbajo = y + 1;
        int xIzquierda = x - 1;
        while (true) {
            //si sale del array
            if (yAbajo
                    < 0
                    || yAbajo
                    > 7 || xIzquierda
                    < 0
                    || xIzquierda
                    > 7) {
                break;
            }
            //si pieza mismo color
            if (partida.getTablero()[yAbajo][xIzquierda]
                    != null
                    && partida.getTablero()[yAbajo][xIzquierda].getColor()
                    == partida.getTablero()[y][x].getColor()) {
                break;
            }
            //si pieza color diferente
            if (partida.getTablero()[yAbajo][xIzquierda]
                    != null
                    && partida.getTablero()[yAbajo][xIzquierda].getColor()
                    != partida.getTablero()[y][x].getColor()) {
                movimientosAbsolutos.add(new int[]{yAbajo,
                    xIzquierda});
                break;
            }
            //si es null
            if (partida.getTablero()[yAbajo][xIzquierda]
                    == null) {
                movimientosAbsolutos.add(new int[]{yAbajo,
                    xIzquierda});
            }
            yAbajo++;
            xIzquierda--;
        }          

        yArriba = y - 1;
        xIzquierda = x - 1;
        while (true) {
            //si sale del array
            if (yArriba
                    < 0
                    || yArriba
                    > 7 || xIzquierda
                    < 0
                    || xIzquierda
                    > 7) {
                break;
            }
            //si pieza mismo color
            if (partida.getTablero()[yArriba][xIzquierda]
                    != null
                    && partida.getTablero()[yArriba][xIzquierda].getColor()
                    == partida.getTablero()[y][x].getColor()) {
                break;
            }
            //si pieza color diferente
            if (partida.getTablero()[yArriba][xIzquierda]
                    != null
                    && partida.getTablero()[yArriba][xIzquierda].getColor()
                    != partida.getTablero()[y][x].getColor()) {
                movimientosAbsolutos.add(new int[]{yArriba,
                    xIzquierda});
                break;
            }
            //si es null
            if (partida.getTablero()[yArriba][xIzquierda]
                    == null) {
                movimientosAbsolutos.add(new int[]{yArriba,
                    xIzquierda});
            }
            yArriba--;
            xIzquierda--;
        }
        
      yArriba = y - 1;
        while(true) {
            //si sale del array
            if(yArriba < 0 || yArriba > 7) {
                break;
            }   
            //si pieza mismo color
            if(partida.getTablero()[yArriba][x] != null && partida.getTablero()[yArriba][x].getColor() == partida.getTablero()[y][x].getColor()) {
               break; 
            }
            //si pieza color diferente
            if(partida.getTablero()[yArriba][x]
                    != null
                    && partida.getTablero()[yArriba][x].getColor() != partida.getTablero()[y][x].getColor()) {
                movimientosAbsolutos.add(new int[]{yArriba, x});
                break;           
            }
            //si es null
            if(partida.getTablero()[yArriba][x] == null) {
                movimientosAbsolutos.add(new int[]{yArriba, x});
            }
            yArriba--;
        }
        
        yAbajo = y + 1;
        while (true) {
            //si sale del array
            if (yAbajo
                    < 0
                    || yAbajo
                    > 7) {
                break;
            }
            //si pieza mismo color
            if (partida.getTablero()[yAbajo][x]
                    != null
                    && partida.getTablero()[yAbajo][x].getColor()
                    == partida.getTablero()[y][x].getColor()) {
                break;
            }
            //si pieza color diferente
            if (partida.getTablero()[yAbajo][x]
                    != null && partida.getTablero()[yAbajo][x].getColor()
                    != partida.getTablero()[y][x].getColor()) {
                movimientosAbsolutos.add(new int[]{yAbajo,
                    x});
                break;
            }
            //si es null
            if (partida.getTablero()[yAbajo][x]
                    == null) {
                movimientosAbsolutos.add(new int[]{yAbajo,
                    x});
            }
            yAbajo++;
        }

        xIzquierda = x - 1;
        while (true) {
            //si sale del array
            if (xIzquierda
                    < 0
                    || xIzquierda
                    > 7) {
                break;
            }
            //si pieza mismo color
            if (partida.getTablero()[y][xIzquierda]
                    != null
                    && partida.getTablero()[y][xIzquierda].getColor()
                    == partida.getTablero()[y][x].getColor()) {
                break;
            }
            //si pieza color diferente
            if (partida.getTablero()[y][xIzquierda]
                    != null
                    && partida.getTablero()[y][xIzquierda].getColor()
                    != partida.getTablero()[y][x].getColor()) {
                movimientosAbsolutos.add(new int[]{y,
                    xIzquierda});
                break;
            }
            //si es null
            if (partida.getTablero()[y][xIzquierda]
                    == null) {
                movimientosAbsolutos.add(new int[]{y,
                    xIzquierda});
            }
            xIzquierda--;
        }
        
        xDerecha = x + 1;
        while (true) {
            //si sale del array
            if (xDerecha
                    < 0
                    || xDerecha
                    > 7) {
                break;
            }
            //si pieza mismo color
            if (partida.getTablero()[y][xDerecha]
                    != null
                    && partida.getTablero()[y][xDerecha].getColor()
                    == partida.getTablero()[y][x].getColor()) {
                break;
            }
            //si pieza color diferente
            if (partida.getTablero()[y][xDerecha]
                    != null
                    && partida.getTablero()[y][xDerecha].getColor()
                    != partida.getTablero()[y][x].getColor()) {
                movimientosAbsolutos.add(new int[]{y,
                    xDerecha});
                break;
            }
            //si es null
            if (partida.getTablero()[y][xDerecha]
                    == null) {
                movimientosAbsolutos.add(new int[]{y,
                    xDerecha});
            }
            xDerecha++;
        }      
        
        // Cambio a true de las posiciones restantes válidas
        for (int[] mov : movimientosAbsolutos) {
            tablero[mov[0]][mov[1]]
                    = true;
        }
        return tablero;    
    }

}
