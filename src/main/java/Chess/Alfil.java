package Chess;

public class Alfil extends Pieza {
    
    public Alfil(Color color) {
        super(color, color == Color.BLANCAS ? "&#9815;": "&#9821;");
    }

    @Override
    public Boolean[][] movimientosValidos(String pos, Partida partida) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
