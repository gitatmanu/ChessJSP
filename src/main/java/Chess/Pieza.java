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
        
        public static void iterarPeon(int y, int x, Color color, List<int[]> movimientosAbsolutos, Partida partida) {

            int yDiferente = color == Color.BLANCAS ? y - 1 : y + 1;
            int filaDeSalida = color == Color.BLANCAS ? 6 : 1;
                        
            //Si a la izquierda o derecha no es null y color diferente
            if(yDiferente <= 7 && yDiferente >= 0) {
                if ( x - 1 <= 7 && x - 1 >= 0 && partida.getTablero()[yDiferente][x - 1] != null && partida.getTablero()[yDiferente][x - 1].getColor() != partida.getTablero()[y][x].getColor()) {
                    movimientosAbsolutos.add(new int[]{yDiferente, x - 1});
                }
                if (x + 1 <= 7 && x + 1 >= 0 && partida.getTablero()[yDiferente][x + 1] != null && partida.getTablero()[yDiferente][x + 1].getColor() != partida.getTablero()[y][x].getColor()) {
                    movimientosAbsolutos.add(new int[]{yDiferente, x + 1});
                }
            }
            
            // Si está en filasalida o no
            if (filaDeSalida == y) {
                while(yDiferente != y - 3 && yDiferente != y + 3) {
                    if(yDiferente < 0 || yDiferente > 7) {
                        break;
                    }
                    if(partida.getTablero()[yDiferente][x] != null && partida.getTablero()[yDiferente][x].getColor() == partida.getTablero()[y][x].getColor()) {
                       break; 
                    }
                    if(partida.getTablero()[yDiferente][x]
                            != null
                            && partida.getTablero()[yDiferente][x].getColor() != partida.getTablero()[y][x].getColor()) {
                        break;           
                    }
                    if(partida.getTablero()[yDiferente][x] == null) {
                        movimientosAbsolutos.add(new int[]{yDiferente, x});
                    }
                    if(yDiferente < y) {
                        yDiferente--;
                    } else if (yDiferente > y) {
                        yDiferente++;
                    } 
                }
            } else {
                if (yDiferente <= 7 && yDiferente >= 0 && x <= 7 && x >= 0 && partida.getTablero()[yDiferente][x] == null) {
                    movimientosAbsolutos.add(new int[]{yDiferente, x});
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
