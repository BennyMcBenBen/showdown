<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Listing Episodes</title>
        <link rel="stylesheet" href="../../style/showdown.css" type="text/css" />
    </head>
    <body>
        <div id="allcontent">
            <p><img src="<c:url value='/images/showdown.jpg'/>" alt="Showdown"/></p>
            <p><a href="<c:url value='/admin/show/list'/>">Shows</a> | <a href="<c:url value='/admin/episode/list'/>">Episodes</a> | <a href="<c:url value='/admin/dvd/list'/>">DVDs</a> | <a href="<c:url value='/logout'/>">Logout</a></p>
            <h1>Listing Episodes</h1>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Show</th>
                    <th>Season</th>
                    <th>Episode</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Image</th>
                    <th>Airdate</th>
                    <th>Hulu Embed</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="episode" items="${episodes}">
                    <tr>
                        <td>${episode.id}</td>
                        <td>${episode.show.title}</td>
                        <td>${episode.season}</td>
                        <td>${episode.episode}</td>
                        <td>${episode.title}</td>
                        <td>${episode.description}</td>
                        <td>
                            <c:if test="${episode.image != ''}">
                                <img class="tabular" src="../../images/episode/${episode.image}" alt="${episode.title}"/>
                            </c:if>
                        </td>
                        <td>${airdates[episode]}</td>
                        <td>
                            <c:if test="${episode.huluEmbed != null && episode.huluEmbed != ''}">
                                <a href="<c:url value='watch?id=${episode.id}' />">Watch</a>
                            </c:if>
                        </td>
                        <td><a href="<c:url value='edit?id=${episode.id}' />">Edit</a></td>
                        <td><a href="<c:url value='delete?id=${episode.id}' />">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
            <h2><a href="<c:url value='/admin/episode/new' />">Create Episode</a></h2>

            <!-- footer -->
            <p id="footer">&copy; 2009, Ben</p>
        </div>
    </body>
</html>
