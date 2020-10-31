package Chess;

public class Alfil extends Pieza {

    private String ascii = this.getColor() == Color.BLANCAS ? "&#9815;": "&#9821;";

    
    public Alfil(Color color) {
        super(color);
    }


    @Override
    public Boolean[][] movimientosValidos(String pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
