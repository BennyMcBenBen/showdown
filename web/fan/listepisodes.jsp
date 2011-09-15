<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Showdown | ${show.title} episodes</title>
        <link rel="stylesheet" href="../style/showdown.css" type="text/css" />
    </head>
    <body>
        <div id="allcontent">
            <p><a href="<c:url value='/show/list'/>"><img src="../images/showdown.jpg" alt="Showdown"/></a></p>
            <c:choose>
                <c:when test="${episodes == null}">
                    <p>No episodes</p>
                </c:when>
                <c:otherwise>

                    <h2>${show.title} episodes</h2>
                    <c:forEach var="episode" items="${episodes}">
                        <h3>${episode.title} (Season ${episode.season} Episode ${episode.episode})</h3>
                        <c:if test="${episode.image != null}">
                            <img class="dvdShop" src="../images/episode/${episode.image}" alt="${episode.title}"/>
                        </c:if>
                        <p>${episode.description}</p>
                        <c:if test="${episode.huluEmbed != null}">
                            <a href="<c:url value='/episode/watch?id=${episode.id}'/>">Watch now</a>
                        </c:if>
                        <br/>
                        <hr/>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
            <a href="<c:url value='/show/list'/>">[Showdown]</a>

            <!-- footer -->
            <p id="footer">&copy; 2009, Ben Zoller</p>
        </div>
    </body>
</html>