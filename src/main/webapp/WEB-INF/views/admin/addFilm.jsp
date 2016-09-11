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


 <c:url value="/admin/addFilm" var="theAction"/>
  <form:form method="POST" commandName="film" action="${theAction}" >
    <table>
        <tr>
            <td><form:hidden path="idfilm" value="${film.idfilm}" readonly="true"/></td>
        </tr>
        <tr>
            <td><form:label path="tytul">Tytul:</form:label></td>
            <td><form:input path="tytul" value="${film.tytul}"/></td>
        </tr>
        <tr>
            <td><form:label path="tytulOryginal">Tytul oryginalny:</form:label></td>
            <td><form:input path="tytulOryginal" value="${film.tytulOryginal}"/></td>
        </tr>
        <tr>
            <td><form:label path="premiera">Rok premiery:</form:label></td>
            <td><form:input type="number" min="1900" path="premiera" value="${film.premiera}"/></td>
        </tr>

        <tr>
            <td><form:label path="czasTrwania">Czas trwania(min.):</form:label></td>
            <td><form:input type="number" path="czasTrwania" value="${film.czasTrwania}" /></td>
        </tr>
        <tr>
            <td><form:label path="produkcja">Kraj produkcji:</form:label></td>
            <td><form:input path="produkcja" value="${film.produkcja}" /></td>
        </tr>
        <tr>
            <td><form:label path="gatunek">Gatunek:</form:label></td>
            <td><form:input path="gatunek" value="${film.gatunek}"/></td>
        </tr>
        <tr>
            <td><form:label path="wersja">Wersja:</form:label></td>
            <td> <form:select path="wersja" value="${film.wersja}" >
            <form:option value="2D">2D</form:option>
            <form:option value="3D">3D</form:option>
            </form:select></td>
        </tr>
        <tr>
            <td><form:label path="odLat">Od lat(0 - b.o.):</form:label></td>
            <td><form:input type="number" min="0" max="18" path="odLat" value="${film.odLat}"/></td>
        </tr>
        <tr>
            <td><form:label path="opis">Opis:</form:label></td>
            <td> <form:textarea cols="100" rows="3" path="opis" value="${film.opis}" /></td>
        </tr>
        <tr>
            <td><form:label path="aktorzy">Aktorzy:</form:label></td>
            <td><form:textarea cols="100" rows="2" path="aktorzy" value="${film.aktorzy}" /></td>
        </tr>

        <tr>
                    <c:if test="${!empty film.tytul}">
        				<td/><td><input type="submit" value="<spring:message text='Zatwierdz zmiany'/>" /></td>
        			</c:if>
        			<c:if test="${empty film.tytul}">
        				<td/><td><input type="submit" value="<spring:message text="Dodaj film"/>" /></td>
        			</c:if>
        </tr>
    </table>
  </form:form>


</body>
</html>