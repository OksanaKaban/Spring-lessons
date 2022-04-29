<%--
  Created by IntelliJ IDEA.
  User: oxana
  Date: 11/02/2022
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
    <h2>Company Home Page</h2>
<hr>

Welcome to company home page!
<p>
<%--    add logout button--%>
    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="logout">
    </form:form>
</p>
</body>
</html>
