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


<table class="table table-bordered">
    <thead>
    <tr>
        <th>Tytul</th>
        <th> Seans</th>
        <th>Stan</th>
        <th>Usun</th>
        <th>Edytuj</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${biletList}" var="bilet">
        <tr>
            <td>${bilet.film.tytul}</td>
            <td>${bilet.seans}</td>
            <td>${bilet.stan}</td>
            <td><a href="<c:url value='/admin/removeBilet/${bilet.idbilet}' />" >Usun</a></td>
            <td><a href="<c:url value='/admin/editTicket/${bilet.idbilet}' />" >Zmien</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
