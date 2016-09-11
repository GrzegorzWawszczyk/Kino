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

<div id="BILETY">

<p style="font-weight:bold">Wyszukaj bilet: <input class="search"></input></p>

<table class="table table-bordered">
    <thead>
    <tr>
        <th class="sort" data-sort="tytul">Tytul filmu</th>
        <th class="sort" data-sort="data">Data</th>
        <th class="sort" data-sort="godzina">Godzina</th>
        <th class="sort" data-sort="sala">Sala</th>
        <th>Miejsce</th>
        <th class="sort" data-sort="stan">Stan</th>
        <th>Anuluj/Zwroc</th>
    </tr>
    </thead>
    <tbody class="list">
    <c:forEach items="${biletList}" var="bilet">
        <tr>
            <td class="tytul">${bilet.film.tytul}</td>
            <td class="data"><fmt:formatDate pattern="dd-MM-yyyy" value="${bilet.seans.data}" /></td>
            <td class="godzina"><fmt:formatDate pattern="hh:mm" value="${bilet.seans.data}" /></td>
            <td class="sala">${bilet.seans.sala.nazwa}</td>
            <td>${bilet.miejsce}</td>
            <td class="stan">${bilet.stan}</td>
             <c:if test="${bilet.stan == 'zarezerwowany'}">
            <td><a href="<c:url value='/changeStanBilet/${bilet.idbilet}' />" >Anuluj</a></td>
            <td>
            <a href="<c:url value='/transferPayment/${bilet.idbilet}' />" >Przelew</a>
            /
            <a href="<c:url value='/cardPayment/${bilet.idbilet}' />" >Karta</a>
            </td>
            </c:if>
             <c:if test="${bilet.stan == 'kupiony'}">
            <td><a href="<c:url value='/changeStanBilet/${bilet.idbilet}' />" >Anuluj</a></td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>

<script type="text/javascript">
    var options = {
      valueNames: [ 'tytul', 'data', 'godzina', 'sala', 'stan' ]
    };

    var userList = new List('BILETY', options);
</script>

</body>
</html>
