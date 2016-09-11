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
        <th>Imie</th>
        <th>Nazwisko</th>
        <th>E-mail</th>
        <th>PESEL</th>
        <th>Rola</th>
        <th>Akcja</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.imie}</td>
            <td>${user.nazwisko}</td>
            <td>${user.email}</td>
            <td>${user.pesel}</td>    
            <c:if test="${user.rola == 'ROLE_ADMIN'}">
            <td>Administrator</td>
            <td><a href="<c:url value='/admin/degrade/${user.idklient}' />" >Zdegraduj</a></td>
            </c:if>
            <c:if test="${user.rola == 'ROLE_USER'}">
            <td>Uzytkownik</td>
            <td><a href="<c:url value='/admin/promote/${user.idklient}' />" >Awansuj</a></td>
            </c:if>     
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
