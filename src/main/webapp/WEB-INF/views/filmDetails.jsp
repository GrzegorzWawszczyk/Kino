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

<c:url value="/addFilm" var="theAction"/>
<form:form method="POST" commandName="film" action="${theAction}" >
    <table>
        <tr>
            <td>
                <form:label path="idfilm">
                    <spring:message text="ID"/>
                </form:label>
            </td>
            <td>
                <form:input path="idfilm" readonly="true" size="8"  disabled="true" />
                <form:hidden path="idfilm" />
            </td>
        </tr>
        <tr>
            <td><form:label path="idfilm">ID film:</form:label></td>
            <td><form:input  path="idfilm" value="${film.idfilm}" readonly="true"/></td>
        </tr>
        <tr>
            <td><form:label path="tytul">tytul:</form:label></td>
            <td><form:input path="tytul" value="${film.tytul}"/></td>
        </tr>
        <tr>
            <td><form:label path="tytulOryginal">Employee Age:</form:label></td>
            <td><form:input path="tytulOryginal" value="${film.tytulOryginal}" readonly="true"/></td>
        </tr>
        <tr>
            <td><form:label path="premiera">premiera:</form:label></td>
            <td><form:input path="premiera" value="${film.premiera}" readonly="true"/></td>
        </tr>

        <tr>
            <td><form:label path="wiek">wiek:</form:label></td>
            <td><form:input path="wiek" value="${film.wiek}" readonly="true"/></td>
        </tr>
        <tr>
            <td><form:label path="czasTrwania">czasTrwania:</form:label></td>
            <td><form:input path="czasTrwania" value="${film.czasTrwania}" readonly="true"/></td>
        </tr>
        <tr>
            <td><form:label path="produkcja">produkcja:</form:label></td>
            <td><form:input path="produkcja" value="${film.produkcja}" readonly="true"/></td>
        </tr>
        <tr>
            <td><form:label path="gatunek">gatunek:</form:label></td>
            <td><form:input path="gatunek" value="${film.gatunek}" readonly="true"/></td>
        </tr>
        <tr>
            <td><form:label path="wersja">wersja:</form:label></td>
            <td><form:input path="wersja" value="${film.wersja}" readonly="true"/></td>
        </tr>
        <tr>
            <td><form:label path="odLat">odLat:</form:label></td>
            <td><form:input path="odLat" value="${film.odLat}" readonly="true"/></td>
        </tr>
        <tr>
            <td><form:label path="opis">opis:</form:label></td>
            <td><form:input path="opis" value="${film.opis}" readonly="true"/></td>
        </tr>
        <tr>
            <td><form:label path="aktorzy">wiek:</form:label></td>
            <td><form:input path="aktorzy" value="${film.aktorzy}" readonly="true"/></td>
        </tr>

    </table>
</form:form>


</body>
</html>