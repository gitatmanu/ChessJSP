package Chess;

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
        
}
