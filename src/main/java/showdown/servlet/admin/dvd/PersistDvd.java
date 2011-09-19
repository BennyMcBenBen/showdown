package showdown.servlet.admin.dvd;

import showdown.db.ShowdownDB;
import showdown.model.Dvd;
import showdown.model.Episode;
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Creates/updates a DVD entry.
 * @author Ben
 */
public class PersistDvd extends HttpServlet {
   
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
        BigDecimal price = new BigDecimal(request.getParameter("price"));
        String[] episodeIds = request.getParameterValues("episodes");

        // build dvd object
        Dvd dvd = new Dvd(title, description, image, price);

        // persist dvd
        if (id < 0) {
            // create
            id = ShowdownDB.createDvd(dvd);
            dvd.setId(id);
        } else {
            // update
            dvd.setId(id);
            ShowdownDB.updateDvd(dvd);
            ShowdownDB.deleteDvdEpisodes(id);
        }
        // persist episodes
        for (String episodeId : episodeIds) {
            Episode ep = ShowdownDB.readEpisode(Integer.parseInt(episodeId));
            ShowdownDB.createDvdEpisode(dvd, ep);
        }

        // redirect to dvd list
        response.sendRedirect("/showdown/admin/dvd/list");
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
