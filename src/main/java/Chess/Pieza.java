package Chess;

import java.util.ArrayList;
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
        
        public static void iterar(int y, int x, int yDiferente, int xDiferente, List<int[]> movimientosAbsolutos, Partida partida) { 
            
            while(true) {
                //si sale del array
                if(yDiferente < 0 || yDiferente > 7 || xDiferente < 0 || xDiferente > 7) {
                    break;
                }   
                //si pieza mismo color
                if(partida.getTablero()[yDiferente][xDiferente] != null && partida.getTablero()[yDiferente][xDiferente].getColor() == partida.getTablero()[y][x].getColor()) {
                   break; 
                }
                //si pieza color diferente
                if(partida.getTablero()[yDiferente][xDiferente]
                        != null
                        && partida.getTablero()[yDiferente][xDiferente].getColor() != partida.getTablero()[y][x].getColor()) {
                    movimientosAbsolutos.add(new int[]{yDiferente, xDiferente});
                    break;           
                }
                //si es null
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
