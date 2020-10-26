package Chess;

public class Rey extends Pieza {

    public Rey(Color color) {
        super(color);
    }

    public String toString(Color color) {

    return color == Color.BLANCAS ? "&#9812;" : "&#9818;";
    }
    
    
}
