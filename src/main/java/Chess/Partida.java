package Chess;
import java.util.ArrayList;

public class Partida {
    
	private Pieza[][] tablero;
	private ArrayList<Pieza> cementerio = new ArrayList<>();
	private Turno turno = Turno.BLANCAS;

	
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
                
		Pieza[][] tablero = new Pieza[8][8]; // Inicializo tablero
		

                tablero[0][0] = new Torre(Color.NEGRAS);
                tablero[0][1] = new Caballo(Color.NEGRAS);
                tablero[0][2] = new Alfil(Color.NEGRAS);
                tablero[0][3] = new Reina(Color.NEGRAS);
                tablero[0][4] = new Rey(Color.NEGRAS);
		tablero[0][5] = new Alfil(Color.NEGRAS);
                tablero[0][6] = new Caballo(Color.NEGRAS);
                tablero[0][7] = new Torre(Color.NEGRAS);
                
                tablero[1][0] = new Peon(Color.NEGRAS);
                tablero[1][1] = new Peon(Color.NEGRAS);
                tablero[1][2] = new Peon(Color.NEGRAS);
                tablero[1][3] = new Peon(Color.NEGRAS);
                tablero[1][4] = new Peon(Color.NEGRAS);
                tablero[1][5] = new Peon(Color.NEGRAS);
                tablero[1][6] = new Peon(Color.NEGRAS);
                tablero[1][7] = new Peon(Color.NEGRAS);
                
                
                tablero[6][0] = new Peon(Color.BLANCAS);
                tablero[6][1] = new Peon(Color.BLANCAS);
                tablero[6][2] = new Peon(Color.BLANCAS);
                tablero[6][3] = new Peon(Color.BLANCAS);
                tablero[6][4] = new Peon(Color.BLANCAS);
                tablero[6][5] = new Peon(Color.BLANCAS);
                tablero[6][6] = new Peon(Color.BLANCAS);
                tablero[6][7] = new Peon(Color.BLANCAS);
                
                tablero[7][0] = new Torre(Color.BLANCAS);
                tablero[7][1] = new Caballo(Color.BLANCAS);
                tablero[7][2] = new Alfil(Color.BLANCAS);
                tablero[7][3] = new Reina(Color.BLANCAS);
                tablero[7][4] = new Rey(Color.BLANCAS);
		tablero[7][5] = new Alfil(Color.BLANCAS);
                tablero[7][6] = new Caballo(Color.BLANCAS);
                tablero[7][7] = new Torre(Color.BLANCAS);
                
                
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

}

enum Turno {
	BLANCAS, NEGRAS;
}
