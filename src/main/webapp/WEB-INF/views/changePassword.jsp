<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
    <link href="<c:url value="/resources/style.css" />" rel="stylesheet">


    <title>Home</title>
</head>
<body>

<jsp:include page="navtab.jsp"></jsp:include>
<form name="login" method="POST"  action="${pageContext.request.contextPath}/changePasswordCommand" >
                        <fieldset>
                        <div class="form-group">
                                Stare Haslo: <input class="form-control" placeholder="Password" name="haslo" type="password" value="">
                            </div>
                            <div class="form-group">
                                Nowe Haslo: <input class="form-control" placeholder="Password" name="haslo1" type="password" value="">
                            </div>
                            <div class="form-group">
                                Powtorz Nowe Haslo: <input class="form-control" placeholder="Password" name="haslo2" type="password" value="">

                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            <!-- Change this to a button or input when using this as a form -->
                             <div style="color: red">${error}</div>
                            <button type="submit" class="btn btn-success btn-block">Zmien haslo</button>
                        </fieldset>
</form>
</body>
</html>