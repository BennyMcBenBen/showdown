<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Showdown | Watch ${episode.title}</title>
        <link rel="stylesheet" href="../style/showdown.css" type="text/css" />
    </head>
    <body>
        <div id="allcontent">
            <p><a href="<c:url value='/show/list'/>"><img src="../images/showdown.jpg" alt="Showdown"/></a></p>
            <h2>Watch Episode: <a href="<c:url value='/episode/list?showId=${episode.show.id}'/>">${episode.show.title}</a> ${episode.season}x${episode.episode}: ${episode.title}</h2>
            <object width="512" height="296">
                <param name="movie" value="http://www.hulu.com/embed/${episode.huluEmbed}">
                </param>
                <param name="allowFullScreen" value="true"></param>
                <embed src="http://www.hulu.com/embed/${episode.huluEmbed}"
                       type="application/x-shockwave-flash" allowFullScreen="true"
                       width="512" height="296">
                </embed>
            </object>

            <!-- footer -->
            <p id="footer">&copy; 2009, Ben</p>
        </div>
    </body>
</html>