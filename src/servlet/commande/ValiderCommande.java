package servlet.commande;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DBConnection;

/**
 * Servlet implementation class ValiderCommande
 */
@WebServlet("/valider-commande")
public class ValiderCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ValiderCommande() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récuperation de l'ID du commande à partir du session HTTP
		HttpSession session = request.getSession();
		if( null != session.getAttribute("idCommande") ) {
			String idCommande = (String) session.getAttribute("idCommande");
			
			// Marquer le commande comme validé
			String sql = "UPDATE detailscommande SET idetat = 1 WHERE idcommande = ?";
			try(Connection connection = DBConnection.psqlConnection(); 
					PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.setString(1, idCommande);
				preparedStatement.executeUpdate();
			

				// Affichage du message de success
				request.getRequestDispatcher("commande/commande-valide.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			response.getWriter().print("L'ID du commande à valider doît être stôcké dans le session HTTP");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}