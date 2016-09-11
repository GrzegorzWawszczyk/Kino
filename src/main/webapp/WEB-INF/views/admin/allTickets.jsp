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
<jsp:include page="../navtab.jsp"></jsp:include>


<table class="table table-bordered">
    <thead>
    <tr>
        <th>Tytul</th>
 +        <th>Data</th>
 +        <th>Stan</th>
 			<th>miejsce</th>
 			<th>e-mail</th>
 +        <th>Edytuj</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${biletList}" var="bilet">
        <tr>
            <td>${bilet.film.tytul}</td>
            <td>${bilet.seans.data}</td>
            <td>${bilet.stan}</td>
            <td>${bilet.miejsce}</td>
            <td>${bilet.uzytkownik.email}</td>          
            <td><a href="<c:url value='/admin/editTicket/${bilet.idbilet}' />" >Zmien</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
