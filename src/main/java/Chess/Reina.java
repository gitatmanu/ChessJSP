package Chess;

public class Reina extends Pieza {

    public Reina(Color color) {
        super(color);
    }

    public String toString(Color color) {

    return color == Color.BLANCAS ? "&#9813;" : "&#9819;";
    }

}
