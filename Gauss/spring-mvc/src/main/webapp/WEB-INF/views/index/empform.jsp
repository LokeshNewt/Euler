<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%--
  Created by IntelliJ IDEA.
  User: neerbans
  Date: 3/6/2017
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Add new Emp</h1>
<form:form method="post" action="save">
    <table>
        <tr>
            <td> Name : </td>
            <td><form:input path="firstName" /></td>
            </tr>
        <td></td>
        <td><input type="submit" value="save" /></td>
        </table>
</form:form>
</body>
</html>
