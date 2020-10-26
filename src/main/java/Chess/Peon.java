package Chess;

public class Peon extends Pieza {

    public Peon(Color color) {
        super(color);
    }

    public String toString(Color color) {

    return color == Color.BLANCAS ? "&#9817;" : "&#9823;";
    }

}
