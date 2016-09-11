<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" rel="stylesheet">    
    <script src="http://listjs.com/no-cdn/list.js"></script>
    <title>Home</title>
</head>
<body>
<jsp:include page="../navtab.jsp"></jsp:include>

<div id="USERZY">

<p style="font-weight:bold">Wyszukaj uzytkownika: <input class="search"></input></p>
<table class="table table-bordered">
    <thead>
    <tr>
        <th class="sort" data-sort="imie">Imie</th>
        <th class="sort" data-sort="nazwisko">Nazwisko</th>
        <th class="sort" data-sort="email">E-mail</th>
        <th class="sort" data-sort="pesel">PESEL</th>
        <th class="sort" data-sort="rola">Rola</th>
        <th>Akcja</th>
    </tr>
    </thead>
    <tbody class="list">
    <c:forEach items="${userList}" var="user">
    <c:if test="${not (pageContext.request.userPrincipal.name == user.email)}">
        <tr>
        	<td style="display:none" class="imnazw">${user.imie} ${user.nazwisko}</td>
        	<td style="display:none" class="nazwim">${user.nazwisko} ${user.imie}</td>
            <td class="imie">${user.imie}</td>
            <td class="nazwisko">${user.nazwisko}</td>
            <td class="email">${user.email}</td>
            <td class="pesel">${user.pesel}</td>    
            <c:if test="${user.rola == 'ROLE_ADMIN'}">
            <td class="rola">Administrator</td>
            <td><a href="<c:url value='/admin/degrade/${user.idklient}' />" >Zdegraduj</a></td>
            </c:if>
            <c:if test="${user.rola == 'ROLE_USER'}">
            <td class="rola">Uzytkownik</td>
            <td><a href="<c:url value='/admin/promote/${user.idklient}' />" >Awansuj</a></td>
            </c:if>     
        </tr>
    </c:if>
    </c:forEach>
    </tbody>
</table>
</div>
<script type="text/javascript">
    var options = {
      valueNames: [ 'imnazw', 'nazwim', 'imie', 'nazwisko', 'email', 'pesel', 'rola' ]
    };

    var userList = new List('USERZY', options);
</script>
</body>
</html>
