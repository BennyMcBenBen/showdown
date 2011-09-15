package edu.zoller.showdown.servlet.shop;

import edu.zoller.showdown.db.ShowdownDB;
import edu.zoller.showdown.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Removes an item from the user's shopping cart.
 * @author Ben Zoller
 */
public class RemoveFromCart extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // delete item from cart
        int id = Integer.parseInt(request.getParameter("id"));
        User user = ShowdownDB.readUser(request.getUserPrincipal().getName());
        ShowdownDB.deleteCartItem(user, id);
        int numCartItems = ShowdownDB.readShoppingCart(user).size();

        // redirect to JSP
        if (numCartItems > 0) {
            // if items left in cart, redirect to cart
            response.sendRedirect("/showdown/cart/list");
        } else {
            // if no items in cart, redirect to shop
            response.sendRedirect("/showdown/shop/dvds");
        }
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
