<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">


</head>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">WebSiteName</a>
        </div>
        <ul class="nav navbar-nav">
<li class="active"><a href="<c:url value="/home" />">Home</a></li>            <li><a href="<c:url value="/listFilmView" />">Filmy</a></li>
            	<li class="dropdown">
                <ul class="dropdown-menu">
                    <li><a href="<c:url value="/listFilmView" />" >Lista filmow</a></li>
 			<li><a href="<c:url value="/listSeansView" />" >Lista seansow</a></li>                    	
                </ul>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Moje konto 
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="<c:url value="/myBilets" />" >Moje bilety</a></li>
                    <li><a href="<c:url value="/changePassword" />" >Zmien haslo</a></li>
                </ul>
            </li>
            <c:if test="${pageContext.request.isUserInRole(\"ROLE_ADMIN\")}">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Administracja
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                    	<li><a href="<c:url value="/admin/addFilmView" />" >Dodaj film</a></li>
                    	<li><a href="<c:url value="/admin/addSeansView" />" >Dodaj seans</a></li>
                    	<li><a href="<c:url value="/admin/addSalaView" />" >Dodaj sala</a></li>
                    	<li><a href="<c:url value="/admin/allUsersView" />" >Lista uzytkownikow</a></li>
                        <li><a href="<c:url value="/admin/allTicketsView" />" >Lista biletow</a></li>
                    </ul>
                </li>
            </c:if>
            <li><a href="<c:url value="/logout" />" >Logout</a></li>
        </ul>
    </div>
</nav>
</html>