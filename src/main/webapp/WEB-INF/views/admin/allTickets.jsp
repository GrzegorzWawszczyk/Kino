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
<jsp:include page="../navtab.jsp"></jsp:include>

<div id="BILETY">

<p style="font-weight:bold">Wyszukaj bilet: <input class="search"></input></p>

<table class="table table-bordered">
    <thead>
    <tr>
    	<th class="sort" data-sort="id">ID</th>
        <th class="sort" data-sort="tytul">Tytul filmu</th>
        <th class="sort" data-sort="data">Data</th>
        <th class="sort" data-sort="godzina">Godzina</th>
        <th class="sort" data-sort="stan">Stan</th>
       <th class="sort" data-sort="sala">Sala</th>
 			<th>miejsce</th>
 			<th class="sort" data-sort="email">e-mail</th>
       <th>Edytuj</th>
    </tr>
    </thead>
    <tbody class="list">
    <c:forEach items="${biletList}" var="bilet">
        <tr>
        	<td class="id">${bilet.idbilet}</td>
            <td class="tytul">${bilet.film.tytul}</td>
             <td class="data"><fmt:formatDate pattern="dd-MM-yyyy" value="${bilet.seans.data}" /></td>
            <td class="godzina"><fmt:formatDate pattern="hh:mm" value="${bilet.seans.data}" /></td>
            <td class="stan">${bilet.stan}</td>
            <td class="sala">${bilet.seans.sala.nazwa}</td>
            <td>${bilet.miejsce}</td>
            <td class="email">${bilet.uzytkownik.email}</td>          
            <td><a href="<c:url value='/admin/editTicket/${bilet.idbilet}' />" >Zmien</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<script type="text/javascript">
    var options = {
      valueNames: [ 'id', 'tytul', 'data', 'godzina', 'stan', 'sala', 'email' ]
    };

    var userList = new List('BILETY', options);
</script>
</body>
</html>
