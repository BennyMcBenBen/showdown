package edu.zoller.showdown.servlet.shop;

import edu.zoller.showdown.db.ShowdownDB;
import edu.zoller.showdown.model.Dvd;
import edu.zoller.showdown.model.Episode;
import edu.zoller.showdown.model.User;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Displays all available DVDs.
 * @author Ben Zoller
 */
public class DvdShop extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // read all DVDs
        Collection<Dvd> dvds = ShowdownDB.readAllDvds();
        User user = ShowdownDB.readUser(request.getUserPrincipal().getName());

        // remove DVDs in cart from view
        Collection<Dvd> cart = ShowdownDB.readShoppingCart(user);
        dvds.removeAll(cart);

        // read DVD episodes
        Map<Dvd, Collection<Episode>> dvdEpisodes = new HashMap<Dvd, Collection<Episode>>();
        for (Dvd dvd : dvds) {
            Collection<Episode> episodes = ShowdownDB.readDvdEpisodes(dvd.getId());
            getServletContext().log(episodes.toString());
            dvdEpisodes.put(dvd, episodes);
        }

        int numCartItems = cart.size();
        request.setAttribute("dvds", dvds);
        request.setAttribute("dvdEpisodes", dvdEpisodes);
        request.setAttribute("numCartItems", numCartItems);

        // forward to JSP
        request.getRequestDispatcher("/shop/dvds.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
