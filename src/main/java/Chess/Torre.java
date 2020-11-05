package Chess;

public class Torre extends Pieza {
        
    public Torre(Color color) {
        super(color, color == Color.BLANCAS ? "&#9814": "&#9820;");
    }
    
    @Override
    public boolean[][] movimientosValidos(int y, int x, Partida partida) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
