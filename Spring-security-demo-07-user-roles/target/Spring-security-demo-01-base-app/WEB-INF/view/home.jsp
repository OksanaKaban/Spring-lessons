<%--
  Created by IntelliJ IDEA.
  User: oxana
  Date: 11/02/2022
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
<h2>Company Home Page</h2>
<hr>

Welcome to company home page!
<p>
    <%--    display user namae and roles--%>
    User name:
    <security:authentication property="principal.username"/>
    User role:
    <security:authentication property="principal.authorities"/>

    <%--    add link to point to /leaders. this is for manageres--%>
    <security:authorize access="hasRole('VADYBININKAS')">
    <p>
        <a href="${pageContext.request.contextPath}/leaders"> Leadership meeting</a>
        (Only for managers!)
    </p>
    </security:authorize>

<%--    add link for /systems--%>
    <security:authorize access="hasRole('ADMINISTRATORE')">
    <p>
        <a href="${pageContext.request.contextPath}/systems">Systems</a>
        (For system users only!)
    </p>
    </security:authorize>

    <%--    add logout button--%>
    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="logout">
    </form:form>
</p>
</body>
</html>
