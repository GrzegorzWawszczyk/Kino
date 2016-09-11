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
            <li class="active"><a href="/">Home</a></li>
            <li><a href="<c:url value="/listFilmView" />">Filmy</a></li>
            <!--<li class="dropdown">
                 <a class="dropdown-toggle" data-toggle="dropdown" href="#">Filmy
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="<c:url value="/listFilmView" />" >Lista filmow</a></li>
                    <c:if test="${!admin}">
                    <li><a href="<c:url value="/myBilets" />" >Zarezerwowane filmy</a></li>
                    </c:if>

                    <li><a href="#">Dodac film</a></li>
                    <li><a href="#">Page 1-3</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Seanse
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="<c:url value="/listSeansView" />" >Lista seansow</a></li>
                    <c:if test="${pageContext.request.isUserInRole(\"ROLE_ADMIN\")}">
                        <li><a href="<c:url value="/listSeansView" />" >Dodaj seans</a></li>
                    </c:if>
                    <li><a href="#">Page 1-3</a></li>
                </ul>
            </li>-->
            <c:if test="${pageContext.request.isUserInRole(\"ROLE_ADMIN\")}">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Administracja
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                    	<li><a href="<c:url value="/admin/addFilmView" />" >Dodaj film</a></li>
                    	<li><a href="<c:url value="/admin/addSeansView" />" >Dodaj seans</a></li>
                    	<li><a href="<c:url value="/admin/addSalaView" />" >Dodaj salę</a></li>
                    	<li><a href="<c:url value="/admin/allTicketsView" />" >Lista użytkowników</a></li>
                        <li><a href="<c:url value="/admin/allTicketsView" />" >Lista biletow</a></li>
                    </ul>
                </li>
            </c:if>
            <li><a href="<c:url value="/logout" />" >Logout</a></li>
        </ul>
    </div>
</nav>
</html>