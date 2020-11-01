package Chess;

public abstract class Pieza {

        private Color color;
    
        public Pieza(Color color) {
            this.color = color;
        }
        
        
        public Color getColor() {
            return this.color;
        }

	public abstract Boolean[][] movimientosValidos(String pos);

}