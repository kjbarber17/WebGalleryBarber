<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "editArtworkServlet" method="post">
Title: <input type = "text" name = "title" value="${ArtworkToEdit.title}">
ArtistName: <input type = "text" name = "artistName" value="${ArtworkToEdit.artistName}">
Media: <input type = "text" name = "media" value="${ArtworkToEdit.media}">
Year: <input type = "text" name = "year" value="${ArtworkToEdit.year}">
Value: <input type = "text" name = "value" value="${ArtworkToEdit.value}">
<input type = "hidden" name = "id" value="${ArtworkToEdit.id}">
<input type = "submit" value = "Save Edited Artwork">
</form>
</body>
</html>