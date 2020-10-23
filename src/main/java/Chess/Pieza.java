package Chess;

public abstract class Pieza {
	
	private Color color;
	
	public abstract Boolean hayMovimientoValido();
	public abstract Pieza[][] movimientosValidos();

}

enum Color {
	BLANCAS, NEGRAS;
}