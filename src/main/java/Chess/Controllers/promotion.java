package Chess.Controllers;

import Chess.Game;
import Chess.Piece;
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

@WebServlet("/promotion")
@MultipartConfig
public class promotion extends HttpServlet 
{
    private static final long serialVersionUID = 1L;     

    public promotion() 
    {
        super();
    }
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException     {
        HttpSession session = request.getSession();
        Game game = (Game) session.getAttribute("game");

        PrintWriter out = response.getWriter();    
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String chosenPiece = request.getParameter("chosenPiece");
        HashMap send = new HashMap();

        Piece[][] board = game.ascendPiece(chosenPiece);
        send.put("promotion", board);

        session.setAttribute("game", game);
        out.print(new Gson().toJson(send));
        out.close();
    }
}
