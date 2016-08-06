<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>Show Films</title>
    
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head> 
  <body>
    <table>
    <tr>
    <td>film-id</td><td>title</td><td>description</td><td>language</td>    
    </tr>
    <c:forEach var ="film" items="${filmList}">
    <tr>
    <td>${film.film_id}</td><td>${film.title}</td><td>${film.description}</td><td>${film.language}</td>    
    </tr>
    </c:forEach>
    </table>
  </body>
</html>
