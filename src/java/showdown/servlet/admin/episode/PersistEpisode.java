package showdown.servlet.admin.episode;

import showdown.db.ShowdownDB;
import showdown.model.Episode;
import showdown.model.Show;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Creates/updates the episode.
 * @author Ben Zoller
 */
public class PersistEpisode extends HttpServlet {

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
        int showId = Integer.parseInt(request.getParameter("showId"));
        Show show = ShowdownDB.readShow(showId);
        int seasonNo = Integer.parseInt(request.getParameter("season"));
        int episodeNo = Integer.parseInt(request.getParameter("episode"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        String airdateString = request.getParameter("airdate");
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date;
        try {
            date = dateFormat.parse(airdateString);
        } catch (ParseException e) {
            date = new Date();
        }
        Calendar airdate = Calendar.getInstance();
        airdate.setTime(date);
        String huluEmbed = request.getParameter("huluEmbed");

        // build episode object
        Episode episode = new Episode(show, seasonNo, episodeNo, title,
                description, image, airdate, huluEmbed);

        // persist episode
        if (id < 0) {
            // create
            ShowdownDB.createEpisode(episode);
        } else {
            // update
            episode.setId(id);
            ShowdownDB.updateEpisode(episode);
        }

        // redirect to show list
        response.sendRedirect("/showdown/admin/episode/list");
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
