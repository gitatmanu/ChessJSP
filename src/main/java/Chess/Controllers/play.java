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

@WebServlet("/play")
@MultipartConfig
public class play extends HttpServlet 
{
    private static final long serialVersionUID = 1L;     

    public play() 
    {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException     {
        HttpSession session = request.getSession();
        Game game = (Game) session.getAttribute("game");

        PrintWriter out = response.getWriter();    
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String square = request.getParameter("square");
        HashMap send = new HashMap();
        int y = Utils.charToIndex(square.charAt(0));
        int x = Integer.parseInt(String.valueOf(square.charAt(1))) - 1;
	    
        if (game.isValidPlay(y, x))
        {
            Piece[][] modifiedBoard = game.doPlay(y,x);

            send.put("promotion", game.checkPromotion(y, x));
            send.put("state", "valid");
            send.put("modifiedBoard", modifiedBoard);
            send.put("turn", game.getTurn());

            game.alternateTurn();
            game.setPreviousSquare(new int[]{y, x});
            session.setAttribute("game", game);
        }
        else
        {
            send.put("state", "not valid");
        }
        send.put("whiteCemetery", game.getWhiteCemetery());
        send.put("blackCemetery", game.getBlackCemetery());

        out.print(new Gson().toJson(send));
        out.close();
    }
}
