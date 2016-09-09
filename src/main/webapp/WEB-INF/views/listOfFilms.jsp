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
    <a href="<c:url value="/addFilmView" />" >Dodac film</a>


    <table class="table table-bordered">
      <thead>
        <tr>
          <th>#</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${filmList}" var="film">
            <tr>
                <th scope="row">1</th>
                <td>${film.idfilm}</td>
                <td>${film.tytul}</td>
                <td>${film.tytulOryginal}</td>
                <td><a href="<c:url value='/edit/${film.idfilm}' />" >Edit</a></td>
                <td><a href="<c:url value='/removeFilm/${film.idfilm}' />" >Delete</a></td>
            </tr>
        </c:forEach>
      </tbody>
    </table>

</body>
</html>
