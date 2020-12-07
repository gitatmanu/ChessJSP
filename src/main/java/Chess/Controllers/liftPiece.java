package Chess.Controllers;

import Chess.Game;
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

@WebServlet("liftPiece")
@MultipartConfig
public class liftPiece extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public liftPiece() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Game game = (Game) session.getAttribute("game");

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String square = request.getParameter("square");
        HashMap send = new HashMap();

        int y = Utils.charToIndex(square.charAt(0));
        int x = Integer.parseInt(String.valueOf(square.charAt(1))) - 1;

        if (game.getTurn() == game.getBoard()[y][x].getColour()) {
            boolean[][] validMovements = game.getBoard()[y][x].validMovements(y, x, game);
            send.put("validMovements", validMovements);
            out.print(new Gson().toJson(send));
            game.setPreviousSquare(new int[]{y, x});
        }
        session.setAttribute("game", game);
        out.close();
    }
}
