package servlet.paiement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBConnection;
import database.DatabaseAccess;
import model.PaiementCommande;
import model.TypePaiement;

/**
 * Servlet implementation class PayerCommande
 */
@WebServlet("/payer-commande")
public class PayerCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayerCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(null != request.getParameter("idCommande") ) {
			String idCommande = request.getParameter("idCommande");
			
			try(Connection connection = DBConnection.psqlConnection()) {
				PaiementCommande commande = DatabaseAccess.find("SELECT * FROM paiement_commande WHERE idCommande  = '" + idCommande + "'",
						PaiementCommande.class,
						connection)
						.get(0);
				request.setAttribute("commande", commande);
				
				List<TypePaiement> typePaiements = DatabaseAccess.find(new TypePaiement(), connection);
				request.setAttribute("typePaiements", typePaiements);
				
				request.getRequestDispatcher("caisse/payer-commande.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			response.getWriter().print("L'ID du commande doît être envoyer en GET");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
