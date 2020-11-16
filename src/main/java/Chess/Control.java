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
import java.util.HashMap;
import javax.servlet.http.HttpSession;

@WebServlet("/Control")
@MultipartConfig
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;     

    public Control() {
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

        switch(request.getParameter("clave")) {
            case "jugada":
                Pieza[][] tableroModificado = partida.hacerJugada(y,x);

                send.put("tableroModificado", tableroModificado);
                send.put("ascenso", partida.comprobarAcenso(y, x));
                break;
            case "alzarPieza":   
                boolean[][] movimientosValidos = partida.getTablero()[y][x].movimientosValidos(y,x,partida);

                send.put("movimientosValidos", movimientosValidos);
                break;
            case "ascenso":
                String piezaElegida = request.getParameter("piezaElegida");
                Pieza[][] tablero = partida.ascenderPieza(piezaElegida);
                
                send.put("ascenso", tablero);
                break;
        }

        partida.setCasillaAnterior(new int[]{y, x});
        session.setAttribute("partida", partida);
        out.print(new Gson().toJson(send));
        out.close();
    }
}
