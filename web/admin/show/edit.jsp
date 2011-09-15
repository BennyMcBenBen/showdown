<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>${action} Show</title>
        <link rel="stylesheet" href="../../style/showdown.css" type="text/css" />
    </head>
    <body>
        <div id="allcontent">
            <!-- header -->
            <p><img src="<c:url value='/images/showdown.jpg'/>" alt="Showdown"/></p>
            <p><a href="<c:url value='/admin/show/list'/>">Shows</a> | <a href="<c:url value='/admin/episode/list'/>">Episodes</a> | <a href="<c:url value='/admin/dvd/list'/>">DVDs</a> | <a href="<c:url value='/logout'/>">Logout</a></p>
            <h1>${action} Show</h1>

            <!-- form -->
            <form action="<c:url value='/admin/show/update' />" method="post">
                <div><input type="hidden" name="id" value="${show.id}"/></div>
                <table>
                    <tr>
                        <td><label for="title">Title</label></td>
                        <td><input type="text" name="title" id="title" value="${show.title}"/></td>
                    </tr>
                    <tr>
                        <td><label for="description">Description</label></td>
                        <td><textarea name="description" id="description" rows="4" cols="50">${show.description}</textarea></td>
                    </tr>
                    <tr>
                        <td><label for="image">Image</label></td>
                        <td><input type="text" name="image" id="image" value="${show.image}"/></td>
                    </tr>
                    <tr>
                        <td><label for="startYear">Start Year</label></td>
                        <td><input type="text" name="startYear" id="startYear" value="${show.startYear}"/></td>
                    </tr>
                    <tr>
                        <td><label for="endYear">End Year</label></td>
                        <td><input type="text" name="endYear" id="endYear" value="${show.endYear}"/></td>
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