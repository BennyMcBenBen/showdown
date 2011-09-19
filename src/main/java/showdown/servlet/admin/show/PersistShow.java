package showdown.servlet.admin.show;

import showdown.db.ShowdownDB;
import showdown.model.Show;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Creates/updates a show.
 * @author Ben
 */
public class PersistShow extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get parameters
        int id;
        try {
            // update
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            // create
            id = -1;
        }
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        int startYear = Integer.parseInt(request.getParameter("startYear"));
        int endYear = Integer.parseInt(request.getParameter("endYear"));

        // build show object
        Show show = new Show(title, description, image, startYear, endYear);

        // persist show
        if (id < 0) {
            // create
            ShowdownDB.createShow(show);
        } else {
            // update
            show.setId(id);
            ShowdownDB.updateShow(show);
        }

        // redirect to show list
        response.sendRedirect("/showdown/admin/show/list");
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
