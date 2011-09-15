<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>${user.nickname}'s Shopping Cart</title>
        <link rel="stylesheet" href="<c:url value='/style/showdown.css'/>" type="text/css" />
    </head>
    <body>
        <div id="allcontent">
            <p><a href="<c:url value='/show/list'/>"><img src="../images/showdown.jpg" alt="Showdown"/></a></p>
            <h1>${user.nickname}'s Shopping Cart</h1>
            <table>
                <tr>
                    <th>Title</th>
                    <th>Price</th>
                    <th></th>
                </tr>
                <c:forEach var="dvd" items="${dvds}">
                    <tr>
                        <td>${dvd.title}</td>
                        <td class="number">$${dvd.price}</td>
                        <td><a href="<c:url value='/cart/remove?id=${dvd.id}' />">Delete</a></td>
                    </tr>
                </c:forEach>
                <tr>
                    <td>Total</td>
                    <td class="number">$${total}</td>
                    <td></td>
                </tr>
            </table>
            <p>
                <input type="button" onclick="parent.location='https://localhost:8443/showdown/shop/payment.jsp'" value="Checkout" />
                <input type="button" onclick="parent.location='/showdown/shop/dvds'" value="Continue Shopping" />
            </p>

            <!-- footer -->
            <p id="footer">&copy; 2009, Ben Zoller</p>
        </div>
    </body>
</html>
