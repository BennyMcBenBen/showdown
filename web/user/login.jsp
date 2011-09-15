<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Showdown | Login</title>
        <link rel="stylesheet" href="<c:url value='/style/showdown.css'/>" type="text/css" />
    </head>
    <body>
        <div id="allcontent">
            <p><a href="<c:url value='/show/list'/>"><img src="<c:url value='/images/showdown.jpg'/>" alt="Showdown"/></a></p>
            <!-- form -->
            <form action="/showdown/j_security_check" method="post">
                <table>
                    <tr>
                        <td><label for="j_username">Email</label></td>
                        <td><input type="text" name="j_username" id="j_username"/></td>
                    </tr>
                    <tr>
                        <td><label for="j_password">Password</label></td>
                        <td><input type="password" name="j_password" id="j_password"/></td>
                    </tr>
                </table>

                <p id="submit">
                    <input type="submit" value="Login" />
                </p>
            </form>

            <!-- footer -->
            <p id="footer">&copy; 2009, Ben Zoller</p>
        </div>
    </body>
</html>