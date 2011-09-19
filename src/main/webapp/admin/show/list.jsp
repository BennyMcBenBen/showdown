<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Listing Shows</title>
        <link rel="stylesheet" href="../../style/showdown.css" type="text/css" />
    </head>
    <body>
        <div id="allcontent">
            <p><img src="<c:url value='/images/showdown.jpg'/>" alt="Showdown"/></p>
            <p><a href="<c:url value='/admin/show/list'/>">Shows</a> | <a href="<c:url value='/admin/episode/list'/>">Episodes</a> | <a href="<c:url value='/admin/dvd/list'/>">DVDs</a> | <a href="<c:url value='/logout'/>">Logout</a></p>
            <h1>Listing Shows</h1>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Image</th>
                    <th>Start Year</th>
                    <th>End Year</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="show" items="${shows}">
                    <tr>
                        <td>${show.id}</td>
                        <td>${show.title}</td>
                        <td>${show.description}</td>
                        <td><img src="../../images/show/${show.image}" alt="${show.title}"/></td>
                        <td>${show.startYear}</td>
                        <td>${show.endYear}</td>
                        <td><a href="<c:url value='/admin/show/edit?id=${show.id}' />">Edit</a></td>
                        <td><a href="<c:url value='/admin/show/delete?id=${show.id}' />">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
            <h2><a href="<c:url value='/admin/show/new' />">Create Show</a></h2>

            <!-- footer -->
            <p id="footer">&copy; 2009, Ben</p>
        </div>
    </body>
</html>
