<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" rel="stylesheet">
    <title>Home</title>
</head>
<body>

<jsp:include page="navtab.jsp"></jsp:include>



<c:if test="${pageContext.request.isUserInRole(\"ROLE_ADMIN\")}">

</c:if>
    <table class="table table-bordered">
      <thead>
        <tr>
			<th>Tytuł</th>
			<th>Oryginalny tytuł</th>
			<th>Premiera</th>
			<th>Szczegóły</th>
			<th>Seanse</th>
			</tr>
      </thead>
      <tbody>
        <c:forEach items="${filmList}" var="film">
            <tr>
                <td>${film.tytul}</td>
                <td>${film.tytulOryginal}</td>
                <td>${film.premiera}</td>
                <td><a href="<c:url value='/detailsFilm/${film.idfilm}' />" >Szczegóły</a></td>
                <td><a href="<c:url value='/filmSeansList/${film.idfilm}' />" >Seanse</a></td>
            </tr>
        </c:forEach>
      </tbody>
    </table>

</body>
</html>
