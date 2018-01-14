<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html><head><title>Enjoy your work</title></head>
<body>
<h1>Enjoy your work</h1>

<form name="openForm" method="GET" action="servlet">
    <input type="hidden" name="command" value="openCheck" />
    <input type="submit" value="Open check"/>
</form>
<!--
<h1>first hello, ${user.name}</><br/>
<input type="text" name="password" value=""/>
<input type="submit" value="Log in"/>
<h1>you password is , ${user.password}</>

<c:forEach var = "users" items = "${ list}">
    <h1>${users.name}</h1>
    <h1>${users.password}</h1><br/>
</c:forEach>
-->
</body></html>