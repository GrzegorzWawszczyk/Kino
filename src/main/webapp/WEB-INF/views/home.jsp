<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<layout:extends name="base.jsp">

<%--<layout:put block="css" type="REPLACE">
	<c:url value="/resources/css/tmp.css" />
</layout:put>--%>

<layout:put block="content" type="REPLACE"><!-- Inne opcje: APPEND, PREPEND -->

<!-- TUTAJ ZAWARTOSC -->

<h1 style="text-align:center">WITAJ NA STRONIE NASZEGO KINA</h1>

<!-- KONIEC ZAWARTOSCi -->

</layout:put>


</layout:extends>