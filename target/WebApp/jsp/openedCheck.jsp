<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html><head><title> Enjoy your work</title></head>
<body>
<h1 align="center"> New check has been opened</h1>
<h3 align="center"> Current check hasn't any products</h3><br/>

<table border="2" cellpadding="7" cellspacing="0" align="center">
    <tr colspan="2" bgcolor="#D3EDF6" valign="top" align="center">
        <td width="30%">Назва товару/продукту</td>
        <td width="10%">Кількість</td>
        <td width="15%">ціна за 1</td>
        <td width="15%">ціна за всі</td>
    </tr>
</table>

name
products.code
products.number
products.priceForOne
products.resultPrice;

<form align="right" name="addProduct" method="GET" action="servlet">
    <input type="hidden" name="command" value="addProduct" />
    <input type="submit" value="Add products"/>
    <h1>Enter value in cases</h1>

</form>
<form name="registrationForm" method="POST" action="servlet">
    <input type="hidden" name="command" value="closeForm" />
    <table border="2" cellpadding="7" cellspacing="0" align="center">
        <tr colspan="2"  valign="top" align="center">
            <td width="30%">Enter name product: <input type="text" name="name" value=""/></td>
            <td width="20%">or enter code: <input type="text" name="code" value=""/></td>
            <td width="15%">and enter number of products: <input type="text" name="number" value=""/></td>
        </tr>
    </table>
    <input type="submit" value="add product"/>
</form><hr/>


<c:forEach var = "products" items = "${listProducts}">
    <table border="2" cellpadding="7" cellspacing="0" align="center">
        <tr colspan="2"  valign="top" align="center">
            <td width="30%">products.name</td>
            <td width="20%">products.code</td>
            <td width="15%">products.number</td>
            <td width="15%">products.priceForOne</td>
            <td width="20%">products.resultPrice</td>
        </tr>
    </table>
</c:forEach>

<form align="center" name="openForm" method="GET" action="servlet">
    <input type="hidden" name="command" value="closeForm" />
    <input type="submit" value="Close check"/>
</form>

</body></html>

