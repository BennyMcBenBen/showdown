package edu.zoller.showdown.servlet.shop;

import edu.zoller.showdown.db.ShowdownDB;
import edu.zoller.showdown.model.CreditCardType;
import edu.zoller.showdown.model.Dvd;
import edu.zoller.showdown.model.Purchase;
import edu.zoller.showdown.model.User;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Processes the payment information, purchases all items in the user's shopping
 * cart, and redirects the user to a receipt page.
 * @author Ben Zoller
 */
public class Checkout extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = null;

        // get parameters
        String cardType = request.getParameter("cardType");
        CreditCardType type = CreditCardType.valueOf(cardType);
        String cardNumber = request.getParameter("cardNumber");
        String billingName = request.getParameter("name");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");

        int cardMonth = 0;
        try {
            cardMonth = Integer.parseInt(request.getParameter("cardMonth"));
        } catch (NumberFormatException e) {
            // redirect to error page
            dispatcher = setupErrorPage(request, "Invalid month");
            dispatcher.forward(request, response);
        }
        int cardYear = 0;
        try {
            cardYear = Integer.parseInt(request.getParameter("cardYear"));
        } catch (NumberFormatException e) {
            // redirect to error page
            dispatcher = setupErrorPage(request, "Invalid year");
            dispatcher.forward(request, response);
        }

        Calendar today = Calendar.getInstance(); // today's date
        Calendar expirationDate = new GregorianCalendar(cardYear, cardMonth - 1, 1);

        // validate credit card number
        if (cardNumber == null || cardNumber.length() == 0) {
            dispatcher = setupErrorPage(request, "Card number cannot be blank");
            dispatcher.forward(request, response);
        } else if (!cardNumber.matches("^\\d+$")) {
            dispatcher = setupErrorPage(request, "Card number can only contain digits with no spaces");
            dispatcher.forward(request, response);
        } else if (!isValid(cardNumber, type)) {
            dispatcher = setupErrorPage(request, "Invalid card number");
            dispatcher.forward(request, response);
        } else if (expirationDate.compareTo(today) < 0) {
            // redirect to error page
            dispatcher = setupErrorPage(request, "Credit card is expired");
            dispatcher.forward(request, response);
        } else if (billingName == null || billingName.length() == 0) {
            dispatcher = setupErrorPage(request, "Billing name cannot be blank");
            dispatcher.forward(request, response);
        } else if (address == null || address.length() == 0) {
            dispatcher = setupErrorPage(request, "Address cannot be blank");
            dispatcher.forward(request, response);
        } else if (city == null || city.length() == 0) {
            dispatcher = setupErrorPage(request, "City cannot be blank");
            dispatcher.forward(request, response);
        } else if (state == null || state.length() == 0) {
            dispatcher = setupErrorPage(request, "State cannot be blank");
            dispatcher.forward(request, response);
        } else if (zip == null || zip.length() == 0) {
            dispatcher = setupErrorPage(request, "Zip code cannot be blank");
            dispatcher.forward(request, response);
        } else if (dispatcher == null) {
            String postfix = cardNumber.substring(cardNumber.length() - 4, cardNumber.length());
            Collection<Dvd> dvds = (Collection<Dvd>) request.getSession().getAttribute("dvds");
            Purchase purchase = new Purchase(type, postfix, expirationDate, billingName, address, city, state, zip, dvds);
            request.getSession().setAttribute("purchase", purchase);

            // delete shopping cart
            User user = ShowdownDB.readUser(request.getUserPrincipal().getName());
            ShowdownDB.deleteShoppingCart(user);

            // set attributes
            DateFormat dateFormat = new SimpleDateFormat("MM/yy");
            request.getSession().setAttribute("expirationDate", dateFormat.format(expirationDate.getTime()));

            // redirect to receipt JSP
            response.sendRedirect("http://localhost/showdown/shop/receipt.jsp");
        }
    }

    /**
     * Validates a credit card number.
     * @param number credit card number
     * @param type credit card type
     * @return true if the credit card number is valid
     */
    private boolean isValid(String number, CreditCardType type) {
        // I got these checks from Wikipedia
        switch (type) {
            case MASTERCARD:
                if (number.length() != 16 ||
                        Integer.parseInt(number.substring(0, 2)) < 51 ||
                        Integer.parseInt(number.substring(0, 2)) > 55) {
                    return false;
                }

                break;

            case VISA:
                if ((number.length() != 13 && number.length() != 16) ||
                        Integer.parseInt(number.substring(0, 1)) != 4) {
                    return false;
                }

                break;

            case DISCOVER:
                if (number.length() != 16 ||
                        Integer.parseInt(number.substring(0, 1)) != 6) {
                    return false;
                }

                break;
        }
// not bothering to do Luhn validation

        return true;
    }

    /**
     * Sets up information needed for error page.
     * @param request request
     * @param message error message
     * @return error request dispatcher
     */
    private RequestDispatcher setupErrorPage(HttpServletRequest request,
            String message) {
        ServletContext servletContext = getServletContext();
        String error = "/error.jsp";
        request.setAttribute("message", message);
        request.setAttribute("back", "/shop/payment");
        return servletContext.getRequestDispatcher(error);
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
            throws ServletException,
            IOException {
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
            throws ServletException,
            IOException {
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
