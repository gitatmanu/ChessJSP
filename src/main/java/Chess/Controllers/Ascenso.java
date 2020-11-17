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

@WebServlet("/Ascenso")
@MultipartConfig
public class Ascenso extends HttpServlet {
	private static final long serialVersionUID = 1L;     

    public Ascenso() {
        super();
    }
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Partida partida = (Partida) session.getAttribute("partida");

        PrintWriter out = response.getWriter();    
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

	String piezaElegida = request.getParameter("piezaElegida");
        HashMap send = new HashMap();

	Pieza[][] tablero = partida.ascenderPieza(piezaElegida);
	send.put("ascenso", tablero);

        session.setAttribute("partida", partida);
        out.print(new Gson().toJson(send));
        out.close();
    }
    
}
