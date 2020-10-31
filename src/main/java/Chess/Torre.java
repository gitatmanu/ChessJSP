package Chess;

public class Torre extends Pieza {
    
    private String ascii = this.getColor() == Color.BLANCAS ? "&#9814": "&#9820;";
    
    public Torre(Color color) {
        super(color);
    }
    

    @Override
    public Boolean[][] movimientosValidos(String pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
