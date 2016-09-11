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


<c:if test="${admin}">

    <a href="<c:url value="/addSeansView" />" >Dodac film</a>
</c:if>

    <table class="table table-bordered">
      <thead>
        <tr>
          <th>Tytul filmu</th>
          <th>Data</th>
          <c:if test="${pageContext.request.isUserInRole(\"ROLE_ADMIN\")}">
           <th>Edycja</th>
           <th>Usuwanie</th>
           </c:if>
           <th>Szczegoly</th>
           <th>Rezerwacja</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${seansList}" var="seans">
            <tr>
                <td>${seans.film.tytul}</td>
                <td>${seans.data}</td>
                <c:if test="${pageContext.request.isUserInRole(\"ROLE_ADMIN\")}">
	                <td><a href="<c:url value='/admin/editSeans/${seans.idseans}' />" >Edytuj</a></td>
	                <td><a href="<c:url value='/admin/removeSeans/${seans.idseans}' />" >Usun</a></td>
                </c:if>
                <td><a href="<c:url value='/detailsFilm/${seans.film.idfilm}' />" >Szczegoly filmu</a></td>
                <td><a href="<c:url value='/book/${seans.idseans}' />" >Rezerwuj bilet</a></td>
            </tr>
        </c:forEach>
      </tbody>
    </table>

</body>
</html>
