<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>${action} Episode</title>
        <link rel="stylesheet" href="../../style/showdown.css" type="text/css" />
    </head>
    <body>
        <div id="allcontent">
            <!-- header -->
            <p><img src="<c:url value='/images/showdown.jpg'/>" alt="Showdown"/></p>
            <p><a href="<c:url value='/admin/show/list'/>">Shows</a> | <a href="<c:url value='/admin/episode/list'/>">Episodes</a> | <a href="<c:url value='/admin/dvd/list'/>">DVDs</a> | <a href="<c:url value='/logout'/>">Logout</a></p>
            <h1>${action} Episode</h1>

            <!-- form -->
            <form action="<c:url value='/admin/episode/update' />" method="post">
                <div><input type="hidden" name="id" value="${episode.id}"/></div>
                <table>
                    <tr>
                        <td><label for="show">Show</label></td>
                        <td>
                            <select id="show" name="showId">
                                <c:forEach var="show" items="${shows}">
                                    <c:choose>
                                        <c:when test="${episode.show.id == show.id}">
                                            <option value="${show.id}" selected="selected">${show.title}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${show.id}">${show.title}</option></c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="season">Season #</label></td>
                        <td><input type="text" name="season" id="season" value="${episode.season}"/></td>
                    </tr>
                    <tr>
                        <td><label for="episode">Episode #</label></td>
                        <td><input type="text" name="episode" id="episode" value="${episode.episode}"/></td>
                    </tr>
                    <tr>
                        <td><label for="title">Title</label></td>
                        <td><input type="text" name="title" id="title" value="${episode.title}"/></td>
                    </tr>
                    <tr>
                        <td><label for="description">Description</label></td>
                        <td><textarea name="description" id="description" rows="4" cols="50">${episode.description}</textarea></td>
                    </tr>
                    <tr>
                        <td><label for="image">Image</label></td>
                        <td><input type="text" name="image" id="image" value="${episode.image}"/></td>
                    </tr>
                    <tr>
                        <td><label for="airdate">Airdate</label></td>
                        <td><input type="text" name="airdate" id="airdate" value="${airdate}"/></td>
                    </tr>
                    <tr>
                        <td><label for="huluEmbed">Hulu Embed ID</label></td>
                        <td><input type="text" name="huluEmbed" id="huluEmbed" value="${episode.huluEmbed}"/></td>
                    </tr>
                </table>

                <p id="submit">
                    <input type="button" onclick="parent.location='list'" value="Back" />
                    <input type="submit" value="${action}" />
                </p>
            </form>

            <!-- footer -->
            <p id="footer">&copy; 2009, Ben Zoller</p>
        </div>
    </body>
</html>