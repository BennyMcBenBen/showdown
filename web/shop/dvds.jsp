<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/custom_functions" prefix="z" %>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>DVD Shop</title>
        <link rel="stylesheet" href="<c:url value='/style/showdown.css'/>" type="text/css" />
    </head>
    <body>
        <div id="allcontent">
            <p><a href="<c:url value='/show/list'/>"><img src="../images/showdown.jpg" alt="Showdown"/></a></p>
            <p>
                <c:if test="${numCartItems > 0}">
                    <a href="<c:url value='/cart/list'/>">View Cart (${numCartItems} Items) | </a>
                </c:if>
                <a href="<c:url value='/logout'/>">Logout</a>
            </p>
            <h2>DVD Shop | <a href="<c:url value='/show/list'/>">Shows</a></h2>
            <c:forEach var="dvd" items="${dvds}">
                <c:if test="${dvd.image != ''}">
                    <img class="dvdShop" src="../images/dvd/${dvd.image}" alt="${dvd.title}"/>
                </c:if>
                <h3>${dvd.title}</h3>
                <p>${dvd.description}</p>
                <c:if test="${ z:containsKey(dvdEpisodes, dvd) }">
                    <p>Contains Episodes:</p>
                    <ul>
                        <c:forEach var="episode" items="${dvdEpisodes[dvd]}">
                            <li>${episode.season}x${episode.episode}: ${episode.title}
                                <c:if test="${episode.huluEmbed != null}">
                                    <a href="<c:url value='/episode/watch?id=${episode.id}'/>">[Watch now]</a>
                                </c:if>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>
                <p>$${dvd.price}
                    <input type="button" onclick="parent.location='/showdown/cart/add?id=${dvd.id}'" value="Add To Cart" />
                </p>
                <br/>
            </c:forEach>

            <!-- footer -->
            <p id="footer">&copy; 2009, Ben Zoller</p>
        </div>
    </body>
</html>
