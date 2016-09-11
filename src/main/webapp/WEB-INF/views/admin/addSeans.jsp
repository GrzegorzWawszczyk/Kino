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


 <c:url value="/admin/addSeans" var="theAction"/>
  <form method="post" action="${theAction}">
<input type="hidden" id="idseans" name="idseans" value="<c:out value="${idseans}"/>"/>

            <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
<table>
<c:if test="${not edit}">
<tr>
<h2><span>Dodaj seans filmu: </span><span style="font-style: oblique"><c:out value="${tytul}"/></span></h2>
</tr></c:if>
<c:if test="${edit}">
<tr>
<h2><span>Edytuj seans filmu <c:out value="${film.tytul}"/> : </span><span style="font-style: oblique"><c:out value="${tytul}"/></span></h2>
</tr></c:if>
<c:if test="${not edit}">
<tr>
       	<td><label>Film</label></td>
        <td><select id="filmField" name="filmField">
        <c:forEach var="f" items="${filmy}"> 
        <option value="${f.idfilm}"  ><c:out value="${f.tytul}"/></option>
        </c:forEach>
        </select></td>
        <td><span class="error"><c:out value="${emptyFilm}"/></span></td>
</tr>
</c:if>
<c:if test="${edit}">
	<input type="hidden" id="filmField" name="filmField" value="<c:out value="${film.idfilm}"/>"/>
</c:if>
<tr>
       <td><label>Data</label></td>
        <td><input type="date" id="dataField" name="dataField" <c:if test="${edit}">value="<c:out value="${oldData}"/>"</c:if>/></td> 
        <td><span class="error"><c:out value="${emptyData}"/></span></td>
</tr>
<tr>
       <td><label>Godzina</label></td>
        <td><input type="time" id="timeField" name="timeField" <c:if test="${edit}">value="<c:out value="${oldGodzina}"/>"</c:if>/></td> 
        <td><span class="error"><c:out value="${emptyGodzina}"/></span></td>
</tr>

<tr>
       	<td><label>Sala</label></td>
        <td><select id="salaField" name="salaField">
        <c:forEach var="s" items="${sale}"> 
        <option value="${s.idsala}"  <c:if test="${edit && oldSala == s.idsala}">selected</c:if>><c:out value="${s.nazwa}"/></option>
        </c:forEach>
        </select></td>
        <td><span class="error"><c:out value="${emptySala}"/></span></td>
</tr>

<tr>
        <td colspan="2">
        <c:if test="${edit}">
        	<input type="submit" value="Edytuj seans">
        </c:if>
        <c:if test="${not edit}">
            <input type="submit" value="Dodaj seans">
        </c:if>
        </td>
    </tr>

</table>
</form>


</body>
</html>