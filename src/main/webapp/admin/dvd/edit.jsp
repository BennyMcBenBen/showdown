<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/custom_functions" prefix="z" %>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>${action} DVD</title>
        <link rel="stylesheet" href="<c:url value='/style/showdown.css'/>" type="text/css" />
    </head>
    <body>
        <div id="allcontent">
            <!-- header -->
            <p><img src="<c:url value='/images/showdown.jpg'/>" alt="Showdown"/></p>
            <p><a href="<c:url value='/admin/show/list'/>">Shows</a> | <a href="<c:url value='/admin/episode/list'/>">Episodes</a> | <a href="<c:url value='/admin/dvd/list'/>">DVDs</a> | <a href="<c:url value='/logout'/>">Logout</a></p>
            <h1>${action} DVD</h1>

            <!-- form -->
            <form action="<c:url value='/admin/dvd/update' />" method="post">
                <div><input type="hidden" name="id" value="${dvd.id}"/></div>
                <table>
                    <tr>
                        <td><label for="title">Title</label></td>
                        <td><input type="text" name="title" id="title" value="${dvd.title}"/></td>
                    </tr>
                    <tr>
                        <td><label for="description">Description</label></td>
                        <td><textarea name="description" id="description" rows="4" cols="30">${dvd.description}</textarea></td>
                    </tr>
                    <tr>
                        <td><label for="image">Image</label></td>
                        <td><input type="text" name="image" id="image" value="${dvd.image}"/></td>
                    </tr>
                    <tr>
                        <td><label for="price">Price ($)</label></td>
                        <td><input type="text" name="price" id="price" value="${dvd.price}"/></td>
                    </tr>
                    <tr>
                        <td><label for="episodes">Episodes</label></td>
                        <td>
                            <select name="episodes" id="episodes" multiple="multiple">
                                <c:forEach var="episode" items="${episodes}">
                                    <c:choose>
                                        <c:when test="${ z:contains( dvd.episodes, episode ) }">
                                            <option value="${episode.id}" selected="selected">
                                                ${episode.show.title} ${episode.season}x${episode.episode}: ${episode.title}
                                            </option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${episode.id}">
                                                ${episode.show.title} ${episode.season}x${episode.episode}: ${episode.title}
                                            </option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>

                <p id="submit">
                    <input type="button" onclick="parent.location='list'" value="Back" />
                    <input type="submit" value="${action}" />
                </p>
            </form>

            <!-- footer -->
            <p id="footer">&copy; 2009, Ben</p>
        </div>
    </body>
</html>