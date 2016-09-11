<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false"  contentType="text/html; charset=UTF-8"%>

<html>
<head>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" rel="stylesheet">
    <title>Home</title>
</head>
<body>
<jsp:include page="navtab.jsp"></jsp:include>


<table>
<tr><td colspan="2" class="titleRow">
<span style="font-size:40px;font-weight:bold" >${film.tytul}</span>
</td></tr>
<tr><td colspan="2" class="originalTitleRow">
<span style="font-size:20px" >(${film.tytulOryginal})</span>
</td></tr>
<tr><td >
<span class="label">Premiera: </span><span class="info"><c:out value="${film.premiera }"/></span>
</td><td >
<span class="label">Czas trwania: </span><span class="info"><c:out value="${film.czasTrwania }"/> min.</span>
</td></tr>
<tr><td >
<span class="label">Produkcja: </span><span class="info"><c:out value="${film.produkcja }"/></span>
</td><td >
<span class="label">Od lat: </span><span class="info">
<c:choose>
<c:when test="${film.odLat>0 }">
<c:out value="${film.odLat }"/>
</c:when>
<c:otherwise>
Bez ograniczeń
</c:otherwise>
</c:choose>
</span>
</td></tr>
<tr><td >
<span class="label">Gatunek: </span><span class="info"><c:out value="${film.gatunek }"/></span>
</td><td >
<span class="label">Wersja: </span><span class="info"><c:out value="${film.wersja }"/></span>
</td></tr>
<tr>
<td colspan="2">
<span class="label">Aktorzy: </span><span style="font-size:23px"><c:out value="${film.aktorzy }"/></span>
</td></tr>
<tr>
<td colspan="2">
<span class="label">Opis: </span><span style="font-size:23px"><c:out value="${film.opis }"/></span>
</td></tr>
<tr><td>
<a href="<c:url value='/filmSeansList/${film.idfilm}' />" class="button">Dostepne seanse</a>
</td></tr>
</table>


</body>
</html>