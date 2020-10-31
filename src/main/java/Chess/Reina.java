package Chess;

public class Reina extends Pieza {

    private String ascii = this.getColor() == Color.BLANCAS ? "&#9813;": "&#9819;";
    
    public Reina(Color color) {
        super(color);
    }

    public String toString(Color color) {

    return color == Color.BLANCAS ? "&#9813;" : "&#9819;";
    }

    @Override
    public Boolean[][] movimientosValidos(String pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
