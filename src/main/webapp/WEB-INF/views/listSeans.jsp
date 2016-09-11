<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" rel="stylesheet">    
    <script src="<c:url value="/resources/js/list.js" />"></script>
    <title>Home</title>
</head>
<body>
<jsp:include page="navtab.jsp"></jsp:include>


<h1>Lista seansow dla filmu ${film}</h1>
<div id="SEANSE">

<p style="font-weight:bold">Wyszukaj seans: <input class="search"></input></p>
    <table class="table table-bordered">
      <thead>
        <tr>
          <th class="sort" data-sort="data">Data</th>
          <th class="sort" data-sort="godzina">Godzina</th>
          <th class="sort" data-sort="sala">Sala</th>
			<th>Rezerwacja</th>
			<c:if test="${pageContext.request.isUserInRole(\"ROLE_ADMIN\")}">
			<th>Edycja</th>
			<th>Usuwanie</th>
			</c:if>
        </tr>
      </thead>
      <tbody class="list">
        <c:forEach items="${seansList}" var="seans">
            <tr>
                <td class="data"><fmt:formatDate pattern="dd-MM-yyyy" value="${seans.data}" /></td>
                <td class="godzina"><fmt:formatDate pattern="hh:mm" value="${seans.data}" /></td>
                <td class="sala">${seans.sala.nazwa}</td>                
                <!-- <td><a href="<c:url value='/detailsFilm/${seans.film.idfilm}' />" >Szczegoly filmu</a></td>-->
                <td><a href="<c:url value='/book/${seans.idseans}' />" >Rezerwuj bilet</a></td>
                <c:if test="${pageContext.request.isUserInRole(\"ROLE_ADMIN\")}">
	                <td><a href="<c:url value='/admin/editSeans/${seans.idseans}' />" >Edytuj</a></td>
	                <td><a href="<c:url value='/admin/removeSeans/${seans.idseans}' />" >Usun</a></td>
                </c:if>
            </tr>
        </c:forEach>
      </tbody>
    </table>
    </div>
    <script type="text/javascript">
    var options = {
      valueNames: [ 'data', 'godzina', 'sala' ]
    };

    var userList = new List('SEANSE', options);
</script>

</body>
</html>
