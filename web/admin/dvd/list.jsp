<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Listing DVDs</title>
        <link rel="stylesheet" href="../../style/showdown.css" type="text/css" />
    </head>
    <body>
        <div id="allcontent">
            <p><img src="<c:url value='/images/showdown.jpg'/>" alt="Showdown"/></p>
            <p><a href="<c:url value='/admin/show/list'/>">Shows</a> | <a href="<c:url value='/admin/episode/list'/>">Episodes</a> | <a href="<c:url value='/admin/dvd/list'/>">DVDs</a> | <a href="<c:url value='/logout'/>">Logout</a></p>
            <h1>Listing DVDs</h1>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Image</th>
                    <th>Price</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="dvd" items="${dvds}">
                    <tr>
                        <td>${dvd.id}</td>
                        <td>${dvd.title}</td>
                        <td>${dvd.description}</td>
                        <td>
                            <c:if test="${dvd.image != ''}">
                                <img src="../../images/dvd/${dvd.image}" alt="${dvd.title}"/>
                            </c:if>
                        </td>
                        <td>${dvd.price}</td>
                        <td><a href="<c:url value='/admin/dvd/edit?id=${dvd.id}' />">Edit</a></td>
                        <td><a href="<c:url value='/admin/dvd/delete?id=${dvd.id}' />">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
            <h2><a href="<c:url value='/admin/dvd/new' />">Create DVD</a></h2>

            <!-- footer -->
            <p id="footer">&copy; 2009, Ben Zoller</p>
        </div>
    </body>
</html>
