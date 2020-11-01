package Chess;

public class Peon extends Pieza {

    private String ascii = this.getColor() == Color.BLANCAS ? "&#9817;": "&#9823;";
    
    public Peon(Color color) {
        super(color);
    }
    public String getAscii() {
        return this.ascii;
    }
    @Override
    public Boolean[][] movimientosValidos(String pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
