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


 <c:url value="/admin/addSala" var="theAction"/>
  <form:form method="POST" commandName="sala" action="${theAction}" >
    <table>
        <tr>
            <!-- <td><form:label type="hidden" path="idsala">ID sala:</form:label></td>-->
            <td><form:hidden path="idsala" value="${sala.idsala}" readonly="true"/></td>
        </tr>
        <tr>
            <td><form:label path="nazwa">Nazwa:</form:label></td>
            <td><form:input path="nazwa" value="${sala.nazwa}"/></td>
        </tr>
        <tr>
            <td><form:label path="typ">Typ:</form:label></td>
            <td><form:input path="typ" value="${sala.typ}"/></td>
        </tr>
        <tr>
            <td><form:label path="liczbaRzedow">Liczba rzędów:</form:label></td>
            <td><form:input type="number" path="liczbaRzedow" value="${sala.liczbaRzedow}"/></td>
        </tr>

        <tr>
            <td><form:label path="liczbaKolumn">Liczba kolumn:</form:label></td>
            <td><form:input type="number" path="liczbaKolumn" value="${sala.liczbaKolumn}"/></td>
        </tr>
        <tr><td><form:hidden path="iloscMiejsc" value="${sala.iloscMiejsc}" readonly="true"/></td></tr>

        

        <tr>
        				<td><input type="submit" value="<spring:message text="Dodaj salę"/>" /></td>
        </tr>
    </table>
  </form:form>


</body>
</html>