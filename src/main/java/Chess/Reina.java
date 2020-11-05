package Chess;

public class Reina extends Pieza {
    
    public Reina(Color color) {
        super(color, color == Color.BLANCAS ? "&#9813;": "&#9819;");
    }

    @Override
    public boolean[][] movimientosValidos(int y, int x, Partida partida) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
