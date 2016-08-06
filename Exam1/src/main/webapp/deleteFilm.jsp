<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>    
    <title>Delete Film</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div>
    	<table>
    <tr>
    <td>film-id</td><td>title</td><td>description</td><td>language</td><td></td>    
    </tr>
    <c:forEach var ="film" items="${filmList}">
    <tr>
    <td>${film.film_id}</td><td>${film.title}</td><td>${film.description}</td>
    <td>${film.language}</td><td><a href="deleteFilm?filmId=${film.film_id}">delete</a></td>    
    </tr>
    </c:forEach>
    </table>
    </div>
  </body>
</html>
