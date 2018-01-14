<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html><head><title>Login</title></head>
<body>
<form name="loginForm" method="POST" action="servlet">
    <h1>Enter login and password</h1>
    <br/>
    
    <c:if test="${not empty errorLoginPassMessage}">
        <h5 style="color:#ff0000">${errorLoginPassMessage}</h5>
    </c:if>
    
    
    <input type="hidden" name="command" value="login" />
    Login:<br/>
    <input type="text" name="login" value=""/>
    <br/>Password:<br/>
    <input type="password" name="password" value=""/>
    <br/>
    or registration by form <br/>
    <a href="/jsp/registration.jsp">Go to registration</a>
    ${errorLoginPassMessage}
    <br/>
    ${wrongAction}
    <br/>
    ${nullPage}
    <br/>
    <input type="submit" value="Log in"/>
</form><hr/>
</body></html>