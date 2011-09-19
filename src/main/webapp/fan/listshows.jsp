<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Showdown | Shows</title>
        <link rel="stylesheet" href="../style/showdown.css" type="text/css" />
    </head>
    <body>
        <div id="allcontent">
            <p><a href="<c:url value='/show/list'/>"><img src="../images/showdown.jpg" alt="Showdown"/></a></p>
            <h2>Shows | <a href="<c:url value='/shop/dvds'/>">DVD Shop</a></h2>
            <c:forEach var="show" items="${shows}">
                <c:if test="${show.image != ''}">
                    <a href="<c:url value='/episode/list?showId=${show.id}'/>">
                        <img class="dvdShop" src="../images/show/${show.image}" alt="${show.title}"/>
                    </a>
                </c:if>
                    <h3><a href="<c:url value='/episode/list?showId=${show.id}'/>">${show.title}</a> (${show.startYear}-${show.endYear})</h3>
                <p>${show.description}</p>
                <br/>
            </c:forEach>

            <!-- footer -->
            <p id="footer">&copy; 2009, Ben</p>
        </div>
    </body>
</html>
