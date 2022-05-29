/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.plat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Plat;
import model.Recette;


/**
 *
 * @author Vola
 */
@WebServlet(name = "Recette", urlPatterns = {"/Recette"})
public class RecetteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

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
            throws ServletException, IOException, Exception 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String idPlat = request.getParameter("idPlat");
            Plat plat = new Plat().getPlatById(idPlat);
            Recette recette = new Recette().getRecette(idPlat);

            String[] li = recette.getRecette().split(",");
            String element = "";
            for(int i=0;i<li.length;i++){
                element+="<li style='font-size:25px' >"+li[i]+"</li>";
                }

             out.println
             ("<div class='modal-content col-md-12'>"+
             "<div class='modal-header' >"+
                 "<h3 class='modal-title' id='exampleModalLabel'>"+
                 plat.getNomPlat()
                 +"</h3>"+
                 "<button type='button' class='btn-close' data-bs-dismiss='modal' aria-label='Close'></button>"+
                 "</div>"+
                 "<div style='padding-top:25px'>"+
                 "<ul>"+
                         element+
                "</ul>"+
                 "</div>"+
             "</div>"
         );
                
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
            Logger.getLogger(RecetteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RecetteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
