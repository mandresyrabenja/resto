package servlet.commande;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Effacer la commande actuelle du session HTTP
 */
@WebServlet("/finir-commande")
public class FinirCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FinirCommande() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("idServeur", null);
		session.setAttribute("idCommande", null);
		session.setAttribute("idTable", null);
		
		response.sendRedirect(request.getContextPath() + "/ChoixServeur");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
