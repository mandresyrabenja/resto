/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DBConnection;
import database.DatabaseAccess;
import model.Commande;
import model.Plat;
import model.TypePlat;

/**
 *
 * @author Vola
 */
@WebServlet(name = "ListePlat", urlPatterns = {"/ListePlat"})
public class ListePlat extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            if(session.getAttribute("idServeur") == null) {
                Commande commande = new Commande();
                commande.setIdTable(request.getParameter("idTable"));
                commande.setDateCommande(Date.valueOf(LocalDate.now()));
                commande.setAddition(0.0);
                
                String sequenceSQL = "SELECT CONCAT('commande-', nextval('commandeSeq'))";
                try(Connection connection = DBConnection.psqlConnection();
                		Statement statement = connection.createStatement();
                		ResultSet resultSet = statement.executeQuery(sequenceSQL)) {
                	if(resultSet.next()) {
                    	String idCmd = resultSet.getString(1);
                		commande.setIdCommande(idCmd);

                		String insertSQL = "INSERT INTO commande(idcommande, idtable, datecommande, addition) VALUES (?, ?, ?, ?)";
                		try(PreparedStatement pStatement = connection.prepareStatement(insertSQL)) {
                			pStatement.setString(1, commande.getIdCommande());
                			pStatement.setString(2, commande.getIdTable());
                			pStatement.setDate(3, (Date) commande.getDateCommande());
                			pStatement.setDouble(4, commande.getAddition());
                			
                			pStatement.executeUpdate();
                            session.setAttribute("idCommande", commande.getIdCommande());
                		}
                	}
                }
                
                session.setAttribute("idServeur", request.getParameter("idServeur"));
                session.setAttribute("idTable", request.getParameter("idTable"));
            }
            
            String idTypePlat = request.getParameter("idTypePlat");
            Plat[] listePlats = new Plat().getListePlats(idTypePlat);
            TypePlat[] typePlat = new TypePlat().getTypePlat();
            request.setAttribute("listePlats", listePlats);
            request.setAttribute("typePlat", typePlat);
            RequestDispatcher dispat = request.getRequestDispatcher("listePlats.jsp");
            dispat.forward(request,response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ListePlat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ListePlat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
