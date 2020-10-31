package Chess;

public class Rey extends Pieza {

        private String ascii = this.getColor() == Color.BLANCAS ? "&#9812;": "&#9818;";
    
    public Rey(Color color) {
        super(color);
    }

    @Override
    public Boolean[][] movimientosValidos(String pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
