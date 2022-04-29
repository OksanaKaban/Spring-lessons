<%--
  Created by IntelliJ IDEA.
  User: oxana
  Date: 11/02/2022
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Custom Login Page</title>
    <style>.failed{color:red;}</style>
</head>
<body>
    <h3>My Custom Login Page</h3>
<form:form action="${pageContext.request.contextPath}/authenticateUser" method="post">
<%--    check for login error--%>
    <c:if test="${param.error != null}">
        <i class="failed">Sorry, you entered invalid user name/password</i>
    </c:if>

    <p>User name: <input type="text" name="username"/></p>
    <p>User password: <input type="password" name="password"/></p>
    <p><input type="submit" value="login"></p>
</form:form>
</body>
</html>
