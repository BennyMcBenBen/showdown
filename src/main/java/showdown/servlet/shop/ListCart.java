package showdown.servlet.shop;

import showdown.db.ShowdownDB;
import showdown.model.Dvd;
import showdown.model.User;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Lists the items in the user's shopping cart.
 * @author Ben
 */
public class ListCart extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // read shopping cart
        User user = ShowdownDB.readUser(request.getUserPrincipal().getName());
        Collection<Dvd> dvds = ShowdownDB.readShoppingCart(user);
        BigDecimal total = new BigDecimal(0);
        for (Dvd dvd : dvds) {
            total = total.add(dvd.getPrice());
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("dvds", dvds);
        session.setAttribute("total", total);

        // forward to JSP
        request.getRequestDispatcher("/shop/list.jsp").forward(request, response);
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
