package Chess;

public class Caballo extends Pieza {

    public Caballo(Color color) {
        super(color);
    }
    
    public String toString(Color color) {

    return color == Color.BLANCAS ? "&#9816;" : "&#9822;";
    }
    

}
