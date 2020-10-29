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
import java.sql.Array;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();    
                String casilla = request.getParameter("casilla");
                
                int iCasilla = charToNum(casilla.charAt(0));
                int jCasilla = casilla.charAt(1) - 1;
               
//                partida.getTablero();

                String json = new Gson().toJson((casilla));
		out.println(json);

                out.close();
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
