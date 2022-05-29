package servlet.commande;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DBConnection;
import database.DatabaseAccess;
import model.commande.PlatCommande;

/**
 * Liste des plats commandés d'une commande
 */
@WebServlet("/liste-commande")
public class ListePlatCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListePlatCommande() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Récuperation de l'ID du commande à partir du session
		HttpSession session = request.getSession();
		if(null != session.getAttribute("idCommande") )  {
			String idCommande = (String) session.getAttribute("idCommande");
			
			// Recupération du liste des plats du commande au base de données
			try(Connection connection = DBConnection.psqlConnection()){
				String sql = String.format("SELECT * FROM plat_commande WHERE idcommande = '%s'", idCommande);
				List<PlatCommande> platsDuCommande = DatabaseAccess.find(sql, PlatCommande.class, connection);
				request.setAttribute("commandes", platsDuCommande);
				
				request.getRequestDispatcher("commande/liste-commande.jsp").forward(request, response);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			response.getWriter().print("L'ID du commande doit être dans le session HTTP");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
