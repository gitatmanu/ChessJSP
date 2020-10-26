package Chess;

public class Torre extends Pieza {

    public Torre(Color color) {
        super(color);
    }
    
    public String toString(Color color) {
        
        return color == Color.BLANCAS ? "&#9814;" : "&#9820;";
    }

}
