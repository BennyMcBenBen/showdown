<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Error</title>
        <link rel="stylesheet" href="<c:url value='/style/showdown.css'/>" type="text/css" />
    </head>
    <body>
        <div id="allcontent">
            <p><a href="<c:url value='/show/list'/>"><img src="<c:url value='/images/showdown.jpg'/>" alt="Showdown"/></a></p>
            <!-- error message -->
            <p>Error: ${message}.</p>

            <!-- back button -->
            <form class="linkButton" action="<c:url value='${back}.jsp' />" method="get">
                <p><input type="submit" value="Back" /></p>
            </form>
            
            <!-- footer -->
            <p id="footer">&copy; 2009, Ben</p>
        </div>
    </body>
</html>
