package servlet.paiement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBConnection;

/**
 * Servlet implementation class InsertPaiement
 */
@WebServlet("/insert-paiement")
public class InsertPaiement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPaiement() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if( (null != request.getParameter("idCommande")) 
				&& (null != request.getParameter("sommepaye"))
				&& (null != request.getParameter("idtypepaiement")) ) {
			String idCommande = request.getParameter("idCommande");
			double sommePaye = Double.valueOf( request.getParameter("sommepaye") );
			String idTypePaiement = request.getParameter("idtypepaiement");
			
			String sql = "INSERT INTO paiement(idpaiement, idcommande, idtypepaiement, sommepaye, datepaiement) "
						+ " VALUES(nextval('paiementseq'), ?, ?, ?, ?)";
			try(Connection connection = DBConnection.psqlConnection();
					PreparedStatement paiementStatement = connection.prepareStatement(sql)) {
				paiementStatement.setString(1, idCommande);
				paiementStatement.setString(2, idTypePaiement);
				paiementStatement.setDouble(3, sommePaye);
				paiementStatement.setDate(4, Date.valueOf(LocalDate.now()));
				paiementStatement.executeUpdate();
				
				
				response.sendRedirect(request.getContextPath() + "/caisse");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			response.getWriter().print("Donnée incomplet");
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
