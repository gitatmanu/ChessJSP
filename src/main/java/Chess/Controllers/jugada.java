package Chess.Controllers;
import Chess.Partida;
import Chess.Pieza;
import Chess.Utils;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.util.HashMap;
import javax.servlet.http.HttpSession;

@WebServlet("/jugada")
@MultipartConfig
public class jugada extends HttpServlet {
	private static final long serialVersionUID = 1L;     

    public jugada() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Partida partida = (Partida) session.getAttribute("partida");

        PrintWriter out = response.getWriter();    
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String casilla = request.getParameter("casilla");
        HashMap send = new HashMap();
        int y = Utils.charToNum(casilla.charAt(0));
        int x = Integer.parseInt(String.valueOf(casilla.charAt(1))) - 1;

	
	if (partida.esJugadaValida(y, x)) {
		Pieza[][] tableroModificado = partida.hacerJugada(y,x);

		send.put("tableroModificado", tableroModificado);
		send.put("ascenso", partida.comprobarAcenso(y, x));
		send.put("estado", "válido");

		partida.cambiarTurno();
		partida.setCasillaAnterior(new int[]{y, x});
		session.setAttribute("partida", partida);
	} else  {
		send.put("estado", "no valido");
	}
	
	out.print(new Gson().toJson(send));
        out.close();
    }	   
}
