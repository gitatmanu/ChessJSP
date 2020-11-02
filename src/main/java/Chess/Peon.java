package Chess;

public class Peon extends Pieza {
    
    public Peon(Color color) {
        super(color, color == Color.BLANCAS ? "&#9817;": "&#9823;");
    }
    
    @Override
    public Boolean[][] movimientosValidos(String pos, Partida partida) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
}
