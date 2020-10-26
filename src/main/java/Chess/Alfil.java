package Chess;

public class Alfil extends Pieza {

    public Alfil(Color color) {
        super(color);
    }

    public String toString(Color color) {

    return color == Color.BLANCAS ? "&#9815;" : "&#9821;";
    }
}
