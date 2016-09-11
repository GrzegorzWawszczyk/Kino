 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <%@ page session="false" %>

 <html>
 <head>
     <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
     <link href="<c:url value="/resources/bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" rel="stylesheet">
     <title>Home</title>
 </head>
 <body>

 <jsp:include page="navtab.jsp"></jsp:include>


 <c:url value="/myBilets" var="theAction"/>
 
 <h3>Wykonaj przelew o podanych parametrach:</h3>
 <h4>(Gdy zostanie zaksiegowany, Twoj bilet zostanie potwierdzony)</h4>
 
 <span style="font-weight:bold">Numer konta: </span><c:out value="${accountNumber}"/><br>
 <span style="font-weight:bold">Tytul‚: </span>Platnosc za bilet <c:out value="${bilet.idbilet}"/><br>
 <span style="font-weight:bold">Kwota: 20 PLN<br>
 <a class="button" href="${theAction}">OK</a>
 


</body>
</html>