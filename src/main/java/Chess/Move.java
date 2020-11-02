package Chess;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Move
 */
@WebServlet("/Move")
@MultipartConfig
public class Move extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Move() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();    
                String casilla = request.getParameter("casilla");
                                
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
                tablero[5][0] = new Caballo(Color.BLANCAS);
                tablero[7][2] = new Alfil(Color.BLANCAS);
                tablero[7][3] = new Reina(Color.BLANCAS);
                tablero[7][4] = new Rey(Color.BLANCAS);
		tablero[7][5] = new Alfil(Color.BLANCAS);
                tablero[7][6] = new Caballo(Color.BLANCAS);
                tablero[7][7] = new Torre(Color.BLANCAS);
                        
                int iCasilla = charToNum(casilla.charAt(0));
                int jCasilla = casilla.charAt(1) - 1;
                
                switch(request.getParameter("clave")) {
                    case "jugada":

//                        if(esJugadaValida()) {
//                            
//                        } else {
//                            
//                        }
                        out.println(new Gson().toJson(tablero));
                        out.close();
                        break;
                    case "alzarPieza":
                        
                        Boolean[][] mov = new Boolean[8][8];  
                        mov[0][0] = false;
                        mov[5][0] = true;
                        mov[5][2] = true;

                        out.println(new Gson().toJson(mov));
                        out.close();
                        break;
                }

	}

        public static int charToNum(char c) {      
            int out = 0;
            switch (c) {
                case 'A':
                    out = 0;
                    break;
                case 'B':
                    out = 1;               
                    break;
                case 'C':
                    out = 2;               
                    break;
                case 'D':
                    out = 3;
                    break;
                case 'E':
                    out = 4;
                    break;
                case 'F':
                    out = 5;
                    break;
                case 'G':
                    out = 5;
                    break;
                case 'H':
                    out = 6;
                    break;  
            }
            return out;
        }
}
