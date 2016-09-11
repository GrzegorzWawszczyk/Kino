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


 <c:url value="/cardPaymentCommand" var="theAction"/>
  <!--<form:form method="POST" commandName="bilet" action="${theAction}" >-->
  <form method="POST" action="${theAction}">
    <table>
        <tr>
            <td><input type="hidden" id="id" name="id" value="${bilet.idbilet}" readonly="true"/></td>
            <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
        </tr>
        <tr>
            <td><label>Numer Karty:</label></td>
            <td><input id="cardNumber" name="cardNumber"/></td>
        </tr>
        <tr>
            <td><label>CVV:</label></td>
            <td><input id="CVV" name="CVV"/></td>
        </tr>

        

        <tr>
        				<td><input type="submit" value="<spring:message text="Zaplac™"/>" /></td>
        				<td><span style="color:red"> <c:out value="${error}"/> </span></td>
        </tr>
    </table>
    </form>
  <!--</form:form>-->


</body>
</html>