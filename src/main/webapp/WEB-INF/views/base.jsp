<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<link rel="Stylesheet" type="text/css" href="<c:url value="/resources/css/base.css" />"/>
	<link rel="Stylesheet" type="text/css" href="<layout:block name="css"></layout:block>"/>
	<title>Home</title>
</head>
<body>
<div id="MAIN">
<div id="HEADER">
<!-- <h1><span><c:url value="/resources/css/base.css" /></span></h1>
 <img src="<c:url value="/resources/images/header.png" />"/> -->
 

</div>

 <div id="LOGINANDMENU">
	<div id="MENU">
		<ul id="menu">
		  <li><a href="str1">Strona 1</a></li>
		  <li><a href="str2">Strona 2</a></li>
		  <li><a href="str3">Strona 3</a></li>
		  <li><a href="str4">Strona 4</a></li>
		</ul>
		</div>
<div id="LOGIN">
	Witaj Imię Nazwisko

	</div>
</div>

<div id="CONTENT">
        <layout:block name="content">

        </layout:block>
</div>
<div id="FOOTER">
<h5>Aplikacja przygotowana na potrzeby przedmiotu "Programowanie bezpiecznych aplikacji internetowych"</h5>
</div>
</div>
</body>
</html>
