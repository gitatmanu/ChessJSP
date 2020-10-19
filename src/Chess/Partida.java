package Chess;

public class Partida {

	private Pieza[][] tablero;
	private Pieza[][] cementerio;
	Turno turno = Turno.BLANCAS;
	
	public Partida(Pieza[][] tablero) {
		this.tablero = tablero;
	}
	
	public static Pieza[][] tableroDefault() {

		Pieza[][] tablero = new Peon[8][8];
		for(int i = 0; i < 9; i++) {
			for(int j = 0; i < 9; j++) {
				tablero[i][j] = null;
			}
		}
		return tablero;
	}
	
	public static void main(String[] args) {
		System.out.println(tableroDefault());
	}
	
	public static void inicializaPartida() {
		
		Partida partida = new Partida(tableroDefault());
		
	}

}

enum Turno {
	BLANCAS, NEGRAS;
}
