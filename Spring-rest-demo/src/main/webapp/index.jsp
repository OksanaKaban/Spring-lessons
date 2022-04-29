<%--
  Created by IntelliJ IDEA.
  User: oxana
  Date: 21/02/2022
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%-- si failiuka kuriam tik tam, kad nerodyti klaidos 404, bet uzkrautu kelia--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring rest demo</title>
</head>
    <a>
        <h3>
        Spring rest demo
        </h3>
    <hr>
<%--        <a href="${pageContext.request.contextPath}/test/hello">Hello</a>--%>
        <a href="${pageContext.request.contextPath}/api/students">get all students</a>
    </body>
</html>
