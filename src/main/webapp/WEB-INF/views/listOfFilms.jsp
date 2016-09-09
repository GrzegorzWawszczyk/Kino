<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" rel="stylesheet">
    <title>Home</title>
</head>
<body>

<jsp:include page="navtab.jsp"></jsp:include>



<c:if test="${pageContext.request.isUserInRole(\"ROLE_ADMIN\")}">

    <a href="<c:url value="/addFilmView" />" >Dodac film</a>
</c:if>


    <table class="table table-bordered">
      <thead>
        <tr>
          <th>ID</th>
          <th>Tytul</th>
          <th>Oryginalna nazwa</th>
           <th>Edycja</th>
           <th>Usuwanie</th>
           <th>Szczegoły</th>
           <th>Akcja</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${filmList}" var="film">
            <tr>
                <td>${film.idfilm}</td>
                <td>${film.tytul}</td>
                <td>${film.tytulOryginal}</td>
                <td><a href="<c:url value='/editFilm/${film.idfilm}' />" >Edit</a></td>
                <td><a href="<c:url value='/removeFilm/${film.idfilm}' />" >Delete</a></td>
                <td><a href="<c:url value='/detailsFilm/${film.idfilm}' />" >Details</a></td>
                <td><a href="<c:url value='/buyTicketFilm/${film.idfilm}' />" >Kupic bilet</a></td>
            </tr>
        </c:forEach>
      </tbody>
    </table>

</body>
</html>
