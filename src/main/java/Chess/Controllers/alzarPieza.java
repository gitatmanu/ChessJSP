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

@WebServlet("/alzarPieza")
@MultipartConfig
public class alzarPieza extends HttpServlet {
	private static final long serialVersionUID = 1L;     

    public alzarPieza() {
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

	if(partida.getTurno() == partida.getTablero()[y][x].getColor()) {
		boolean[][] movimientosValidos = partida.getTablero()[y][x].movimientosValidos(y,x,partida);
		send.put("movimientosValidos", movimientosValidos);
		out.print(new Gson().toJson(send));
		partida.setCasillaAnterior(new int[]{y, x});
	}
	session.setAttribute("partida", partida);
        out.close();	
	}
}	   
