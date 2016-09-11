<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="http://listjs.com/no-cdn/list.js"></script>
    <title>Home</title>
</head>
<body>

<jsp:include page="navtab.jsp"></jsp:include>



<div id="FILMY">
<p style="font-weight:bold">Wyszukaj film: <input class="search"></input></p>
    <table class="table table-bordered">
      <thead>
        <tr>
			<th class="sort" data-sort="tytul">Tytul</th>
			<th class="sort" data-sort="origTytul">Oryginalny tytul</th>
			<th class="sort" data-sort="premiera">Premiera</th>
			<th>Szczegoly</th>			<th>Seanse</th>
			<c:if test="${pageContext.request.isUserInRole(\"ROLE_ADMIN\")}">
			<th>Edycja</th>
			</c:if>
			</tr>
      </thead>
      <tbody class="list">
        <c:forEach items="${filmList}" var="film">
            <tr>
 <td class="tytul">${film.tytul}</td>
                <td class="origTytul">${film.tytulOryginal}</td>
                <td class="premiera">${film.premiera}</td>
                <td><a href="<c:url value='/detailsFilm/${film.idfilm}' />" >Szczegoly</a></td>                <td><a href="<c:url value='/filmSeansList/${film.idfilm}' />" >Seanse</a></td>
                <c:if test="${pageContext.request.isUserInRole(\"ROLE_ADMIN\")}">
                <td><a href="<c:url value='/admin/editFilm/${film.idfilm}' />" >Edytuj</a></td>
                </c:if>
            </tr>
        </c:forEach>
      </tbody>
    </table>
    </div>
<script type="text/javascript">
    var options = {
      valueNames: [ 'tytul', 'origTytul', 'premiera' ]
    };

    var userList = new List('FILMY', options);
</script>
</body>
</html>
