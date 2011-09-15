<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Payment Confirmation</title>
        <link rel="stylesheet" href="../style/showdown.css" type="text/css" />
    </head>
    <body>
        <div id="allcontent">
            <p><a href="<c:url value='/show/list'/>"><img src="../images/showdown.jpg" alt="Showdown"/></a></p>
            <p><a href="<c:url value='/logout'/>">Logout</a></p>

            <h1>Payment Confirmation</h1>

            <table>
                <tr>
                    <th>Title</th>
                    <th>Price</th>
                </tr>
                <c:forEach var="dvd" items="${dvds}">
                    <tr>
                        <td>${dvd.title}</td>
                        <td class="number">$${dvd.price}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td>Total</td>
                    <td class="number">$${total}</td>
                </tr>
            </table>

            <br />

            <table>
                <tr>
                    <td>Credit Card Type</td>
                    <td>${purchase.creditCardType}</td>
                </tr>
                <tr>
                    <td>Credit Card Number</td>
                    <td>Ends with ${purchase.creditCardPostfix}</td>
                </tr>
                <tr>
                    <td>Credit Card Expiration Date</td>
                    <td>${expirationDate}</td>
                </tr>
                <tr>
                    <td>Billing Name</td>
                    <td>${purchase.billingName}</td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td>${purchase.address}</td>
                </tr>
                <tr>
                    <td>City</td>
                    <td>${purchase.city}</td>
                </tr>
                <tr>
                    <td>State</td>
                    <td>${purchase.state}</td>
                </tr>
                <tr>
                    <td>Zip Code</td>
                    <td>${purchase.zip}</td>
                </tr>
            </table>
            <br/>
            <input type="button" onclick="parent.location='/showdown/shop/dvds'" value="Back to the Shop" />

            <!-- footer -->
            <p id="footer">&copy; 2009, Ben Zoller</p>
        </div>
    </body>
</html>