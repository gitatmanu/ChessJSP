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

    public Move() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                HttpSession session = request.getSession();
                Partida partida = (Partida) session.getAttribute("partida");
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();    
                String casilla = request.getParameter("casilla");
                        
                int y = Utils.charToNum(casilla.charAt(0));
                int x = Integer.parseInt(String.valueOf(casilla.charAt(1))) - 1;
                
                switch(request.getParameter("clave")) {
                    case "jugada":
                        Pieza[][] tableroModificado = partida.hacerJugada(y,x);
                        
                        if (partida.comprobarAcenso(y, x)) {
                            
                            out.println(new Gson().toJson(tableroModificado));
                        }
                        out.println(new Gson().toJson(tableroModificado));
                        break;
                    case "alzarPieza":   
                        boolean[][] movValidos = partida.getTablero()[y][x].movimientosValidos(y,x,partida);
                        out.println(new Gson().toJson(movValidos));
                        break;
                }
                partida.setCasillaAnterior(new int[]{y, x});
                session.setAttribute("partida", partida);
                out.close();
	}
}
