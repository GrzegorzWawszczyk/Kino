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

 <jsp:include page="../navtab.jsp"></jsp:include>

 <c:url value="/admin/editTicketCommand" var="theAction"/>
<form:form name="login" method="POST" modelAttribute="bilet" action="${theAction}" >
        <table>
        <tr>
            <td><form:label path="idbilet">ID Bilet:</form:label></td>
            <td><form:input path="idbilet" value="${bilet.idbilet}" readonly="true"/></td>
        </tr>
        <tr>
            <td><form:label path="film.tytul">tytul:</form:label></td>
            <td><form:input path="film.tytul" value="${bilet.film.tytul}" readonly="true" disabled="true"/></td>
        </tr>
        <tr>
            <td><form:label path="uzytkownik.email">email</form:label></td>
            <td><form:input path="uzytkownik.email" value="${bilet.uzytkownik.email}" readonly="true" disabled="true"/></td>
        </tr>
		<select name="typ">
			<option value="zarezerwowany">Zarezerwowany</option>
			<option value="anulowany">Anulowany</option>
			<option value="kupiony">Kupiony</option>
			<option value="doZwrotu">Do zwrotu</option>
		</select>

    	<input type="submit" value="<spring:message text='Potwierdz'/>" />
    	<input type="reset" value="<spring:message text='Anuluj'/>" />
        </tr>
    </table>
</form:form>
