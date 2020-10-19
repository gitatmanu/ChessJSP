package Chess;
import java.util.ArrayList;

public class Partida {

	private Pieza[][] tablero;
	private ArrayList<Pieza> cementerio = new ArrayList<Pieza>();
	Turno turno = Turno.BLANCAS;

	
	public Partida(Pieza[][] tablero) {
		this.tablero = tablero;
	}
	
	public Pieza[][] getTablero() {
		return this.tablero;
	}

	public ArrayList<Pieza> getCementerio() {
		return this.cementerio;
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

	/*
	public jugada(casillaOrigen, casillaDestino, turno, tablero) {
		
	}
	*/
	/*
	public comprobarMovimientosValidos(casillaOrigen, Tablero) {
		
	}
	*/

	public static void inicializaPartida() {
		
		Partida partida = new Partida(tableroDefault());
		
	}

	public void matarPieza(Pieza jeje) {
		this.getCementerio().add(jeje);
	}

	public static void main(String[] args) {
		System.out.println(tableroDefault());
	}

}

enum Turno {
	BLANCAS, NEGRAS;
}
