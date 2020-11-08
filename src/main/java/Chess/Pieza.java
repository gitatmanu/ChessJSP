package Chess;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Pieza {

        private Color color;
        private String ascii;
        
        public Pieza(Color color, String ascii) {
            this.color = color;
            this.ascii = ascii;
        }
        
        public String getAscii(){return this.ascii;}
        
        public Color getColor() {return this.color;}
        
        public abstract boolean[][] movimientosValidos(int y, int x, Partida partida);
        
        public static void iterarPeonBlancas(int y, int x, List<int[]> movimientosAbsolutos, Partida partida) {

            //Si a la izquierda o derecha no es null y color diferente
            if(y - 1 <= 7 && y - 1 >= 0) {

                if ( x - 1 <= 7 && x - 1 >= 0 && partida.getTablero()[y - 1][x - 1] != null && partida.getTablero()[y - 1][x - 1].getColor() != partida.getTablero()[y][x].getColor()) {
                    movimientosAbsolutos.add(new int[]{y - 1, x - 1});
                }

                if (x + 1 <= 7 && x + 1 >= 0 && partida.getTablero()[y - 1][x + 1] != null && partida.getTablero()[y - 1][x + 1].getColor() != partida.getTablero()[y][x].getColor()) {
                    movimientosAbsolutos.add(new int[]{y - 1, x + 1});
                }
            }
        }
        
        public static void insertarValidos(boolean[][] tablero, List<int[]> movimientosAbsolutos) {
            for(int[] mov:movimientosAbsolutos) {
                tablero[mov[0]][mov[1]] = true;
            }
        }
        
        public static void iterarFijos(int y, int x, List<int[]> movimientosAbsolutos, Partida partida) {
            for(Iterator<int[]> iterator = movimientosAbsolutos.iterator(); iterator.hasNext(); ){
                int[] movimiento = iterator.next();
            
                if(movimiento[0] > 7 || movimiento[0] < 0 || movimiento[1] > 7 || movimiento[1] < 0){
                    iterator.remove();
                    continue;
                }
           
                if(partida.getTablero()[movimiento[0]][movimiento[1]] != null) {
                    if (partida.getTablero()[movimiento[0]][movimiento[1]].getColor() == partida.getTablero()[y][x].getColor()){
                        iterator.remove();
                        continue;
                    }               
                }
            }
        }
        
        public static void iterarLado(int y, int x, int yDiferente, int xDiferente, List<int[]> movimientosAbsolutos, Partida partida) { 
            
            while(true) {
                if(yDiferente < 0 || yDiferente > 7 || xDiferente < 0 || xDiferente > 7) {
                    break;
                }   
                
                if(partida.getTablero()[yDiferente][xDiferente] != null && partida.getTablero()[yDiferente][xDiferente].getColor() == partida.getTablero()[y][x].getColor()) {
                   break; 
                }
                
                if(partida.getTablero()[yDiferente][xDiferente]
                        != null
                        && partida.getTablero()[yDiferente][xDiferente].getColor() != partida.getTablero()[y][x].getColor()) {
                    movimientosAbsolutos.add(new int[]{yDiferente, xDiferente});
                    break;           
                }
                
                if(partida.getTablero()[yDiferente][xDiferente] == null) {
                    movimientosAbsolutos.add(new int[]{yDiferente, xDiferente});
                }
               
                
                if(yDiferente < y) {
                    yDiferente--;
                } else if (yDiferente > y) {
                    yDiferente++;
                }
                if(xDiferente < x) {
                    xDiferente--;
                } else if (xDiferente > x) {
                    xDiferente++;
                }    
            }
        }
}
